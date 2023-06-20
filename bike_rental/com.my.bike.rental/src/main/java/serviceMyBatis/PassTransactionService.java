package serviceMyBatis;
import mapper.PassTransactionMapper;
import model.PassTransaction;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PassTransactionService {

	public void insertPassTransaction(PassTransaction transaction) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassTransactionMapper passTransactionMapper = session.getMapper(PassTransactionMapper.class);
			passTransactionMapper.addPassTransaction(transaction);
		}
	}

	public PassTransaction selectPassTransaction(int transactionId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassTransactionMapper passTransactionMapper = session.getMapper(PassTransactionMapper.class);
			return passTransactionMapper.selectPassTransactionById(transactionId);
		}
	}

	public List<PassTransaction> selectAllPassTransactions() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassTransactionMapper passTransactionMapper = session.getMapper(PassTransactionMapper.class);
			return passTransactionMapper.selectAllPassTransactions();
		}
	}

	public void updatePassTransaction(PassTransaction transaction) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassTransactionMapper passTransactionMapper = session.getMapper(PassTransactionMapper.class);
			passTransactionMapper.updatePassTransaction(transaction);
		}
	}

	public void deletePassTransaction(int transactionId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassTransactionMapper passTransactionMapper = session.getMapper(PassTransactionMapper.class);
			passTransactionMapper.deletePassTransaction(transactionId);
		}
	}
}
