package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Feedback;

/**
 * 反馈ORM数据分页对象(Table: FAW_FEEDBACK)
 */
public class FeedbackPage extends Pagex {


	// 反馈列表
	private List<Feedback> feedbackList;



	/**
	 * 获取反馈ORM数据分页对象
	 */
	public List<Feedback> getFeedbackList() {
		return feedbackList;
	}

	/**
	 * 设置反馈ORM数据分页对象
	 */
	public void setFeedbackList(List<Feedback> feedbackList) {
		this.feedbackList = feedbackList;
	}

}
