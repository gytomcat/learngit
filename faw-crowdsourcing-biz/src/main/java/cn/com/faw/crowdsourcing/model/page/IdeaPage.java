package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Idea;

/**
 * ORM数据分页对象(Table: FAW_IDEA)
 */
public class IdeaPage extends Pagex {

	public Long categoryId;

	// 列表
	private List<Idea> ideaList;



	/**
	 * 获取ORM数据分页对象
	 */
	public List<Idea> getIdeaList() {
		return ideaList;
	}

	/**
	 * 设置ORM数据分页对象
	 */
	public void setIdeaList(List<Idea> ideaList) {
		this.ideaList = ideaList;
	}

}
