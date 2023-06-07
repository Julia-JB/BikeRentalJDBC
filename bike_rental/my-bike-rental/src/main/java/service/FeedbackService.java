package service;

import dao.FeedbackDAO;
import model.Feedback;

import java.util.List;

public class FeedbackService {
	private FeedbackDAO feedbackDAO;

	public FeedbackService() {
		feedbackDAO = new FeedbackDAO();
	}

	public void insertFeedback(Feedback feedback) {
		feedbackDAO.save(feedback);
	}

	public Feedback selectFeedback(int feedbackId) {
		return feedbackDAO.getById(feedbackId);
	}

	public List<Feedback> selectAllFeedback() {
		return feedbackDAO.getAll();
	}

	public void updateFeedback(Feedback feedback) {
		feedbackDAO.update(feedback);
	}

	public void deleteFeedback(int feedbackId) {
		feedbackDAO.delete(feedbackId);
	}
}
