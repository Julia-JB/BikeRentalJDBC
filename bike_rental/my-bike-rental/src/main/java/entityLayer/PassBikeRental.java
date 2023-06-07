package entityLayer;

import java.time.LocalDateTime;

public class PassBikeRental {
	private int passRentalId;
	private LocalDateTime timeStart;
	private LocalDateTime timeEnd;
	private int bikeId;
	private int stationStartId;
	private int stationEndId;
	private int passId;
	private int userId;

	public PassBikeRental(int passRentalId, LocalDateTime timeStart, LocalDateTime timeEnd,
	                      int bikeId, int stationStartId, int stationEndId, int passId,
	                      int userId) {
		this.passRentalId = passRentalId;
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.bikeId = bikeId;
		this.stationStartId = stationStartId;
		this.stationEndId = stationEndId;
		this.passId = passId;
		this.userId = userId;
	}

	public PassBikeRental(LocalDateTime timeStart, LocalDateTime timeEnd, int bikeId,
	                      int stationStartId, int stationEndId, int passId, int userId) {
		this.timeStart = timeStart;
		this.timeEnd = timeEnd;
		this.bikeId = bikeId;
		this.stationStartId = stationStartId;
		this.stationEndId = stationEndId;
		this.passId = passId;
		this.userId = userId;
	}

	public PassBikeRental() {
	}

	public int getPassRentalId() {
		return passRentalId;
	}

	public void setPassRentalId(int passRentalId) {
		this.passRentalId = passRentalId;
	}

	public LocalDateTime getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(LocalDateTime timeStart) {
		this.timeStart = timeStart;
	}

	public LocalDateTime getTimeEnd() {
		return timeEnd;
	}

	public void setTimeEnd(LocalDateTime timeEnd) {
		this.timeEnd = timeEnd;
	}

	public int getBikeId() {
		return bikeId;
	}

	public void setBikeId(int bikeId) {
		this.bikeId = bikeId;
	}

	public int getStationStartId() {
		return stationStartId;
	}

	public void setStationStartId(int stationStartId) {
		this.stationStartId = stationStartId;
	}

	public int getStationEndId() {
		return stationEndId;
	}

	public void setStationEndId(int stationEndId) {
		this.stationEndId = stationEndId;
	}

	public int getPassId() {
		return passId;
	}

	public void setPassId(int passId) {
		this.passId = passId;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
