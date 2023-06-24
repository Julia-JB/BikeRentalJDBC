package serviceDAO;

import dao.PassTransactionDAO;
import model.PassTransaction;

import java.util.List;

public class PassTransactionService {
	private PassTransactionDAO passTransactionDAO;

	public PassTransactionService() {
		passTransactionDAO = new PassTransactionDAO();
	}

	public void insertPassTransaction(PassTransaction transaction) {
		passTransactionDAO.save(transaction);
	}

	public PassTransaction selectPassTransaction(int transactionId) {
		return passTransactionDAO.getById(transactionId);
	}

	public List<PassTransaction> selectAllPassTransactions(){
		return passTransactionDAO.getAll();
	}

	public void updatePassTransaction(PassTransaction transaction) {
		passTransactionDAO.update(transaction);
	}

	public void deletePassTransaction(int transactionId) {
		passTransactionDAO.delete(transactionId);
	}
}
