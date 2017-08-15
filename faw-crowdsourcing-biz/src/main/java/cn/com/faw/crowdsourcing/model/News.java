package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 新闻ORM数据对象(Table: FAW_NEWS)
 */
public class News extends BaseModel {

	// 新闻分类.1:普通,默认1(Column: NEWS_CATEGORY)
	private Integer newsCategory;

	// 新闻标题(Column: NEWS_TITLE)
	private String newsTitle;

	// 新闻内容(Column: NEWS_DESC)
	private String newsDesc;

	// 是否置顶,Y:置顶,N:不置顶,默认N(Column: IS_TOP)
	private String isTop;

	/**
	 * 获取新闻分类.1:普通,默认1
	 */
	public Integer getNewsCategory() {
		return newsCategory;
	}

	/**
	 * 设置新闻分类.1:普通,默认1
	 */
	public void setNewsCategory(Integer newsCategory) {
		this.newsCategory = newsCategory;
	}

	/**
	 * 获取新闻标题
	 */
	public String getNewsTitle() {
		return newsTitle;
	}

	/**
	 * 设置新闻标题
	 */
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}

	/**
	 * 获取新闻内容
	 */
	public String getNewsDesc() {
		return newsDesc;
	}

	/**
	 * 设置新闻内容
	 */
	public void setNewsDesc(String newsDesc) {
		this.newsDesc = newsDesc;
	}

	/**
	 * 获取是否置顶,Y:置顶,N:不置顶,默认N
	 */
	public String getIsTop() {
		return isTop;
	}

	/**
	 * 设置是否置顶,Y:置顶,N:不置顶,默认N
	 */
	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

}
