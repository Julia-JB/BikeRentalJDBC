package model;

import javax.xml.bind.annotation.*;
import java.awt.geom.Point2D;
import java.time.LocalDateTime;

		@XmlRootElement(name = "event")
		@XmlAccessorType(XmlAccessType.FIELD)
		public class Event {
		@XmlElement(name = "eventId")
		private Integer eventId;
		@XmlElement(name = "name")
		private String name;
		@XmlElement(name = "date")
		private LocalDateTime date;
		@XmlElement(name = "location")
		private Point2D location;
		@XmlElement(name = "organizerId")
		private Integer organizerId;
		@XmlElement(name = "user")
		private User user;

		public Event() {
		}
		public Event(String name, LocalDateTime date, Point2D location, User user) {
			this.name = name;
			this.date = date;
			this.location = location;
			this.user = user;
		}

		public Event(Integer eventId, String name, LocalDateTime date, Point2D location,
		             User user) {
			this.eventId = eventId;
			this.name = name;
			this.date = date;
			this.location = location;
			this.user = user;
		}

			@Override
			public String toString() {
				return "Event{" +
						"eventId=" + eventId +
						", name='" + name + '\'' +
						", date=" + date +
						", location=" + location +
						", user" + user +
						'}';
			}

			public int getEventId() {
			return eventId;
		}

		public void setEventId(int eventId) {
			this.eventId = eventId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public LocalDateTime getDate() {
			return date;
		}

		public void setDate(LocalDateTime date) {
			this.date = date;
		}

		public Point2D getLocation() {
			return location;
		}

		public void setLocation(Point2D location) {
			this.location = location;
		}

		public int getOrganizerId() {
			return organizerId;
		}

		public void setOrganizerId(int organizerId) {
			this.organizerId = organizerId;
		}

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}
		}

