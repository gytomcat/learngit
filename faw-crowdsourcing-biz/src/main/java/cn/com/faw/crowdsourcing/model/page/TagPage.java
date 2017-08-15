package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Tag;

/**
 * 标签ORM数据分页对象(Table: FAW_TAG)
 */
public class TagPage extends Pagex {


	// 标签列表
	private List<Tag> tagList;



	/**
	 * 获取标签ORM数据分页对象
	 */
	public List<Tag> getTagList() {
		return tagList;
	}

	/**
	 * 设置标签ORM数据分页对象
	 */
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

}
