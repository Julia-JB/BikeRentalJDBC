package serviceDAO;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
	private UserDAO userDAO;
	public UserService() {
		userDAO = new UserDAO();
	}
	public void insertUser(User user) {
		userDAO.save(user);
	}

	public User selectUser(int userId) {
		return userDAO.getById(userId);
	}

	public List<User> selectAllUsers() {
		return userDAO.getAll();
	}

	public void updateUser(User user) {
		userDAO.update(user);
	}

	public void deleteUser(int userId) {
		userDAO.delete(userId);
	}
}
