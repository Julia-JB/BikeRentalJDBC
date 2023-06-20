package serviceMyBatis;

import mapper.FeedbackMapper;
import model.Feedback;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class FeedbackService {

	public void insertFeedback(Feedback feedback) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
			feedbackMapper.addFeedback(feedback);
		}
	}

	public Feedback selectFeedback(int feedbackId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
			return feedbackMapper.selectFeedbackById(feedbackId);
		}
	}

	public List<Feedback> selectAllFeedback() throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
			return feedbackMapper.selectAllFeedbacks();
		}
	}

	public void updateFeedback(Feedback feedback) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
			feedbackMapper.updateFeedback(feedback);
		}
	}

	public void deleteFeedback(int feedbackId) throws IOException {
		try (InputStream stream = Resources.getResourceAsStream("mybatis-config.xml")) {
			SqlSession session = new SqlSessionFactoryBuilder().build(stream).openSession(true);
			FeedbackMapper feedbackMapper = session.getMapper(FeedbackMapper.class);
			feedbackMapper.deleteFeedback(feedbackId);
		}
	}
}
