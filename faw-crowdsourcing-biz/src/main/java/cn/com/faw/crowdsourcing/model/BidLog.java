package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 投标日志ORM数据对象(Table: FAW_BID_LOG)
 */
public class BidLog extends BaseModel {

	// 状态.0.已完成,1.待投标,2.已投标,3.已拒绝,4.未中标,5.已中标,6.生产中,7.待验收(Column: NOW_STATUS)
	private Integer nowStatus;

	// 投标ID,关联FAW_BID.ID(Column: PROJECT_ID)
	private Long projectId;

	/**
	 * 获取状态.0.已完成,1.待投标,2.已投标,3.已拒绝,4.未中标,5.已中标,6.生产中,7.待验收
	 */
	public Integer getNowStatus() {
		return nowStatus;
	}

	/**
	 * 设置状态.0.已完成,1.待投标,2.已投标,3.已拒绝,4.未中标,5.已中标,6.生产中,7.待验收
	 */
	public void setNowStatus(Integer nowStatus) {
		this.nowStatus = nowStatus;
	}

	/**
	 * 获取投标ID,关联FAW_BID.ID
	 */
	public Long getProjectId() {
		return projectId;
	}

	/**
	 * 设置投标ID,关联FAW_BID.ID
	 */
	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

}
