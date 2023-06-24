package serviceDAO;

import dao.EventDAO;
import model.Event;

import java.util.List;

public class EventService {
	private EventDAO eventDAO;

	public EventService() {
		eventDAO = new EventDAO();
	}

	public void insertEvent(Event event) {
		eventDAO.save(event);
	}

	public Event selectEvent(int eventId) {
		return eventDAO.getById(eventId);
	}

	public List<Event> selectAllEvents() {
		return eventDAO.getAll();
	}

	public void updateEvent(Event event) {
		eventDAO.update(event);
	}

	public void deleteEvent(int eventId) {
		eventDAO.delete(eventId);
	}
}
