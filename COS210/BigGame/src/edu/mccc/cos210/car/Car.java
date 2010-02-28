package edu.mccc.cos210.car;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
import edu.mccc.cos210.dddial.*;
import com.cbthinkx.util.Debug;
public abstract class Car {
	public enum View {
		TOP_VIEW,
		SIDE_VIEW
	}
	public enum Skill {
		EASY,
		AVERAGE,
		INTERMEDIATE,
		ADVANCED,
		PRO,
		EXPERT,
		UNKNOWN
	}
	private boolean active = false;
	private InetAddress inetaddr;
	private int port;
	private AffineTransform at = AffineTransform.getScaleInstance(50.0, 50.0);
	private double torque = 0.0;
	private double direction = 0.0;
	private double speed = 0.01;
	private double rpm = 1000.0;
	private double deltaR = 0.0;
	private double crashR = 0.0;
	private double crashX = 0.0;
	private double crashY = 0.0;
	private String carName = "";
	private String driverName = "";
	private int HP = 0;
	private ShifterModel shifterModel;
	private int gears = 0;
	private int maxSpeed = 0;
	private Skill driverSkill = Skill.UNKNOWN;
	private Car.Speedometer speedometer;
	private Car.Tachometer tachometer;
	public Car.Speedometer createSpeedometer() {
		Debug.println("Car:createSpeedometer()");
		this.speedometer = new Car.Speedometer(
			new DefaultBoundedRangeModel(0, 1000, 0, 2000)
		);
		return this.speedometer;
	}
	public Car.Speedometer getSpeedometer() {
		Debug.println("Car.getSpeedometer()");
		return this.speedometer;
	}
	public void setSpeedometer(Car.Speedometer s) {
		Debug.println("Car.setSpeedometer()");
		this.speedometer = s;
	}
	public Car.Tachometer createTachometer() {
		Debug.println("Car:createTachometer()");
		this.tachometer = new Car.Tachometer(
			new DefaultBoundedRangeModel(0, 5000, 0, 10000)
		);
		return this.tachometer;
	}
	public Car.Tachometer getTachometer() {
		Debug.println("Car.getTachometer()");
		return this.tachometer;
	}
	public void setTachometer(Car.Tachometer t) {
		Debug.println("Car.setTachometer()");
		this.tachometer = t;
	}
	public boolean isActive() {
		Debug.println("Car:isActive()");
		return this.active;
	}
	public void setActive(boolean b) {
		Debug.println("Car:setActive()");
		this.active = b;
	}
	public InetAddress getInetAddress() {
		Debug.println("Car:getInetAddress()");
		return this.inetaddr;
	}
	public void setInetAddress(InetAddress ia) {
		Debug.println("Car:setInetAddress()");
		this.inetaddr = ia;
	}
	public int getPort() {
		Debug.println("Car:getPort()");
		return this.port;
	}
	public void setPort(int n) {
		Debug.println("Car:setPort()");
		this.port = n;
	}
	public AffineTransform getAffineTransform() {
		Debug.println("Car:getAffineTransform()");
		return this.at;
	}
	public void setAffineTransform(AffineTransform at) {
		Debug.println("Car:setAffineTransform()");
		this.at = at;
	}
	public double getTorque() {
		Debug.println("Car:getTorque()");
		return this.torque;
	}
	public void setTorque(double d) {
		Debug.println("Car:setTorque()");
		this.torque = d;
	}
	public double getDirection() {
		Debug.println("Car:getDirection()");
		return this.direction;
	}
	public void setDirection(double d) {
		Debug.println("Car:setDirection()");
		this.direction = d;
	}
	public double getSpeed() {
		Debug.println("Car:getSpeed()");
		return this.speed;
	}
	public void setSpeed(double d) {
		Debug.println("Car:setSpeed()");
		this.speed = d;
		if (getSpeedometer() != null) {
			getSpeedometer().setValue((int) (d * 100.0));
		}
	}
	public double getRPM() {
		Debug.println("Car:getRPM()");
		return this.rpm;
	}
	public void setRPM(double d) {
		Debug.println("Car:setRPM()");
		this.rpm = d;
		if (getTachometer() != null) {
			getTachometer().setValue((int) d);
		}
	}
	public double getDeltaR() {
		Debug.println("Car:getDeltaR()");
		return this.deltaR;
	}
	public void setDeltaR(double d) {
		Debug.println("Car:setDeltaR()");
		this.deltaR = d;
	}
	public double getCrashR() {
		Debug.println("Car:getCrashR()");
		return this.crashR;
	}
	public void setCrashR(double d) {
		Debug.println("Car:setCrashR()");
		this.crashR = d;
	}
	public double getCrashX() {
		Debug.println("Car:getCrashX()");
		return this.crashX;
	}
	public void setCrashX(double d) {
		Debug.println("Car:setCrashX()");
		this.crashX = d;
	}
	public double getCrashY() {
		Debug.println("Car:getCrashY()");
		return this.crashY;
	}
	public void setCrashY(double d) {
		Debug.println("Car:setCrashY()");
		this.crashY = d;
	}
	private void setCarName(String s) {
		Debug.println("Car:setCarName()");
		this.carName = s;
	}
	public String getCarName() {
		Debug.println("Car:getCarName()");
		return this.carName;
	}
	private void setDriverName(String s) {
		Debug.println("Car:setDriverName()");
		this.driverName = s;
	}
	public String getDriverName() {
		Debug.println("Car:getDriverName()");
		return this.driverName;
	}
	private void setHP(int n) {
		Debug.println("Car:setHP()");
		this.HP = n;
	}
	public int getHP() {
		Debug.println("Car:getHP()");
		return this.HP;
	}
	private void setGears(int n) {
		Debug.println("Car:setGears()");
		this.gears = n;
	}
	public int getGears() {
		Debug.println("Car:getGears()");
		return this.gears;
	}
	private void setMaxSpeed(int n) {
		Debug.println("Car:setMaxSpeed()");
		this.maxSpeed = n;
	}
	public int getMaxSpeed() {
		Debug.println("Car:getMaxSpeed()");
		return this.maxSpeed;
	}
	private void setDriverSkill(Car.Skill s) {
		Debug.println("Car:setDriverSkill()");
		this.driverSkill = s;
	}
	public Car.Skill getDriverSkill() {
		Debug.println("Car:getDriverSkill()");
		return this.driverSkill;
	}
	public ShifterModel getShifterModel() {
		Debug.println("Car:getShifterModel()");
		return this.shifterModel;
	}
	public void setShifterModel(ShifterModel shifterModel) {
		Debug.println("Car:setShifterModel()");
		this.shifterModel = shifterModel;
	}
	public static HashMap<String, Car> loadCars() {
		Debug.println("Car:loadCars()");
		HashMap<String, Car> cars = new HashMap<String, Car>();
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(
				new FileInputStream("racecars.xml")
			);
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			NodeList nodeList = (NodeList) xp.evaluate(
				"//racecars/racecar/@carname",
				doc,
				XPathConstants.NODESET
			);
			for (int i = 0; i < nodeList.getLength(); i++) {
				String carName = (String) nodeList.item(i).getNodeValue();
				Car car = loadCar(carName);
				cars.put(carName, car);
			}
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return cars;
	}
	public static Car loadCar(String s) {
		Debug.println("Car:loadCar()");
		Car car = null;
		try {
			Class c = Class.forName("edu.mccc.cos210.car.cars." + s);
			car = (Car) c.newInstance();
			car.loadData(s);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return car;
	}
	private void loadData(String s) {
		Debug.println("Car:loadData()");
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(
				new FileInputStream("racecars.xml")
			);
			XPathFactory xpf = XPathFactory.newInstance();
			XPath xp = xpf.newXPath();
			setCarName(s);
			setDriverName(
				xp.evaluate(
					"//racecars/racecar[@carname='" + s + "']/@drivername",
					doc
				)
			);
			setHP(
				Integer.parseInt(
					xp.evaluate(
						"//racecars/racecar[@carname='" + s + "']/@hp",
						doc
					)
				)
			);
			setGears(
				Integer.parseInt(
					xp.evaluate(
						"//racecars/racecar[@carname='" + s + "']/@gears",
						doc
					)
				)
			);
			setMaxSpeed(
				Integer.parseInt(
					xp.evaluate(
						"//racecars/racecar[@carname='" + s + "']/@maxspeed",
						doc
					)
				)
			);
			String skill = xp.evaluate(
				"//racecars/racecar[@carname='" + s + "']/@driverskill",
				doc
			);
			setDriverSkill(
				Car.Skill.valueOf(skill)
			);
			this.shifterModel = new ShifterModel(getGears(), this);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	public String toString() {
		Debug.println("Car:toString()");
		return getCarName() + " " + getDriverName() + " " + getHP() + " " + getGears() + " " + getMaxSpeed() + " " + getDriverSkill();
	}
	public void paintCar(JPanel jp, Graphics2D g, AffineTransform at, Car.View view) {
		Debug.println("Car:paintCar()");
		AffineTransform gat = new AffineTransform();
		gat.scale(1.0, 1.0);
		Graphics2D g2d = (Graphics2D) g.create();
		g2d.transform(gat);
		switch (view) {
			case TOP_VIEW:
				paintTop(jp, g2d, at);
				break;
			case SIDE_VIEW:
				paintSide(jp, g2d, at);
				break;
			default:
				break;
		}
		g2d.dispose();
	}
	protected abstract void paintTop(JPanel jp, Graphics2D g2d, AffineTransform at);
	protected abstract void paintSide(JPanel jp, Graphics2D g2d, AffineTransform at);
	public void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear) {
		Debug.println("Car:paintShifter()");
		String value = String.valueOf(gear);
		String maxValue = String.valueOf(maxGear);
		int w = SwingUtilities.computeStringWidth(
			g2d.getFontMetrics(),
			value
		);
		g2d.setPaint(Color.BLUE);
		g2d.drawString(
			value,
			jp.getWidth() / 2 - w / 2,
			jp.getHeight() / 2 + 8
		);
	}
	public class Speedometer extends DDDial {
		public Speedometer(BoundedRangeModel model) {
			super(model);
			Debug.println("Car.Speedometer:Car.Speedometer()");
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			String value = String.valueOf(getValue());
			g2d.setPaint(Color.GREEN);
			g2d.drawString(value, 90, 60);
			g2d.dispose();
		}
	}
	public class Tachometer extends DDDial {
		public Tachometer(BoundedRangeModel model) {
			super(model);
			Debug.println("Car.Tachometer:Car.Tachometer()");
			ArrayList<DDDial.SuperTicks> alst = new ArrayList<DDDial.SuperTicks>();
			DDDial.SuperTicks ts = new DDDial.SuperTicks(4000, Color.RED);
			alst.add(ts);
			setSuperTicks(alst);
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g.create();
			String value = String.valueOf(getValue());
			g2d.setPaint(Color.GREEN);
			g2d.drawString(value, 90, 60);
			g2d.dispose();
		}
	}
}
