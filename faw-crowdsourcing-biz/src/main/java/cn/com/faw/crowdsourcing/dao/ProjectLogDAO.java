package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.ProjectLog;
import cn.com.faw.crowdsourcing.model.page.ProjectLogPage;

/**
 * 项目日志DAO(表名: FAW_PROJECT_LOG)
 */
@Repository
public interface ProjectLogDAO {

	/**
	 * 查找项目日志数量
	 * 
	 * @param page 项目日志分页对象
	 * @return 项目日志数量
	 */
	Integer selectProjectLogCount(ProjectLogPage page);

	/**
	 * 查找项目日志列表
	 * 
	 * @param page 项目日志分页对象
	 * @return 项目日志列表
	 */
	List<ProjectLog> selectProjectLogList(ProjectLogPage page);

	/**
	 * 根据ID查找项目日志
	 * 
	 * @param id 项目日志id
	 * @return 项目日志
	 */
	ProjectLog selectProjectLogById(Long id);

	/**
	 * 添加项目日志
	 * 
	 * @param projectLog 项目日志
	 */
	void insertIntoProjectLog(ProjectLog projectLog);

	/**
	 * 根据ID更新项目日志
	 * 
	 * @param projectLog 项目日志
	 * @return 更新成功条数
	 */
	Integer updateProjectLogById(ProjectLog projectLog);

	/**
	 * 根据ID删除项目日志(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 项目日志id
	 * @return 项目日志成功数量
	 */
	Integer updateProjectLogToDisabledById(Long id);

}
