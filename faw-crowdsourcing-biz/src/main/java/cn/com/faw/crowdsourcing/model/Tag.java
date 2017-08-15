package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 标签ORM数据对象(Table: FAW_TAG)
 */
public class Tag extends BaseModel {

	// 标签名称(Column: TAG_NAME)
	private String tagName;

	// 标签描述(Column: TAG_DESC)
	private String tagDesc;

	/**
	 * 获取标签名称
	 */
	public String getTagName() {
		return tagName;
	}

	/**
	 * 设置标签名称
	 */
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	/**
	 * 获取标签描述
	 */
	public String getTagDesc() {
		return tagDesc;
	}

	/**
	 * 设置标签描述
	 */
	public void setTagDesc(String tagDesc) {
		this.tagDesc = tagDesc;
	}

}
