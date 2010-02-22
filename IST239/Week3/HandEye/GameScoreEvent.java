import java.util.EventObject;
public class GameScoreEvent extends EventObject { 
	private long score;

	public GameScoreEvent(Object source, long score) {
		super(source);
		this.score = score;
	}

	public long getScore() {
		return score;
	} 
}
