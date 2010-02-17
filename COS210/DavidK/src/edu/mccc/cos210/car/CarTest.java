package edu.mccc.cos210.car;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import com.cbthinkx.util.Debug;
public class CarTest {
	public CarTest() {
		Debug.println("CarTest:CarTest()");
		JFrame jf = new JFrame("CarTest");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(1, 2));
		Car car = Car.loadCar("MommasBadBoy");
		MyJPanel mjp = new MyJPanel(car, Car.View.TOP_VIEW);
		jp.add(mjp);
		jp.add(new MyJPanel(car, Car.View.SIDE_VIEW));
		jf.add(
			jp,
			BorderLayout.CENTER
		);
		JSlider js = new JSlider(-180, 180, 0);
		js.addChangeListener(mjp);
		jf.add(
			js,
			BorderLayout.SOUTH
		);
		jf.setTitle(jf.getTitle() + " " + car.toString());
		jf.pack();
		jf.setVisible(true);
	}
	public static void main(String[] sa) {
		Debug.println("CarTest:main()");
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					Debug.println("Runnable:run()");
					new CarTest();
				}
			}
		);
	}
	public class MyJPanel extends JPanel implements ChangeListener {
		private Car car;
		private Car.View view;
		private double rotation = 0.0;
		public MyJPanel(Car car, Car.View view) {
			Debug.println("MyJPanel:MyJPanel()");
			setLayout(null);
			setBackground(Color.LIGHT_GRAY);
			this.car = car;
			this.view = view;
		}
		public Dimension getPreferredSize() {
			Debug.println("MyJPanel:getPreferredSize()");
			return new Dimension(384, 384);
		}
		protected void paintComponent(Graphics g) {
			Debug.println("MyJPanel:paintComponent()");
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			AffineTransform gat = new AffineTransform();
			gat.translate(getWidth() / 2, getHeight() / 2);
			gat.scale(1.0, -1.0);
			g2d.transform(gat);
			AffineTransform at = new AffineTransform();
			at.scale(getWidth() / 3.0, getWidth() / 3.0);
			if (view == Car.View.TOP_VIEW) {
				at.rotate(this.rotation);
			}
			car.paintCar(this, g2d, at, view);
			g2d.dispose();
		}
		public void stateChanged(ChangeEvent e) {
			Debug.println("MyJPanel:stateChanged()");
			this.rotation = Math.toRadians(
				((JSlider) e.getSource()).getValue()
			);
			repaint();
		}
	}
}
