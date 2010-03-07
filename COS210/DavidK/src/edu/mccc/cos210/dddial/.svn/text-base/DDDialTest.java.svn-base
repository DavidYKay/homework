package edu.mccc.cos210.dddial;
import java.awt.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class DDDialTest {
	public DDDialTest() {
		Debug.println("DDDialTest()");
		JFrame jf = new JFrame("Dial Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//DDDial jc1 = new DanDial(
		DDDial jc1 = new DaveDial(
            new TestModel(
                //0,
                //360,
                //0,
                //720
                0,
                180,
                0,
                360
            )
        );
		jf.add(
			jc1,
			BorderLayout.CENTER
		);
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] sa) {
		Debug.println("main()");
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					new DDDialTest();
				}
			}
		);
	}
}
