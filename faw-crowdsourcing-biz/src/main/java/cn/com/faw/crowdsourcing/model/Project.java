package cn.com.faw.crowdsourcing.model;

import java.math.BigDecimal;
import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 项目ORM数据对象(Table: FAW_PROJECT)
 */
public class Project extends BaseModel {

    /**
     * 状态：no
     */
    public static final String NO = "N";

    /**
     * 状态：yes
     */
    public static final String YES = "Y";

    /**
     * 项目状态：-8.已过期
     */
    public static final int OUT_OF_DATE = -8;

    /**
     * 项目状态：-9.已取消
     */
    public static final int HAS_CANCELED = -9;

    /**
     * 项目状态：-1.待审核
     */
    public static final int WATING_AUDIT = -1;

    /**
     * 项目状态：2.审核未通过
     */
    public static final int NOT_PASS = -2;

    /**
     * 项目状态：0:已完成
     */
    public static final int COMPLETED = 0;

    /**
     * 项目状态：1.招标中
     */
    public static final int IN_BIDDING = 1;

    /**
     * 项目状态：2.选标中
     */
    public static final int CHOOSE_BIDDING = 2;

    /**
     * 项目状态：3.已选标待审核
     */
    public static final int BIDDED = 3;

    /**
     * 项目状态：4.审核成功待确认
     */
    public static final int WATING_CONFIRM = 4;

    /**
     * 项目状态：5.选标审核未通过
     */
    public static final int AUDIT_NOT_PASS = 5;

    /**
     * 项目状态：6.已确认.生产中
     */
    public static final int PRODUCTING = 6;

    /**
     * 项目状态：7.待验收
     */
    public static final int WATING_ACCEPTING = 7;

    /**
     * 项目状态：8.验收失败
     */
    public static final int ACCEPT_FAIL = 8;

    /**
     * 项目状态：9.已评分
     */
    public static final int SCORED = 9;

    // 状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.(Column:
    // NOW_STATUS)
    private Integer nowStatus;

    // 发标企业ID,关联FAW_COMPANY.ID(Column: COMPANY_ID)
    private Long companyId;

    // 发标部门ID,关联FAW_DEPT.ID(Column: AGENCY_ID)
    private Long agencyId;

    // 发布人ID,关联FAW_MEMBER.ID(Column: RELEASE_ID)
    private Long releaseId;

    // 发布时间(Column: RELEASE_TIME)
    private Date releaseTime;

    // 审核时间(Column: REVIEW_TIME)
    private Date reviewTime;

    // 招标截止日期(Column: BID_END_TIME)
    private Date bidEndTime;

    // 是否公开.Y:公开,N:不公开,默认N(Column: IS_OPEN)
    private String isOpen;

    // 是否发布.Y:已发布,N:未发布,默认N(Column: IS_RELEASE)
    private String isRelease;

    // 标题(Column: PROJECT_TITLE)
    private String projectTitle;

    // 要求(Column: PROJECT_DESC)
    private String projectDesc;

    // 价格(Column: PRICE)
    private BigDecimal price;

    // 制作周期(Column: PERIOD)
    private Integer period;

    // 投标人数,不限人数为-1(Column: BID_AMOUNT)
    private Integer bidAmount;

    // 中标人数,默认1(Column: WIN_AMOUNT)
    private Integer winAmount;

    // 选标时间(Column: SELECT_TIME)
    private Date selectTime;

    // 中标ID,关联FAW_BID.ID未选标是为-1(Column: WIN_BID_ID)
    private Long winBidId;

    // 创意ID,关联FAW_IDEA.ID,无创意为-1(Column: IDEA_ID)
    private Long ideaId;

    // 是否有专利,Y:有专利,N:无专利,默认N(Column: IS_PATENT)
    private String isPatent;

    // 专利描述
    private String patentDesc;

    // 评分
    private BigDecimal score;

    // 企业名称
    private String companyName;

    // 部门名称
    private String deptName;

    // 用户名称
    private String memberName;

    // 项目标签ids,例4,3,2,1
    private String projectTagIds;

    /**
     * 获取状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.
     */
    public Integer getNowStatus() {
        return nowStatus;
    }

    /**
     * 设置状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.
     */
    public void setNowStatus(Integer nowStatus) {
        this.nowStatus = nowStatus;
    }

    /**
     * 获取发标企业ID,关联FAW_COMPANY.ID
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * 设置发标企业ID,关联FAW_COMPANY.ID
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * 获取发标部门ID,关联FAW_DEPT.ID
     */
    public Long getAgencyId() {
        return agencyId;
    }

    /**
     * 设置发标部门ID,关联FAW_DEPT.ID
     */
    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 获取发布人ID,关联FAW_MEMBER.ID
     */
    public Long getReleaseId() {
        return releaseId;
    }

    /**
     * 设置发布人ID,关联FAW_MEMBER.ID
     */
    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    /**
     * 获取发布时间
     */
    public Date getReleaseTime() {
        return releaseTime;
    }

    /**
     * 设置发布时间
     */
    public void setReleaseTime(Date releaseTime) {
        this.releaseTime = releaseTime;
    }

    /**
     * 获取审核时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 设置审核时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * 获取招标截止日期
     */
    public Date getBidEndTime() {
        return bidEndTime;
    }

    /**
     * 设置招标截止日期
     */
    public void setBidEndTime(Date bidEndTime) {
        this.bidEndTime = bidEndTime;
    }

    /**
     * 获取是否公开.Y:公开,N:不公开,默认N
     */
    public String getIsOpen() {
        return isOpen;
    }

    /**
     * 设置是否公开.Y:公开,N:不公开,默认N
     */
    public void setIsOpen(String isOpen) {
        this.isOpen = isOpen;
    }

    /**
     * 获取是否发布.Y:已发布,N:未发布,默认N
     */
    public String getIsRelease() {
        return isRelease;
    }

    /**
     * 设置是否发布.Y:已发布,N:未发布,默认N
     */
    public void setIsRelease(String isRelease) {
        this.isRelease = isRelease;
    }

    /**
     * 获取标题
     */
    public String getProjectTitle() {
        return projectTitle;
    }

    /**
     * 设置标题
     */
    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    /**
     * 获取要求
     */
    public String getProjectDesc() {
        return projectDesc;
    }

    /**
     * 设置要求
     */
    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    /**
     * 获取价格
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取制作周期
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 设置制作周期
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 获取投标人数,不限人数为-1
     */
    public Integer getBidAmount() {
        return bidAmount;
    }

    /**
     * 设置投标人数,不限人数为-1
     */
    public void setBidAmount(Integer bidAmount) {
        this.bidAmount = bidAmount;
    }

    /**
     * 获取中标人数,默认1
     */
    public Integer getWinAmount() {
        return winAmount;
    }

    /**
     * 设置中标人数,默认1
     */
    public void setWinAmount(Integer winAmount) {
        this.winAmount = winAmount;
    }

    /**
     * 获取选标时间
     */
    public Date getSelectTime() {
        return selectTime;
    }

    /**
     * 设置选标时间
     */
    public void setSelectTime(Date selectTime) {
        this.selectTime = selectTime;
    }

    /**
     * 获取中标ID,关联FAW_BID.ID未选标是为-1
     */
    public Long getWinBidId() {
        return winBidId;
    }

    /**
     * 设置中标ID,关联FAW_BID.ID未选标是为-1
     */
    public void setWinBidId(Long winBidId) {
        this.winBidId = winBidId;
    }

    /**
     * 获取创意ID,关联FAW_IDEA.ID,无创意为-1
     */
    public Long getIdeaId() {
        return ideaId;
    }

    /**
     * 设置创意ID,关联FAW_IDEA.ID,无创意为-1
     */
    public void setIdeaId(Long ideaId) {
        this.ideaId = ideaId;
    }

    /**
     * 获取是否有专利,Y:有专利,N:无专利,默认N
     */
    public String getIsPatent() {
        return isPatent;
    }

    /**
     * 设置是否有专利,Y:有专利,N:无专利,默认N
     */
    public void setIsPatent(String isPatent) {
        this.isPatent = isPatent;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getProjectTagIds() {
        return projectTagIds;
    }

    public void setProjectTagIds(String projectTagIds) {
        this.projectTagIds = projectTagIds;
    }

    public String getPatentDesc() {
        return patentDesc;
    }

    public void setPatentDesc(String patentDesc) {
        this.patentDesc = patentDesc;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
