package dao;

import model.Feedback;
import utilities.DBConnection;
import dao.daoUtilities.DaoUtility;
import dao.daoUtilities.StatusLogUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FeedbackDAO implements CrudDAO<Feedback, Integer> {
	@Override
	public void save(Feedback feedback) {
		String sql = "INSERT INTO feedback (date, rating, comments, user_id) VALUES (?, ?, ?, ?);";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			DaoUtility.setObjectParameters(statement, feedback);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(feedback, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Feedback getById(Integer feedbackId) {
		String sql = "SELECT feedback_id AS feedbackId, date, rating, comments, user_id AS userId" +
				" FROM feedback WHERE feedback_id = ?;";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement =
				connection.prepareStatement(sql)) {
			statement.setInt(1, feedbackId);
			ResultSet resultSet = statement.executeQuery();
			Feedback feedback = DaoUtility.mapResultSetToObject(resultSet, Feedback.class);
			return  feedback;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

		@Override
	public List<Feedback> getAll() {
		List<Feedback> feedbacks = new ArrayList<>();
			String sql = "SELECT feedback_id AS feedbackId, date, rating, comments, user_id AS userId" +
					" FROM feedback;";

			try (Connection connection = DBConnection.getConnection();
			     PreparedStatement statement = connection.prepareStatement(sql)) {
				 ResultSet resultSet = statement.executeQuery();
				  feedbacks = DaoUtility.mapResultSetToObjectList(resultSet, Feedback.class);
				} catch (SQLException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
			return feedbacks;
	}
	@Override
	public void update(Feedback feedback) {
		String sql = "UPDATE feedback SET date = ?, rating = ?, comments = ?, user_id = ? WHERE " +
				"feedback_id = ?";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = DaoUtility.setObjectFieldsForUpdate(statement, feedback);
			statement.setInt(parameterIndex, feedback.getFeedbackId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(feedback, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer feedbackId) {
		String sql = "DELETE FROM users WHERE user_id = ?";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, feedbackId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(Feedback.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
