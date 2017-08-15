package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.MemberMessage;

/**
 * 会员消息ORM数据分页对象(Table: FAW_MEMBER_MESSAGE)
 */
public class MemberMessagePage extends Pagex {


	// 会员消息列表
	private List<MemberMessage> memberMessageList;



	/**
	 * 获取会员消息ORM数据分页对象
	 */
	public List<MemberMessage> getMemberMessageList() {
		return memberMessageList;
	}

	/**
	 * 设置会员消息ORM数据分页对象
	 */
	public void setMemberMessageList(List<MemberMessage> memberMessageList) {
		this.memberMessageList = memberMessageList;
	}

}
