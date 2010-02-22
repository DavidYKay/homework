import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class HandEyePanel extends JPanel {

    private GameScoreListener gameScoreListener;

    /** Number of rounds that will be played */
    private static final int NUM_ROUNDS = 20;
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

    public HandEyePanel(int xMax, int yMax, GameScoreListener gameScoreListener) {
        //Null out layout manager for absolute positioning
        this.gameScoreListener = gameScoreListener;
        this.xMax   = xMax;
        this.yMax   = yMax;
        this.random = new Random();
        this.setLayout(null);
        newGame();
	}

    public void newGame() {
        //clear the JPanel
        removeAll();
        //Reset the round counter
        roundNum = -1;
        //Call nextRound
        nextRound(System.currentTimeMillis());
    }

    private void nextRound(HandEyeBall ball) {
        remove(ball);
        nextRound(ball.getStartTime());
    }
    /**
     * Executed when a circle has been clicked and it is time to begin the next round
     */
    private void nextRound(long prevTime) {
        if (roundNum >= NUM_ROUNDS - 1) {
            endGame();
            return;
        } 
        long currentTime = System.currentTimeMillis();
        if (roundNum > -1) {
            //record reaction time
            long score = currentTime - prevTime;
            userScore[roundNum] = score;
            System.out.print("Current round: " + roundNum);
            System.out.println(", this round's score: " + score);
            gameScoreListener.gameScoreEvent(
                new GameScoreEvent(this, getScore(), false)
            );
        }
        roundNum++;

        //Create a new ball
        HandEyeBall ball = new HandEyeBall(currentTime);
        //Add the ball to the panel
        add(ball);
        Container pane = this;
        Dimension size = ball.getPreferredSize();
        ball.setBounds(
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
        long sumScore = getScore();
        System.out.println("Final score is: " + sumScore);
        gameScoreListener.gameScoreEvent(
            new GameScoreEvent(this, sumScore, true)
        );
    }
    public long getScore() {
        long sumScore = 0;
        //Show quit/new game buttons
        for (long score : userScore) {
            sumScore += score;
            //System.out.println(score);
        }
        return sumScore;
    }

    /**
     * Returns a random point on the game surface in one dimension
     *
     * @param ballSize - used to shift the ball positioning 
     * so it doesn't go off the screen
     * @param max - max allowd position on this axis
     */
    private int getRandom(int max, int ballSize) {
        //Add one since nextInt is non-enclusive
        int centerBall = random.nextInt(
            (max + 1) - (ballSize)
        );
        //Shift 
        //return centerBall + (ballSize / 2);
        return centerBall;
    }
    public Dimension getPreferredSize() {
        //return new Dimension(xMax + 20, yMax + 20);
        return new Dimension(xMax, yMax);
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
            return new Dimension(20, 20);
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
