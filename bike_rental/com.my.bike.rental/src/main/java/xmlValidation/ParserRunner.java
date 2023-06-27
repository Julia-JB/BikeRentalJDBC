package xmlValidation;
import model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Keys;

public class ParserRunner {
	public static void main (String[] args) {
		Logger logger = LogManager.getLogger();
		ParserXML parser = new ParserXML();

		// Validating xml file against the schema
		parser.validateXmlFile(Keys.USERS_PATH.getKey(), Keys.XSD_SCHEMA_PATH.getKey());

		// Getting the number of items in the document
		int numberOfItems = parser.getNumberOfItems();
		logger.info(numberOfItems);

		// Getting the user by index
		User user = parser.getUserByIndex(2);
		logger.info(user);
	}
}

