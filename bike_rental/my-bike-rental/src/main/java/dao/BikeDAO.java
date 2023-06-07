package dao;

import Interface.CrudDAO;
import model.Bike;
import utilities.SQLConnection;
import dao.daoUtilities.StatementUtility;
import dao.daoUtilities.StatusLogUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BikeDAO implements CrudDAO<Bike, Integer> {

	@Override
	public void save(Bike bike) {
		String sql = "INSERT INTO bikes (brand, properties, status, current_station_id) VALUES " +
				"(?, ?, ?, ?)";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			StatementUtility.setObjectParameters(statement, bike);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(bike, rowsAffected);
		} catch ( SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Bike getById(Integer bikeId) {
		String sql = "SELECT bike_id AS bikeId, brand, properties, status, current_station_id AS " +
				"currentStationId FROM bikes WHERE bike_id = ?";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement =
				connection.prepareStatement(sql)) {
			statement.setInt(1, bikeId);
			ResultSet resultSet = statement.executeQuery();
			return StatementUtility.mapResultSetToObject(resultSet, Bike.class);
		} catch ( SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Bike> getAll() {
		List<Bike> bikes = new ArrayList<>();
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement("SELECT * FROM bikes")) {
			ResultSet resultSet = statement.executeQuery();
			bikes = StatementUtility.mapResultSetToObjectList(resultSet, Bike.class);
			} catch (SQLException | IllegalAccessException |
		             InstantiationException e) {
			e.printStackTrace();
		}
		return bikes;
	}

	@Override
	public void update(Bike bike) {
		String sql = "UPDATE bikes SET brand = ?, properties = ?, status = ?, current_station_id " +
				"= ? WHERE bike_id = ?";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = StatementUtility.setObjectFieldsForUpdate(statement, bike);
			statement.setInt(parameterIndex, bike.getBikeId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(bike, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer bikeId) {
		String sql = "DELETE FROM bikes WHERE bike_id = ?";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, bikeId);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(Bike.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

