package serviceMyBatis;

import designPatterns.serviceInterface.ITechnicianService;
import mapper.TechnicianMapper;
import model.Technician;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TechnicianService implements ITechnicianService {

	public void insertTechnician(Technician technician) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			technicianMapper.addTechnician(technician);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Technician selectTechnician(int technicianId) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			return technicianMapper.selectTechnicianById(technicianId);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Technician> selectAllTechnicians() {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			return technicianMapper.selectAllTechnicians();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public void updateTechnician(Technician technician) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
			technicianMapper.updateTechnician(technician);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deleteTechnician(int technicianId) {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			TechnicianMapper technicianMapper =
					session.getMapper(TechnicianMapper.class);
		technicianMapper.deleteTechnician(technicianId);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
