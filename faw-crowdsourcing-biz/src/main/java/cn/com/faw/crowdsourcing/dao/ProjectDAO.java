package cn.com.faw.crowdsourcing.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.com.faw.crowdsourcing.model.Bid;
import cn.com.faw.crowdsourcing.model.Collect;
import cn.com.faw.crowdsourcing.model.Company;
import cn.com.faw.crowdsourcing.model.Project;
import cn.com.faw.crowdsourcing.model.page.ProjectPage;

/**
 * 项目DAO(表名: FAW_PROJECT)
 */
@Repository
public interface ProjectDAO {

    /**
     * 查找项目数量
     * 
     * @param page 项目分页对象
     * @return 项目数量
     */
    Integer selectProjectCount(ProjectPage page);

    /**
     * 查找项目列表
     * 
     * @param page 项目分页对象
     * @return 项目列表
     */
    List<Project> selectProjectList(ProjectPage page);

    /**
     * 查找需求大厅项目数量
     * 
     * @param page 项目分页对象
     * @return 项目数量
     */
    Integer selectAllProjectCount(ProjectPage page);

    /**
     * 查找需求大厅项目列表
     * 
     * @param page 项目分页对象
     * @return 项目列表
     */
    List<Project> selectAllProjectList(ProjectPage page);

    /**
     * 根据ID查找项目
     * 
     * @param id 项目id
     * @return 项目
     */
    Project selectProjectById(Long id);

    /**
     * 添加项目
     * 
     * @param project 项目
     */
    void insertIntoProject(Project project);

    /**
     * 根据ID更新项目
     * 
     * @param project 项目
     * @return 更新成功条数
     */
    Integer updateProjectById(Project project);

    /**
     * 根据ID删除项目(逻辑删除, 更新状态为不可用)
     * 
     * @param id 项目id
     * @return 项目成功数量
     */
    Integer updateProjectToDisabledById(Long id);

    /**
     * 根据ID更新项目状态
     * 
     * @param data
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    void updateProjectStutsById(Map<String, Object> data);

    /**
     * 根据ID更新项目审核状态
     * 
     * @param data
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    void updateProjectAuditStutsAndTimeById(Map<String, Object> data);

    /**
     * 获取项目标签匹配供应商
     * 
     * @param projectId 项目ID
     * @return list 标签匹配的供应商列表
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    List<Bid> selectTagMatchServicesByProjectId(Long projectId);

    /**
     * 更新评分和专利信息
     * 
     * @param project
     * @return
     *
     * @author gaoyang
     * @since 2017年8月11日
     */
    Integer updateScoreAndPatentById(Project project);

    /**
     * 更新投标人数
     * 
     * @param projectId
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    void updateBidAmountById(Long projectId);

    /**
     * 更新中标人数
     * 
     * @param projectId
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    void updateWinAmountById(Long projectId);

    /**
     * 添加我的收藏
     * 
     * @param collect
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    void insertMyCollect(Collect collect);

    /**
     * 查看项目是否存在
     * 
     * @param data
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    int selectCollectCountByProjectId(Map<String, Object> data);

    /**
     * 获取企业信息
     * 
     * @param memberId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    Company selectCompanyInfoByMemberId(Long memberId);
}
