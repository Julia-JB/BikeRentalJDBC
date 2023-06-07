package daoLayer;

import entityLayer.Station;
import utilities.SQLConnection;
import utilities.StatementUtility;
import utilities.StatusLogUtility;

import java.awt.geom.Point2D;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StationDAO implements CrudDAO<Station, Integer> {


	@Override
	public void save(Station station) {
		Point2D point = station.getLocation();
		String sql =
				"INSERT INTO stations (name, location, capacity) VALUES (?, POINT(?, ?), ?)";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {

			setParameters(statement, station);

			int rowsAffected  = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(station, rowsAffected);
	} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Station getById(Integer stationId) {
		String sql = "SELECT station_id, name, ST_AsText(location) AS locationStr, capacity FROM " +
				"stations WHERE station_id = ?";

		try (Connection connection = SQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, stationId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Station station = mapToStationObject(resultSet);
				return station;
			}
		} catch (SQLException e) {

		}
		return null;
	}

	@Override
	public List<Station> getAll() {
		List<Station> stations = new ArrayList<>();
		String sql = "SELECT station_id, name, ST_AsText(location) AS locationStr, capacity FROM " +
				"stations";
		try (Connection connection = SQLConnection.getConnection();
		PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Station station = mapToStationObject(resultSet);
				stations.add(station);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stations;
	}

	@Override
	public void update(Station station) {
		String sql = "UPDATE stations SET name = ?, location = POINT(?, ?), capacity = ? WHERE " +
				"station_id = ?";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {

			setParameters(statement, station);

			 int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logUpdateStatus(station, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer stationId) {
		String sql = "DELETE FROM stations WHERE station_id = ?";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			 statement.setInt(1, stationId);

			 int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(Station.class, rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	private Station mapToStationObject(ResultSet resultSet) throws SQLException {
		Station station = new Station();
		String locationStr = resultSet.getString("locationStr");
		Point2D location = StatementUtility.parseLocationText(locationStr);

		station.setStationId(resultSet.getInt("station_id"));
		station.setName(resultSet.getString("name"));
		station.setLocation(location);
		station.setCapacity(resultSet.getInt("capacity"));
		return station;
	}

	private void setParameters(PreparedStatement statement, Station station) throws SQLException {
		statement.setString(1, station.getName());
		statement.setDouble(2, station.getLocation().getX());
		statement.setDouble(3, station.getLocation().getY());
		statement.setInt(4, station.getCapacity());
		statement.setInt(5, station.getStationId());
	}
}
