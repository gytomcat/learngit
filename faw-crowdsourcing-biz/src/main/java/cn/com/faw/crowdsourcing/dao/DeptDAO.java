package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Dept;
import cn.com.faw.crowdsourcing.model.page.DeptPage;

/**
 * 部门DAO(表名: FAW_DEPT)
 */
@Repository
public interface DeptDAO {

	/**
	 * 查找部门数量
	 * 
	 * @param page 部门分页对象
	 * @return 部门数量
	 */
	Integer selectDeptCount(DeptPage page);

	/**
	 * 查找部门列表
	 * 
	 * @param page 部门分页对象
	 * @return 部门列表
	 */
	List<Dept> selectDeptList(DeptPage page);

	/**
	 * 根据ID查找部门
	 * 
	 * @param id 部门id
	 * @return 部门
	 */
	Dept selectDeptById(Long id);

	/**
	 * 添加部门
	 * 
	 * @param dept 部门
	 */
	void insertIntoDept(Dept dept);

	
	/**
	 * 根据ID更新部门
	 * 
	 * @param dept 部门
	 * @return 更新成功条数
	 */
	Integer updateDeptById(Dept dept);

	/**
	 * 根据ID删除部门(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 部门id
	 * @return 部门成功数量
	 */
	Integer updateDeptToDisabledById(Long id);
	/**
	 * 查找部门列表
	 * 根据部门名称，企业ID，上级部门查询数据
	 * @param page 部门分页对象
	 * @return 部门列表
	 */
	List<Dept> selectDept(Dept dept);

}
