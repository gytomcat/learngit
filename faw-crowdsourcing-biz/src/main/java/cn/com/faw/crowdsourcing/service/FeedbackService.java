package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.FeedbackDAO;
import cn.com.faw.crowdsourcing.model.Feedback;
import cn.com.faw.crowdsourcing.model.page.FeedbackPage;

/**
 * 反馈业务逻辑
 */
@Service
public class FeedbackService {

	/**
	 * 反馈DAO
	 */
	@Resource
	private FeedbackDAO feedbackDAO;

	/**
	 * 分页查找反馈列表
	 * 
	 * @param page 反馈分页对象
	 */
	public void loadFeedbackList(FeedbackPage page) {
		Integer total = feedbackDAO.selectFeedbackCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setFeedbackList(feedbackDAO.selectFeedbackList(page));
		}
	}

	/**
	 * 添加反馈
	 * 
	 * @param feedback 反馈
	 */
	public void addOneFeedback(Feedback feedback) {
		feedbackDAO.insertIntoFeedback(feedback);
	}

	/**
	 * 更新反馈
	 * 
	 * @param feedback 反馈
	 */
	public void modifyOneFeedback(Feedback feedback) {
		feedbackDAO.updateFeedbackById(feedback);
	}

	/**
	 * 获取某一反馈
	 * 
	 * @param id 反馈ID
	 * @return 反馈
	 */
	public Feedback getOneFeedback(Long id) {
		return feedbackDAO.selectFeedbackById(id);
	}

	/**
	 * 删除反馈(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 反馈ID
	 */
	public void removeOneFeedback(Long id) {
		feedbackDAO.updateFeedbackToDisabledById(id);
	}

}
