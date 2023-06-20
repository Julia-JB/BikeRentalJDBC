package serviceMyBatis;

import mapper.TechnicianMapper;
import model.Technician;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TechnicianService {

	public void insertTechnician(Technician technician) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			technicianMapper.addTechnician(technician);
		}
	}

	public Technician selectTechnician(int technicianId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			return technicianMapper.selectTechnicianById(technicianId);
		}
	}

	public List<Technician> selectAllTechnicians() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			return technicianMapper.selectAllTechnicians();
		}
	}

	public void updateTechnician(Technician technician) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			technicianMapper.updateTechnician(technician);
		}
	}

	public void deleteTechnician(int technicianId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
		technicianMapper.deleteTechnician(technicianId);
		}
	}
}
