import java.util.EventListener;

public interface EndGameListener extends EventListener {
	public void endGameEvent(EndGameEvent e);
}
