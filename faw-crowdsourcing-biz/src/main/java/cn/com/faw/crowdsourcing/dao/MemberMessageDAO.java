package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.MemberMessage;
import cn.com.faw.crowdsourcing.model.page.MemberMessagePage;

/**
 * 会员消息DAO(表名: FAW_MEMBER_MESSAGE)
 */
@Repository
public interface MemberMessageDAO {

	/**
	 * 查找会员消息数量
	 * 
	 * @param page 会员消息分页对象
	 * @return 会员消息数量
	 */
	Integer selectMemberMessageCount(MemberMessagePage page);

	/**
	 * 查找会员消息列表
	 * 
	 * @param page 会员消息分页对象
	 * @return 会员消息列表
	 */
	List<MemberMessage> selectMemberMessageList(MemberMessagePage page);

	/**
	 * 根据ID查找会员消息
	 * 
	 * @param id 会员消息id
	 * @return 会员消息
	 */
	MemberMessage selectMemberMessageById(Long id);

	/**
	 * 添加会员消息
	 * 
	 * @param memberMessage 会员消息
	 */
	void insertIntoMemberMessage(MemberMessage memberMessage);

	/**
	 * 根据ID更新会员消息
	 * 
	 * @param memberMessage 会员消息
	 * @return 更新成功条数
	 */
	Integer updateMemberMessageById(MemberMessage memberMessage);

	/**
	 * 根据ID删除会员消息(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 会员消息id
	 * @return 会员消息成功数量
	 */
	Integer updateMemberMessageToDisabledById(Long id);

}
