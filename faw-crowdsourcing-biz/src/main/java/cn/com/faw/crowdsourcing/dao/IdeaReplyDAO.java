package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.IdeaReply;
import cn.com.faw.crowdsourcing.model.page.IdeaReplyPage;

/**
 * 创意回复DAO(表名: FAW_IDEA_REPLY)
 */
@Repository
public interface IdeaReplyDAO {

	/**
	 * 查找创意回复数量
	 * 
	 * @param page 创意回复分页对象
	 * @return 创意回复数量
	 */
	Integer selectIdeaReplyCount(IdeaReplyPage page);

	/**
	 * 查找创意回复列表
	 * 
	 * @param page 创意回复分页对象
	 * @return 创意回复列表
	 */
	List<IdeaReply> selectIdeaReplyList(IdeaReplyPage page);

	/**
	 * 根据ID查找创意回复
	 * 
	 * @param id 创意回复id
	 * @return 创意回复
	 */
	IdeaReply selectIdeaReplyById(Long id);

	/**
	 * 添加创意回复
	 * 
	 * @param ideaReply 创意回复
	 */
	void insertIntoIdeaReply(IdeaReply ideaReply);

	/**
	 * 根据ID更新创意回复
	 * 
	 * @param ideaReply 创意回复
	 * @return 更新成功条数
	 */
	Integer updateIdeaReplyById(IdeaReply ideaReply);

	/**
	 * 根据ID删除创意回复(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 创意回复id
	 * @return 创意回复成功数量
	 */
	Integer updateIdeaReplyToDisabledById(Long id);

}
