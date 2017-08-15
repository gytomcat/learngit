package cn.com.faw.crowdsourcing.model.page;

import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Project;

/**
 * 项目ORM数据分页对象(Table: FAW_PROJECT)
 */
public class ProjectPage extends Pagex {

    // 状态
    private Integer nowStatus;

    // 发布公司ID
    private Integer companyId;

    // 发布部门ID
    private Integer agencyId;

    // 发布人ID
    private Integer releaseId;

    // 项目列表
    private List<Project> projectList;

    public Integer getNowStatus() {
        return nowStatus;
    }

    public void setNowStatus(Integer nowStatus) {
        this.nowStatus = nowStatus;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public Integer getReleaseId() {
        return releaseId;
    }

    public void setReleaseId(Integer releaseId) {
        this.releaseId = releaseId;
    }

    /**
     * 获取项目ORM数据分页对象
     */
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * 设置项目ORM数据分页对象
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

}
