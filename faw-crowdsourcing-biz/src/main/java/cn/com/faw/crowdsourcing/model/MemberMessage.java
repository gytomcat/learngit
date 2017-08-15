package cn.com.faw.crowdsourcing.model;

import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 会员消息ORM数据对象(Table: FAW_MEMBER_MESSAGE)
 */
public class MemberMessage extends BaseModel {

	// 消息ID,关联FAW_MESSAGE.ID(Column: MESSAGE_ID)
	private Long messageId;

	// 接收人ID,关联FAW_MEMBER.ID(Column: SENDEE_ID)
	private Long sendeeId;

	// 是否读取.Y:已读,N:未读,默认N(Column: IS_READ)
	private String isRead;

	// 读取时间(Column: READ_TIME)
	private Date readTime;

	/**
	 * 获取消息ID,关联FAW_MESSAGE.ID
	 */
	public Long getMessageId() {
		return messageId;
	}

	/**
	 * 设置消息ID,关联FAW_MESSAGE.ID
	 */
	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	/**
	 * 获取接收人ID,关联FAW_MEMBER.ID
	 */
	public Long getSendeeId() {
		return sendeeId;
	}

	/**
	 * 设置接收人ID,关联FAW_MEMBER.ID
	 */
	public void setSendeeId(Long sendeeId) {
		this.sendeeId = sendeeId;
	}

	/**
	 * 获取是否读取.Y:已读,N:未读,默认N
	 */
	public String getIsRead() {
		return isRead;
	}

	/**
	 * 设置是否读取.Y:已读,N:未读,默认N
	 */
	public void setIsRead(String isRead) {
		this.isRead = isRead;
	}

	/**
	 * 获取读取时间
	 */
	public Date getReadTime() {
		return readTime;
	}

	/**
	 * 设置读取时间
	 */
	public void setReadTime(Date readTime) {
		this.readTime = readTime;
	}

}
