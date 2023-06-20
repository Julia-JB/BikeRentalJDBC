package mapper;

import model.Bike;
import model.BikeRental;

import java.util.List;

public interface BikeRentalMapper {
	void addBikeRental(BikeRental bikeRental);
	BikeRental selectBikeRentalById(int id);
	List<BikeRental> selectAllBikeRentals();
	void updateBikeRental(BikeRental bikeRental);
	void deleteBikeRental(int id);
}
