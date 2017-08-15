package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.MemberTag;

/**
 * 会员标签ORM数据分页对象(Table: FAW_MEMBER_TAG)
 */
public class MemberTagPage extends Pagex {


	// 会员标签列表
	private List<MemberTag> memberTagList;



	/**
	 * 获取会员标签ORM数据分页对象
	 */
	public List<MemberTag> getMemberTagList() {
		return memberTagList;
	}

	/**
	 * 设置会员标签ORM数据分页对象
	 */
	public void setMemberTagList(List<MemberTag> memberTagList) {
		this.memberTagList = memberTagList;
	}

}
