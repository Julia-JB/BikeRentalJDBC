package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

	public class BikeRental {
		private int rentalId;
		private LocalDateTime timeStart;
		private LocalDateTime timeEnd;
		private BigDecimal cost;
		private int userId;
		private int bikeId;
		private int stationStartId;
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
							"\nentityLayer.User ID: %d" +
							"\nEntityLayer.Bike ID: %d" +
							"\nentityLayer.Station start: %d" +
							"\nentityLayer.Station end: %d",
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


