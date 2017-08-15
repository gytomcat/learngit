package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 项目标签ORM数据对象(Table: FAW_PROJECT_TAG)
 */
public class ProjectTag extends BaseModel {

	// 项目ID,关联FAW_PROJECT.ID(Column: ID)
	private Long projectId;

	// 标签ID,关联FAW_TAG.ID(Column: TAG_ID)
	private Long tagId;

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

	/**
	 * 获取标签ID,关联FAW_TAG.ID
	 */
	public Long getTagId() {
		return tagId;
	}

	/**
	 * 设置标签ID,关联FAW_TAG.ID
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

}
