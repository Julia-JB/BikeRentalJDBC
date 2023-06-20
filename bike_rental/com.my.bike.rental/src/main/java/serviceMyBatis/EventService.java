package serviceMyBatis;
import mapper.EventMapper;
import model.Event;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class EventService {

	public void insertEvent(Event event) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			EventMapper eventMapper = session.getMapper(EventMapper.class);
			eventMapper.addEvent(event);
		}
	}

	public Event selectEvent(int eventId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			EventMapper eventMapper = session.getMapper(EventMapper.class);
			return eventMapper.selectEventById(eventId);
		}
	}

	public List<Event> selectAllEvents() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			EventMapper eventMapper = session.getMapper(EventMapper.class);
			return eventMapper.selectAllEvents();
		}
	}

	public void updateEvent(Event event) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			EventMapper eventMapper = session.getMapper(EventMapper.class);
			eventMapper.updateEvent(event);
		}
	}

	public void deleteEvent(int eventId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			EventMapper eventMapper = session.getMapper(EventMapper.class);
			eventMapper.deleteEvent(eventId);
		}
	}
}
