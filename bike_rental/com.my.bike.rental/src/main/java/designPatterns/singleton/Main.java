package designPatterns.singleton;

import model.Bike;
import org.apache.logging.log4j.LogManager;

public class Main {
	public static void main(String[] args) {

		// Instantiating the class by invoking getInstance() method
		BikeRentalManager manager = BikeRentalManager.getInstance();

		Bike streetBike = new Bike.BikeBuilder().brand("Street Runner")
				.properties("{\"gears\": 8, \"model\": \"CityCruiser\", \"brakeType\": \"Rim brakes\", " +
						"\"wheelSize\": \"26 inches\", \"suspension\": false, \"frameMaterial\": " +
						"\"Steel\", \"basketIncluded\": true}")
				.status("AVAILABLE")
				.currentStationId(4)
				.build();

		manager.rentBike(streetBike);
		LogManager.getLogger().info("Bike status: " + streetBike.getStatus());
	}
}
