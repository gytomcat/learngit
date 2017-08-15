package cn.com.faw.crowdsourcing.model;

import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 创意回复ORM数据对象(Table: FAW_IDEA_REPLY)
 */
public class IdeaReply extends BaseModel {

	// 创意ID,关联FAW_IDEA.ID(Column: IDEA_ID)
	private Long ideaId;

	// 回复人ID,关联FAW_MEMBER.ID(Column: REPLYER_ID)
	private Long replyerId;

	// 回复人角色. C:普通会员,M:楼主,P:专家,默认C(Column: REPLYER_ROLE)
	private String replyerRole;

	// 回复内容(Column: REPLY_DESC)
	private String replyDesc;

	// 回复时间(Column: REPLY_TIME)
	private Date replyTime;

	/**
	 * 获取创意ID,关联FAW_IDEA.ID
	 */
	public Long getIdeaId() {
		return ideaId;
	}

	/**
	 * 设置创意ID,关联FAW_IDEA.ID
	 */
	public void setIdeaId(Long ideaId) {
		this.ideaId = ideaId;
	}

	/**
	 * 获取回复人ID,关联FAW_MEMBER.ID
	 */
	public Long getReplyerId() {
		return replyerId;
	}

	/**
	 * 设置回复人ID,关联FAW_MEMBER.ID
	 */
	public void setReplyerId(Long replyerId) {
		this.replyerId = replyerId;
	}

	/**
	 * 获取回复人角色. C:普通会员,M:楼主,P:专家,默认C
	 */
	public String getReplyerRole() {
		return replyerRole;
	}

	/**
	 * 设置回复人角色. C:普通会员,M:楼主,P:专家,默认C
	 */
	public void setReplyerRole(String replyerRole) {
		this.replyerRole = replyerRole;
	}

	/**
	 * 获取回复内容
	 */
	public String getReplyDesc() {
		return replyDesc;
	}

	/**
	 * 设置回复内容
	 */
	public void setReplyDesc(String replyDesc) {
		this.replyDesc = replyDesc;
	}

	/**
	 * 获取回复时间
	 */
	public Date getReplyTime() {
		return replyTime;
	}

	/**
	 * 设置回复时间
	 */
	public void setReplyTime(Date replyTime) {
		this.replyTime = replyTime;
	}

}
