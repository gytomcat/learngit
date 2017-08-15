package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 部门标签ORM数据对象(Table: FAW_DEPT_TAG)
 */
public class DeptTag extends BaseModel {

	// 部门ID,关联FAW_DEPT.ID(Column: DEPT_ID)
	private Long deptId;

	// 标签ID,关联FAW_TAG.ID(Column: TAG_ID)
	private Long tagId;

	// 权重,默认1(Column: WEIGHT)
	private Integer weight;

	/**
	 * 获取部门ID,关联FAW_DEPT.ID
	 */
	public Long getDeptId() {
		return deptId;
	}

	/**
	 * 设置部门ID,关联FAW_DEPT.ID
	 */
	public void setDeptId(Long deptId) {
		this.deptId = deptId;
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

	/**
	 * 获取权重,默认1
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * 设置权重,默认1
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
