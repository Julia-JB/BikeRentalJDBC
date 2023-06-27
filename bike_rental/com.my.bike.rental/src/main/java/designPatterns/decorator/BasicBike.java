package designPatterns.decorator;

import org.apache.logging.log4j.LogManager;

// Concrete Component

public class BasicBike implements BikeInterface {
	@Override
	public void assemble() {
		LogManager.getLogger().info("Basic bike assembled.");
	}
}
