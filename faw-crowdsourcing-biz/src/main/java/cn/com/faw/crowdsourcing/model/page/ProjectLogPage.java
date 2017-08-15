package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.ProjectLog;

/**
 * 项目日志ORM数据分页对象(Table: FAW_PROJECT_LOG)
 */
public class ProjectLogPage extends Pagex {


	// 项目日志列表
	private List<ProjectLog> projectLogList;



	/**
	 * 获取项目日志ORM数据分页对象
	 */
	public List<ProjectLog> getProjectLogList() {
		return projectLogList;
	}

	/**
	 * 设置项目日志ORM数据分页对象
	 */
	public void setProjectLogList(List<ProjectLog> projectLogList) {
		this.projectLogList = projectLogList;
	}

}
