package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.BidLog;

/**
 * 投标日志ORM数据分页对象(Table: FAW_BID_LOG)
 */
public class BidLogPage extends Pagex {


	// 投标日志列表
	private List<BidLog> bidLogList;



	/**
	 * 获取投标日志ORM数据分页对象
	 */
	public List<BidLog> getBidLogList() {
		return bidLogList;
	}

	/**
	 * 设置投标日志ORM数据分页对象
	 */
	public void setBidLogList(List<BidLog> bidLogList) {
		this.bidLogList = bidLogList;
	}

}
