package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 创意分类ORM数据对象(Table: FAW_IDEA_CATEGORY)
 */
public class IdeaCategory extends BaseModel {

	// 分类名称(Column: CATEGORY_NAME)
	private String categoryName;

	// 创意数量,默认0(Column: IDEA_COUNT)
	private Integer ideaCount;

	// 最后回复ID,关联FAW_IDEA_REPLY.ID(Column: LAST_REPLY_ID)
	private Long lastReplyId;

	/**
	 * 获取分类名称
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * 设置分类名称
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * 获取创意数量,默认0
	 */
	public Integer getIdeaCount() {
		return ideaCount;
	}

	/**
	 * 设置创意数量,默认0
	 */
	public void setIdeaCount(Integer ideaCount) {
		this.ideaCount = ideaCount;
	}

	/**
	 * 获取最后回复ID,关联FAW_IDEA_REPLY.ID
	 */
	public Long getLastReplyId() {
		return lastReplyId;
	}

	/**
	 * 设置最后回复ID,关联FAW_IDEA_REPLY.ID
	 */
	public void setLastReplyId(Long lastReplyId) {
		this.lastReplyId = lastReplyId;
	}

}
