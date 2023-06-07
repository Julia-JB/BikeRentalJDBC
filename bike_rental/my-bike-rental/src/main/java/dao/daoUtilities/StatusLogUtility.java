package dao.daoUtilities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StatusLogUtility {
	public static void logSaveStatus(Object object, int rowsAffected) {
		Logger logger = LogManager.getLogger();

		if (rowsAffected > 0) {
			logger.info(object.getClass().getSimpleName() + " saved successfully.");
		} else {
			logger.warn(object.getClass().getSimpleName() + " was not saved");
		}
	}

	public static void logUpdateStatus(Object object, int rowsAffected) {
		Logger logger = LogManager.getLogger();
		if (rowsAffected > 0) {
			logger.info(object.getClass().getSimpleName() + " updated successfully.");
		} else {
			logger.warn(object.getClass().getSimpleName() + " was not found");
		}
	}

	public static void logDeleteStatus(Class<?> clazz, int rowsAffected) {
		Logger logger = LogManager.getLogger();
		if (rowsAffected > 0) {
			logger.info(clazz.getSimpleName() + " deleted successfully.");
		} else {
			logger.warn(clazz.getSimpleName() + " was not found.");
		}
	}
}
