package mapper;

import model.RentalTransaction;

import java.util.List;

public interface RentalTransactionMapper {
	void addRentalTransaction(RentalTransaction transaction);

	RentalTransaction selectRentalTransactionById(int id);

	List<RentalTransaction> selectAllRentalTransactions();

	void updateRentalTransaction(RentalTransaction transaction);

	void deleteRentalTransaction(int id);
}
