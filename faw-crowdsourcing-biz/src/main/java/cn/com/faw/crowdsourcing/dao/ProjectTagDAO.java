package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.ProjectTag;
import cn.com.faw.crowdsourcing.model.page.ProjectTagPage;

/**
 * 项目标签DAO(表名: FAW_PROJECT_TAG)
 */
@Repository
public interface ProjectTagDAO {

	/**
	 * 查找项目标签数量
	 * 
	 * @param page 项目标签分页对象
	 * @return 项目标签数量
	 */
	Integer selectProjectTagCount(ProjectTagPage page);

	/**
	 * 查找项目标签列表
	 * 
	 * @param page 项目标签分页对象
	 * @return 项目标签列表
	 */
	List<ProjectTag> selectProjectTagList(ProjectTagPage page);

	/**
	 * 根据ID查找项目标签
	 * 
	 * @param id 项目标签id
	 * @return 项目标签
	 */
	ProjectTag selectProjectTagById(Long id);

	/**
	 * 添加项目标签
	 * 
	 * @param projectTag 项目标签
	 */
	void insertIntoProjectTag(ProjectTag projectTag);

	/**
	 * 根据ID更新项目标签
	 * 
	 * @param projectTag 项目标签
	 * @return 更新成功条数
	 */
	Integer updateProjectTagById(ProjectTag projectTag);

	/**
	 * 根据ID删除项目标签(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 项目标签id
	 * @return 项目标签成功数量
	 */
	Integer updateProjectTagToDisabledById(Long id);

}
