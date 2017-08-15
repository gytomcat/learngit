package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 项目附件ORM数据对象(Table: FAW_PROJECT_FILE)
 */
public class ProjectFile extends BaseModel {

	// 项目ID,关联FAW_PROJECT.ID(Column: PROJECT_ID)
	private Long projectId;

	// 文件路径(Column: FILE_PATH)
	private String filePath;

	// 文件类型.1:发标文件,2:专利(Column: FILE_TYPE)
	private Integer fileType;

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
	 * 获取文件路径
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 设置文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 获取文件类型.1:发标文件,2:专利
	 */
	public Integer getFileType() {
		return fileType;
	}

	/**
	 * 设置文件类型.1:发标文件,2:专利
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

}
