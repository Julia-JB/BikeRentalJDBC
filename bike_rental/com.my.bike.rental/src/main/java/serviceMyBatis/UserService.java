package serviceMyBatis;

import dao.UserDAO;
import mapper.TechnicianMapper;
import mapper.UserMapper;
import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserService {
	public void insertUser(User user) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			UserMapper userMapper =
					session.getMapper(UserMapper.class);
			userMapper.addUser(user);
		}
	}

	public User selectUser(int userId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			UserMapper userMapper =
					session.getMapper(UserMapper.class);
			return userMapper.selectUserById(userId);
		}
	}

	public List<User> selectAllUsers() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			UserMapper userMapper =
					session.getMapper(UserMapper.class);
			return userMapper.selectAllUsers();
		}
	}

	public void updateUser(User user) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			UserMapper userMapper =
					session.getMapper(UserMapper.class);
			userMapper.updateUser(user);
		}
	}

	public void deleteUser(int userId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			UserMapper userMapper =
					session.getMapper(UserMapper.class);
			userMapper.deleteUser(userId);
		}
	}
}
