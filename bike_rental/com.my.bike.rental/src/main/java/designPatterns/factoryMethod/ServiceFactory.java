package designPatterns.factoryMethod;

import designPatterns.factoryMethod.Interface.IBikeRentalService;
import designPatterns.factoryMethod.Interface.IBikeService;
import designPatterns.factoryMethod.Interface.ITechnicianService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
