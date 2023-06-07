package daoLayer;

import entityLayer.RentalTransaction;
import utilities.SQLConnection;
import utilities.StatementUtility;
import utilities.StatusLogUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalTransactionDAO implements CrudDAO<RentalTransaction, Integer> {
	@Override
	public void save(RentalTransaction rentalTransaction) {
		String sql =
				"INSERT INTO rental_transactions (date, type, amount, user_id, rental_id) " +
						"VALUES (?, ?, ?, ?, ?);";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			StatementUtility.setObjectParameters(statement, rentalTransaction);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(rentalTransaction, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public RentalTransaction getById(Integer transactionId) {
		String sql = "SELECT transaction_id AS transactionId, date AS dateTime, type, amount, " +
				"user_id AS userId, rental_id as rentalId FROM rental_transactions WHERE " +
				"transaction_id = ?;";
		try ( Connection connection = SQLConnection.getConnection();
		      PreparedStatement statement =
				      connection.prepareStatement(sql)) {
			statement.setInt(1, transactionId);
			ResultSet resultSet = statement.executeQuery();
			RentalTransaction rentalTransaction = StatementUtility.mapResultSetToObject(resultSet,
					RentalTransaction.class);
			return  rentalTransaction;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<RentalTransaction> getAll() {
		List<RentalTransaction> transactions = new ArrayList<>();
		String sql = "SELECT transaction_id AS transactionId, date AS dateTime, type, amount, " +
				"user_id AS userId, rental_id as rentalId FROM rental_transactions;";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			transactions = StatementUtility.mapResultSetToObjectList(resultSet,
					RentalTransaction.class);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return transactions;
	}

	@Override
	public void update(RentalTransaction rentalTransaction) {
		String sql = "UPDATE rental_transactions SET date = ?, type = ?, amount = ?, user_id = ?," +
				" rental_id = ? WHERE transaction_id = ?";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = StatementUtility.setObjectFieldsForUpdate(statement, rentalTransaction);
			statement.setInt(parameterIndex, rentalTransaction.getTransactionId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(rentalTransaction, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer transactionId) {
		String sql = "DELETE FROM rental_transactions WHERE transaction_id = ?";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, transactionId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(RentalTransaction.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
