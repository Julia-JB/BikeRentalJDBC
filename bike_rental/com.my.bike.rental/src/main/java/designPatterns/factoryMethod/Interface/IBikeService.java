package designPatterns.factoryMethod.Interface;

import model.Bike;

import java.util.List;

public interface IBikeService {
	public void insertBike(Bike bike);

	public Bike selectBike(int bikeId);

	public List<Bike> selectAllBikes();

	public void updateBike(Bike bike);

	public void deleteBike(int bikeId);
}
