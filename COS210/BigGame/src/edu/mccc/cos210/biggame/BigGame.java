package edu.mccc.cos210.biggame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import java.util.*;
import java.util.regex.*;
import javax.imageio.*;
import javax.swing.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class BigGame {
	static {
		boolean debug = Debug.DEBUG;
	}
	private JPanel jp;
	private Map<String, Car> cars;
	private DatagramSocket socket;
	private InetAddress ipaddr;
	private Pattern p;
	public BigGame(String car, String ip) {
		Debug.println("BigGame:BigGame()");
		JFrame jf = new JFrame("BigGame");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.cars = Collections.synchronizedMap(Car.loadCars());
		this.jp = new MyJPanel(this.cars.get(car), ip);
		jf.add(jp);
		jf.getContentPane().setBackground(Color.WHITE);
		jf.setResizable(false);
		jf.pack();
		jf.setVisible(true);
		this.p = Pattern.compile(
			"(.+):(-?\\d+\\.\\d+E?-?\\d*):(-?\\d+\\.\\d+E?-?\\d*):(-?\\d+\\.\\d+E?-?\\d*):(\\d+):AffineTransform\\[\\[(-?\\d+\\.\\d+E?-?\\d*), (-?\\d+\\.\\d+E?-?\\d*), (-?\\d+\\.\\d+E?-?\\d*)], \\[(-?\\d+\\.\\d+E?-?\\d*), (-?\\d+\\.\\d+E?-?\\d*), (-?\\d+\\.\\d+E?-?\\d*)]]"
		);
		try {
			String hello = "hi:" + car;
			this.ipaddr = InetAddress.getByName(ip);
			this.socket = new DatagramSocket();
			this.socket.send(
				new DatagramPacket(
					hello.getBytes(),
					hello.length(),
					ipaddr,
					5972
				)
			);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		new Thread() {
			public void run() {
				Debug.println("Thread:run()");
				try {
					for (;;) {
						DatagramPacket dp = new DatagramPacket(new byte[256], 256);
						socket.receive(dp);
						String msg = new String(dp.getData()).trim();
						Debug.println(msg);
						Matcher m = p.matcher(msg);
						try {
							m.find();
							AffineTransform cat = new AffineTransform(
								Double.parseDouble(m.group(6)),
								Double.parseDouble(m.group(9)),
								Double.parseDouble(m.group(7)),
								Double.parseDouble(m.group(10)),
								Double.parseDouble(m.group(8)),
								Double.parseDouble(m.group(11))
							);
							Car car = cars.get(m.group(1));
							car.setSpeed(
								Double.parseDouble(m.group(2))
							);
							car.setRPM(
								Double.parseDouble(m.group(3))
							);
							car.setDirection(
								Double.parseDouble(m.group(4))
							);
							car.getShifterModel().setGear(
								Integer.parseInt(m.group(5))
							);
							car.setActive(true);
							car.setAffineTransform(cat);
							jp.repaint();
						} catch (Exception ex) {
							System.err.println(ex.getMessage());
							System.err.println(msg);
						}
					}
				} catch (Exception ex) {
					System.err.println(ex.getMessage());
				}
			}
		}.start();
		jp.requestFocus();
	}
	public static void main(final String[] sa) {
		Debug.println("BigGame:main()");
		if (sa.length < 1) {
			System.err.println("usage: biggame <car> <ip>");
			System.exit(-1);
		}
		EventQueue.invokeLater(
			new Runnable() {
				public void run() {
					Debug.println("Runnable:run()");
					new BigGame(sa[0], "127.0.0.1");
				}
			}
		);
	}
	private class MyJPanel extends JPanel implements KeyListener {
		private Car car;
		private String ip;
		private BufferedImage track;
		private int trackWidth;
		private int trackHeight;
		public MyJPanel(Car car, String ip) {
			Debug.println("MyJPanel:MyJPanel()");
			this.car = car;
			car.setActive(true);
			setLayout(null);
			loadTrack();
			addKeyListener(this);
			ShifterView sv = new ShifterView(car.getShifterModel());
			sv.setBounds(400 - 72, 600 - 144, 144, 144);
			add(sv);
			Car.Speedometer speedo = this.car.createSpeedometer();
			speedo.setBounds(400 + 100, 600 - 128, 128, 128);
			add(speedo);
			Car.Tachometer tach = this.car.createTachometer();
			tach.setBounds(400 - 228, 600 - 128, 128, 128);
			add(tach);
		}
		public Dimension getPreferredSize() {
			Debug.println("MyJPanel:getPreferredSize()");
			return new Dimension(800, 600);
		}
		private void loadTrack() {
			Debug.println("MyJPanel:loadTrack()");
			try {
				this.track = ImageIO.read(
					new FileInputStream(
						"track.bmp"
					)
				);
				this.trackWidth = this.track.getWidth();
				this.trackHeight = this.track.getHeight();
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		protected void paintComponent(Graphics g) {
			Debug.println("MyJPanel:paintComponent()");
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			AffineTransform gat = new AffineTransform();

			BufferedImage bi = new BufferedImage(1600, 1200, BufferedImage.TYPE_INT_BGR);
			Graphics2D bg2d = (Graphics2D) bi.createGraphics();
			bg2d.drawRenderedImage(this.track, new AffineTransform());

			AffineTransform bat = new AffineTransform();
			bat.translate(800, 600);
			bat.scale(1.0, -1.0);
			bg2d.transform(bat);

			for (Car car : cars.values()) {
				if (car.isActive()) {
					AffineTransform cat = car.getAffineTransform();
					Graphics2D g2dp = (Graphics2D) bg2d.create();
					car.paintCar(this, g2dp, cat, Car.View.TOP_VIEW);
					g2dp.dispose();
				}
			}

			AffineTransform cat = this.car.getAffineTransform();
			gat.translate(
				 -400 - cat.getTranslateX(),
				 -300 + cat.getTranslateY()
			);

			g2d.drawRenderedImage(bi, gat);

			bg2d.dispose();

			AffineTransform mat = new AffineTransform();
			mat.translate(725.0, 600.0);
			mat.scale(-50.0, -50.0);
			car.paintCar(this, (Graphics2D) g, mat, Car.View.SIDE_VIEW);

			g2d.dispose();
		}
		public void keyPressed(KeyEvent e) {
			Debug.println("MyJPanel:keyPressed()");
			try {
				switch (e.getKeyCode()) {
					case KeyEvent.VK_A:
					case KeyEvent.VK_LEFT:
						socket.send(
							new DatagramPacket(
								"left".getBytes(),
								4,
								ipaddr,
								5972
							)
						);
						break;
					case KeyEvent.VK_D:
					case KeyEvent.VK_RIGHT:
						socket.send(
							new DatagramPacket(
								"right".getBytes(),
								5,
								ipaddr,
								5972
							)
						);
						break;
					case KeyEvent.VK_W:
					case KeyEvent.VK_UP:
						socket.send(
							new DatagramPacket(
								"speedup".getBytes(),
								7,
								ipaddr,
								5972
							)
						);
						break;
					case KeyEvent.VK_S:
					case KeyEvent.VK_DOWN:
						socket.send(
							new DatagramPacket(
								"brake".getBytes(),
								5,
								ipaddr,
								5972
							)
						);
						break;
					case KeyEvent.VK_COMMA:
						socket.send(
							new DatagramPacket(
								"downshift".getBytes(),
								9,
								ipaddr,
								5972
							)
						);
						break;
					case KeyEvent.VK_PERIOD:
						socket.send(
							new DatagramPacket(
								"upshift".getBytes(),
								7,
								ipaddr,
								5972
							)
						);
						break;
					default:
						break;
				}
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		public void keyReleased(KeyEvent e) {
			Debug.println("MyJPanel:keyReleased()");
		}
		public void keyTyped(KeyEvent e) {
			Debug.println("MyJPanel:keyTyped()");
		}
	}
}
