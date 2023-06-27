package designPatterns.builder;

import model.Bike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BikeCreator {
	public static void main(String[] args) {
		/*
		Creating instances of the Bike class with specific configurations using Builder pattern.
		Provides separation of the object construction logic from Bike class.
		 */

		Logger logger = LogManager.getLogger();

		Bike streetBike = new Bike.BikeBuilder().brand("Street Runner")
				.properties("{\"gears\": 8, \"model\": \"CityCruiser\", \"brakeType\": \"Rim brakes\", " +
						"\"wheelSize\": \"26 inches\", \"suspension\": false, \"frameMaterial\": " +
						"\"Steel\", \"basketIncluded\": true}")
				.status("AVAILABLE")
				.currentStationId(4)
				.build();

		logger.info(streetBike);

		// Different representations of the object without multiple constructors

		Bike mountainBike = new Bike.BikeBuilder().brand("MountainScape")
				.status("MAINTAINED")
				.build();

		logger.info(mountainBike);

		Bike sportsBike = new Bike.BikeBuilder().brand("KTM").build();

		logger.info(sportsBike);
	}
}
