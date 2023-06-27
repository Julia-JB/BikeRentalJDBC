package serviceMyBatis;

import mapper.BikeMapper;
import model.Bike;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import designPatterns.factoryMethod.Interface.IBikeService;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class BikeService implements IBikeService {

	public void insertBike(Bike bike) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			bikeMapper.addBike(bike);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Bike selectBike(int bikeId) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			return bikeMapper.selectBikeById(bikeId);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Bike> selectAllBikes() {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			return bikeMapper.selectAllBikes();
		} catch (IOException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	public void updateBike(Bike bike) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			bikeMapper.updateBike(bike);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteBike(int bikeId) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			BikeMapper bikeMapper = session.getMapper(BikeMapper.class);
			bikeMapper.deleteBike(bikeId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
