package designPatterns.decorator;

import org.apache.logging.log4j.LogManager;

// Concrete Decorator

public class MountainBikeDecorator extends BikeDecorator {
	public MountainBikeDecorator(BikeInterface bikeInterface) {
		super(bikeInterface);
	}

	@Override
	public void assemble() {
		super.assemble();
		addMountainBikeFeatures();
	}

	private void addMountainBikeFeatures() {
		LogManager.getLogger().info("Adding features of a mountain bike: suspension, wider tires, and off-road gearing.");
	}
}
