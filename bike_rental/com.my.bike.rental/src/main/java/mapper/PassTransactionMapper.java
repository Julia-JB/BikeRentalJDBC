package mapper;

import model.PassTransaction;

import java.util.List;

public interface PassTransactionMapper {
	void addPassTransaction(PassTransaction passTransaction);

	PassTransaction selectPassTransactionById(int id);

	List<PassTransaction> selectAllPassTransactions();

	void updatePassTransaction(PassTransaction passTransaction);

	void deletePassTransaction(int id);
}
