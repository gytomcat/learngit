package cn.com.faw.crowdsourcing.model;

import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 反馈ORM数据对象(Table: FAW_FEEDBACK)
 */
public class Feedback extends BaseModel {

	// 反馈人ID,关联FAW_MEMBER.ID(Column: FEEDBACK_ID)
	private Long feedbackId;

	// 反馈分类.1:系统错误,2::咨询(Column: FEEDBACK_TYPE)
	private Integer feedbackType;

	// 反馈标题(Column: FEEDBACK_TITLE)
	private String feedbackTitle;

	// 反馈内容(Column: FEEDBACK_DESC)
	private String feedbackDesc;

	// 是否回复.Y:已回复.N:未回复,默认N(Column: IS_REPLY)
	private String isReply;

	// 回复时间(Column: REPLY_TIME)
	private Date replyTime;

	/**
	 * 获取反馈人ID,关联FAW_MEMBER.ID
	 */
	public Long getFeedbackId() {
		return feedbackId;
	}

	/**
	 * 设置反馈人ID,关联FAW_MEMBER.ID
	 */
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	/**
	 * 获取反馈分类.1:系统错误,2::咨询
	 */
	public Integer getFeedbackType() {
		return feedbackType;
	}

	/**
	 * 设置反馈分类.1:系统错误,2::咨询
	 */
	public void setFeedbackType(Integer feedbackType) {
		this.feedbackType = feedbackType;
	}

	/**
	 * 获取反馈标题
	 */
	public String getFeedbackTitle() {
		return feedbackTitle;
	}

	/**
	 * 设置反馈标题
	 */
	public void setFeedbackTitle(String feedbackTitle) {
		this.feedbackTitle = feedbackTitle;
	}

	/**
	 * 获取反馈内容
	 */
	public String getFeedbackDesc() {
		return feedbackDesc;
	}

	/**
	 * 设置反馈内容
	 */
	public void setFeedbackDesc(String feedbackDesc) {
		this.feedbackDesc = feedbackDesc;
	}

	/**
	 * 获取是否回复.Y:已回复.N:未回复,默认N
	 */
	public String getIsReply() {
		return isReply;
	}

	/**
	 * 设置是否回复.Y:已回复.N:未回复,默认N
	 */
	public void setIsReply(String isReply) {
		this.isReply = isReply;
	}

	/**
	 * 获取回复时间
	 */
	public Date getReplyTime() {
		return replyTime;
	}

	/**
	 * 设置回复时间
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

}
