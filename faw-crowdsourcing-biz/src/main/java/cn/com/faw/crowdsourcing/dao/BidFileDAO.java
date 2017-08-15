package cn.com.faw.crowdsourcing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.faw.crowdsourcing.model.BidFile;
import cn.com.faw.crowdsourcing.model.page.BidFilePage;

/**
 * 投标附件DAO(表名: FAW_BID_FILE)
 */
@Repository
public interface BidFileDAO {

    /**
     * 查找投标附件数量
     * 
     * @param page 投标附件分页对象
     * @return 投标附件数量
     */
    Integer selectBidFileCount(BidFilePage page);

    /**
     * 查找投标附件列表
     * 
     * @param page 投标附件分页对象
     * @return 投标附件列表
     */
    List<BidFile> selectBidFileList(BidFilePage page);

    /**
     * 根据ID查找投标附件
     * 
     * @param id 投标附件id
     * @return 投标附件
     */
    BidFile selectBidFileById(Long id);

    /**
     * 添加投标附件
     * 
     * @param bidFile 投标附件
     */
    void insertIntoBidFile(BidFile bidFile);

    /**
     * 根据ID更新投标附件
     * 
     * @param bidFile 投标附件
     * @return 更新成功条数
     */
    Integer updateBidFileById(BidFile bidFile);

    /**
     * 根据ID删除投标附件(逻辑删除, 更新状态为不可用)
     * 
     * @param id 投标附件id
     * @return 投标附件成功数量
     */
    Integer updateBidFileToDisabledById(Long id);

    /**
     * 查找投标附件列表
     * 
     * @return 投标附件列表
     */
    List<BidFile> selectBidFileByBidId(Map<String, Object> data);

    /**
     * 查找投标附件列表
     * 
     * @return 投标附件列表
     */
    List<BidFile> selectBidFileByProjectIdAndMemberId(Map<String, Object> data);

}
