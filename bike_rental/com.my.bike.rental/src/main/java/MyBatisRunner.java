import mapper.*;
import model.*;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.InputStream;

import java.sql.Date;
import java.util.List;

public class MyBatisRunner {
	public static void main(String[] args) throws IOException {
		Logger logger = LogManager.getLogger();
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {

			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);

			TechnicianMapper technicianMapper = session.getMapper(TechnicianMapper.class);

			// Handling complex objects containing collections of objects
			Technician technician = technicianMapper.selectTechnicianById(3);
			logger.info("Selecting technician by id " + technician);

			List<Technician> technicians = technicianMapper.selectAllTechnicians();
			logger.info("Selecting all technicians " + technicians);

			// Adding a record

			Technician technician1 = new Technician( "Thomas", "Weller", "2251281430",
					"thomasweller22@gmail.com");
			technicianMapper.addTechnician(technician1);

			// Updating the record
			technicianMapper.updateTechnician(technician1); // add technicianId value to the
			// constructor

			// Deleting the record
			technicianMapper.deleteTechnician(5);

			// Handling POINT2D type using type handler "java/mapper/POINT2DTypeHandler"
			StationMapper stationMapper = session.getMapper(StationMapper.class);

			Station station = stationMapper.selectStationById(4);
			logger.info("Selecting a station by id" + station);

			List<Station> stations = stationMapper.selectAllStations();
			logger.info("Selection all stations" + stations);

			Station station1 = new Station( "Olive Grove", new Point2D.Double(42.0942, 19.1333),
					10);

			stationMapper.addStation(station1);
			stationMapper.updateStation(station1); // add stationId value to the constructor
			stationMapper.deleteStation(8);

			// Handling regular objects - basic CRUD operations

			MaintenanceMapper maintenanceMapper = session.getMapper(MaintenanceMapper.class);

			Maintenance maintenance = maintenanceMapper.selectMaintenanceById(2);
			logger.info("Selecting maintenance record by id" + maintenance);

			List<Maintenance> maintenanceList = maintenanceMapper.selectAllMaintenances();
			logger.info("Selecting all maintenance records" + maintenanceList);

			Maintenance maintenance1 = new Maintenance(4, Date.valueOf("2023-06-18"),
					Date.valueOf("2023-06-20"), "speed switcher fix", 2, 3);

			maintenanceMapper.addMaintenance(maintenance1);
			maintenanceMapper.updateMaintenance(maintenance1);
			maintenanceMapper.deleteMaintenance(5);

		}
	}
}
