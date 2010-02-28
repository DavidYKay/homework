package edu.mccc.cos210.biggame;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.net.*;
import edu.mccc.cos210.car.*;
import com.cbthinkx.util.Debug;
public class BigGameServer implements ActionListener {
	private HashMap<SocketAddress, Car> cars = new HashMap<SocketAddress, Car>();
	private DatagramSocket socket;
	public BigGameServer() throws Exception {
		Debug.println("BigGameServer:BigGameServer()");
		this.socket = new DatagramSocket(5972);
		new javax.swing.Timer(100, this).start();
	}
	public static void main(String[] sa) throws Exception {
		Debug.println("BigGameServer:main()");
		BigGameServer server = new BigGameServer();
		server.doit();
	}
	private void doit() throws Exception {
		Debug.println("BigGameServer:doit()");
		for (;;) {
			DatagramPacket dp = new DatagramPacket(new byte[32], 32);
			socket.receive(dp);
			String msg = new String(dp.getData()).trim();
			Debug.println(msg);
			SocketAddress saddr = dp.getSocketAddress();
			if (msg.startsWith("hi")) {
				String[] sa = msg.split(":");
				Car car = Car.loadCar(sa[1]);
				car.setInetAddress(dp.getAddress());
				car.setPort(dp.getPort());
				cars.put(saddr, car);
			} else {
				Car car = cars.get(saddr);
				AffineTransform tat = new AffineTransform();
				double turnValue = 0.125;
				double speedBump = 1.1;
				double speedMax = car.getMaxSpeed() / 100.0;
				double speedDump = 0.9;
				if (msg.startsWith("left")) {
					if (car.getSpeed() > 0.005) {
						tat.rotate(turnValue);
						car.getAffineTransform().concatenate(tat);
						bumpDirection(car, turnValue);
					}
				} else {
					if (msg.startsWith("right")) {
						if (car.getSpeed() > 0.005) {
							tat.rotate(-turnValue);
							car.getAffineTransform().concatenate(tat);
							bumpDirection(car, -turnValue);
						}
					} else {
						if (msg.startsWith("speedup")) {
							car.setSpeed(car.getSpeed() * speedBump);
							car.setSpeed(car.getSpeed() > speedMax ? speedMax : car.getSpeed());
						} else {
							if (msg.startsWith("brake")) {
								car.setSpeed(car.getSpeed() * speedDump);
								car.setSpeed(car.getSpeed() < 0.0 ? 0.0 : car.getSpeed());
							} else {
								if (msg.startsWith("downshift")) {
									car.getShifterModel().downShift();
								} else {
									if (msg.startsWith("upshift")) {
										car.getShifterModel().upShift();
									}
								}
							}
						}
					}
				}
			}
		}
	}
	private void bumpDirection(Car car, double value) {
		Debug.println("BigGameServer:bumpDirection()");
		car.setDirection(car.getDirection() + value);
		while (car.getDirection() > Math.PI * 2.0) {
			car.setDirection(car.getDirection() - Math.PI * 2.0);
		}
		while (car.getDirection() < 0.0) {
			car.setDirection(car.getDirection() + Math.PI * 2.0);
		}
	}
	public void actionPerformed(ActionEvent e) {
		Debug.println("BigGameServer:actionPerformed()");
		try {
			for (Car car : cars.values()) {
				updateCar(car);
				String msg = car.getCarName() + ":" + car.getSpeed() + ":" + car.getRPM() + ":" + car.getDirection() + ":" + car.getShifterModel().getGear() + ":" + car.getAffineTransform().toString();
				Debug.println(msg);
				for (Car target : cars.values()) {
					DatagramPacket dp = new DatagramPacket(
						msg.getBytes(),
						msg.length(),
						target.getInetAddress(),
						target.getPort()
					);
					socket.send(dp);
				}
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	private void updateCar(Car car) {
		Debug.println("BigGameServer:updateCar()");
		AffineTransform tat;
		car.setCrashR(fadeCrash(car.getCrashR()));
		car.setCrashX(fadeCrash(car.getCrashX()));
		car.setCrashY(fadeCrash(car.getCrashY()));
		updateSpeedAndRPMs(car);
		tat = new AffineTransform();
		tat.translate(car.getCrashY(), car.getSpeed() / 10.0 + car.getCrashX());
		car.getAffineTransform().concatenate(tat);
		tat = new AffineTransform();
		tat.rotate(car.getCrashR());
		car.getAffineTransform().concatenate(tat);
		bumpDirection(car, car.getCrashR());
		//checkCollision();
	}
	private void updateSpeedAndRPMs(Car car) {
		Debug.println("BigGameServer:updateSpeedAndRPMs()");
		double maxSpeed = car.getMaxSpeed();
		double gear = car.getShifterModel().getGear();
		double maxGear = car.getShifterModel().getMaxGear();
		double extent = maxSpeed / maxGear;
		double speed = car.getSpeed() * 100.0;
		double work = speed;
		while (work >= extent) {
			work -= extent;
		}
		double rpm = work / extent * 4000.0;
		if (rpm > 4000.0 || rpm < 500.0 && gear != 1) {
			speed = 1.0;
			car.setSpeed(0.01);
		}
		car.setRPM(rpm);
	}
	private double fadeCrash(double var) {
		Debug.println("BigGameServer:fadeCrash()");
		if (var < 0.01 && var > -0.01) {
			var = 0.0;
		} else {
			var *= 0.9;
		}
		return var;
	}
}
