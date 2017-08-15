package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Notice;

/**
 * 公告ORM数据分页对象(Table: FAW_NOTICE)
 */
public class NoticePage extends Pagex {


	// 公告列表
	private List<Notice> noticeList;



	/**
	 * 获取公告ORM数据分页对象
	 */
	public List<Notice> getNoticeList() {
		return noticeList;
	}

	/**
	 * 设置公告ORM数据分页对象
	 */
	public void setNoticeList(List<Notice> noticeList) {
		this.noticeList = noticeList;
	}

}
