package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.IdeaReply;

/**
 * 创意回复ORM数据分页对象(Table: FAW_IDEA_REPLY)
 */
public class IdeaReplyPage extends Pagex {

	public Long ideaId;
	
	public IdeaReplyPage(Long ideaId){
		this.ideaId = ideaId;
	}
	// 创意回复列表
	private List<IdeaReply> ideaReplyList;



	/**
	 * 获取创意回复ORM数据分页对象
	 */
	public List<IdeaReply> getIdeaReplyList() {
		return ideaReplyList;
	}

	/**
	 * 设置创意回复ORM数据分页对象
	 */
	public void setIdeaReplyList(List<IdeaReply> ideaReplyList) {
		this.ideaReplyList = ideaReplyList;
	}

}
