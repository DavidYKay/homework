#!/usr/bin/env python
import sys, tty, termios, optparse, time
from subprocess import Popen, PIPE

version = "0.1"

# parse options
optp = optparse.OptionParser(version=version, usage="""
  %prog [options] executable dimensions human-start bot-start

 executable:  shell command used to invoke your bot.
 dimensions:  dimensions of the board to use
human-start:  starting position of the human player
  bot-start:  starting position of the computer player""",
	description="Unofficial interactive tool used to test out Tron bots for the UW CSC Google AI Challenge (Winter 2010).")
optp.add_option("-s", "--style", dest="style", default='colours',
	help="visual style shown to user [default: %default]")
optp.add_option("-A", "--no-ansi", dest="ansi", default=True, action="store_false",
	help="disable ANSI and other control characters")
(options, args) = optp.parse_args()

if len(sys.argv) <= 1:
	optp.print_help()
	exit()
elif len(args) != 4:
	optp.error("incorrect number of arguments")

# define allowed styles
# (note suffixes: u, d, l and r are for direction: up, down, left, right;
# x is for collisions.)
styles = {
	'standard': {'wall':"#", 'player1':"1", 'player2':"2", 'empty':" "},
	'bot': {'wall':"#", 'player1':"2", 'player2':"1", 'empty':" "},
	'colours': {
		'wall':	    "\033[7m  \033[0m",
		'player1u': "\033[41m/\\\033[0m",
		'player1d': "\033[41m\\/\033[0m",
		'player1l': "\033[41m<<\033[0m",
		'player1r': "\033[41m>>\033[0m",
		'player1x': "\033[41m:(\033[0m",
		'player2u': "\033[46m/\\\033[0m",
		'player2d': "\033[46m\\/\033[0m",
		'player2l': "\033[46m<<\033[0m",
		'player2r': "\033[46m>>\033[0m",
		'player2x': "\033[46m:(\033[0m",
		'empty': "  "
	}
}

# parse int tuple from a string
def int_tuple(str):
	return (int(x) for x in str.split(","))

def print_board(board, style=options.style, stream=sys.stdout):
	for row in board:
		for char in row:
			try:
				out_char = styles[style][{
					'#':'wall',
					'1':'player1'+(human_dir),
					'2':'player2'+(bot_dir),
					' ':'empty'
				}[char]]
			except KeyError:
				if char == '1':
					out_char = styles[style]['player1']
				elif char == '2':
					out_char = styles[style]['player2']
			
			stream.write(out_char)
		stream.write("\n")

# initialize an empty board
(width, height) = int_tuple(args[1])
board = []
board.append(["#"] * (width+2))
board.extend([["#"] + [" "] * width + ["#"] for x in range(height)])
board.append(["#"] * (width+2))

# place the players
(human_x, human_y) = int_tuple(args[2])
human_dir="u"
board[human_y][human_x] = "1"
(bot_x, bot_y) = int_tuple(args[3])
board[bot_y][bot_x] = "2"
bot_dir = "u"

# Start the bot
bot = Popen(args[0], shell=True, stdin=PIPE, stdout=PIPE, close_fds=True)

if not options.ansi:
	sys.stderr.write("Interactive Tron (unofficial, v%(version)s)\n" % {'version':version})
	sys.stderr.write("http://csclub.uwaterloo.ca/~jbroman/tron/\n")

try:
	command = "w"
	game_over = False
	while True:
		if options.ansi:
			sys.stdout.write("\033[2J\033[1;1H")
			print "\033[44m\033[1m    Interactive Tron \033[22m(unofficial, v%(version)s)    " % {'version':version}
			print " http://csclub.uwaterloo.ca/~jbroman/tron/ "
			sys.stdout.write("\033[0m")
	
		print
		print_board(board)
		print
		print "Use wasd followed by Enter to control the human player (red/1)."
		print "Entering nothing will repeat your previous command.\n"
		print "Enter Q, or send ^C or ^D to quit.\n"
		
		if game_over and options.ansi:
			print "\033[31m\033[1mGame over\033[0m"
			break
		elif game_over:
			print "Game over"
			break
		else:
			game_over = False
		
		# Give the bot the board (let it think while the human does)
		bot.stdin.write("%d %d\n" % (width+2, height+2))
		print_board(board, 'bot', bot.stdin)
		
		# Process human command
		last_command = command
		command = raw_input(">> ").lower()
		if command == "":
			command = last_command
		
		if command == "q":
			break
		elif command == "w":
			board[human_y][human_x] = "#"
			human_y = human_y - 1
			human_dir = "u"
		elif command == "a":
			board[human_y][human_x] = "#"
			human_x = human_x - 1
			human_dir = "l"
		elif command == "s":
			board[human_y][human_x] = "#"
			human_y = human_y + 1
			human_dir = "d"
		elif command == "d":
			board[human_y][human_x] = "#"
			human_x = human_x + 1
			human_dir = "r"
		else:
			if options.ansi:
				sys.stderr.write("\033[31mInvalid command.\033[0m\n")
			else:
				sys.stderr.write("Invalid command.\n")
				
			time.sleep(1)
			continue
		
		if board[human_y][human_x] != " ":
			human_dir = "x"
			game_over = True
		board[human_y][human_x] = "1"
		
		# Process bot command
		bot_command = bot.stdout.readline()[0]
		if bot_command == "1":
			board[bot_y][bot_x] = "#"
			bot_y = bot_y - 1
			bot_dir = "u"
		elif bot_command == "2":
			board[bot_y][bot_x] = "#"
			bot_x = bot_x + 1
			bot_dir = "r"
		elif bot_command == "3":
			board[bot_y][bot_x] = "#"
			bot_y = bot_y + 1
			bot_dir = "d"
		elif bot_command == "4":
			board[bot_y][bot_x] = "#"
			bot_x = bot_x - 1
			bot_dir = "l"
		
		if board[bot_y][bot_x] != " ":
			bot_dir="x"
			game_over = True
		board[bot_y][bot_x] = "2"
		
except (KeyboardInterrupt, EOFError):
	pass
