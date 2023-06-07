package entityLayer;

import java.sql.Date;
public class Feedback {
	private int feedbackId;
	private Date date;
	private int rating;
	private String comments;
	private int userId;

	public Feedback() {
	}

	public Feedback(Date date, int rating, String comments, int userId) {
		this.date = date;
		this.rating = rating;
		this.comments = comments;
		this.userId = userId;
	}

	public Feedback(int feedbackId, Date date, int rating, String comments, int userId) {
		this.feedbackId = feedbackId;
		this.date = date;
		this.rating = rating;
		this.comments = comments;
		this.userId = userId;
	}

	public int getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(int feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
