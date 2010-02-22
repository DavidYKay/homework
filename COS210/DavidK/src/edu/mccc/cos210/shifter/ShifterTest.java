package edu.mccc.cos210.shifter;
import java.awt.*;
import java.io.*;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class ShifterTest implements ShifterModelListener {
	private JFrame jf;
	public ShifterTest() {
		Debug.println("ShifterTest:ShifterTest()");
		this.jf = new JFrame("ShifterTest");
		this.jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(new Color(255, 128, 0));
		//String s = "MyCar";
		String s = "MommasBadBoy";
		Car car = Car.loadCar(s);
		int maxGear = 2;
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(
				new FileInputStream("../racecars.xml")
			);
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			maxGear = Integer.parseInt(
				xp.evaluate(
					"//racecars/racecar[@carname='" + s + "']/@gears",
					doc
				)
			);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
        Debug.println("MaxGear: " + maxGear);
		ShifterCoordinator sc = new ShifterCoordinator(car, maxGear);
		sc.getModel().addShifterModelListener(this);
		JComponent jcr = sc.getController();
		JComponent jc = sc.getView();
		jcr.add(jc);
		this.jf.add(jcr, BorderLayout.CENTER);
		this.jf.pack();
		this.jf.setVisible(true);
		jcr.requestFocus();
	}
	public static void main(String[] sa) {
		Debug.println("ShifterTest:main()");
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					Debug.println("Runnable:run()");
					new ShifterTest();
				}
			}
		);
	}
	public void shift(ShifterModelEvent e) {
		Debug.println("ShifterTest:shift()");
		this.jf.setTitle(String.valueOf(e.getGear()));
	}
}
