package json;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import model.Station;
import model.Technician;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import serviceMyBatis.TechnicianService;
import utilities.Keys;

import java.awt.geom.Point2D;

import java.io.File;
import java.io.IOException;

public class JacksonRunner {

	public static void main(String[] args) throws IOException {
		Logger logger = LogManager.getLogger();

		File jsonTechnician = new File(Keys.TECHNICIAN_INPUT_JSON.getKey());

		// Deserializing - handling complex objects
		ObjectMapper objectMapper = new ObjectMapper();
		Technician technician1 = objectMapper.readValue(jsonTechnician, Technician.class);
		logger.info("Object created from JSON: " + technician1);

		TechnicianService technicianService = new TechnicianService();
		Technician technician = technicianService.selectTechnician(3);
		String technicianJSON = objectMapper.writeValueAsString(technician);
		logger.info(technicianJSON);

		Station station = new Station(5, "Old Town", new Point2D.Double(42.0974, 19.0911),10);

		// Serializing - handling POINT2D data type
		String stationJSON = objectMapper.writeValueAsString(station);
		ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
		writer.writeValue(new File(Keys.STATION_OUTPUT_JSON.getKey()), stationJSON);
		logger.info(stationJSON);

	}
}
