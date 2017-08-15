package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.DeptTag;
import cn.com.faw.crowdsourcing.model.page.DeptTagPage;

/**
 * 部门标签DAO(表名: FAW_DEPT_TAG)
 */
@Repository
public interface DeptTagDAO {

	/**
	 * 查找部门标签数量
	 * 
	 * @param page 部门标签分页对象
	 * @return 部门标签数量
	 */
	Integer selectDeptTagCount(DeptTagPage page);

	/**
	 * 查找部门标签列表
	 * 
	 * @param page 部门标签分页对象
	 * @return 部门标签列表
	 */
	List<DeptTag> selectDeptTagList(DeptTagPage page);

	/**
	 * 根据ID查找部门标签
	 * 
	 * @param id 部门标签id
	 * @return 部门标签
	 */
	DeptTag selectDeptTagById(Long id);

	/**
	 * 添加部门标签
	 * 
	 * @param deptTag 部门标签
	 */
	void insertIntoDeptTag(DeptTag deptTag);

	/**
	 * 根据ID更新部门标签
	 * 
	 * @param deptTag 部门标签
	 * @return 更新成功条数
	 */
	Integer updateDeptTagById(DeptTag deptTag);

	/**
	 * 根据ID删除部门标签(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 部门标签id
	 * @return 部门标签成功数量
	 */
	Integer updateDeptTagToDisabledById(Long id);

}
