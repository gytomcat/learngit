package cn.com.faw.crowdsourcing.model.page;

import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Bid;

/**
 * 投标ORM数据分页对象(Table: FAW_BID)
 */
public class BidPage extends Pagex {

    private Long bidMemberId;

    private Integer nowStatus;

    // 投标列表
    private List<Bid> bidList;

    /**
     * 获取投标ORM数据分页对象
     */
    public List<Bid> getBidList() {
        return bidList;
    }

    /**
     * 设置投标ORM数据分页对象
     */
    public void setBidList(List<Bid> bidList) {
        this.bidList = bidList;
    }

    public Long getBidMemberId() {
        return bidMemberId;
    }

    public void setBidMemberId(Long bidMemberId) {
        this.bidMemberId = bidMemberId;
    }

    public Integer getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(Integer nowStatus) {
        this.nowStatus = nowStatus;
    }

}
