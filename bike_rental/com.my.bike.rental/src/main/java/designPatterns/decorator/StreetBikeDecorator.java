package designPatterns.decorator;

import org.apache.logging.log4j.LogManager;


// Concrete Decorator
public class StreetBikeDecorator extends BikeDecorator{
	public StreetBikeDecorator(BikeInterface bikeInterface) {
		super(bikeInterface);
	}

	@Override
	public void assemble() {
		super.assemble();
		addStreetBikeFeatures();
	}

	private void addStreetBikeFeatures() {
		LogManager.getLogger().info("Adding features of a street bike: sleek design, narrow " +
				"tires, and upright handlebars.");
	}
}
