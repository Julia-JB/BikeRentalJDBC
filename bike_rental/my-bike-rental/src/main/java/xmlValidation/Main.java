package xmlValidation;

import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import utilities.Keys;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Date;


public class Main {
	public static void main (String[] args) {
		Logger logger = LogManager.getLogger();

		try {
			// Create a document builder
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document document = documentBuilder.parse((Keys.USERS_PATH).getKey());

			Element rootElement = document.getDocumentElement();
			Node node = document.getElementsByTagName("users").item(0);
			Element userElement = (Element) node;
			int userId =
					Integer.parseInt(userElement.getElementsByTagName("userId").item(0).getTextContent());
			String firstName = userElement.getElementsByTagName("firstName").item(0).getTextContent();
			String lastName = userElement.getElementsByTagName("lastName").item(0).getTextContent();
			String email = userElement.getElementsByTagName("email").item(0).getTextContent();
			Date dateRegistered =
					Date.valueOf(userElement.getElementsByTagName("dateRegistered").item(0).getTextContent());

			User user1 = new User(userId, firstName, lastName, email, dateRegistered);

			NodeList usersNodes = document.getElementsByTagName("user");
			logger.info("Number of users: " + usersNodes.getLength());

			logger.info(user1.toString());
			logger.info("XML is valid.");

		} catch (ParserConfigurationException | SAXException | IOException e) {
			logger.warn("XML is not valid. Error: " + e.getMessage());
		}
	}
	}

