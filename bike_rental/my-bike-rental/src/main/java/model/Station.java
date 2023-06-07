package model;

import java.awt.geom.Point2D;
public class Station {

	private int stationId;
	private String stationName;
	private Point2D location;
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
		return String.format("\nentityLayer.Station ID: %d" +
							"\nentityLayer.Station name: %s" +
							"\nLocation: (%.4f, %.4f)" +
							"\nCapacity: %d",
				getStationId(), getName(), getLocation().getX(), getLocation().getY(),
				getCapacity());
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
