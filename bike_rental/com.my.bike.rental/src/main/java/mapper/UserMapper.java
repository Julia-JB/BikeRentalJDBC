package mapper;

import model.User;

import java.util.List;

public interface UserMapper {
	void addUser(User user);
	User selectUserById(int id);
	List<User> selectAllUsers();
	void updateUser(User user);
	void deleteUser(int id);
}
