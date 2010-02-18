package edu.mccc.cos210.mvc;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class MVCTest {
	public MVCTest() {
		Debug.println("MVCTest()");
		JFrame jf = new JFrame("MVC Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JComponent jc1 = new MVCCoordinator().getView1();
		jf.add(
			jc1,
			BorderLayout.CENTER
		);
		JComponent jc2 = new MVCCoordinator().getView2();
		jf.add(
			jc2,
			BorderLayout.SOUTH
		);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] sa) {
		Debug.println("main()");
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					new MVCTest();
				}
			}
		);
	}
}
