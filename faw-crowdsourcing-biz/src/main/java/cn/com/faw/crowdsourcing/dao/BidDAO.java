package cn.com.faw.crowdsourcing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.faw.crowdsourcing.model.Bid;
import cn.com.faw.crowdsourcing.model.page.BidPage;

/**
 * 投标DAO(表名: FAW_BID)
 */
@Repository
public interface BidDAO {

    /**
     * 查找投标数量
     * 
     * @param page 投标分页对象
     * @return 投标数量
     */
    Integer selectBidCount(BidPage page);

    /**
     * 查找投标列表
     * 
     * @param page 投标分页对象
     * @return 投标列表
     */
    List<Bid> selectBidList(BidPage page);

    /**
     * 根据ID查找投标
     * 
     * @param id 投标id
     * @return 投标
     */
    Bid selectBidById(Long id);

    /**
     * 添加投标
     * 
     * @param bid 投标
     */
    void insertIntoBid(Bid bid);

    /**
     * 根据ID更新投标
     * 
     * @param bid 投标
     * @return 更新成功条数
     */
    Integer updateBidById(Bid bid);

    /**
     * 根据ID删除投标(逻辑删除, 更新状态为不可用)
     * 
     * @param id 投标id
     * @return 投标成功数量
     */
    Integer updateBidToDisabledById(Long id);

    /**
     * 根据ID获取所有投标服务商
     * 
     * @param projectId 项目ID
     * @return list 投标服务商
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    List<Bid> selectBidByProjectId(Long projectId);

    /**
     * 根据ID更新投标状态
     * 
     * @param data
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    Integer updateBidStatusById(Map<String, Object> data);

    /**
     * 根据ID更新投标状态
     * 
     * @param data
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    Integer updateBidStatusByProId(Map<String, Object> data);

    /**
     * 根据项目ID更新投标状态
     * 
     * @param data
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    Integer updateBidStatusByProjectId(Map<String, Object> data);

    /**
     * 查找已投标服务商
     * 
     * @param data
     * @return list 投标服务商
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    List<Bid> selectHasBidServiceByProjectId(Map<String, Object> data);

    /**
     * 修改其他服务商状态
     * 
     * @param data
     * @return
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    Integer updateOtherSeviceStatus(Map<String, Object> data);

    /**
     * 查找投标数量
     * 
     * @param page 投标分页对象
     * @return 投标数量
     */
    Integer selectHasBidCount(BidPage page);

    /**
     * 查找投标列表
     * 
     * @param page 投标分页对象
     * @return 投标列表
     */
    List<Bid> selectHasBidList(BidPage page);

    /**
     * 获取投标信息
     * 
     * @param projectId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    Bid selectBidServiceByProjectId(Map<String, Object> data);

    /**
     * 查询是否投标
     * 
     * @param data
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    int selectBidCountByProjectId(Map<String, Object> data);

    /**
     * 获取服务商投标列表
     * 
     * @param data
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    List<Bid> selectBidsByAndMemberId(Map<String, Object> data);

}
