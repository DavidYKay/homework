package edu.mccc.cos210.leddisplay;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class LEDDisplayTest {
	private static String script = "leddisplaydefault.txt";
	public LEDDisplayTest() {
		Debug.println("LEDDisplayTest.LEDDisplayTest()");
		JFrame jf = new JFrame("LED Display Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent jc = new LEDDisplay(this.script).getView();
		jf.add(
			jc,
			BorderLayout.CENTER
		);
		jf.pack();
		jf.setResizable(false);
		jf.setVisible(true);
		new Thread((Runnable) jc).start();
	}
	public static void main(String[] sa) {
		Debug.println("LEDDisplayTest.main()");
		if (sa.length > 0) {
			script = sa[0];
		}
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					Debug.println("LEDDisplayTest.Runnable.run()");
					new LEDDisplayTest();
				}
			}
		);
	}
}
