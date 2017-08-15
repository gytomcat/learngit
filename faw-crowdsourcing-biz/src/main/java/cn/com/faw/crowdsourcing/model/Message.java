package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 消息ORM数据对象(Table: FAW_MESSAGE)
 */
public class Message extends BaseModel {

	// 发送人ID,关联FAW_MEMBER.ID,系统发送为-1(Column: SENDER_ID)
	private Long senderId;

	// 消息标题(Column: MSG_TITLE)
	private String msgTitle;

	// 消息内容(Column: MSG_DESC)
	private String msgDesc;

	// 消息类型,1.系统消息,2.站内信(Column: MSG_TYPE)
	private Integer msgType;

	// 消息类别.1:系统消息,2.招投标,3.活动,4.论坛(Column: MSG_CATEGORY)
	private Integer msgCategory;

	/**
	 * 获取发送人ID,关联FAW_MEMBER.ID,系统发送为-1
	 */
	public Long getSenderId() {
		return senderId;
	}

	/**
	 * 设置发送人ID,关联FAW_MEMBER.ID,系统发送为-1
	 */
	public void setSenderId(Long senderId) {
		this.senderId = senderId;
	}

	/**
	 * 获取消息标题
	 */
	public String getMsgTitle() {
		return msgTitle;
	}

	/**
	 * 设置消息标题
	 */
	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	/**
	 * 获取消息内容
	 */
	public String getMsgDesc() {
		return msgDesc;
	}

	/**
	 * 设置消息内容
	 */
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	/**
	 * 获取消息类型,1.系统消息,2.站内信
	 */
	public Integer getMsgType() {
		return msgType;
	}

	/**
	 * 设置消息类型,1.系统消息,2.站内信
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
	}

	/**
	 * 获取消息类别.1:系统消息,2.招投标,3.活动,4.论坛
	 */
	public Integer getMsgCategory() {
		return msgCategory;
	}

	/**
	 * 设置消息类别.1:系统消息,2.招投标,3.活动,4.论坛
	 */
	public void setMsgCategory(Integer msgCategory) {
		this.msgCategory = msgCategory;
	}

}
