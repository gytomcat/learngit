package cn.com.faw.crowdsourcing.service;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import cn.com.faw.crowdsourcing.dao.BidDAO;
import cn.com.faw.crowdsourcing.dao.BidFileDAO;
import cn.com.faw.crowdsourcing.dao.MemberMessageDAO;
import cn.com.faw.crowdsourcing.dao.MessageDAO;
import cn.com.faw.crowdsourcing.dao.ProjectDAO;
import cn.com.faw.crowdsourcing.dao.ProjectFileDAO;
import cn.com.faw.crowdsourcing.dao.ProjectTagDAO;
import cn.com.faw.crowdsourcing.model.Bid;
import cn.com.faw.crowdsourcing.model.BidFile;
import cn.com.faw.crowdsourcing.model.Collect;
import cn.com.faw.crowdsourcing.model.Company;
import cn.com.faw.crowdsourcing.model.MemberMessage;
import cn.com.faw.crowdsourcing.model.Message;
import cn.com.faw.crowdsourcing.model.Project;
import cn.com.faw.crowdsourcing.model.ProjectFile;
import cn.com.faw.crowdsourcing.model.ProjectTag;
import cn.com.faw.crowdsourcing.model.page.BidPage;
import cn.com.faw.crowdsourcing.model.page.ProjectPage;

/**
 * 项目业务逻辑
 */
@Service
public class ProjectService {

    // 获取config文件中的dir.upload 内容
    @Value("${dir.upload}")
    private String uploadPath;

    /**
     * 项目DAO
     */
    @Resource
    private ProjectDAO projectDAO;

    /**
     * 项目附件DAO
     */
    @Resource
    private ProjectFileDAO projectFileDAO;

    /**
     * 项目附件DAO
     */
    @Resource
    private ProjectTagDAO projectTagDAO;

    /**
     * 投标DAO
     */
    @Resource
    private BidFileDAO bidFileDAO;

    /**
     * 投标DAO
     */
    @Resource
    private BidDAO bidDAO;

    /**
     * 投标DAO
     */
    @Resource
    private MessageDAO messageDAO;

    /**
     * 投标DAO
     */
    @Resource
    private MemberMessageDAO memberMessageDAO;

    // 投标方操作

    /**
     * 分页查找项目列表
     * 
     * @param page
     *        项目分页对象
     */
    public void loadProjectList(ProjectPage page) {
        Integer total = projectDAO.selectProjectCount(page);

        if (total > 0) {
            page.setTotalRow(total);
            page.setProjectList(projectDAO.selectProjectList(page));
        }
    }

    /**
     * 添加项目
     * 
     * @param project
     *        项目
     */
    public void addOneProject(Project project) {
        projectDAO.insertIntoProject(project);
    }

    /**
     * 更新项目
     * 
     * @param project
     *        项目
     */
    public void modifyOneProject(Project project) {
        projectDAO.updateProjectById(project);
    }

    /**
     * 获取某一项目
     * 
     * @param id
     *        项目ID
     * @return 项目
     */
    public Project getOneProject(Long id) {
        return projectDAO.selectProjectById(id);
    }

    /**
     * 删除项目(逻辑删除, 更新状态为不可用)
     * 
     * @param id
     *        项目ID
     */
    public void removeOneProject(Long id) {
        projectDAO.updateProjectToDisabledById(id);
    }

    /**
     * 分页查找投标列表
     * 
     * @param page
     *        投标分页对象
     */
    public void loadBidList(BidPage page) {
        Integer total = bidDAO.selectBidCount(page);

        if (total > 0) {
            page.setTotalRow(total);
            page.setBidList(bidDAO.selectBidList(page));
        }
    }

    /**
     * 添加投标
     * 
     * @param bid
     *        投标
     */
    public void addOneBid(Bid bid) {
        bidDAO.insertIntoBid(bid);
    }

    /**
     * 更新投标
     * 
     * @param bid
     *        投标
     */
    public void modifyOneBid(Bid bid) {
        bidDAO.updateBidById(bid);
    }

    /**
     * 获取某一投标
     * 
     * @param id
     *        投标ID
     * @return 投标
     */
    public Bid getOneBid(Long id) {
        return bidDAO.selectBidById(id);
    }

    /**
     * 删除投标(逻辑删除, 更新状态为不可用)
     * 
     * @param id
     *        投标ID
     */
    public void removeOneBid(Long id) {
        bidDAO.updateBidToDisabledById(id);
    }

    /**
     * 发布项目
     * 
     * <pre>
     *  1. 添加项目信息
     *  2. 添加项目标签
     * </pre>
     * 
     * @param project
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void addNewProject(Project project, MultipartFile file) {
        // 添加项目信息
        addOneNewProject(project);

        // 添加项目标签
        addProjectTags(project.getId(), project.getProjectTagIds());

        // 添加附件信息
        addProjectFile(project, file);

    }

    /**
     * 上传附件，添加项目附件信息
     * 
     * @param project
     * @param file
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    private void addProjectFile(Project project, MultipartFile file) {
        String filePath = uploadFile(file);
        if (StringUtils.isNotEmpty(filePath)) {
            ProjectFile pf = new ProjectFile();
            pf.setEnabled("Y");
            pf.setFilePath(filePath);
            pf.setProjectId(project.getId());
            pf.setFileType(1);

            projectFileDAO.insertIntoProjectFile(pf);
        }
    }

    /**
     * 添加项目信息
     * 
     * @param project
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    private void addOneNewProject(Project project) {
        project.setNowStatus(Project.WATING_AUDIT);
        project.setCompanyId(1L);
        project.setAgencyId(1L);
        project.setReleaseId(1L);
        project.setBidAmount(0);
        project.setWinAmount(0);
        project.setIsRelease(Project.NO);

        projectDAO.insertIntoProject(project);
    }

    /**
     * 添加项目标签表
     * 
     * @param projectId
     * @param projectTagIds
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    private void addProjectTags(Long projectId, String projectTagIds) {
        String[] ptIds = projectTagIds.split(",");
        for (String projectTagId : ptIds) {
            ProjectTag projectTag = new ProjectTag();
            projectTag.setProjectId(projectId);
            projectTag.setTagId(Long.parseLong(projectTagId));

            projectTagDAO.insertIntoProjectTag(projectTag);
        }
    }

    /**
     * 上传项目文件
     * 
     * @param bidId
     * @param bidFile
     * @param fileType
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void uploadProjectFile(Long projectId, MultipartFile bidFile, Integer fileType) {
        if (StringUtils.isNotEmpty(bidFile.getOriginalFilename())) {
            String filePath = uploadFile(bidFile);
            if (StringUtils.isNotEmpty(filePath)) {
                ProjectFile pf = new ProjectFile();
                pf.setEnabled("Y");
                pf.setFilePath(filePath);
                pf.setProjectId(projectId);
                pf.setFileType(1);

                projectFileDAO.insertIntoProjectFile(pf);
            }
        }
    }

    /**
     * 文件上传,上传的文件名命名规则：当前时间(精确到毫秒)
     * 将文件上传至服务器后返回上传文件名
     * 
     * @param file
     * @param response
     * @return
     * @throws Exception
     * 
     * @date 2014-1-10
     * @author gaoyang
     */
    public String uploadFile(MultipartFile file) {
        try {
            // 生成上传文件路径(含文件名)
            // 格式：/20140110/2014011018523255686.xls
            String filePath = getAbsolutePath(file.getOriginalFilename());
            // 设置文件上传绝对路径
            File newFile = new File(uploadPath + "/faw", filePath);
            // 上传文件
            newFile.mkdirs();
            file.transferTo(newFile);
            // 返回文件路径(含文件名)
            return "/faw/" + filePath;
        }
        catch (Exception e) {
            return null;
        }
    }

    /**
     * 获取文件的绝对路径
     * 
     * @param srcName
     * @return
     * 
     * @date 2014-1-10
     * @author gaoyang
     */
    private String getAbsolutePath(String srcName) {
        StringBuffer buf = new StringBuffer();
        buf.append(getNewFileName(srcName));
        return buf.toString();
    }

    /**
     * 构建新的文件名
     * 
     * @param srcName
     * @return
     * 
     *         2014-1-10
     * @author gaoyang
     */
    private String getNewFileName(String srcName) {
        StringBuffer buf = new StringBuffer();
        buf.append(srcName.substring(0, srcName.indexOf(".")));
        buf.append("-");
        buf.append(System.currentTimeMillis());
        buf.append(".");
        buf.append(FilenameUtils.getExtension(srcName));

        return buf.toString();
    }

    /**
     * 分页查找项目列表
     * 
     * @param page 查询条件
     * @return page 查询结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public ProjectPage getProjectListPage(ProjectPage page) {
        editProjectPage(page);
        Integer total = projectDAO.selectProjectCount(page);
        if (total == 0) {
            return page;
        }

        page.setTotalRow(total);
        page.setProjectList(projectDAO.selectProjectList(page));
        return page;
    }

    /**
     * 编辑查询条件
     * 
     * @param page
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    private void editProjectPage(ProjectPage page) {
        page.setCompanyId(1);
    }

    /**
     * 更新项目状态
     * 
     * @param projectId 项目ID
     * @param changeStatus 更改的状态
     * @param isRelease 是否发布
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public void modifyProjectStatus(Long projectId, Integer changeStatus) {
        modifyProjectStatus(projectId, changeStatus, null);
    }

    /**
     * 更新项目状态
     * 
     * @param projectId 项目ID
     * @param changeStatus 更改的状态
     * @param isRelease 是否发布
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public void modifyProjectStatus(Long projectId, Integer changeStatus, Long winBidId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", projectId);
        data.put("changeStatus", changeStatus);
        data.put("winbidId", winBidId);

        projectDAO.updateProjectStutsById(data);
    }

    /**
     * 更新项目审核状态
     * 
     * @param projectId 项目ID
     * @param changeStatus 更改的状态
     * @param isRelease 是否发布
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public void modifyProjectAuditStatus(Long projectId, Integer changeStatus, String isRelease) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", projectId);
        data.put("changeStatus", changeStatus);
        data.put("isRelease", isRelease);

        projectDAO.updateProjectAuditStutsAndTimeById(data);
    }

    /**
     * 更新项目状态
     * 
     * @param projectId 项目ID
     * @return 项目附件
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public List<ProjectFile> getProjectFiles(Long projectId) {
        return projectFileDAO.selectProjectFilesByProjectId(projectId);
    }

    /**
     * 取消项目
     * 
     * @param projectId 项目ID
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void cancelProject(Long projectId) {
        // 修改状态
        modifyProjectStatus(projectId, Project.HAS_CANCELED);
        // 更新投标表状态
        modifyProjectBidStatus(projectId, Bid.CANCELED);
        // 通知已投标服务商
        noticeBidService(projectId);
    }

    /**
     * 通知已投标服务商
     * 
     * @param projectId
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    private void noticeBidService(Long projectId) {
        List<Bid> bids = getHasBidService(projectId, Bid.BIDDED);
        for (Bid bid : bids) {
            addProjectMessage(bid.getBidMemberId(), "您有新的项目被取消信息，请查看！");
        }
    }

    /**
     * 添加投标项目消息通知
     * 
     * @param receiveUserId 接受人Id
     * @param msg 消息
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    private void addProjectMessage(Long receiveUserId, String msg) {
        Message message = new Message();
        message.setEnabled("Y");
        message.setMsgTitle(msg);
        message.setMsgType(1); // 系统消息
        message.setMsgDesc(msg);
        message.setMsgCategory(2); // 类别: 招投标
        message.setSenderId(1L);  // 当前登录人ID
        messageDAO.insertIntoMessage(message);

        MemberMessage mm = new MemberMessage();
        mm.setMessageId(message.getId());
        mm.setSendeeId(receiveUserId);
        mm.setEnabled("Y");
        mm.setIsRead("N");
        memberMessageDAO.insertIntoMemberMessage(mm);
    }

    /**
     * 查找已投标服务商
     * 
     * @param projectId
     * @param nowStatus
     * @return list 投标服务商
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    private List<Bid> getHasBidService(Long projectId, Integer nowStatus) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("nowStatus", nowStatus);

        return bidDAO.selectHasBidServiceByProjectId(data);
    }

    /**
     * 获取项目标签匹配供应商
     * 
     * @param projectId 项目ID
     * @return list 标签匹配的供应商列表
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    public List<Bid> getTagMatchServices(Long projectId) {
        return projectDAO.selectTagMatchServicesByProjectId(projectId);
    }

    /**
     * 邀请供应商投标
     * 
     * <pre>
     *  1. 给服务商发送消息
     *  2. 添加服务商邀请记录
     * </pre>
     * 
     * @param projectId 项目ID
     * @param serviceInfo
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void inviteService(Long projectId, String serviceInfo) {
        // 添加通知消息内容
        noticeService(projectId, serviceInfo);

        // 添加服务商邀请记录
        addServiceInvite(projectId, serviceInfo);
    }

    /**
     * 给服务商发送消息
     * 
     * @param projectId
     * @param serviceInfo
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    private void noticeService(Long projectId, String serviceInfo) {
        addProjectMessage(Long.parseLong(serviceInfo.substring(serviceInfo.lastIndexOf("-") + 1)), "您有新的项目邀请信息，请查看！");
    }

    /**
     * 添加服务商邀请记录
     * 
     * @param projectId
     * @param serviceInfo
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    private void addServiceInvite(Long projectId, String serviceInfo) {
        Bid bid = new Bid();
        bid.setProjectId(projectId);
        bid.setBidCompanyId(Long.parseLong(serviceInfo.substring(0, serviceInfo.indexOf("-"))));
        bid.setBidAgencyId(Long.parseLong(serviceInfo.substring(serviceInfo.indexOf("-") + 1, serviceInfo.lastIndexOf("-"))));
        bid.setBidMemberId(Long.parseLong(serviceInfo.substring(serviceInfo.lastIndexOf("-") + 1)));
        bid.setNowStatus(Bid.WATING_BID);
        bid.setEnabled("Y");
        bid.setBidType(2); // 邀请
        bid.setBidPrice(BigDecimal.ZERO);
        bid.setIsView("N");

        bidDAO.insertIntoBid(bid);
    }

    /**
     * 根据ID获取所有投标服务商
     * 
     * @param projectId 项目ID
     * @return list 投标服务商
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    public List<Bid> getAllBidService(Long projectId) {
        List<Bid> bids = bidDAO.selectBidByProjectId(projectId);
        for (Bid bid : bids) {
            bid.setBidFiles(getBidFiles(bid.getId(), 1));
            if (bid.getNowStatus() > Bid.AUDIT_BID_FAIL || bid.getNowStatus() == Bid.COMPLETED) {
                bid.setCheckFiles(getBidFiles(bid.getId(), 2));
            }
        }
        return bids;
    }

    /**
     * 更新评分和专利信息
     * 
     * @param project
     * @return
     *
     * @author gaoyang
     * @since 2017年8月11日
     */
    public void modifyScoreAndPatentById(Project project) {
        project.setNowStatus(Project.SCORED);
        projectDAO.updateScoreAndPatentById(project);
    }

    /**
     * 逻辑删除项目文件
     * 
     * @param bidId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void modifyProjectFileToDisabled(Long fileId) {
        projectFileDAO.updateProjectFileToDisabledById(fileId);
    }

    /**
     * 更新投标人数
     * 
     * @param projectId
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public void modifyBidAmount(Long projectId) {
        projectDAO.updateBidAmountById(projectId);
    }

    /**
     * 更新中标人数
     * 
     * @param projectId
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public void modifyWinAmount(Long projectId) {
        projectDAO.updateWinAmountById(projectId);
    }

    // TODO 服务商操作

    /**
     * 查找投标项目列表
     * 
     * @param page 查询条件
     * @return page 查询结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public BidPage getBidListPage(BidPage page) {
        editBidPage(page);
        Integer total = bidDAO.selectBidCount(page);
        if (total == 0) {
            return page;
        }

        page.setTotalRow(total);
        page.setBidList(bidDAO.selectBidList(page));
        return page;
    }

    /**
     * 编辑查询条件
     * 
     * @param page
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    private void editBidPage(BidPage page) {
        page.setBidMemberId(4l); // 当前登录ID
    }

    /**
     * 更新投标状态以及更新投标人数
     * 
     * @param bidId
     * @param projectId
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void acceptBid(Long bidId, Long projectId) {
        // 更新投标状态
        modifyBidStatus(bidId, Bid.BIDDED);
        // 更新投标人数
        modifyBidAmount(projectId);
    }

    /**
     * 根据ID更新投标状态
     * 
     * @param bidId id
     * @param status 状态
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void modifyBidStatus(Long bidId, Integer status) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("id", bidId);
        data.put("nowStatus", status);

        bidDAO.updateBidStatusById(data);
    }

    /**
     * 根据ID更新投标状态
     * 
     * @param projectId id
     * @param status 状态
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void modifyProBidStatus(Long projectId, Integer status) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("nowStatus", status);

        bidDAO.updateBidStatusByProId(data);
    }

    /**
     * 根据项目ID更新投标状态
     * 
     * @param projectId 项目id
     * @param status 状态
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void modifyProjectBidStatus(Long projectId, Integer status) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("nowStatus", status);

        bidDAO.updateBidStatusByProjectId(data);
    }

    /**
     * 根据项目ID更新投标状态
     * 
     * @param projectId 项目id
     * @param status 状态
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void selectService(Long projectId, Long bidId) {
        // 修改项目状态:已中标
        modifyProjectStatus(projectId, Project.BIDDED, bidId);

        // 修改投标服务商"已中标待审核"状态
        modifyBidStatus(bidId, Bid.WATING_CHECK);

        // 修改其他服务商为"未中标"状态
        modifyOtherServiceStatus(projectId, bidId, Bid.FAIL_BID);

        // 更新已中标人数
        modifyWinAmount(projectId);
    }

    /**
     * 修改其他投标服务商状态为未中标
     * 
     * @param projectId
     * @param bidId
     * @param status
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    private void modifyOtherServiceStatus(Long projectId, Long bidId, Integer status) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("id", bidId);
        data.put("nowStatus", status);

        bidDAO.updateOtherSeviceStatus(data);
    }

    /**
     * 修改项目状态以及投标信息状态
     * 
     * @param projectId 项目ID
     * @param projectStatus 项目状态
     * @param bidStatus 投标状态
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyProjectAndBidStatus(Long projectId, Integer projectStatus, Integer bidStatus) {
        // 修改项目状态:已中标
        modifyProjectStatus(projectId, projectStatus);

        // 修改投标服务商"已中标"状态
        modifyProBidStatus(projectId, bidStatus);
    }

    /**
     * 查找已投标项目列表
     * 
     * @param page 查询条件
     * @return page 查询结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public BidPage getHasBidListPage(BidPage page) {
        editBidPage(page);
        Integer total = bidDAO.selectHasBidCount(page);
        if (total == 0) {
            return page;
        }

        page.setTotalRow(total);
        page.setBidList(bidDAO.selectHasBidList(page));
        return page;
    }

    /**
     * 获取投标信息
     * 
     * @param projectId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public Bid getBidServiceByProjectId(Long projectId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("bidMemberId", 4); // 当前登录人ID
        Bid bid = bidDAO.selectBidServiceByProjectId(data);
        bid.setBidFiles(getBidFiles(bid.getId(), 1));
        if (bid.getNowStatus() > Bid.AUDIT_BID_FAIL || bid.getNowStatus() == Bid.COMPLETED) {
            bid.setCheckFiles(getBidFiles(bid.getId(), 2));
        }

        return bid;
    }

    /**
     * 修改项目状态以及投标信息状态
     * 
     * @param projectId 项目ID
     * @param projectStatus 项目状态
     * @param bidStatus 投标状态
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void modifyProjectAndBidStatus(Long projectId, Integer projectStatus, Long bidId, Integer bidStatus) {
        // 修改项目状态
        modifyProjectStatus(projectId, projectStatus);

        // 修改投标服务商状态
        modifyBidStatus(bidId, bidStatus);
    }

    /**
     * 获取投标文件
     * 
     * @param bidId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public List<BidFile> getBidFiles(Long bidId, Integer fileType) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("bidId", bidId);
        data.put("fileType", fileType);

        return bidFileDAO.selectBidFileByBidId(data);
    }

    /**
     * 逻辑删除投标文件
     * 
     * @param bidId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void modifyBidFileDisabled(Long fileId) {
        bidFileDAO.updateBidFileToDisabledById(fileId);
    }

    /**
     * 上传投标/交付文件
     * 
     * @param bidId
     * @param bidFile
     * @param fileType
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    public void uploadBidFile(Long bidId, MultipartFile bidFile, Integer fileType) {
        if (StringUtils.isNotEmpty(bidFile.getOriginalFilename())) {
            String filePath = uploadFile(bidFile);
            if (StringUtils.isNotEmpty(filePath)) {
                BidFile pf = new BidFile();
                pf.setEnabled("Y");
                pf.setFilePath(filePath);
                pf.setBidId(bidId);
                pf.setFileType(fileType); // 类型：交付文件

                bidFileDAO.insertIntoBidFile(pf);
            }
        }
    }

    /**
     * 查找需求项目列表
     * 
     * @param page 查询条件
     * @return page 查询结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    public ProjectPage getDemandProjectListPage(ProjectPage page) {
        editDemandProjectPage(page);
        Integer total = projectDAO.selectAllProjectCount(page);
        if (total == 0) {
            return page;
        }

        page.setTotalRow(total);
        page.setProjectList(projectDAO.selectAllProjectList(page));
        return page;
    }

    private void editDemandProjectPage(ProjectPage page) {
        page.setNowStatus(Project.IN_BIDDING); // 选标中
    }

    /**
     * 添加我的收藏
     * 
     * @param projectId 项目ID
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public void addMyCollect(Long projectId) {
        Collect collect = new Collect();
        collect.setProjectId(projectId);
        collect.setBidCompanyId(4l);
        collect.setBidAgencyId(3l);
        collect.setBidMemberId(4l); // 当前登录ID

        projectDAO.insertMyCollect(collect);
    }

    /**
     * 查看项目是否存在
     * 
     * @param projectId
     * @param memberId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public int getCollectCount(Long projectId, Long memberId) {
        Map<String, Object> data = new HashMap<String, Object>();

        data.put("projectId", projectId);
        data.put("memberId", memberId);

        return projectDAO.selectCollectCountByProjectId(data);
    }

    /**
     * 查找投标附件列表
     * 
     * @param projectId 项目ID
     * @param memberId 当前登录人ID
     * @return list
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public List<BidFile> getBidFileByProjectIdAndMemberId(Long projectId, Long memberId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("memberId", memberId);

        return bidFileDAO.selectBidFileByProjectIdAndMemberId(data);
    }

    /**
     * 查询是否投标
     * 
     * @param projectId 项目ID
     * @param memberId 当前登录人ID
     * @return int
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public int getBidCountByProjectId(Long projectId, Long memberId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("bidMemberId", memberId);

        return bidDAO.selectBidCountByProjectId(data);
    }

    /**
     * 投标
     * 
     * @param projectId
     * @param bidFile
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void bidProject(Long projectId, MultipartFile bidFile) {
        Long bidId = addBidInfo(projectId);
        uploadBidFile(bidId, bidFile, 1);
        modifyBidAmount(projectId);
    }

    /**
     * 添加服务商投标
     * 
     * @param projectId
     * @param serviceInfo
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    private Long addBidInfo(Long projectId) {
        Bid bid = new Bid();
        bid.setProjectId(projectId);
        bid.setBidCompanyId(4l);
        bid.setBidAgencyId(3l);
        bid.setBidMemberId(4l);
        bid.setNowStatus(Bid.BIDDED);
        bid.setEnabled("Y");
        bid.setBidType(2); // 邀请
        bid.setBidPrice(BigDecimal.ZERO);
        bid.setIsView("N");

        bidDAO.insertIntoBid(bid);
        return bid.getId();
    }

    /**
     * 获取投标信息
     * 
     * @param projectId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public Bid getBidService(Long projectId, Long memberId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("projectId", projectId);
        data.put("bidMemberId", memberId); // 当前登录人ID

        return bidDAO.selectBidServiceByProjectId(data);
    }

    /**
     * 获取所投项目信息
     * 
     * @param projectId
     * @param memberId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public List<Bid> getBidServiceInfo(Long memberId) {
        List<Bid> bids = getBidServices(memberId);
        for (Bid bid : bids) {
            bid.setBidFiles(getBidFiles(bid.getId(), 1));
        }

        return bids;
    }

    /**
     * 获取服务商投标列表
     * 
     * @param data
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public List<Bid> getBidServices(Long memberId) {
        Map<String, Object> data = new HashMap<String, Object>();
        data.put("bidMemberId", memberId); // 当前登录人ID

        return bidDAO.selectBidsByAndMemberId(data);
    }

    /**
     * 获取企业信息
     * 
     * @param memberId
     * @return
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    public Company getCompanyInfo(Long memberId) {
        return projectDAO.selectCompanyInfoByMemberId(memberId);
    }
}
