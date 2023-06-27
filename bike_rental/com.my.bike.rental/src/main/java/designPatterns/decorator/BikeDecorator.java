package designPatterns.decorator;

// Abstract Decorator
public abstract class BikeDecorator implements BikeInterface {
	protected BikeInterface bikeInterface;
	public BikeDecorator(BikeInterface bikeInterface) {
		this.bikeInterface = bikeInterface;
	}

	@Override
	public void assemble() {
		bikeInterface.assemble();
	}
}

