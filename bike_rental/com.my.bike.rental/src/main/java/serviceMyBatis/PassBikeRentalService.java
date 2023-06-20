package serviceMyBatis;
import mapper.PassBikeRentalMapper;
import model.PassBikeRental;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PassBikeRentalService {

	public void insertPassBikeRental(PassBikeRental passBikeRental) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassBikeRentalMapper passBikeRentalMapper= session.getMapper(PassBikeRentalMapper.class);
			passBikeRentalMapper.addPassBikeRental(passBikeRental);
		}
	}

	public PassBikeRental selectPassBikeRental(int rentalId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassBikeRentalMapper passBikeRentalMapper= session.getMapper(PassBikeRentalMapper.class);
			return passBikeRentalMapper.selectPassBikeRentalById(rentalId);
		}
	}

	public List<PassBikeRental> selectAllPassBikeRentals() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassBikeRentalMapper passBikeRentalMapper= session.getMapper(PassBikeRentalMapper.class);
			return passBikeRentalMapper.selectAllPassBikeRentals();
		}
	}

	public void updatePassBikeRental(PassBikeRental passBikeRental) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassBikeRentalMapper passBikeRentalMapper= session.getMapper(PassBikeRentalMapper.class);
			passBikeRentalMapper.updatePassBikeRental(passBikeRental);
		}
	}

	public void deletePassBikeRental(int rentalId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassBikeRentalMapper passBikeRentalMapper= session.getMapper(PassBikeRentalMapper.class);
			passBikeRentalMapper.deletePassBikeRental(rentalId);
		}
	}
}
