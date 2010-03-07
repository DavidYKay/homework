import java.util.Random;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.Timer;

/**
 * Responsible for maintaining current state
 */
public class QuizModel {
	private QuizType  quizType;
	private QuizLevel quizLevel;
	
	private int score;
	/** Current math problem */
	private Problem problem;
	/** Time elapsed */
	private int seconds;

	private Timer timer;

	private Random rand;

	public QuizModel() {
		this.quizType  = QuizType.ADD;
		this.quizLevel = QuizLevel.ZERO_FIVE;
		this.rand = new Random();
		this.timer = new Timer(
			1000,
			new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					updateTime();
				}
			}
		);
	}
	
	public void startQuiz() {
		//Clear out the score
		score = 0;
		seconds = 0;
		nextProblem();
		timer.start();
	}
	public void stopQuiz() {
		//Stop timer
		timer.stop();
	}

	public void setType(QuizType quizType) {
		this.quizType = quizType;
		//nextProblem();
	}
	public QuizType getType() {
		return this.quizType;
	}
	public void setLevel(QuizLevel quizLevel) {
		this.quizLevel = quizLevel;
		//nextProblem();
	}
	public QuizLevel getLevel() {
		return this.quizLevel;
	}
	public Problem getProblem() {
		return this.problem;
	}
	public int getScore() {
		return this.score;
	}
	public int getTimeElapsed() {
		return this.seconds;
	}
	public void answerProblem(int answer) {
		if (answer == problem.getAnswer()) {
			score++;
		}
		nextProblem();
	}
	private void updateTime() {
		seconds++;
		notifyListeners();
	}
	private void nextProblem() {
		int a = generateLegalNum();
		int b = generateLegalNum();
		this.problem = new Problem(
			quizType,
			a,
			b
		);
		notifyListeners();
	}
	private int generateLegalNum() {
		int extent = quizLevel.getMax() - quizLevel.getMin();
		int delta = rand.nextInt(extent + 1);
		int num = quizLevel.getMin() + delta;
		return num;
	}

	/**
	 * Event listener code modified from Prof Bostain's MVC example 
	 * available at:
	 * http://cos210.drbco.com/mccc/COS210/DaveB/MVC/mvc.jar
	 */
	private EventListenerList listenerList = new EventListenerList();
	public void addListener(QuizListener l) {
		listenerList.add(QuizListener.class, l);
	}
	public void removeListener(QuizListener l) {
		listenerList.remove(QuizListener.class, l);
	}
	private void notifyListeners() {
		QuizEvent e = new QuizEvent(this);
		Object[] listeners = listenerList.getListenerList();
		//Not sure why he uses this style of iteration
		for (int i = listeners.length - 2; i >= 0; i -= 2) {
			if (listeners[i] == QuizListener.class) {
				((QuizListener) listeners[i + 1]).stateChanged(e);
			}
		}
	}
}
