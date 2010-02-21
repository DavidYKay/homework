import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class HandEyePanel extends JPanel {

    private static final int TICK_SPEED = 333;

    /** Number of rounds that will be played */
    private static final int NUM_ROUNDS = 5;
    /** Holds the score of the user from each round  */
    private long[] userScore = new long[NUM_ROUNDS];

    /** The width of the game area, as specified by in the constructor */
    private int xMax;
    /** The height of the game area, as specified by in the constructor */
    private int yMax;

    /** RNG for placing circles */
    private Random random;
    /** Used for calculating the user's response time*/
    private long roundStartTime;
    /** What round are we on */
    private int roundNum;

    public HandEyePanel(int xMax, int yMax) {
        this.setLayout(null);

        this.xMax = xMax;
        this.yMax = yMax;
        random = new Random();
        //Initialize gui
        //start thread
        //new HandEyeThread().start();
        startGame();
	}

    public void startGame() {
        //Set up the playing area
        roundNum = -1;
        //Call nextRound
        nextRound();
    }

    private void nextRound(HandEyeBall ball) {
        remove(ball);
        nextRound();
    }
    /**
     * Executed when a circle has been clicked and it is time to bein the next round
     */
    private void nextRound() {
        if (roundNum >= NUM_ROUNDS) {
            endGame();
            return;
        } 
        long currentTime = System.currentTimeMillis();
        if (roundNum == -1) {
            roundStartTime = currentTime;
        } else {
            //record reaction time
            userScore[roundNum] = currentTime - roundStartTime;
            roundStartTime = currentTime;
            System.out.println("Current round: " + roundNum);
        }
        roundNum++;

        //Create a new ball
        HandEyeBall ball = new HandEyeBall();
        //Add the ball to the panel
        add(ball);
        Container pane = this;
        //Insets insets = pane.getInsets();
        Dimension size = ball.getPreferredSize();
        ball.setBounds(
            //25 + insets.left, 5 + insets.top,
            getRandom(xMax, size.width), 
            getRandom(yMax, size.height), 
            size.width, 
            size.height
        );
        
        //Mark the time
        repaint();
    }

    private void endGame() {
        //Display user's score
        //Show quit/new game buttons
        for (long score : userScore) {
            System.out.println(score);
        }
    }

    private int getRandom(int max, int ballSize) {
        //Add one since nextInt is non-enclusive
        int centerBall = random.nextInt(
                (max + 1) - (ballSize)
        );
        //Shift 
        return centerBall + (ballSize / 2);
    }
    public Dimension getPreferredSize() {
        return new Dimension(xMax + 20, yMax + 20);
    }

    /**
     * A clickable ball, used in the game
     */
    private class HandEyeBall extends JButton {
        private Color color;
        /**
         * Returns a new ball in a given location on the screen
         */
        private HandEyeBall() {
            color = randomColor();
            setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
            );
            //Start a new round when clicked
            addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        nextRound(HandEyeBall.this);
                        //((JFrame) getParent()).remove(HandEyeBall.this);
                        //frame.remove(HandEyeBall.this);
                    }
            });
        }
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }

        /** 
         * Draw the button as a round circle rather than a standard button
         */
        protected void paintComponent(Graphics g) {
            g.setColor(color);
            g.fillOval(
                0, 
                0, 
                (int) getPreferredSize().getWidth(), 
                (int) getPreferredSize().getHeight()
            );
        }
        private Color randomColor() {
            return new Color( 
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
            );
        }
    }
}
