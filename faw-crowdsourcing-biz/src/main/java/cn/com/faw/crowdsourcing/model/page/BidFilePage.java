package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.BidFile;

/**
 * 投标附件ORM数据分页对象(Table: FAW_BID_FILE)
 */
public class BidFilePage extends Pagex {


	// 投标附件列表
	private List<BidFile> bidFileList;



	/**
	 * 获取投标附件ORM数据分页对象
	 */
	public List<BidFile> getBidFileList() {
		return bidFileList;
	}

	/**
	 * 设置投标附件ORM数据分页对象
	 */
	public void setBidFileList(List<BidFile> bidFileList) {
		this.bidFileList = bidFileList;
	}

}
