package daoLayer;
import Interface.CrudDAO;
import entityLayer.Technician;
import utilities.SQLConnection;
import daoLayer.daoUtilities.StatementUtility;
import daoLayer.daoUtilities.StatusLogUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianDAO implements CrudDAO<Technician, Integer> {
	@Override
	public void save(Technician technician) {
		String sql = "INSERT INTO technicians (first_name, last_name, phone_number, email) VALUES" +
				" (?, ?, ?, ?);";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			StatementUtility.setObjectParameters(statement, technician);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(technician, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Technician getById(Integer technicianId) {
		String sql = "SELECT technician_id AS technicianId, first_name AS firstName, last_name AS" +
				" lastName, phone_number AS phoneNumber, email FROM technicians WHERE " +
				"technician_id = ?;";

		try (Connection connection = SQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, technicianId);
			ResultSet resultSet = statement.executeQuery();
			Technician technician = StatementUtility.mapResultSetToObject(resultSet,
					Technician.class);

			return technician;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Technician> getAll() {
		List<Technician> technicians = new ArrayList<>();
		String sql = "SELECT technician_id AS technicianId, first_name AS firstName, last_name AS" +
				" lastName, phone_number AS phoneNumber, email FROM technicians;";

		try (Connection connection = SQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			technicians = StatementUtility.mapResultSetToObjectList(resultSet, Technician.class);

		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return technicians;
	}

	@Override
	public void update(Technician technician) {
		String sql = "UPDATE technicians SET first_name = ?, last_name = ?, phone_number = ?, " +
				"email = ? WHERE technician_id = ?";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = StatementUtility.setObjectFieldsForUpdate(statement, technician);
			statement.setInt(parameterIndex, technician.getTechnicianId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(technician, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer technicianId) {
		String sql = "DELETE FROM technicians WHERE technician_id = ?;";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, technicianId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(Technician.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
