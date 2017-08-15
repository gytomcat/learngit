package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.MemberTag;
import cn.com.faw.crowdsourcing.model.page.MemberTagPage;

/**
 * 会员标签DAO(表名: FAW_MEMBER_TAG)
 */
@Repository
public interface MemberTagDAO {

	/**
	 * 查找会员标签数量
	 * 
	 * @param page 会员标签分页对象
	 * @return 会员标签数量
	 */
	Integer selectMemberTagCount(MemberTagPage page);

	/**
	 * 查找会员标签列表
	 * 
	 * @param page 会员标签分页对象
	 * @return 会员标签列表
	 */
	List<MemberTag> selectMemberTagList(MemberTagPage page);

	/**
	 * 根据ID查找会员标签
	 * 
	 * @param id 会员标签id
	 * @return 会员标签
	 */
	MemberTag selectMemberTagById(Long id);

	/**
	 * 添加会员标签
	 * 
	 * @param memberTag 会员标签
	 */
	void insertIntoMemberTag(MemberTag memberTag);

	/**
	 * 根据ID更新会员标签
	 * 
	 * @param memberTag 会员标签
	 * @return 更新成功条数
	 */
	Integer updateMemberTagById(MemberTag memberTag);

	/**
	 * 根据ID删除会员标签(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 会员标签id
	 * @return 会员标签成功数量
	 */
	Integer updateMemberTagToDisabledById(Long id);

}
