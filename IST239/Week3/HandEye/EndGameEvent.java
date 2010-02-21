import java.util.EventObject;
public class EndGameEvent extends EventObject { 
	private long score;

	public EndGameEvent(Object source, long score) {
		super(source);
		this.score = score;
	}

	public long getScore() {
		return score;
	} 
}
