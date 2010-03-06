import java.util.Random;
import javax.swing.event.*;

/**
 * Responsible for maintaining current state
 */
public class QuizModel {
	private QuizType  quizType;
	private QuizLevel quizLevel;
	private boolean running;
	
	private int score;
	/** Current math problem */
	private Problem problem;

	private Random rand;

	public QuizModel() {
		this.quizType  = QuizType.ADD;
		this.quizLevel = QuizLevel.ZERO_FIVE;
		this.rand = new Random();
	}
	
	public void startQuiz() {
		//Clear out the score
		score = 0;
		running = true;
		nextProblem();
	}
	public void stopQuiz() {
		running = false;
		//Stop timer
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
		//FIXME make this work!
		return 2;
	}
	public void answerProblem(int answer) {
		if (answer == problem.getAnswer()) {
			score++;
		}
		nextProblem();
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
	 * Event listener code modified from MVC example from 
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
