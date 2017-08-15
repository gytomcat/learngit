package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 投标ORM数据对象(Table: FAW_COLLECT)
 */
public class Collect extends BaseModel {

    private Long bidCompanyId;

    private Long bidAgencyId;

    private Long bidMemberId;

    private Long projectId;

    public Long getBidCompanyId() {
        return bidCompanyId;
    }

    public void setBidCompanyId(Long bidCompanyId) {
        this.bidCompanyId = bidCompanyId;
    }

    public Long getBidAgencyId() {
        return bidAgencyId;
    }

    public void setBidAgencyId(Long bidAgencyId) {
        this.bidAgencyId = bidAgencyId;
    }

    public Long getBidMemberId() {
        return bidMemberId;
    }

    public void setBidMemberId(Long bidMemberId) {
        this.bidMemberId = bidMemberId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

}
