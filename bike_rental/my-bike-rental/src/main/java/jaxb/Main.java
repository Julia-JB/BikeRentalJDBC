package jaxb;

import model.Station;
import model.Technician;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.StationService;
import utilities.Keys;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Main {
	public static void main(String[] args) {

		Logger logger = LogManager.getLogger();
		File technicianInput = new File(Keys.TECHNICIAN_INPUT.getKey());

		try  {
			JAXBContext jaxbContext = JAXBContext.newInstance(Technician.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Technician technician = (Technician) unmarshaller.unmarshal(technicianInput);
			logger.info("Technician object created from XML - unmarshalling: " + technician);
			// Use the technician object as needed
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		File stationInput = new File(Keys.STATION_INPUT.getKey());

		try  {
			JAXBContext jaxbContext = JAXBContext.newInstance(Station.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Station  station = (Station) unmarshaller.unmarshal(stationInput);
			logger.info("Station object created from XML - unmarshalling: " + station);
			// Use the technician object as needed
		} catch (JAXBException e) {
			e.printStackTrace();
		}

		StationService stationService = new StationService();
		Station station1 = stationService.selectStation(3);

		File stationsOutput = new File(Keys.STATION_OUTPUT.getKey());

	try {  JAXBContext jaxbContext = JAXBContext.newInstance(Station.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.marshal(station1, stationsOutput);
			// Use the technician object as needed
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}

