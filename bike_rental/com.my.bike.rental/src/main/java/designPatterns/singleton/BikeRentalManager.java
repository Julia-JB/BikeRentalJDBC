package designPatterns.singleton;
import model.Bike;
import org.apache.logging.log4j.LogManager;

public class BikeRentalManager {

		private static BikeRentalManager instance = null;

		// Private constructor to prevent instantiation
		private BikeRentalManager() {
		}

		public static BikeRentalManager getInstance() {
			if (instance == null) {
				instance = new BikeRentalManager();
			}
			return instance;
		}

		public void rentBike(Bike bike) {
			if (bike.getStatus().equalsIgnoreCase("available")) {
				bike.setStatus("rented");
				LogManager.getLogger().info("Bike rented successfully");
			} else {
				LogManager.getLogger().info("Sorry, the bike is not available for rent.");
			}
		}
		public void returnBike(Bike bike) {
			if (bike.getStatus().equalsIgnoreCase("rented"))
			bike.setStatus("available");
		}
}


