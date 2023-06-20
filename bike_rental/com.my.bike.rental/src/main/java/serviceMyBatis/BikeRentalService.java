package serviceMyBatis;
import mapper.BikeRentalMapper;
import model.BikeRental;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BikeRentalService {

	 public void insertBikeRental(BikeRental bikeRental) throws IOException {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 bikeRentalMapper.addBikeRental(bikeRental);
		 }
	 }

	 public BikeRental selectBikeRental(int bikeRentalId) throws IOException {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 return bikeRentalMapper.selectBikeRentalById(bikeRentalId);
		 }
	 }

	 public List<BikeRental> selectAllBikeRentals() throws IOException {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 return bikeRentalMapper.selectAllBikeRentals();
		 }
	 }

	 public void updateBikeRental(BikeRental bikeRental) throws IOException {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 bikeRentalMapper.updateBikeRental(bikeRental);
		 }
	 }
	 public void deleteBikeRental(int bikeRentalId) throws IOException {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 bikeRentalMapper.deleteBikeRental(bikeRentalId);
		 }
	 }
}
