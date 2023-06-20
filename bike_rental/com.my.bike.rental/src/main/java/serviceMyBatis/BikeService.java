package serviceMyBatis;

import mapper.BikeMapper;
import model.Bike;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class BikeService {

	public void insertBike(Bike bike) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			bikeMapper.addBike(bike);
		}
	}

	public Bike selectBike(int bikeId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			return bikeMapper.selectBikeById(bikeId);
		}
	}

	public List<Bike> selectAllBikes() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			return bikeMapper.selectAllBikes();
		}
	}

	public void updateBike(Bike bike) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			bikeMapper.updateBike(bike);
		}
	}

	public void deleteBike(int bikeId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			bikeMapper.deleteBike(bikeId);
		}
	}
}
