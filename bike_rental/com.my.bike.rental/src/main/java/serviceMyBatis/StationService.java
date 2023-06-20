package serviceMyBatis;

import mapper.StationMapper;
import model.Station;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class StationService {

	public void insertStation(Station station) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			StationMapper stationMapper =
					session.getMapper(StationMapper.class);
			stationMapper.addStation(station);
		}
	}

	public Station selectStation(int stationId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			StationMapper stationMapper =
					session.getMapper(StationMapper.class);
			return stationMapper.selectStationById(stationId);
		}
	}

	public List<Station> selectAllStations() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			StationMapper stationMapper =
					session.getMapper(StationMapper.class);
			return stationMapper.selectAllStations();
		}
	}

	public void updateStation(Station station) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			StationMapper stationMapper =
					session.getMapper(StationMapper.class);
			stationMapper.updateStation(station);
		}
	}

	public void deleteStation(int stationId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			StationMapper stationMapper =
					session.getMapper(StationMapper.class);
			stationMapper.deleteStation(stationId);
		}
	}
}

