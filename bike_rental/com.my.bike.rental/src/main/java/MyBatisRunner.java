
import model.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceMyBatis.EventService;
import serviceMyBatis.MaintenanceService;
import serviceMyBatis.StationService;
import serviceMyBatis.TechnicianService;

import java.awt.geom.Point2D;
import java.io.IOException;

import java.sql.Date;
import java.util.List;

public class MyBatisRunner {
	public static void main(String[] args) throws IOException {
		Logger logger = LogManager.getLogger();

		// Retrieving complex objects containing a nested object (association XML element)
		EventService eventService = new EventService();
		Event event = eventService.selectEvent(4);
		logger.info(event);

		List<Event> events = eventService.selectAllEvents();
		logger.info(events);

		// Retrieving complex objects containing collections of objects (collection XML element)
		TechnicianService technicianService = new TechnicianService();
		Technician technician = technicianService.selectTechnician(3);
		logger.info("Selecting technician by id " + technician);

		List<Technician> technicians = technicianService.selectAllTechnicians();
		logger.info("Selecting all technicians " + technicians);

		// Adding a record
		Technician technician1 = new Technician( "Thomas", "Weller", "2251281430",
					"thomasweller22@gmail.com");
		technicianService.insertTechnician(technician1);

		// Updating the record
		technician1.setTechnicianId(4);
		technician1.setEmail("thomasweller@gmail.com");
		technicianService.updateTechnician(technician1);

		// Deleting the record
		technicianService.deleteTechnician(5);

		// Handling POINT2D type using custom type handler "java/mapper/POINT2DTypeHandler"

		StationService stationService = new StationService();
		Station station = stationService.selectStation(6);
		logger.info("Selecting station by id" + station);

		List<Station> stations = stationService.selectAllStations();
		logger.info("Selecting all stations" + stations);

		Station station1 = new Station( "Olive Grove", new Point2D.Double(42.0942, 19.1333),
					10);

		stationService.insertStation(station1);

		station1.setStationId(6);
		station1.setCapacity(12);
		stationService.updateStation(station1);

		stationService.deleteStation(8);

		// Handling regular objects - basic CRUD operations

		MaintenanceService maintenanceService = new MaintenanceService();

		Maintenance maintenance = maintenanceService.selectMaintenance(2);
		logger.info("Selecting maintenance record by id" + maintenance);

		List<Maintenance> maintenanceList = maintenanceService.selectAllMaintenance();
		logger.info("Selecting all maintenance records" + maintenanceList);

		Maintenance maintenance1 = new Maintenance(4, Date.valueOf("2023-06-18"),
					Date.valueOf("2023-06-20"), "speed switcher fix", 2, 3);

		maintenanceService.insertMaintenance(maintenance1);

		maintenance1.setMaintenanceId(4);
		maintenance1.setDateEnd(Date.valueOf("2023-06-22"));
		maintenanceService.updateMaintenance(maintenance1);

		maintenanceService.deleteMaintenance(5);

		}
	}

