package mapper;

import model.Event;

import java.util.List;

public interface EventMapper {
	void addEvent(Event event);
	Event selectEventById(int id);
	List<Event> selectAllEvents();
	void updateEvent(Event event);
	void deleteEvent(int id);
}
