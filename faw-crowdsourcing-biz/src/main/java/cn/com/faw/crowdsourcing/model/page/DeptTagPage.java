package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.DeptTag;

/**
 * 部门标签ORM数据分页对象(Table: FAW_DEPT_TAG)
 */
public class DeptTagPage extends Pagex {


	// 部门标签列表
	private List<DeptTag> deptTagList;



	/**
	 * 获取部门标签ORM数据分页对象
	 */
	public List<DeptTag> getDeptTagList() {
		return deptTagList;
	}

	/**
	 * 设置部门标签ORM数据分页对象
	 */
	public void setDeptTagList(List<DeptTag> deptTagList) {
		this.deptTagList = deptTagList;
	}

}
