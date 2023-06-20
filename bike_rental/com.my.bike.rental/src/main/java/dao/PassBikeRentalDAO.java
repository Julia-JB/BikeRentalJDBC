package dao;

import Interface.CrudDAO;
import model.PassBikeRental;
import utilities.SQLConnection;
import dao.daoUtilities.DaoUtility;
import dao.daoUtilities.StatusLogUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassBikeRentalDAO implements CrudDAO<PassBikeRental, Integer> {
	@Override
	public void save(PassBikeRental passBikeRental) {
		String sql = "INSERT INTO pass_bike_rentals (time_start, time_end, bike_id, " +
				"station_start_id, station_end_id, pass_id, user_id) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			DaoUtility.setObjectParameters(statement, passBikeRental);
			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(passBikeRental, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public PassBikeRental getById(Integer passRentalId) {
		String sql = "SELECT pass_rental_id AS passRentalId, time_start AS timeStart, time_end AS" +
				" timeEnd, bike_id AS bikeId, station_start_id AS stationStartId, station_end_id " +
				" AS stationEndId, pass_id AS passId, user_id AS userId FROM pass_bike_rentals " +
				"WHERE pass_rental_id = ?;";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement =
				connection.prepareStatement(sql)) {
			statement.setInt(1, passRentalId);
			ResultSet resultSet = statement.executeQuery();
			return DaoUtility.mapResultSetToObject(resultSet, PassBikeRental.class);
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<PassBikeRental> getAll() {
		List<PassBikeRental> passBikeRentals = new ArrayList<>();
		String sql = "SELECT pass_rental_id AS passRentalId, time_start AS timeStart, time_end AS" +
		" timeEnd, bike_id AS bikeId, station_start_id AS stationStartId, station_end_id " +
				"AS stationEndId, pass_id AS passId, user_id AS userId FROM pass_bike_rentals;";

		try (Connection connection = SQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			passBikeRentals = DaoUtility.mapResultSetToObjectList(resultSet,
					PassBikeRental.class);
		} catch (SQLException | IllegalAccessException | InstantiationException e) {
			e.printStackTrace();
		}
		return  passBikeRentals;
	}

	@Override
	public void update(PassBikeRental passBikeRental) {
		String sql = "UPDATE pass_bike_rentals SET time_start = ?, time_end = ?, bike_id = ?, " +
				"station_start_id = ?, station_end_id = ?, pass_id = ?, user_id = ? WHERE " +
				"pass_rental_id = ?;";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			int parameterIndex = DaoUtility.setObjectFieldsForUpdate(statement, passBikeRental);
			statement.setInt(parameterIndex, passBikeRental.getPassRentalId());

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(passBikeRental, rowsAffected);
		} catch (SQLException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer passRentalId) {
		String sql = "DELETE FROM pass_bike_rentals WHERE pass_rental_id = ?";
		try (Connection connection = SQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, passRentalId);

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(PassBikeRental.class, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
