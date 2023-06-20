package service;

import dao.PassBikeRentalDAO;
import model.PassBikeRental;

import java.util.List;

public class PassBikeRentalService {
	private PassBikeRentalDAO passBikeRentalDAO;

	public PassBikeRentalService() {
		passBikeRentalDAO = new PassBikeRentalDAO();
	}

	public void insertPassBikeRental(PassBikeRental passBikeRental) {
		passBikeRentalDAO.save(passBikeRental);
	}

	public PassBikeRental selectPassBikeRental(int rentalId) {
		return passBikeRentalDAO.getById(rentalId);
	}

	public List<PassBikeRental> selectAllPassBikeRentals() {
		return passBikeRentalDAO.getAll();
	}

	public void updatePassBikeRental(PassBikeRental passBikeRental) {
		passBikeRentalDAO.update(passBikeRental);
	}

	public void deletePassBikeRental(int rentalId) {
		passBikeRentalDAO.delete(rentalId);
	}
}
