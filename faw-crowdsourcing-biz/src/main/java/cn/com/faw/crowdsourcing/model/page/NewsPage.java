package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.News;

/**
 * 新闻ORM数据分页对象(Table: FAW_NEWS)
 */
public class NewsPage extends Pagex {


	// 新闻列表
	private List<News> newsList;



	/**
	 * 获取新闻ORM数据分页对象
	 */
	public List<News> getNewsList() {
		return newsList;
	}

	/**
	 * 设置新闻ORM数据分页对象
	 */
	public void setNewsList(List<News> newsList) {
		this.newsList = newsList;
	}

}
