package dao;

import model.PassTransaction;
import utilities.DBConnection;
import dao.daoUtilities.DaoUtility;
import dao.daoUtilities.StatusLogUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassTransactionDAO implements CrudDAO<PassTransaction, Integer> {
	@Override
	public void save(PassTransaction passTransaction) {
		String sql = "INSERT INTO pass_transactions (date, type, amount, user_id, pass_id) " +
						"VALUES (?, ?, ?, ?, ?);";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			DaoUtility.setObjectParameters(statement, passTransaction);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(passTransaction, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PassTransaction getById(Integer transactionId) {
		String sql = "SELECT transaction_id AS transactionId, date AS dateTime, type, amount, " +
				"user_id AS userId, pass_id as passId FROM pass_transactions WHERE transaction_id = ?;";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement =
				      connection.prepareStatement(sql)) {
			statement.setInt(1, transactionId);
			ResultSet resultSet = statement.executeQuery();
			PassTransaction passTransaction = DaoUtility.mapResultSetToObject(resultSet,
					PassTransaction.class);
			return  passTransaction;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PassTransaction> getAll() {
		List<PassTransaction> transactions = new ArrayList<>();
		String sql = "SELECT transaction_id AS transactionId, date AS dateTime, type, amount, " +
				"user_id AS userId, pass_id as passId FROM pass_transactions;";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			transactions = DaoUtility.mapResultSetToObjectList(resultSet, PassTransaction.class);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	@Override
	public void update(PassTransaction passTransaction) {
		String sql = "UPDATE pass_transactions SET date = ?, type = ?, amount = ?, user_id = ?, " +
				"pass_id = ? WHERE transaction_id = ?";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = DaoUtility.setObjectFieldsForUpdate(statement, passTransaction);
			statement.setInt(parameterIndex, passTransaction.getTransactionId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(passTransaction, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer transactionId) {
		String sql = "DELETE FROM pass_transactions WHERE transaction_id = ?";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, transactionId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(PassTransaction.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

