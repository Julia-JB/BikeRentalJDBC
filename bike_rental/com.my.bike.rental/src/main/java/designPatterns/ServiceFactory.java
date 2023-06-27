package designPatterns;

import designPatterns.serviceInterface.IBikeRentalService;
import designPatterns.serviceInterface.ITechnicianService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import designPatterns.serviceInterface.IBikeService;
import serviceMyBatis.BikeRentalService;
import serviceMyBatis.BikeService;
import serviceMyBatis.TechnicianService;

public class ServiceFactory {
	public IBikeService createBikeService(String serviceImpl) {
		Logger logger = LogManager.getLogger();
		if (serviceImpl.equalsIgnoreCase("mybatis")) {
			return new BikeService();
		} else if (serviceImpl.equalsIgnoreCase("dao")) {
			return new serviceDAO.BikeService();
		} else {
			InvalidServiceException exception = new InvalidServiceException();
			logger.error(exception.getMessage());
			throw exception;
		}
	}

	public IBikeRentalService createBikeRentalService(String serviceImpl) {
		Logger logger = LogManager.getLogger();
		if (serviceImpl.equalsIgnoreCase("mybatis")) {
			return new BikeRentalService();
		} else if (serviceImpl.equalsIgnoreCase("dao")) {
			return new serviceDAO.BikeRentalService();
		} else {
			InvalidServiceException exception = new InvalidServiceException();
			logger.error(exception.getMessage());
			throw exception;
		}
	}

	public ITechnicianService createTechnicianService(String serviceImpl) {
		Logger logger = LogManager.getLogger();
		if (serviceImpl.equalsIgnoreCase("mybatis")) {
			return new TechnicianService();
		} else if (serviceImpl.equalsIgnoreCase("dao")) {
			return new serviceDAO.TechnicianService();
		} else {
			InvalidServiceException exception = new InvalidServiceException();
			logger.error(exception.getMessage());
			throw exception;
		}
	}
}
