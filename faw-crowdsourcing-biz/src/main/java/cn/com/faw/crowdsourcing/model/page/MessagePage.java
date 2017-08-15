package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Message;

/**
 * 消息ORM数据分页对象(Table: FAW_MESSAGE)
 */
public class MessagePage extends Pagex {


	// 消息列表
	private List<Message> messageList;



	/**
	 * 获取消息ORM数据分页对象
	 */
	public List<Message> getMessageList() {
		return messageList;
	}

	/**
	 * 设置消息ORM数据分页对象
	 */
	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

}
