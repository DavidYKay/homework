package edu.mccc.cos210.crash;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.vecmath.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class CrashTest {
	static {
		boolean debug = Debug.DEBUG;
	}
	private Timer timer;
	public CrashTest() {
		Debug.println("CrashTest:CrashTest()");
		JFrame jf = new JFrame("CrashTest");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Car[] car = new Car[2];
		car[0] = Car.loadCar("Car1");
		//car[0] = Car.loadCar("MommasBadBoy");
		car[1] = Car.loadCar("Car2");
		MyJPanel mjp = new MyJPanel(car);
		jf.add(
			mjp,
			BorderLayout.CENTER
		);
		jf.pack();
		jf.setVisible(true);
		this.timer = new Timer(100, mjp);
		this.timer.start();
		mjp.requestFocus();
	}
	public static void main(String[] sa) {
		Debug.println("CrashTest:main()");
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					Debug.println("Runnable:run()");
					new CrashTest();
				}
			}
		);
	}
	public class MyJPanel extends JPanel implements ActionListener, KeyListener {
		private Car[] car;
		private AffineTransform[] at;
		private double[] torque;
		private double[] direction;
		private double[] speed;
		private double[] deltaR;
		private double[] crashR;
		private double[] crashX;
		private double[] crashY;
		private boolean crash = false;
		private final double scale = 50.0;
		private Vector3d card0 = new Vector3d();
		private Vector3d card1 = new Vector3d();
		public MyJPanel(Car[] car) {
			Debug.println("MyJPanel:MyJPanel()");
			setLayout(null);
			addKeyListener(this);
			this.car = car;
			this.at = new AffineTransform[2];
			this.torque = new double[2];
			this.direction = new double[2];
			this.speed = new double[2];
			this.deltaR = new double[2];
			this.crashR = new double[2];
			this.crashX = new double[2];
			this.crashY = new double[2];
			init();
		}
		private void init() {
			Debug.println("MyJPanel:init()");
			this.at[0] = new AffineTransform();
			this.at[0].translate(-200.0, 0.0);
			this.at[0].scale(this.scale, this.scale);
			this.at[0].rotate(-Math.PI / 2.0);
			this.at[1] = new AffineTransform();
			this.at[1].translate(0.0, 0.0);
			this.at[1].scale(this.scale, this.scale);
			this.at[1].rotate(-Math.PI / 2.0);
			this.torque[0] = 0.0;
			this.direction[0] = -Math.PI / 2.0;
			this.speed[0] = 0.2;
			this.deltaR[0] = 0.0;
			this.crashR[0] = 0.0;
			this.crashX[0] = 0.0;
			this.crashY[0] = 0.0;
			this.torque[1] = 0.0;
			this.direction[1] = -Math.PI / 2.0;
			this.speed[1] = 0.0;
			this.deltaR[1] = 0.0;
			this.crashR[1] = 0.0;
			this.crashX[1] = 0.0;
			this.crashY[1] = 0.0;
			this.crash = false;
		}
		public Dimension getPreferredSize() {
			Debug.println("MyJPanel:getPreferredSize()");
			return new Dimension(800, 600);
		}
		protected void paintComponent(Graphics g) {
			Debug.println("MyJPanel:paintComponent()");
			if (this.crash) {
				setBackground(Color.WHITE);
				if (Debug.DEBUG) {
					timer.stop();
				}
			} else {
				setBackground(Color.LIGHT_GRAY);
			}
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			AffineTransform gat = new AffineTransform();
			gat.translate(getWidth() / 2.0, getHeight() / 2.0);
			gat.scale(1.0, -1.0);
			g2d.transform(gat);
			Graphics2D g2dp = (Graphics2D) g2d.create();
			car[0].paintCar(this, g2dp, at[0], Car.View.TOP_VIEW);
			car[1].paintCar(this, g2dp, at[1], Car.View.TOP_VIEW);
			g2dp.dispose();
			if (Debug.DEBUG) {
				Ellipse2D hit0 = new Ellipse2D.Double(
					this.at[0].getTranslateX() - 50.0,
					this.at[0].getTranslateY() - 50.0,
					100.0,
					100.0
				);
				g2d.setPaint(Color.ORANGE);
				g2d.draw(hit0);
				Ellipse2D hit1 = new Ellipse2D.Double(
					this.at[1].getTranslateX() - 50.0,
					this.at[1].getTranslateY() - 50.0,
					100.0,
					100.0
				);
				g2d.draw(hit1);
				Line2D l2d0 = new Line2D.Double(
					this.at[0].getTranslateX(),
					this.at[0].getTranslateY(),
					this.at[0].getTranslateX() + this.card0.getX() * 300.0,
					this.at[0].getTranslateY() + this.card0.getY() * 300.0
				);
				Line2D l2d1 = new Line2D.Double(
					this.at[1].getTranslateX(),
					this.at[1].getTranslateY(),
					this.at[1].getTranslateX() + this.card1.getX() * 300.0,
					this.at[1].getTranslateY() + this.card1.getY() * 300.0
				);
				Line2D between = new Line2D.Double(
					this.at[1].getTranslateX(),
					this.at[1].getTranslateY(),
					this.at[0].getTranslateX(),
					this.at[0].getTranslateY()
				);
				g2d.setPaint(new Color(80, 90, 90).darker());
				g2d.draw(between);
				g2d.setPaint(new Color(105, 70, 255));
				g2d.draw(l2d0);
				g2d.draw(l2d1);
			}
			g2d.dispose();
		}
		public void actionPerformed(ActionEvent e) {
			Debug.println("ActionListener:actionPerformed()");
			AffineTransform tat;
			this.crashR[0] = fadeCrash(this.crashR[0]);
			this.crashR[1] = fadeCrash(this.crashR[1]);
			this.crashX[0] = fadeCrash(this.crashX[0]);
			this.crashX[1] = fadeCrash(this.crashX[1]);
			this.crashY[0] = fadeCrash(this.crashY[0]);
			this.crashY[1] = fadeCrash(this.crashY[1]);
			tat = new AffineTransform();
			tat.translate(this.crashY[0], this.speed[0] + this.crashX[0]);
			this.at[0].concatenate(tat);
			tat = new AffineTransform();
			tat.translate(this.crashY[0], this.speed[1] + this.crashX[1]);
			this.at[1].concatenate(tat);
			tat = new AffineTransform();
			tat.rotate(this.crashR[0]);
			this.at[0].concatenate(tat);
			tat = new AffineTransform();
			tat.rotate(this.crashR[1]);
			this.at[1].concatenate(tat);
			bumpDirection(0, this.crashR[0]);
			bumpDirection(1, this.crashR[1]);
			if (!this.crash) {
				checkCollision();
			}
			repaint();
		}
		private void bumpDirection(int index, double value) {
			Debug.println("MyJPanel:bumpDirection()");
			this.direction[index] += value;
			while (this.direction[index] > Math.PI * 2.0) {
				this.direction[index] -= Math.PI * 2.0;
			}
			while (this.direction[index] < 0.0) {
				this.direction[index] += Math.PI * 2.0;
			}
		}
		private double fadeCrash(double var) {
			Debug.println("MyJPanel:fadeCrash()");
			if (var < 0.01 && var > -0.01) {
				var = 0.0;
				this.crash = false;
			} else {
				var *= 0.9;
			}
			return var;
		}
		protected void checkCollision() {
			Debug.println("MyJPanel:checkCollision()");
			Point2d p2d0 = new Point2d(
				this.at[0].getTranslateX(),
				this.at[0].getTranslateY()
			);
			Point2d p2d1 = new Point2d(
				this.at[1].getTranslateX(),
				this.at[1].getTranslateY()
			);
			double dist = Math.abs(p2d0.distance(p2d1));
			if (dist <= this.scale * 2.0) {
				this.crash = true;
				computeCrash();
				this.crashR[0] = this.torque[0] / 6.0;
				this.crashR[1] = this.torque[1] / 6.0;
			} else {
				this.crash = false;
			}
		}
		protected void computeCrash() {
			Debug.println("MyJPanel:computeCrash()");
			Vector3d carp0 = new Vector3d(
				this.at[0].getTranslateX(),
				this.at[0].getTranslateY(),
				0.0
			);
			Vector3d carp1 = new Vector3d(
				this.at[1].getTranslateX(),
				this.at[1].getTranslateY(),
				0.0
			);
			this.card0 = new Vector3d(
				Math.cos(this.direction[0] + Math.PI / 2.0),
				Math.sin(this.direction[0] + Math.PI / 2.0),
				0.0
			);
			this.card0.scale(this.speed[0]);
			this.card1 = new Vector3d(
				Math.cos(this.direction[1] + Math.PI / 2.0),
				Math.sin(this.direction[1] + Math.PI / 2.0),
				0.0
			);
			this.card1.scale(this.speed[1]);
			Vector3d bump = new Vector3d();
			Vector3d r0 = new Vector3d();
			bump.sub(this.card0, this.card1);
			r0.sub(carp1, carp0);
			r0.scale(0.5);
			Vector3d r0perp = new Vector3d(
				-r0.y,
				r0.x,
				0.0
			);
			r0perp.normalize();
			double dot = r0perp.dot(bump);
			r0perp.scale(dot);
			Vector3d torque = new Vector3d();
			torque.cross(r0perp, r0);
			if (torque.z < 0.0001 && torque.z > -0.0001) {
				torque = new Vector3d(0.0, 0.0, 0.0);
			}
			if (this.card0.angle(r0) > Math.PI / 4.0 && this.card0.angle(r0) < Math.PI * 3.0 / 4.0) {
				this.torque[0] = -torque.z;
			} else {
				this.torque[0] = torque.z;
			}
			Vector3d crash0 = transformWorldToCar(bump, this.direction[0]);
			this.crashX[0] = crash0.x;
			this.crashY[0] = crash0.y;
			bump.sub(this.card1, this.card0);
			r0.sub(carp0, carp1);
			r0.scale(0.5);
			r0perp = new Vector3d(
				-r0.y,
				r0.x,
				0.0
			);
			r0perp.normalize();
			dot = r0perp.dot(bump);
			r0perp.scale(dot);
			torque = new Vector3d();
			torque.cross(r0perp, r0);
			if (torque.z < 0.0001 && torque.z > -0.0001) {
				torque = new Vector3d(0.0, 0.0, 0.0);
			}
			if (this.card1.angle(r0) > Math.PI / 4.0 && this.card1.angle(r0) < Math.PI * 3.0 / 4.0) {
				this.torque[1] = -torque.z;
			} else {
				this.torque[1] = torque.z;
			}
			Vector3d crash1 = transformWorldToCar(bump, this.direction[1]);
			this.crashX[1] = crash1.x;
			this.crashY[1] = crash1.y;
		}
		private Vector3d transformWorldToCar(Vector3d v3d, double carAngle) {
			Debug.println("MyJPanel:transformWorldToCar()");
			double length = v3d.length();
			if (carAngle > Math.PI / 2.0 && carAngle < Math.PI * 3.0 / 2.0) {
				length *= -1.0;
			}
			length *= -1.0;
			double angle = v3d.angle(new Vector3d(1.0, 0.0, 0.0));
			double dangle = angle - carAngle;
			Vector3d ans = new Vector3d(Math.sin(dangle), Math.cos(dangle), 0.0);
			ans.normalize();
			ans.scale(length);
			return ans;
		}
		public void keyPressed(KeyEvent e) {
			Debug.println("KeyListener:keyPressed()");
			AffineTransform tat = new AffineTransform();
			double turnValue = 0.25;
			double speedBump = 1.1;
			double speedMax = 0.2;
			double speedDump = 0.9;
			switch (e.getKeyCode()) {
				case KeyEvent.VK_ESCAPE:
					init();
					break;
				case KeyEvent.VK_A:
					if (this.speed[0] > 0.005) {
						tat.rotate(turnValue);
						this.at[0].concatenate(tat);
						bumpDirection(0, turnValue);
					}
					break;
				case KeyEvent.VK_D:
					if (this.speed[0] > 0.005) {
						tat.rotate(-turnValue);
						this.at[0].concatenate(tat);
						bumpDirection(0, -turnValue);
					}
					break;
				case KeyEvent.VK_W:
					this.speed[0] *= speedBump;
					this.speed[0] = this.speed[0] > speedMax ? speedMax : this.speed[0];
					break;
				case KeyEvent.VK_S:
					this.speed[0] *= speedDump;
					this.speed[0] = this.speed[0] < 0.0 ? 0.0 : this.speed[0];
					break;
				case KeyEvent.VK_LEFT:
					if (this.speed[1] > 0.005) {
						tat.rotate(turnValue);
						this.at[1].concatenate(tat);
						bumpDirection(1, turnValue);
					}
					break;
				case KeyEvent.VK_RIGHT:
					if (this.speed[1] > 0.005) {
						tat.rotate(-turnValue);
						this.at[1].concatenate(tat);
						bumpDirection(1, -turnValue);
					}
					break;
				case KeyEvent.VK_UP:
					this.speed[1] *= speedBump;
					this.speed[1] = this.speed[1] > speedMax ? speedMax : this.speed[1];
					break;
				case KeyEvent.VK_DOWN:
					this.speed[1] *= speedDump;
					this.speed[1] = this.speed[1] < 0.0 ? 0.0 : this.speed[1];
					break;
				case KeyEvent.VK_SPACE:
					if (Debug.DEBUG) {
						if (timer.isRunning()) {
							timer.stop();
						} else {
							timer.start();
						}
					}
					break;
				default:
					break;
			}
		}
		public void keyReleased(KeyEvent e) {
			Debug.println("KeyListener:keyReleased()");
			switch (e.getKeyCode()) {
				case KeyEvent.VK_A:
					this.deltaR[0] = 0.0;
					break;
				case KeyEvent.VK_D:
					this.deltaR[0] = 0.0;
					break;
				case KeyEvent.VK_LEFT:
					this.deltaR[1] = 0.0;
					break;
				case KeyEvent.VK_RIGHT:
					this.deltaR[1] = 0.0;
					break;
				default:
					break;
			}
		}
		public void keyTyped(KeyEvent e) {
			Debug.println("KeyListener:keyTyped()");
		}
	}
}
