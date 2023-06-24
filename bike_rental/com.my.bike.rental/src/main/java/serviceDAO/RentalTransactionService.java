package serviceDAO;

import dao.RentalTransactionDAO;
import model.RentalTransaction;

import java.util.List;

public class RentalTransactionService {
	private RentalTransactionDAO rentalTransactionDAO;

	public RentalTransactionService() {
		rentalTransactionDAO = new RentalTransactionDAO();
	}

	public void insertRentalTransaction(RentalTransaction transaction) {
		rentalTransactionDAO.save(transaction);
	}

	public RentalTransaction selectRentalTransaction(int transactionId) {
		return rentalTransactionDAO.getById(transactionId);
	}

	public List<RentalTransaction> getAllRentalTransactions() {
		return rentalTransactionDAO.getAll();
	}

	public void updateRentalTransaction(RentalTransaction transaction) {
		rentalTransactionDAO.update(transaction);
	}

	public void deleteRentalTransaction(int transactionId) {
		rentalTransactionDAO.delete(transactionId);
	}
}
