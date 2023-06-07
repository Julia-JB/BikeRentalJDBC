package daoLayer;

import Interface.CrudDAO;
import entityLayer.Event;
import utilities.SQLConnection;
import daoLayer.daoUtilities.StatementUtility;
import daoLayer.daoUtilities.StatusLogUtility;

import java.awt.geom.Point2D;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EventDAO implements CrudDAO<Event, Integer> {
	@Override
	public void save(Event event) {
		String sql = "INSERT INTO events (name, date, location, organizer_id) VALUES (?, ?, POINT" +
				"(?, ?), ?)";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			setParameters(statement, event);
			int rowsAffected  = statement.executeUpdate();
			StatusLogUtility.logSaveStatus(event, rowsAffected);
		} catch (SQLException  e) {
			e.printStackTrace();
		}
	}

	@Override
	public Event getById(Integer eventId) {
		String sql = "SELECT event_id , name, date, ST_AsText(location) AS locationStr," +
				" organizer_id FROM events WHERE event_id = ?";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, eventId);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				Event event = mapToEventObject(resultSet);
				return event;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Event> getAll() {
		List<Event> events = new ArrayList<>();
		String sql = "SELECT event_id , name, date, ST_AsText(location) AS locationStr, " +
				"organizer_id FROM events";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Event event = mapToEventObject(resultSet);
				events.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return events;
	}

	@Override
	public void update(Event event) {
		String sql = "UPDATE events SET name = ?, date = ?, location = POINT(?, ?), organizer_id " +
				"= ? WHERE event_id = ?";
		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			setParameters(statement, event);

			int rowsAffected = statement.executeUpdate();
		StatusLogUtility.logUpdateStatus(event, rowsAffected);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void delete(Integer eventId) {
		String sql = "DELETE FROM events WHERE event_id = ?";

		try (Connection connection = SQLConnection.getConnection();
		     PreparedStatement statement = connection.prepareStatement(sql)) {
			statement.setInt(1, eventId);

			int rowsAffected = statement.executeUpdate();
			StatusLogUtility.logDeleteStatus(Event.class, rowsAffected);

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private Event mapToEventObject(ResultSet resultSet) throws SQLException {
		Event event = new Event();
		String locationStr = resultSet.getString("locationStr");
		Point2D location = StatementUtility.parseLocationText(locationStr);

		event.setEventId(resultSet.getInt("event_id"));
		event.setName(resultSet.getString("name"));

		java.sql.Timestamp timestamp = resultSet.getTimestamp("date");
		LocalDateTime localDateTime = timestamp.toLocalDateTime();
		event.setDate(localDateTime);

		event.setLocation(location);
		event.setOrganizerId(resultSet.getInt("organizer_id"));

		return event;
	}

	private void setParameters(PreparedStatement statement, Event event) throws SQLException {
		statement.setString(1, event.getName());
		LocalDateTime dateTime = event.getDate();
		Timestamp timestamp = Timestamp.valueOf(dateTime);
		statement.setTimestamp(2, timestamp);

		statement.setDouble(3, event.getLocation().getX());
		statement.setDouble(4, event.getLocation().getY());
		statement.setInt(5, event.getOrganizerId());
	}
}
