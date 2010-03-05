package edu.mccc.cos210.leddisplay;
import java.io.*;
import com.cbthinkx.util.Debug;
public class LEDDisplay {
	private LEDDisplayQueue queue;
	private LEDDisplayView view;
	public LEDDisplay(String script) {
		Debug.println("LEDDisplay.LEDDisplay()");
		this.queue = new LEDDisplayQueue();
		loadQueue(script);
		this.view = new LEDDisplayView(this.queue);
	}
	private void loadQueue(String script) {
		Debug.println("LEDDisplay.loadQueue()");
		try {
			BufferedReader br = new BufferedReader(
				new FileReader(script)
			);
			String s;
			while ((s = br.readLine()) != null) {
				String[] sa = s.trim().split(":");
				if (sa.length == 2) {
					queue.enqueue(
						new LEDDisplayItem(
							sa[1],
							LEDDisplayTransition.getTransition(sa[0])
						)
					);
				}
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	public LEDDisplayView getView() {
		Debug.println("LEDDisplay.getView()");
		return this.view;
	}
}
