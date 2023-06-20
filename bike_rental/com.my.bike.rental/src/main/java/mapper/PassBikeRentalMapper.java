package mapper;
import model.PassBikeRental;

import java.util.List;

public interface PassBikeRentalMapper {
	void addPassBikeRental(PassBikeRental rental);

	PassBikeRental selectPassBikeRentalById(int id);

	List<PassBikeRental> selectAllPassBikeRentals();

	void updatePassBikeRental(PassBikeRental rental);

	void deletePassBikeRental(int id);
}
