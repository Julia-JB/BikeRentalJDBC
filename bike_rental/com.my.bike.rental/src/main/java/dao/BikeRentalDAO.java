package dao;

import Interface.CrudDAO;
import model.BikeRental;
import utilities.DBConnection;
import dao.daoUtilities.DaoUtility;
import dao.daoUtilities.StatusLogUtility;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BikeRentalDAO implements CrudDAO<BikeRental, Integer> {
	@Override
	public void save(BikeRental bikeRental) {
		String sql = "INSERT INTO bike_rentals (time_start, time_end, cost, user_id, bike_id, " +
				"station_start_id, station_end_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			DaoUtility.setObjectParameters(statement, bikeRental);
			int rowsAffected = statement.executeUpdate();
			if (rowsAffected > 0) {
				System.out.println("EntityLayer.Bike rental saved successfully.");
			} else {
				System.out.println("EntityLayer.Bike rental was not saved.");
			}
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public BikeRental getById(Integer rentalId) {
		String sql =
				"SELECT rental_id AS rentalId, time_start AS timeStart, time_end AS " +
						"timeEnd, cost, user_id AS userId, bike_id AS bikeId, station_start_id AS" +
						" stationStartId, station_end_id AS stationEndId FROM bike_rentals WHERE " +
						"rental_id = ?";

		try (Connection connection = DBConnection.getConnection(); PreparedStatement statement =
				connection.prepareStatement(sql)) {
			statement.setInt(1, rentalId);
			ResultSet resultSet = statement.executeQuery();
			return DaoUtility.mapResultSetToObject(resultSet, BikeRental.class);
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<BikeRental> getAll() {
		List<BikeRental> bikeRentals= new ArrayList<>();
		String sql =
				"SELECT rental_id AS rentalId, time_start AS timeStart, time_end AS " +
						"timeEnd, cost, user_id AS userId, bike_id AS bikeId, station_start_id AS" +
						" stationStartId, station_end_id AS stationEndId FROM bike_rentals;";
		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			bikeRentals = DaoUtility.mapResultSetToObjectList(resultSet, BikeRental.class);
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return bikeRentals;

	}

	@Override
	public void update(BikeRental bikeRental) {
		String sql = "UPDATE bike_rentals SET time_start = ?, time_end = ?, cost = ?, " +
				"user_id = ?, bike_id = ?, station_start_id = ?, station_end_id = ? WHERE " +
				"rental_id = ?";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = DaoUtility.setObjectFieldsForUpdate(statement, bikeRental);
			statement.setInt(parameterIndex, bikeRental.getRentalId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(bikeRental, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer rentalId) {
		String sql = "DELETE FROM bike_rentals WHERE rental_id = ?";

		try (Connection connection = DBConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, rentalId);

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(BikeRental.class, rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
