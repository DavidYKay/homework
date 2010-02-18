package edu.mccc.cos210.car;
import java.awt.*;
import java.awt.geom.*;
import java.io.*;
import javax.swing.*;
import javax.xml.parsers.*;
import javax.xml.xpath.*;
import org.w3c.dom.*;
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
	private String carName = "";
	private String driverName = "";
	private int HP = 0;
	private int maxSpeed = 0;
	private Skill driverSkill = Skill.UNKNOWN;
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
				new FileInputStream("../racecars.xml")
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
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	public String toString() {
		Debug.println("Car:toString()");
		return getCarName() + " " + getDriverName() + " " + getHP() + " " + getMaxSpeed() + " " + getDriverSkill();
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
	public abstract void paintShifter(JPanel jp, Graphics2D g2d, int gear, int maxGear);
}
