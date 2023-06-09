package dao;

import model.User;
import utilities.DBConnection;
import dao.daoUtilities.DaoUtility;
import dao.daoUtilities.StatusLogUtility;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User, Integer> {

	// create
	@Override
	public void save(User user) {
		String sql = "INSERT INTO users (first_name, last_name, email, date_registered) VALUES " +
				"(?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			 DaoUtility.setObjectParameters(statement, user);
			 int rowsAffected = statement.executeUpdate();
			 StatusLogUtility.logSaveStatus(user, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	// read
	public User getById(Integer userId) {
		String sql = "SELECT user_id AS userId, first_name AS firstName, last_name AS lastName, " + "email, date_registered AS dateRegistered FROM users WHERE user_id = ?";

		try (Connection connection = DBConnection.getConnection(); PreparedStatement statement =
				connection.prepareStatement(sql)) {
			statement.setInt(1, userId);
			ResultSet resultSet = statement.executeQuery();
			return DaoUtility.mapResultSetToObject(resultSet, User.class);
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

		// read
	@Override
	public List<User> getAll() {
		List<User> users = new ArrayList<>();
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement("SELECT user_id AS userId," +
						     " first_name AS firstName, last_name AS lastName, email, " +
						     "date_registered AS dateRegistered FROM users;")) {
			ResultSet resultSet = statement.executeQuery();
			users = DaoUtility.mapResultSetToObjectList(resultSet, User.class);
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return users;
	}

	// update
	@Override
	public void update(User user) {
		String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, " +
				"date_registered = ? WHERE user_id = ?";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			 int parameterIndex = DaoUtility.setObjectFieldsForUpdate(statement, user);
			 statement.setInt(parameterIndex, user.getUserId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(user, rowsAffected);
		} catch ( SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	// delete
	@Override
	public void delete(Integer userId) {
		String sql = "DELETE FROM users WHERE user_id = ?";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, userId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(User.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
