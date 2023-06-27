package serviceMyBatis;
import designPatterns.serviceInterface.IBikeRentalService;
import mapper.BikeRentalMapper;
import model.BikeRental;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BikeRentalService implements IBikeRentalService {

	 public void insertBikeRental(BikeRental bikeRental)  {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 bikeRentalMapper.addBikeRental(bikeRental);
		 } catch (IOException e) {
			e.printStackTrace();
		 }
	 }

	 public BikeRental selectBikeRental(int bikeRentalId) {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 return bikeRentalMapper.selectBikeRentalById(bikeRentalId);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 return null;
	 }

	 public List<BikeRental> selectAllBikeRentals() {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 return bikeRentalMapper.selectAllBikeRentals();
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
		 return new ArrayList<>();
	 }

	 public void updateBikeRental(BikeRental bikeRental) {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 bikeRentalMapper.updateBikeRental(bikeRental);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
	 public void deleteBikeRental(int bikeRentalId) {
		 try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			 SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			 BikeRentalMapper bikeRentalMapper = session.getMapper(BikeRentalMapper.class);
			 bikeRentalMapper.deleteBikeRental(bikeRentalId);
		 } catch (IOException e) {
			 e.printStackTrace();
		 }
	 }
}
