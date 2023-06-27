package designPatterns.factoryMethod;
import designPatterns.factoryMethod.Interface.IBikeService;
import designPatterns.factoryMethod.ServiceFactory;
import model.Bike;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	public static void main(String[] args) {
		Logger logger = LogManager.getLogger();

		/*
		Factory Method Design Pattern
		Abstract Product - IBikeService interface
		Concrete Products - BikeServiceDAO, BikeServiceMB
		Concrete Creator - ServiceFactory
		*/

		// Creating instances of BikeService using the ServiceFactory for MyBatis and DAO
		// implementations.

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

	}
}

