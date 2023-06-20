package serviceMyBatis;
import mapper.RentalTransactionMapper;
import model.RentalTransaction;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class RentalTransactionService {

	public void insertRentalTransaction(RentalTransaction transaction) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			RentalTransactionMapper rentalTransactionMapper =
					session.getMapper(RentalTransactionMapper.class);
			rentalTransactionMapper.addRentalTransaction(transaction);
		}
	}

	public RentalTransaction selectRentalTransaction(int transactionId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			RentalTransactionMapper rentalTransactionMapper = session.getMapper(RentalTransactionMapper.class);
			return rentalTransactionMapper.selectRentalTransactionById(transactionId);
		}
	}

	public List<RentalTransaction> getAllRentalTransactions() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			RentalTransactionMapper rentalTransactionMapper = session.getMapper(RentalTransactionMapper.class);
			return rentalTransactionMapper.selectAllRentalTransactions();
		}
	}

	public void updateRentalTransaction(RentalTransaction transaction) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			RentalTransactionMapper rentalTransactionMapper = session.getMapper(RentalTransactionMapper.class);
			rentalTransactionMapper.updateRentalTransaction(transaction);
		}
	}

	public void deleteRentalTransaction(int transactionId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			RentalTransactionMapper rentalTransactionMapper = session.getMapper(RentalTransactionMapper.class);
			rentalTransactionMapper.deleteRentalTransaction(transactionId);
		}
	}
}
