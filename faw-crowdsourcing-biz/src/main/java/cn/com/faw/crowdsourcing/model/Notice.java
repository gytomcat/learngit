package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 公告ORM数据对象(Table: FAW_NOTICE)
 */
public class Notice extends BaseModel {

	// 通知标题(Column: NOTICE_TITLE)
	private String noticeTitle;

	// 通知内容(Column: NOTICE_DESC)
	private String noticeDesc;

	// 通知类型.1.通知,默认1(Column: NOTICE_TYPE)
	private Integer noticeType;

	/**
	 * 获取通知标题
	 */
	public String getNoticeTitle() {
		return noticeTitle;
	}

	/**
	 * 设置通知标题
	 */
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	/**
	 * 获取通知内容
	 */
	public String getNoticeDesc() {
		return noticeDesc;
	}

	/**
	 * 设置通知内容
	 */
	public void setNoticeDesc(String noticeDesc) {
		this.noticeDesc = noticeDesc;
	}

	/**
	 * 获取通知类型.1.通知,默认1
	 */
	public Integer getNoticeType() {
		return noticeType;
	}

	/**
	 * 设置通知类型.1.通知,默认1
	 */
	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

}
