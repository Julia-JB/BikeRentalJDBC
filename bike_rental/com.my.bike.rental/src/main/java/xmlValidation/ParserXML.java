package xmlValidation;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utilities.Keys;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

public class ParserXML {
	public Document getDocument() throws ParserConfigurationException, IOException, SAXException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder documentBuilder = factory.newDocumentBuilder();
		Document document = documentBuilder.parse(Keys.USERS_PATH.getKey());
		return document;
	}

	public int getNumberOfItems() {
		try {
			Document document = getDocument();
			NodeList usersNodes = document.getElementsByTagName("user");
			return usersNodes.getLength();
		} catch (ParserConfigurationException | IOException | SAXException e) {
			LogManager.getLogger().error("Error occurred while getting the number of items", e);
		}
		return -1;
	}

	public User getUserByIndex(int index) {
		try {
			Document document = getDocument();
			Element rootElement = document.getDocumentElement();
			NodeList usersList = rootElement.getElementsByTagName("user");

			if (index >= 0 && index < usersList.getLength()) {
				Element userElement = (Element) usersList.item(index);

				// Parsing the element to get the values
				int userId = Integer.parseInt(userElement.getElementsByTagName("userId").item(0).getTextContent());
				String firstName = userElement.getElementsByTagName("firstName").item(0).getTextContent();
				String lastName = userElement.getElementsByTagName("lastName").item(0).getTextContent();
				String email = userElement.getElementsByTagName("email").item(0).getTextContent();
				Date dateRegistered = Date.valueOf(userElement.getElementsByTagName("dateRegistered").item(0).getTextContent());

				// Creating an object using the obtained values
				return new User(userId, firstName, lastName, email, dateRegistered);
			} else {
				throw new IllegalArgumentException("Invalid index: " + index);
			}
		} catch (ParserConfigurationException | IOException | SAXException e) {
			LogManager.getLogger().error("Error occurred while getting user by index", e);
		}

		return null;
	}

	public void validateXmlFile(String xmlFile, String xsdFile) {
		try {
			// Creating a schema factory
			SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			// Loading the XML Schema
			Schema schema = schemaFactory.newSchema(new File(xsdFile));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlFile)));

			// Validation successful
			LogManager.getLogger().info("XML is valid.");
		} catch (SAXException | IOException e) {
			// Validation failed
			LogManager.getLogger().error("XML is not valid. Error: " + e.getMessage());
		}
	}
}
