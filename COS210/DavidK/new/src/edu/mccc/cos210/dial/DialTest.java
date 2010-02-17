package edu.mccc.cos210.dial;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class DialTest {
	public DialTest() {
		Debug.println("DialTest()");
		JFrame jf = new JFrame("Dial Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent jc1 = new MVCCoordinator().getView1();
		jf.add(
			jc1,
			BorderLayout.WEST
		);
		JComponent jc2 = new MVCCoordinator().getView2();
		jf.add(
			jc2,
			BorderLayout.SOUTH
		);
		JComponent jc3 = new MVCCoordinator().getView3();
		jf.add(
			jc3,
			BorderLayout.CENTER
		);
		jf.pack();
		jf.setResizable(true);
		jf.setVisible(true);
	}
	public static void main(String[] sa) {
		Debug.println("main()");
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					new DialTest();
				}
			}
		);
	}
}
