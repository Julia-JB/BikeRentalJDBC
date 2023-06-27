package serviceMyBatis;

import mapper.MaintenanceMapper;
import model.Maintenance;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MaintenanceService {

	public void insertMaintenance(Maintenance maintenance) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			MaintenanceMapper maintenanceMapper = session.getMapper(MaintenanceMapper.class);
			maintenanceMapper.addMaintenance(maintenance);
		}
	}

	public Maintenance selectMaintenance(int maintenanceId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			MaintenanceMapper maintenanceMapper = session.getMapper(MaintenanceMapper.class);
			return maintenanceMapper.selectMaintenanceById(maintenanceId);
		}
	}

	public List<Maintenance> selectAllMaintenance() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			MaintenanceMapper maintenanceMapper = session.getMapper(MaintenanceMapper.class);
			return maintenanceMapper.selectAllMaintenances();
		}
	}

	public void updateMaintenance(Maintenance maintenance) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			MaintenanceMapper maintenanceMapper = session.getMapper(MaintenanceMapper.class);
			maintenanceMapper.updateMaintenance(maintenance);
		}
	}

	public void deleteMaintenance(int maintenanceId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			MaintenanceMapper maintenanceMapper = session.getMapper(MaintenanceMapper.class);
			maintenanceMapper.deleteMaintenance(maintenanceId);
		}
	}
}
