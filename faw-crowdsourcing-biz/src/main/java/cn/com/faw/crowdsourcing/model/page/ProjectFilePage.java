package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.ProjectFile;

/**
 * 项目附件ORM数据分页对象(Table: FAW_PROJECT_FILE)
 */
public class ProjectFilePage extends Pagex {


	// 项目附件列表
	private List<ProjectFile> projectFileList;



	/**
	 * 获取项目附件ORM数据分页对象
	 */
	public List<ProjectFile> getProjectFileList() {
		return projectFileList;
	}

	/**
	 * 设置项目附件ORM数据分页对象
	 */
	public void setProjectFileList(List<ProjectFile> projectFileList) {
		this.projectFileList = projectFileList;
	}

}
