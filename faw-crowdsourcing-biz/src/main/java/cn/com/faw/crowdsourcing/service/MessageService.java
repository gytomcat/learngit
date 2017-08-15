package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.MessageDAO;
import cn.com.faw.crowdsourcing.model.Message;
import cn.com.faw.crowdsourcing.model.page.MessagePage;

/**
 * 消息业务逻辑
 */
@Service
public class MessageService {

	/**
	 * 消息DAO
	 */
	@Resource
	private MessageDAO messageDAO;

	/**
	 * 分页查找消息列表
	 * 
	 * @param page 消息分页对象
	 */
	public void loadMessageList(MessagePage page) {
		Integer total = messageDAO.selectMessageCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setMessageList(messageDAO.selectMessageList(page));
		}
	}

	/**
	 * 添加消息
	 * 
	 * @param message 消息
	 */
	public void addOneMessage(Message message) {
		messageDAO.insertIntoMessage(message);
	}

	/**
	 * 更新消息
	 * 
	 * @param message 消息
	 */
	public void modifyOneMessage(Message message) {
		messageDAO.updateMessageById(message);
	}

	/**
	 * 获取某一消息
	 * 
	 * @param id 消息ID
	 * @return 消息
	 */
	public Message getOneMessage(Long id) {
		return messageDAO.selectMessageById(id);
	}

	/**
	 * 删除消息(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 消息ID
	 */
	public void removeOneMessage(Long id) {
		messageDAO.updateMessageToDisabledById(id);
	}

}
