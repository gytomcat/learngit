package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Idea;
import cn.com.faw.crowdsourcing.model.page.IdeaPage;

/**
 * DAO(表名: FAW_IDEA)
 */
@Repository
public interface IdeaDAO {

	/**
	 * 查找数量
	 * 
	 * @param page 分页对象
	 * @return 数量
	 */
	Integer selectIdeaCount(IdeaPage page);

	/**
	 * 查找列表
	 * 
	 * @param page 分页对象
	 * @return 列表
	 */
	List<Idea> selectIdeaList(IdeaPage page);

	/**
	 * 根据ID查找
	 * 
	 * @param id id
	 * @return 
	 */
	Idea selectIdeaById(Long id);

	/**
	 * 添加
	 * 
	 * @param idea 
	 */
	void insertIntoIdea(Idea idea);

	/**
	 * 根据ID更新
	 * 
	 * @param idea 
	 * @return 更新成功条数
	 */
	Integer updateIdeaById(Idea idea);

	/**
	 * 根据ID删除(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id id
	 * @return 成功数量
	 */
	Integer updateIdeaToDisabledById(Long id);

}
