package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Message;
import cn.com.faw.crowdsourcing.model.page.MessagePage;

/**
 * 消息DAO(表名: FAW_MESSAGE)
 */
@Repository
public interface MessageDAO {

	/**
	 * 查找消息数量
	 * 
	 * @param page 消息分页对象
	 * @return 消息数量
	 */
	Integer selectMessageCount(MessagePage page);

	/**
	 * 查找消息列表
	 * 
	 * @param page 消息分页对象
	 * @return 消息列表
	 */
	List<Message> selectMessageList(MessagePage page);

	/**
	 * 根据ID查找消息
	 * 
	 * @param id 消息id
	 * @return 消息
	 */
	Message selectMessageById(Long id);

	/**
	 * 添加消息
	 * 
	 * @param message 消息
	 */
	void insertIntoMessage(Message message);

	/**
	 * 根据ID更新消息
	 * 
	 * @param message 消息
	 * @return 更新成功条数
	 */
	Integer updateMessageById(Message message);

	/**
	 * 根据ID删除消息(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 消息id
	 * @return 消息成功数量
	 */
	Integer updateMessageToDisabledById(Long id);

}
