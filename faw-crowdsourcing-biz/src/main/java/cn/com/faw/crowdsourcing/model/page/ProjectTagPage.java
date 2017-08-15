package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.ProjectTag;

/**
 * 项目标签ORM数据分页对象(Table: FAW_PROJECT_TAG)
 */
public class ProjectTagPage extends Pagex {


	// 项目标签列表
	private List<ProjectTag> projectTagList;



	/**
	 * 获取项目标签ORM数据分页对象
	 */
	public List<ProjectTag> getProjectTagList() {
		return projectTagList;
	}

	/**
	 * 设置项目标签ORM数据分页对象
	 */
	public void setProjectTagList(List<ProjectTag> projectTagList) {
		this.projectTagList = projectTagList;
	}

}
