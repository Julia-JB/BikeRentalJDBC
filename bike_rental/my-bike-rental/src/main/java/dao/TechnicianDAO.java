package dao;
import Interface.CrudDAO;
import model.Maintenance;
import model.Technician;
import utilities.SQLConnection;
import dao.daoUtilities.DaoUtility;
import dao.daoUtilities.StatusLogUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TechnicianDAO implements CrudDAO<Technician, Integer> {
	@Override
	public void save(Technician technician) {
		String sql = "INSERT INTO technicians (first_name, last_name, phone_number, email) VALUES" +
				" (?, ?, ?, ?);";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			DaoUtility.setObjectParameters(statement, technician);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(technician, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Technician getById(Integer technicianId) {
		String sql = "SELECT technicians.technician_id, first_name, last_name, phone_number, " +
				"email, maintenance_id, date_start, date_end, description, bike_id " +
				"FROM technicians " +
				"LEFT JOIN maintenance ON technicians.technician_id = maintenance.technician_id " +
				"WHERE technicians.technician_id = ?";

		try (Connection connection = SQLConnection.getConnection(); PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, technicianId);
			ResultSet resultSet = statement.executeQuery();

			Technician technician = null;

			while (resultSet.next()) {
				if (technician == null) {
					technicianId = resultSet.getInt("technician_id");
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					String phoneNumber = resultSet.getString("phone_number");
					String email = resultSet.getString("email");
					technician = new Technician(technicianId, firstName, lastName, phoneNumber,
							email);

				}

				if (!resultSet.wasNull()) {
					int maintenanceId = resultSet.getInt("maintenance_id");
					Date dateStart = resultSet.getDate("date_start");
					Date dateEnd = resultSet.getDate("date_end");
					String description = resultSet.getString("description");
					int bikeId = resultSet.getInt("bike_id");

					Maintenance maintenance = new Maintenance(maintenanceId, dateStart, dateEnd, description, bikeId, technicianId);
					technician.getMaintenanceList().add(maintenance);
				}
			}
			return technician;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public List<Technician> getAll() {
		List<Technician> technicians = new ArrayList<>();
		String sql = "SELECT technicians.technician_id, first_name, last_name, phone_number, " +
				"email, maintenance_id, date_start, date_end, description, bike_id " +
				"FROM technicians " +
				"LEFT JOIN maintenance ON technicians.technician_id = maintenance.technician_id;";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql);
		     ResultSet resultSet = statement.executeQuery()) {

			while (resultSet.next()) {
				int technicianId = resultSet.getInt("technician_id");

				Technician technician = findTechnicianById(technicians, technicianId);
				if (technician == null) {
					String firstName = resultSet.getString("first_name");
					String lastName = resultSet.getString("last_name");
					String phoneNumber = resultSet.getString("phone_number");
					String email = resultSet.getString("email");
					technician = new Technician(technicianId, firstName, lastName, phoneNumber,
							email);
					technicians.add(technician);
				}

				if (!resultSet.wasNull()) {
					int maintenanceId = resultSet.getInt("maintenance_id");
					Date dateStart = resultSet.getDate("date_start");
					Date dateEnd = resultSet.getDate("date_end");
					String description = resultSet.getString("description");
					int bikeId = resultSet.getInt("bike_id");

					Maintenance maintenance = new Maintenance(maintenanceId, dateStart, dateEnd, description, bikeId, technicianId);
					technician.getMaintenanceList().add(maintenance);
				}
			}

			return technicians;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	private Technician findTechnicianById(List<Technician> technicians, int technicianId) {
		for (Technician technician : technicians) {
			if (technician.getTechnicianId() == technicianId) {
				return technician;
			}
		}
		return null;
	}



	@Override
	public void update(Technician technician) {
		String sql = "UPDATE technicians SET first_name = ?, last_name = ?, phone_number = ?, " +
				"email = ? WHERE technician_id = ?";
		try (   Connection connection = SQLConnection.getConnection();
		        PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = DaoUtility.setObjectFieldsForUpdate(statement, technician);
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
