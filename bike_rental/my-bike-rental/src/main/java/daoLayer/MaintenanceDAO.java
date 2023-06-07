package daoLayer;

import Interface.CrudDAO;
import entityLayer.Maintenance;
import utilities.SQLConnection;
import daoLayer.daoUtilities.StatementUtility;
import daoLayer.daoUtilities.StatusLogUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO implements CrudDAO<Maintenance, Integer> {
	@Override
	public void save(Maintenance maintenance) {
		String sql = "INSERT INTO maintenance (date_start, date_end, description, bike_id, " +
						"technician_id) VALUES (?, ?, ?, ?, ?);";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			StatementUtility.setObjectParameters(statement, maintenance);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(maintenance, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Maintenance getById(Integer maintenanceId) {
		String sql = "SELECT maintenance_id AS maintenanceId, date_start AS dateStart, date_end " +
				"AS dateEnd, description, bike_id AS bikeId, technician_id AS technicianId FROM " +
				"maintenance WHERE maintenance_id = ?;";
		try ( Connection connection = SQLConnection.getConnection();
		      PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, maintenanceId);
			ResultSet resultSet = statement.executeQuery();
			Maintenance maintenance = StatementUtility.mapResultSetToObject(resultSet, Maintenance.class);
			return  maintenance;
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Maintenance> getAll() {
		List<Maintenance> maintenanceEntries = new ArrayList<>();
		String sql = "SELECT maintenance_id AS maintenanceId, date_start AS dateStart, date_end " +
				"AS dateEnd, description, bike_id AS bikeId, technician_id AS technicianId FROM " +
				"maintenance;";

		try (Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			maintenanceEntries = StatementUtility.mapResultSetToObjectList(resultSet,
					Maintenance.class);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return maintenanceEntries;
	}

	@Override
	public void update(Maintenance maintenance) {
		String sql = "UPDATE maintenance SET date_start = ?, date_end = ?, description = ?, " +
				"bike_id = ?, technician_id = ? WHERE maintenance_id = ?";

		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = StatementUtility.setObjectFieldsForUpdate(statement, maintenance);
			statement.setInt(parameterIndex, maintenance.getMaintenanceId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(maintenance, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer maintenanceId) {
		String sql = "DELETE FROM maintenance WHERE maintenance_id = ?";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, maintenanceId);
			int rowsAffected = statement.executeUpdate();
		StatusLogUtility.logDeleteStatus(Maintenance.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
