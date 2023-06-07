package dao;

import Interface.CrudDAO;
import model.Pass;
import utilities.SQLConnection;
import dao.daoUtilities.StatementUtility;
import dao.daoUtilities.StatusLogUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassDAO implements CrudDAO<Pass, Integer> {
	@Override
	public void save(Pass pass) {
		String sql = "INSERT INTO passes (type, price, valid_from, valid_to, " +
						"user_id) VALUES (?, ?, ?, ?, ?);";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			StatementUtility.setObjectParameters(statement, pass);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(pass, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Pass getById(Integer passId) {
		String sql = "SELECT pass_id AS passId, type, price, valid_from AS validFrom, valid_to AS" +
				" validTo, user_id AS userId FROM passes WHERE pass_id = ?;";

		try ( Connection connection = SQLConnection.getConnection();
		      PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, passId);
			ResultSet resultSet = statement.executeQuery();
			Pass pass = StatementUtility.mapResultSetToObject(resultSet, Pass.class);
			return pass;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Pass> getAll() {
		List<Pass> passes = new ArrayList<>();
		String sql = "SELECT pass_id AS passId, type, price, valid_from AS validFrom, valid_to AS" +
				" validTo, user_id AS userId FROM passes;";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			passes = StatementUtility.mapResultSetToObjectList(resultSet,
					Pass.class);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return passes;
	}

	@Override
	public void update(Pass pass) {
		String sql = "UPDATE passes SET type = ?, price = ?, valid_from = ?, " +
				"valid_to = ?, user_id = ? WHERE pass_id = ?";

		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = StatementUtility.setObjectFieldsForUpdate(statement, pass);
			statement.setInt(parameterIndex, pass.getPassId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(pass, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void delete(Integer passId) {
		String sql = "DELETE FROM passes WHERE pass_id = ?";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, passId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(Pass.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
