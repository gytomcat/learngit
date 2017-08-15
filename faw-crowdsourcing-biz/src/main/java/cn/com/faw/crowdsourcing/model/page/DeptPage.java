package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Dept;

/**
 * 部门ORM数据分页对象(Table: FAW_DEPT)
 */
public class DeptPage extends Pagex {


	// 部门列表
	private List<Dept> deptList;



	/**
	 * 获取部门ORM数据分页对象
	 */
	public List<Dept> getDeptList() {
		return deptList;
	}

	/**
	 * 设置部门ORM数据分页对象
	 */
	public void setDeptList(List<Dept> deptList) {
		this.deptList = deptList;
	}

}
