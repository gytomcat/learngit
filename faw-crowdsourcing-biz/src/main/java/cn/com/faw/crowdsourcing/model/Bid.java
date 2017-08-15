package cn.com.faw.crowdsourcing.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 投标ORM数据对象(Table: FAW_BID)
 */
public class Bid extends BaseModel {

    /**
     * 项目状态：-1.已取消
     */
    public static final int CANCELED = -1;

    /**
     * 项目状态：0.已完成
     */
    public static final int COMPLETED = 0;

    /**
     * 项目状态：1.待投标
     */
    public static final int WATING_BID = 1;

    /**
     * 项目状态：2.已投标
     */
    public static final int BIDDED = 2;

    /**
     * 项目状态：3.已拒绝
     */
    public static final int REFUSED = 3;

    /**
     * 项目状态：4.未中标
     */
    public static final int FAIL_BID = 4;

    /**
     * 项目状态：5.已中标待审核
     */
    public static final int WATING_CHECK = 5;

    /**
     * 项目状态：6.审核成功待确认
     */
    public static final int WAITING_CONFIRM = 6;

    /**
     * 项目状态：7.审核未通过
     */
    public static final int AUDIT_BID_FAIL = 7;

    /**
     * 项目状态：8.已确认,生产中
     */
    public static final int PRODUCTING = 8;

    /**
     * 项目状态：9.待验收
     */
    public static final int WATING_ACCEPT = 9;

    /**
     * 项目状态：10.验收失败
     */
    public static final int CHECK_FAIL = 10;

    // 状态.0.已完成,1.待投标,2.已投标,3.已拒绝,4.未中标,5.已中标,6.生产中,7.待验收(Column: NOW_STATUS)
    private Integer nowStatus;

    // 项目ID,关联FAW_PROJECT.ID(Column: PROJECT_ID)
    private Long projectId;

    // 投标企业ID,关联FAW_COMPANY.ID(Column: BID_COMPANY_ID)
    private Long bidCompanyId;

    // 投标机构ID,关联FAW_DEPT.ID(Column: BID_AGENCY_ID)
    private Long bidAgencyId;

    // 投标人ID,关联FAW_MEMBER.ID(Column: BID_MEMBER_ID)
    private Long bidMemberId;

    // 投标类型.1:投标,2:邀请(Column: BID_TYPE)
    private Integer bidType;

    // 报价(Column: BID_PRICE)
    private BigDecimal bidPrice;

    // 投标时间(Column: BID_TIME)
    private Date bidTime;

    // 发标方是否查看,Y:已看,N:未看,默认N(Column: IS_VIEW)
    private String isView;

    // 查看时间(Column: VIEW_TIME)
    private Date viewTime;

    private Project project;

    // 投标文件
    private List<BidFile> bidFiles;

    // 交付文件
    private List<BidFile> checkFiles;

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
     * 获取项目ID,关联FAW_PROJECT.ID
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     * 设置项目ID,关联FAW_PROJECT.ID
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     * 获取投标企业ID,关联FAW_COMPANY.ID
     */
    public Long getBidCompanyId() {
        return bidCompanyId;
    }

    /**
     * 设置投标企业ID,关联FAW_COMPANY.ID
     */
    public void setBidCompanyId(Long bidCompanyId) {
        this.bidCompanyId = bidCompanyId;
    }

    /**
     * 获取投标机构ID,关联FAW_DEPT.ID
     */
    public Long getBidAgencyId() {
        return bidAgencyId;
    }

    /**
     * 设置投标机构ID,关联FAW_DEPT.ID
     */
    public void setBidAgencyId(Long bidAgencyId) {
        this.bidAgencyId = bidAgencyId;
    }

    /**
     * 获取投标人ID,关联FAW_MEMBER.ID
     */
    public Long getBidMemberId() {
        return bidMemberId;
    }

    /**
     * 设置投标人ID,关联FAW_MEMBER.ID
     */
    public void setBidMemberId(Long bidMemberId) {
        this.bidMemberId = bidMemberId;
    }

    /**
     * 获取投标类型.1:投标,2:邀请
     */
    public Integer getBidType() {
        return bidType;
    }

    /**
     * 设置投标类型.1:投标,2:邀请
     */
    public void setBidType(Integer bidType) {
        this.bidType = bidType;
    }

    /**
     * 获取报价
     */
    public BigDecimal getBidPrice() {
        return bidPrice;
    }

    /**
     * 设置报价
     */
    public void setBidPrice(BigDecimal bidPrice) {
        this.bidPrice = bidPrice;
    }

    /**
     * 获取投标时间
     */
    public Date getBidTime() {
        return bidTime;
    }

    /**
     * 设置投标时间
     */
    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    /**
     * 获取发标方是否查看,Y:已看,N:未看,默认N
     */
    public String getIsView() {
        return isView;
    }

    /**
     * 设置发标方是否查看,Y:已看,N:未看,默认N
     */
    public void setIsView(String isView) {
        this.isView = isView;
    }

    /**
     * 获取查看时间
     */
    public Date getViewTime() {
        return viewTime;
    }

    /**
     * 设置查看时间
     */
    public void setViewTime(Date viewTime) {
        this.viewTime = viewTime;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<BidFile> getBidFiles() {
        return bidFiles;
    }

    public void setBidFiles(List<BidFile> bidFiles) {
        this.bidFiles = bidFiles;
    }

    public List<BidFile> getCheckFiles() {
        return checkFiles;
    }

    public void setCheckFiles(List<BidFile> checkFiles) {
        this.checkFiles = checkFiles;
    }

}
