
import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceDAO.*;
import java.awt.geom.Point2D;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;


public class Main {
	public static void main(String[] args) {

		Logger logger = LogManager.getLogger();

		// Create
		UserService userService = new UserService();
		User user1 = new User("Jeff", "Ashton", "jeffbhome@gmail.com", Date.valueOf("2023-05-16"));
		userService.insertUser(user1);

		// Read
		StationService stationService = new StationService();
		Station station1 = stationService.selectStation(3);
		logger.info(station1);

		// Complex query with JOIN and lists of objects
		TechnicianService technicianService = new TechnicianService();
		logger.info(technicianService.selectTechnician(1));
		logger.info(technicianService.selectAllTechnicians());

		int stationsTotal = stationService.selectAllStations().size();
		logger.info("Total number of stations: " + stationsTotal);

		// Update
		LocalDateTime startDateTime = LocalDateTime.of(2023, 5, 29, 12, 0, 0);
		LocalDateTime endDateTime = LocalDateTime.of(2023, 5, 29, 12, 10, 0);
		BikeRental bikeRental1 = new BikeRental(6, startDateTime, endDateTime, new BigDecimal(0.90), 8, 4, 3, 4);

		BikeRentalService bikeRentalService = new BikeRentalService();
		bikeRentalService.updateBikeRental(bikeRental1);

		// Create
		LocalDateTime dateTime = LocalDateTime.of(2023, 6, 20, 10, 0, 0);
		Event event2 = new Event("Pedalpalooza", dateTime, new Point2D.Double(42.0942, 19.1333), user1);

		EventService eventService = new EventService();
		eventService.insertEvent(event2);

		// Delete
		eventService.deleteEvent(6);
	}
}




































































































































