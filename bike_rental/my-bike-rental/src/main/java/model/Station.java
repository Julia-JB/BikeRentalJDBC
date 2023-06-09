package model;

import jaxb.Point2DAdaper;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.awt.geom.Point2D;
@XmlRootElement(name = "station")
@XmlAccessorType(XmlAccessType.FIELD)
public class Station {
	@XmlElement(name = "stationId")
	private int stationId;
	@XmlElement(name = "stationName")
	private String stationName;
	@XmlElement(name = "location")
	@XmlJavaTypeAdapter(Point2DAdaper.class)
	private Point2D location;
	@XmlElement(name = "capacity")
	private int capacity;

	public Station(int stationId, String stationName, Point2D location, int capacity) {
		this.stationId = stationId;
		this.stationName = stationName;
		this.location = location;
		this.capacity = capacity;
	}

	public Station(String stationName, Point2D location, int capacity) {
		this.stationName = stationName;
		this.location = location;
		this.capacity = capacity;
	}

	public Station() {
	}

	@Override
	public String toString() {
		return "Station{" + "stationId=" + stationId + ", stationName='" + stationName + '\'' + ", location=" + location + ", capacity=" + capacity + '}';
	}

	public int getStationId() {
		return stationId;
	}

	public void setStationId(int stationId) {
		this.stationId = stationId;
	}

	public String getName() {
		return stationName;
	}

	public void setName(String stationName) {
		this.stationName = stationName;
	}

	public Point2D getLocation() {
		return location;
	}

	public void setLocation(Point2D location) {
		this.location = location;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

}
