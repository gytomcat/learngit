package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.BidLog;
import cn.com.faw.crowdsourcing.model.page.BidLogPage;

/**
 * 投标日志DAO(表名: FAW_BID_LOG)
 */
@Repository
public interface BidLogDAO {

	/**
	 * 查找投标日志数量
	 * 
	 * @param page 投标日志分页对象
	 * @return 投标日志数量
	 */
	Integer selectBidLogCount(BidLogPage page);

	/**
	 * 查找投标日志列表
	 * 
	 * @param page 投标日志分页对象
	 * @return 投标日志列表
	 */
	List<BidLog> selectBidLogList(BidLogPage page);

	/**
	 * 根据ID查找投标日志
	 * 
	 * @param id 投标日志id
	 * @return 投标日志
	 */
	BidLog selectBidLogById(Long id);

	/**
	 * 添加投标日志
	 * 
	 * @param bidLog 投标日志
	 */
	void insertIntoBidLog(BidLog bidLog);

	/**
	 * 根据ID更新投标日志
	 * 
	 * @param bidLog 投标日志
	 * @return 更新成功条数
	 */
	Integer updateBidLogById(BidLog bidLog);

	/**
	 * 根据ID删除投标日志(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 投标日志id
	 * @return 投标日志成功数量
	 */
	Integer updateBidLogToDisabledById(Long id);

}
