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
    /** What round are we on */
    private int roundNum;

    public HandEyePanel(int xMax, int yMax) {
        //Null out layout manager for absolute positioning
        this.setLayout(null);
        this.xMax   = xMax;
        this.yMax   = yMax;
        this.random = new Random();
        startGame();
	}

    public void startGame() {
        //Set up the playing area
        roundNum = -1;
        //Call nextRound
        nextRound(System.currentTimeMillis());
    }

    private void nextRound(HandEyeBall ball) {
        remove(ball);
        nextRound(ball.getStartTime());
    }
    /**
     * Executed when a circle has been clicked and it is time to bein the next round
     */
    private void nextRound(long prevTime) {
        if (roundNum >= NUM_ROUNDS) {
            endGame();
            return;
        } 
        long currentTime = System.currentTimeMillis();
        if (roundNum > -1) {
            //record reaction time
            userScore[roundNum] = currentTime - prevTime;
            System.out.println("Current round: " + roundNum);
        }
        roundNum++;

        //Create a new ball
        HandEyeBall ball = new HandEyeBall(currentTime);
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
        
        long sumScore = 0;
        //Show quit/new game buttons
        for (long score : userScore) {
            sumScore += score;
            System.out.println(score);
        }
        System.out.println("Final score is: " + sumScore);
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
         * When was this ball rendered? 
         * Used for calculating the user's response time 
         */
        private long startTime;

        /**
         * Returns a new ball in a given location on the screen
         */
        private HandEyeBall(long startTime) {
            this.startTime = startTime;
            this.color = randomColor();
            setBorder(
                BorderFactory.createEmptyBorder(0, 0, 0, 0)
            );
            addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        //Start a new round when clicked
                        nextRound(HandEyeBall.this);
                    }
            });
        }
        public long getStartTime() {
            return startTime;
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
        /**
         * Returns a random color, using RGB 0-255
         * Note: This may appear invisible, by matching the background color identically
         */
        private Color randomColor() {
            return new Color( 
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
            );
        }
    }
}
