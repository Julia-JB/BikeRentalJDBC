package mapper;

import model.Feedback;
import model.User;

import java.util.List;

public interface FeedbackMapper {
	void addFeedback(Feedback feedback);
	Feedback selectFeedbackById(int id);
	List<Feedback> selectAllFeedbacks();
	void updateFeedback(Feedback feedback);
	void deleteFeedback(int id);
}
