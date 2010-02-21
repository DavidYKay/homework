import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class HandEyePanel extends JPanel {

    private static final int TICK_SPEED = 333;

    /** Number of rounds that will be played */
    private static final int NUM_ROUNDS = 20;
    /** Holds the score of the user from each round  */
    private int[] userScore = new int[NUM_ROUNDS];

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
        //Call nextRound
        nextRound();
       // timer = new Timer(speed, this);
       // timer.setInitialDelay(pause);
       // timer.start(); 
    }

    /**
     * Executed when a circle has been clicked and it is time to bein the next round
     */
    private void nextRound() {
        if (roundNum > NUM_ROUNDS) {
            endGame();
            return;
        } 
        roundNum++;
        //Create a new ball
        //HandEyeBall ball = new HandEyeBall(
        //    getRandomX(),
        //    getRandomY()
        //);
        HandEyeBall ball = new HandEyeBall();
        //Add the ball to the panel
        
        //Mark the time
        roundStartTime = System.currentTimeMillis();
    }

    private void endGame() {
        //Display user's score
        //Show quit/new game buttons
    }

    private int getRandomX() {
        //Add one since nextInt is non-enclusive
        return random.nextInt(xMax + 1);
    }
    private int getRandomY() {
        //Add one since nextInt is non-enclusive
        return random.nextInt(yMax + 1);
    }
    public Dimension getPreferredSize() {
        return new Dimension(xMax + 20, yMax + 20);
    }

    /**
     * A clickable ball, used in the game
     */
    private class HandEyeBall extends JButton {
        /**
         * Returns a new ball in a given location on the screen
         */
        //private HandEyeBall(int x, int y) {
        //    setLocation(x, y);
        private HandEyeBall() {
            //Start a new round when clicked
            addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        nextRound();
                    }
            });
        }
    }
}
