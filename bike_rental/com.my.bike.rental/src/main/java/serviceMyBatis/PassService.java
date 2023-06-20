package serviceMyBatis;

import mapper.PassMapper;
import model.Pass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PassService {

	public void insertPass(Pass pass) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassMapper passMapper = session.getMapper(PassMapper.class);
			passMapper.addPass(pass);
		}
	}

	public Pass selectPass(int passId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassMapper passMapper = session.getMapper(PassMapper.class);
			return passMapper.selectPassById(passId);
		}
	}

	public List<Pass> selectAllPasses() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassMapper passMapper = session.getMapper(PassMapper.class);
			return passMapper.selectAllPasses();
		}
	}

	public void updatePass(Pass pass) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassMapper passMapper = session.getMapper(PassMapper.class);
			passMapper.updatePass(pass);
		}
	}

	public void deletePass(int passId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			PassMapper passMapper = session.getMapper(PassMapper.class);
			passMapper.deletePass(passId);
		}
	}
}
