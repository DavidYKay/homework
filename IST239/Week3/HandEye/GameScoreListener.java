import java.util.EventListener;

public interface GameScoreListener extends EventListener {
	public void gameScoreEvent(GameScoreEvent e);
}
