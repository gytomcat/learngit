package cn.com.faw.crowdsourcing.model;

import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * ORM数据对象(Table: FAW_IDEA)
 */
public class Idea extends BaseModel {

	// 发布人ID,关联FAW_MEMBER.ID(Column: RELEASE_ID)
	private Long releaseId;
	
	// 发布时间(Column: RELEASE_TIME)
	private Date releaseTime;
	
	// 标题(Column: IDEA_TITLE)
	private String ideaTitle;
	
	// 描述(Column: IDEA_DESC)
	private String ideaDesc;
	
	// 分类ID,关联FAW_CATEGORY.ID(Column: CATEGORY_ID)
	private Long categoryId;
	
	// 浏览人数,默认0(Column: VIEW_COUNT)
	private Integer viewCount;
	
	// 回复人数,默认0(Column: REPLY_COUNT)
	private Integer replyCount;
	
	// 最新回复人ID,关联FAW_IEAD_REPLY.ID,无回复为-1(Column: LAST_REPLY_ID)
	private Long lastReplyId;
	
	private String lastReplyContent;
	
	// 系统推荐分数(Column: SYSTEM_SCORE)
	private Integer systemScore;
	
	// 评审人ID,关联FAW_MEMBER.ID,无评审人为-1(Column: REVIEWER_ID)
	private Long reviewerId;
	
	// 评审时间(Column: REVIEW_TIME)
	private Date reviewTime;
	
	// 评审分数(Column: REVIEW_SCORE)
	private Integer reviewScore;
	
	// 评审意见(Column: REVIEW_DESC)
	private String reviewDesc;
	
	// 是否是创意,Y:是,N:否,默认N(Column: IS_IDEA)
	private String isIdea;
	
	
	/**
	 * 获取发布人ID,关联FAW_MEMBER.ID
	 */
	public Long getReleaseId() {
		return releaseId;
	}

	/**
	 * 设置发布人ID,关联FAW_MEMBER.ID
	 */
	public void setReleaseId(Long releaseId) {
		this.releaseId = releaseId;
	}
	
	/**
	 * 获取发布时间
	 */
	public Date getReleaseTime() {
		return releaseTime;
	}

	/**
	 * 设置发布时间
	 */
	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
	
	/**
	 * 获取标题
	 */
	public String getIdeaTitle() {
		return ideaTitle;
	}

	/**
	 * 设置标题
	 */
	public void setIdeaTitle(String ideaTitle) {
		this.ideaTitle = ideaTitle;
	}
	
	/**
	 * 获取描述
	 */
	public String getIdeaDesc() {
		return ideaDesc;
	}

	/**
	 * 设置描述
	 */
	public void setIdeaDesc(String ideaDesc) {
		this.ideaDesc = ideaDesc;
	}
	
	/**
	 * 获取分类ID,关联FAW_CATEGORY.ID
	 */
	public Long getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置分类ID,关联FAW_CATEGORY.ID
	 */
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	/**
	 * 获取浏览人数,默认0
	 */
	public Integer getViewCount() {
		return viewCount;
	}

	/**
	 * 设置浏览人数,默认0
	 */
	public void setViewCount(Integer viewCount) {
		this.viewCount = viewCount;
	}
	
	/**
	 * 获取回复人数,默认0
	 */
	public Integer getReplyCount() {
		return replyCount;
	}

	/**
	 * 设置回复人数,默认0
	 */
	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}
	
	/**
	 * 获取最新回复人ID,关联FAW_IEAD_REPLY.ID,无回复为-1
	 */
	public Long getLastReplyId() {
		return lastReplyId;
	}

	/**
	 * 设置最新回复人ID,关联FAW_IEAD_REPLY.ID,无回复为-1
	 */
	public void setLastReplyId(Long lastReplyId) {
		this.lastReplyId = lastReplyId;
	}
	
	/**
	 * 获取系统推荐分数
	 */
	public Integer getSystemScore() {
		return systemScore;
	}

	/**
	 * 设置系统推荐分数
	 */
	public void setSystemScore(Integer systemScore) {
		this.systemScore = systemScore;
	}
	
	/**
	 * 获取评审人ID,关联FAW_MEMBER.ID,无评审人为-1
	 */
	public Long getReviewerId() {
		return reviewerId;
	}

	/**
	 * 设置评审人ID,关联FAW_MEMBER.ID,无评审人为-1
	 */
	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}
	
	/**
	 * 获取评审时间
	 */
	public Date getReviewTime() {
		return reviewTime;
	}

	/**
	 * 设置评审时间
	 */
	public void setReviewTime(Date reviewTime) {
		this.reviewTime = reviewTime;
	}
	
	/**
	 * 获取评审分数
	 */
	public Integer getReviewScore() {
		return reviewScore;
	}

	/**
	 * 设置评审分数
	 */
	public void setReviewScore(Integer reviewScore) {
		this.reviewScore = reviewScore;
	}
	
	/**
	 * 获取评审意见
	 */
	public String getReviewDesc() {
		return reviewDesc;
	}

	/**
	 * 设置评审意见
	 */
	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}
	
	/**
	 * 获取是否是创意,Y:是,N:否,默认N
	 */
	public String getIsIdea() {
		return isIdea;
	}

	/**
	 * 设置是否是创意,Y:是,N:否,默认N
	 */
	public void setIsIdea(String isIdea) {
		this.isIdea = isIdea;
	}
	
	public String getLastReplyContent() {
		return lastReplyContent;
	}

	public void setLastReplyContent(String lastReplyContent) {
		this.lastReplyContent = lastReplyContent;
	}
}
