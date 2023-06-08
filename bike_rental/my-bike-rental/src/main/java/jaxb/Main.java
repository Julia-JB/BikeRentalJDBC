package jaxb;

import model.Technician;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Keys;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
	public static void main(String[] args) {

		Logger logger = LogManager.getLogger();
		File xmlFile = new File(Keys.TECHNICIAN_PATH.getKey());

		try (InputStream inputStream = new FileInputStream(xmlFile)) {
			JAXBContext jaxbContext = JAXBContext.newInstance(Technician.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			Technician technician = (Technician) unmarshaller.unmarshal(inputStream);
			logger.info("Object created from XML - unmarshalling: " + technician);
			// Use the technician object as needed
		} catch (IOException | JAXBException e) {
			e.printStackTrace();
		}
	}
}
