package serviceDAO;

import dao.BikeRentalDAO;
import model.BikeRental;
import designPatterns.serviceInterface.IBikeRentalService;

import java.util.List;

public class BikeRentalService implements IBikeRentalService {
	 private  BikeRentalDAO bikeRentalDAO;

	 public BikeRentalService() {
		 bikeRentalDAO = new BikeRentalDAO();
	 }

	 public void insertBikeRental(BikeRental bikeRental) {
		 bikeRentalDAO.save(bikeRental);
	 }

	 public BikeRental selectBikeRental(int bikeRentalId) {
		 return bikeRentalDAO.getById(bikeRentalId);
	 }

	 public List<BikeRental> selectAllBikeRentals() {
		 return bikeRentalDAO.getAll();
	 }

	 public void updateBikeRental(BikeRental bikeRental) {
		 bikeRentalDAO.update(bikeRental);
	 }

	 public void deleteBikeRental(int bikeRentalId) {
		 bikeRentalDAO.delete(bikeRentalId);
	 }
}
