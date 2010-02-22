import java.util.EventObject;
public class GameScoreEvent extends EventObject { 
	private long score;
    private boolean gameOver;

	public GameScoreEvent(Object source, long score, boolean gameOver) {
		super(source);
		this.score = score;
		this.gameOver = gameOver;
	}

	public long getScore() {
		return score;
	} 
	public boolean getGameOver() {
		return gameOver;
	} 
}
