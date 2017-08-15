package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 投标附件ORM数据对象(Table: FAW_BID_FILE)
 */
public class BidFile extends BaseModel {

	// 投标ID,关联FAW_BID.ID(Column: BID_ID)
	private Long bidId;

	// 文件路径(Column: FILE_PATH)
	private String filePath;

	// 文件类型.1:投标文件,2:交付文件.3:发票(Column: FILE_TYPE)
	private Integer fileType;

	/**
	 * 获取投标ID,关联FAW_BID.ID
	 */
	public Long getBidId() {
		return bidId;
	}

	/**
	 * 设置投标ID,关联FAW_BID.ID
	 */
	public void setBidId(Long bidId) {
		this.bidId = bidId;
	}

	/**
	 * 获取文件路径
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * 设置文件路径
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * 获取文件类型.1:投标文件,2:交付文件.3:发票
	 */
	public Integer getFileType() {
		return fileType;
	}

	/**
	 * 设置文件类型.1:投标文件,2:交付文件.3:发票
	 */
	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}

}
