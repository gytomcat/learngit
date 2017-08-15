package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.IdeaCategory;

/**
 * 创意分类ORM数据分页对象(Table: FAW_IDEA_CATEGORY)
 */
public class IdeaCategoryPage extends Pagex {


	// 创意分类列表
	private List<IdeaCategory> ideaCategoryList;



	/**
	 * 获取创意分类ORM数据分页对象
	 */
	public List<IdeaCategory> getIdeaCategoryList() {
		return ideaCategoryList;
	}

	/**
	 * 设置创意分类ORM数据分页对象
	 */
	public void setIdeaCategoryList(List<IdeaCategory> ideaCategoryList) {
		this.ideaCategoryList = ideaCategoryList;
	}

}
