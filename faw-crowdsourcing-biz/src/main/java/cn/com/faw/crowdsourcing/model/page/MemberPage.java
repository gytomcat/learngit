package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Member;

/**
 * 会员ORM数据分页对象(Table: FAW_MEMBER)
 */
public class MemberPage extends Pagex {


	// 会员列表
	private List<Member> memberList;



	/**
	 * 获取会员ORM数据分页对象
	 */
	public List<Member> getMemberList() {
		return memberList;
	}

	/**
	 * 设置会员ORM数据分页对象
	 */
	public void setMemberList(List<Member> memberList) {
		this.memberList = memberList;
	}

}
