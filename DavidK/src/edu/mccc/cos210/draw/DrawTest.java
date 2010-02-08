package edu.mccc.cos210.draw;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.regex.*;
import javax.swing.*;
import com.cbthinkx.util.Debug;
public class DrawTest {
	public DrawTest() {
		Debug.println("DrawTest()");
		JFrame jf = new JFrame("Draw Test");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		TransformControl tc = new TransformControl();
		jf.add(
			tc,
			BorderLayout.WEST
		);
		JPanel jp = new MyJPanel(tc);
		jf.add(
			jp,
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
					new DrawTest();
				}
			}
		);
	}
	private class MyJPanel extends JPanel implements ActionListener {
		TransformControl tc;
		public MyJPanel(TransformControl tc) {
			Debug.println("MyJPanel.MyJPanel()");
			setLayout(null);
			setBackground(new Color(128, 0, 255));
			this.tc = tc;
			tc.getButton().addActionListener(this);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Debug.println("MyJPanel.paintComponent()");
			Graphics2D g2d = (Graphics2D) g.create();
			transformGraphics(g2d);
			Shape s = tc.getShapeTransform().createTransformedShape(
				new Scrobus().getShape()
			);
			g2d.setPaint(Color.WHITE);
			g2d.fill(s);
			g2d.setPaint(Color.BLACK);
			g2d.draw(s);
			g2d.dispose();
		}
		private void transformGraphics(Graphics2D g2d) {
			Debug.println("MyJPanel.transformGraphics()");
			AffineTransform at = tc.getGraphicsTransform();
			g2d.transform(at);
		}
		public Dimension getPreferredSize() {
			Debug.println("MyJPanel.getPreferredSize()");
			return new Dimension(800, 600);
		}
		public void actionPerformed(ActionEvent e) {
			Debug.println("MyJPanel.actionPerformed()");
			repaint();
		}
	}
	private class TransformControl extends Box {
		private JButton jb = new JButton("Apply");
		private MyJTextField[] mjtf = new MyJTextField[10];
		public TransformControl() {
			super(BoxLayout.X_AXIS);
			Debug.println("TransformControl.TransformControl()");
			Box box = new Box(BoxLayout.Y_AXIS);
			box.add(Box.createVerticalGlue());
			for (int i = 0; i < 5; i++) {
				box.add(
					this.mjtf[i] = new MyJTextField(
						i == 2 || i == 3 ? "1.0" : "0.0"
					)
				);
			}
			box.add(Box.createVerticalStrut(24));
			for (int i = 0; i < 5; i++) {
				box.add(
					this.mjtf[i + 5] = new MyJTextField(
						i == 2 || i == 3 ? "1.0" : "0.0"
					)
				);
			}
			box.add(Box.createVerticalStrut(24));
			box.add(this.jb);
			box.add(Box.createVerticalGlue());
			add(Box.createHorizontalStrut(24));
			add(box);
			add(Box.createHorizontalGlue());
		}
		public JButton getButton() {
			Debug.println("TransformControl.getButton()");
			return this.jb;
		}
		public AffineTransform getShapeTransform() {
			Debug.println("TransformControl.getShapeTransform()");
			AffineTransform at = new AffineTransform();
			try {
				at.translate(
					Double.parseDouble(mjtf[0].getText()),
					Double.parseDouble(mjtf[1].getText())
				);
				at.scale(
					Double.parseDouble(mjtf[2].getText()),
					Double.parseDouble(mjtf[3].getText())
				);
				at.rotate(
					Math.toRadians(
						Double.parseDouble(mjtf[4].getText())
					)
				);
			} catch (NumberFormatException ex) {
			}
			return at;
		}
		public AffineTransform getGraphicsTransform() {
			Debug.println("TransformControl.getGraphicsTransform()");
			AffineTransform at = new AffineTransform();
			try {
				at.translate(
					Double.parseDouble(mjtf[5].getText()),
					Double.parseDouble(mjtf[6].getText())
				);
				at.scale(
					Double.parseDouble(mjtf[7].getText()),
					Double.parseDouble(mjtf[8].getText())
				);
				at.rotate(
					Math.toRadians(
						Double.parseDouble(mjtf[9].getText())
					)
				);
			} catch (NumberFormatException ex) {
			}
			return at;
		}
		private class MyJTextField extends JTextField {
			private String defaultText;
			public MyJTextField(String s) {
				super(s, 10);
				Debug.println("MyJTextField.MyJTextField()");
				this.defaultText = s;
				setHorizontalAlignment(JTextField.RIGHT);
				setInputVerifier(new MyInputVerifier());
			}
			public Dimension getMaximumSize() {
				Debug.println("MyJTextField.getMaximumSize()");
				return new Dimension(128, 12);
			}
			public String getDefaultText() {
				Debug.println("MyJTextField.getDefaultText()");
				return this.defaultText;
			}
			private class MyInputVerifier extends InputVerifier {
				private final Pattern p = Pattern.compile(
					"^-?[0-9]*\\.?[0-9]+|-?[0-9]+\\.?[0-9]*$"
				);
				public boolean verify(JComponent input) {
					Debug.println("MyInputVerifier.verify()");
					MyJTextField mjtf = (MyJTextField) input;
					Matcher m = p.matcher(mjtf.getText());
					if (!m.matches()) {
						mjtf.setText(mjtf.getDefaultText());
					}
					return true;
				}
			}
		}
	}
	private class Scrobus {
		private Path2D p2d = new Path2D.Double();
		public Scrobus() {
			Debug.println("Scrobus.Scrobus()");
			this.p2d.moveTo(-10.0, 20.0);
			this.p2d.lineTo(0.0, -20.0);
			this.p2d.lineTo(10.0, 20.0);
			this.p2d.lineTo(-10.0, 20.0);
			this.p2d.moveTo(-0.1, -0.1);
			this.p2d.lineTo(-0.1, 0.1);
			this.p2d.lineTo(0.1, 0.1);
			this.p2d.lineTo(0.1, -0.1);
			this.p2d.closePath();
		}
		public Shape getShape() {
			Debug.println("Scrobus.getShape()");
			return this.p2d;
		}
	}
}
