package designPatterns;
import model.Bike;
import designPatterns.serviceInterface.IBikeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();

		/*
		Creating instances of BikeService using the ServiceFactory for MyBatis and DAO implementations.
		*/

		ServiceFactory factory = new ServiceFactory();
		IBikeService bikeServiceMB = factory.createBikeService("mybatis");
		Bike bike1 = bikeServiceMB.selectBike(5);
		String className = bikeServiceMB.getClass().getName();

		logger.info("BikeService implementation: " + className);
		logger.info("Retrieving data using ServiceMyBatis: " + bike1);

		IBikeService bikeServiceDAO = factory.createBikeService("dao");
		Bike bike2 = bikeServiceDAO.selectBike(4);
		String newClassName = bikeServiceDAO.getClass().getName();

		logger.info("BikeService implementation: " + newClassName);
		logger.info("Retrieving data using ServiceDAO: " + bike2);

		// Checking error message for unknown service exception
		IBikeService bikeService = factory.createBikeService("unknown");

		// Creating bike object using BikeBuilder
		Bike bike3 = new Bike.BikeBuilder().brand("Street Runner")
				.properties("{\"gears\": 8, \"model\": \"CityCruiser\", \"brakeType\": \"Rim brakes\", " +
						"\"wheelSize\": \"26 inches\", \"suspension\": false, \"frameMaterial\": " +
						"\"Steel\", \"basketIncluded\": true}")
				.status("AVAILABLE")
				.currentStationId(4)
				.build();

		logger.info("Bike object: " + bike3);
	}
}

