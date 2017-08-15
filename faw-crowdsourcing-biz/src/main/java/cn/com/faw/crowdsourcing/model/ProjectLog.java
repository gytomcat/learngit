package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 项目日志ORM数据对象(Table: FAW_PROJECT_LOG)
 */
public class ProjectLog extends BaseModel {

	// 状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.(Column:
	// NOW_STATUS)
	private Integer nowStatus;

	// 项目ID,关联FAW_PROJECT.ID(Column: PROJECT_ID)
	private Long projectId;

	/**
	 * 获取状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.
	 */
	public Integer getNowStatus() {
		return nowStatus;
	}

	/**
	 * 设置状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.
	 */
	public void setNowStatus(Integer nowStatus) {
		this.nowStatus = nowStatus;
	}

	/**
	 * 获取项目ID,关联FAW_PROJECT.ID
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * 设置项目ID,关联FAW_PROJECT.ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
