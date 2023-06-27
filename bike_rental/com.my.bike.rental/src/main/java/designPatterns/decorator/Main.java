package designPatterns.decorator;

public class Main {
	public static void main(String[] args) {
		BikeInterface basicBike = new BasicBike();
		BikeDecorator mountainBike = new MountainBikeDecorator(basicBike);
		BikeDecorator streetBike = new StreetBikeDecorator(basicBike);

		mountainBike.assemble();
		streetBike.assemble();
	}
}
