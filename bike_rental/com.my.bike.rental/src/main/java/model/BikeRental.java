package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.time.LocalDateTime;

	@XmlRootElement(name = "bikeRental")
	@XmlAccessorType(XmlAccessType.FIELD)
	public class BikeRental {
	@XmlElement(name = "rentalId")
	private int rentalId;
	@XmlElement(name = "timeStart")
	private LocalDateTime timeStart;
	@XmlElement(name = "timeEnd")
	private LocalDateTime timeEnd;
	@XmlElement(name = "cost")
	private BigDecimal cost;
	@XmlElement(name = "userId")
	private int userId;
	@XmlElement(name = "bikeId")
	private int bikeId;
	@XmlElement(name = "stationStartId")
	private int stationStartId;
	@XmlElement(name = "stationEndId")
	private int stationEndId;


		public BikeRental() {
		}

		public BikeRental(LocalDateTime timeStart, LocalDateTime timeEnd, BigDecimal cost, int userId,
		                  int bikeId, int stationStartId, int stationEndId) {
			this.timeStart = timeStart;
			this.timeEnd = timeEnd;
			this.cost = cost;
			this.userId = userId;
			this.bikeId = bikeId;
			this.stationStartId = stationStartId;
			this.stationEndId = stationEndId;
		}
		public BikeRental(int rentalId, LocalDateTime timeStart, LocalDateTime timeEnd, BigDecimal cost,
		                  int userId, int bikeId, int stationStartId, int stationEndId) {
			this.rentalId = rentalId;
			this.timeStart = timeStart;
			this.timeEnd = timeEnd;
			this.cost = cost;
			this.userId = userId;
			this.bikeId = bikeId;
			this.stationStartId = stationStartId;
			this.stationEndId = stationEndId;
		}

		@Override
		public String toString() {
			return String.format("\nRental ID: %d" +
							"\nStart time: %s" +
							"\nEnd time: %s" +
							"\nCost: %s" +
							"\nUser ID: %d" +
							"\nBike ID: %d" +
							"\nStation start: %d" +
							"\nStation end: %d",
					getRentalId(), getTimeStart(), getTimeEnd(), getCost(), getUserId(),
					getBikeId(), getStationStartId(), getStationEndId());
		}

		public int getRentalId() {
			return rentalId;
		}

		public void setRentalId(int rentalId) {
			this.rentalId = rentalId;
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

		public BigDecimal getCost() {
			return cost;
		}

		public void setCost(BigDecimal cost) {
			this.cost = cost;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
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
	}


