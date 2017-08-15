package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 会员标签ORM数据对象(Table: FAW_MEMBER_TAG)
 */
public class MemberTag extends BaseModel {

	// 用户ID,关联FAW_MEMBER.ID(Column: MEMBER_ID)
	private Long memberId;

	// 标签ID,关联FAW_TAG.ID(Column: TAG_ID)
	private Long tagId;

	// 权重,默认1(Column: WEIGHT)
	private Integer weight;

	/**
	 * 获取用户ID,关联FAW_MEMBER.ID
	 */
	public Long getMemberId() {
		return memberId;
	}

	/**
	 * 设置用户ID,关联FAW_MEMBER.ID
	 */
	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	/**
	 * 获取标签ID,关联FAW_TAG.ID
	 */
	public Long getTagId() {
		return tagId;
	}

	/**
	 * 设置标签ID,关联FAW_TAG.ID
	 */
	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	/**
	 * 获取权重,默认1
	 */
	public Integer getWeight() {
		return weight;
	}

	/**
	 * 设置权重,默认1
	 */
	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
