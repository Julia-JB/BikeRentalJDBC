package designPatterns.factoryMethod.Interface;

import model.BikeRental;

import java.util.List;

public interface IBikeRentalService {
	public void insertBikeRental(BikeRental bikeRental);

	public BikeRental selectBikeRental(int bikeRentalId);

	public List<BikeRental> selectAllBikeRentals();

	public void updateBikeRental(BikeRental bikeRental);

	public void deleteBikeRental(int bikeRentalId);
}
