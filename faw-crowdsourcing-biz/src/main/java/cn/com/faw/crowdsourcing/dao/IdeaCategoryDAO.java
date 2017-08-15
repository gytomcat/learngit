package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.IdeaCategory;
import cn.com.faw.crowdsourcing.model.page.IdeaCategoryPage;

/**
 * 创意分类DAO(表名: FAW_IDEA_CATEGORY)
 */
@Repository
public interface IdeaCategoryDAO {

	/**
	 * 查找创意分类数量
	 * 
	 * @param page 创意分类分页对象
	 * @return 创意分类数量
	 */
	Integer selectIdeaCategoryCount(IdeaCategoryPage page);

	/**
	 * 查找创意分类列表
	 * 
	 * @param page 创意分类分页对象
	 * @return 创意分类列表
	 */
	List<IdeaCategory> selectIdeaCategoryList(IdeaCategoryPage page);

	/**
	 * 根据ID查找创意分类
	 * 
	 * @param id 创意分类id
	 * @return 创意分类
	 */
	IdeaCategory selectIdeaCategoryById(Long id);

	/**
	 * 添加创意分类
	 * 
	 * @param ideaCategory 创意分类
	 */
	void insertIntoIdeaCategory(IdeaCategory ideaCategory);

	/**
	 * 根据ID更新创意分类
	 * 
	 * @param ideaCategory 创意分类
	 * @return 更新成功条数
	 */
	Integer updateIdeaCategoryById(IdeaCategory ideaCategory);

	/**
	 * 根据ID删除创意分类(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 创意分类id
	 * @return 创意分类成功数量
	 */
	Integer updateIdeaCategoryToDisabledById(Long id);

}
