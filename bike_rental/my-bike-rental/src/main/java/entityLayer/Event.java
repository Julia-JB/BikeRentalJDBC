package entityLayer;

import java.awt.geom.Point2D;
	import java.time.LocalDateTime;

	public class Event {
		private int eventId;
		private String name;
		private LocalDateTime date;
		private Point2D location;
		private int organizerId;

		public Event() {
		}

		public Event(String name, LocalDateTime date, Point2D location, int organizerId) {
			this.name = name;
			this.date = date;
			this.location = location;
			this.organizerId = organizerId;
		}

		public Event(int eventId, String name, LocalDateTime date, Point2D location, int organizerId) {
			this.eventId = eventId;
			this.name = name;
			this.date = date;
			this.location = location;
			this.organizerId = organizerId;
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
	}

