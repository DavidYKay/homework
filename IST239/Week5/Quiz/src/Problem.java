/**
 * Representation of a math problem
 */
public class Problem {
	/** First term in math problem */
	private int a;
	/** Second term in math problem */
	private int b;
	private QuizType operation;
	/** Correct answer, hidden from user */
	private int answer;

	public Problem(QuizType operation, int a, int b) {
		this.operation = operation;

		this.a = a;
		this.b = b;
		switch (operation.getSymbol()) {
			case '+':
				this.answer = a + b;
				break;
			case '-':
				this.answer = a - b;
				break;
			case 'x':
				this.answer = a * b;
				break;
			case '/':
				this.answer = a / b;
				break;
		}
	}

	public int getAnswer() {
		return answer;
	}

	/**
	 * Get string representation, sans answer
	 */
	public String getQuestionString() {
		return String.format(
			//"%i %s %i = ",
			"%d %s %d = ",
			a,
			operation.getSymbol(),
			b
		);
	}

	public String toString() {
		return getQuestionString() + answer;
	}
}
