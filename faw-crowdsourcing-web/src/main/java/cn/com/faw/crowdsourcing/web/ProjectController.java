package cn.com.faw.crowdsourcing.web;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.model.Bid;
import cn.com.faw.crowdsourcing.model.Project;
import cn.com.faw.crowdsourcing.model.page.BidPage;
import cn.com.faw.crowdsourcing.model.page.ProjectPage;
import cn.com.faw.crowdsourcing.service.ProjectService;
import cn.com.faw.crowdsourcing.service.TagService;

/**
 * 前端项目管理模块
 *
 * @author gaoyang
 * @since 2017年8月8日
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    // 获取config文件中的dir.upload 内容
    @Value("${dir.upload}")
    private String uploadPath;

    @Resource
    private ProjectService projectService;

    @Resource
    private TagService tagService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(true);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    // TODO 发标方操作

    /**
     * 访问项目发布页
     * 
     * @param model
     * @return Strig 项目发布页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/release/add", method = RequestMethod.GET)
    public String toProjectAddPage(Model model) {
        model.addAttribute("allTags", tagService.getAllTagList());

        return "/project/project_add";
    }

    /**
     * 发布项目
     * 
     * @param model
     * @return Strig 项目发布页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/release/add", method = RequestMethod.POST)
    public String addProject(MultipartFile file, Project project) {
        projectService.addNewProject(project, file);

        return "redirect:/project/release/list";
    }

    /**
     * 访问已投标项目页
     * 
     * @param page 查询条件
     * @param model
     * @return Strig 已投标项目页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/release/list", method = RequestMethod.GET)
    public String toProjectReleaseListPage(ProjectPage page, Model model) {
        // page.setNowStatus(Project.WATING_AUDIT);
        model.addAttribute("page", projectService.getProjectListPage(page));

        return "/project/project_list";
    }

    /**
     * 上传项目附件文件
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/doc/upload", method = RequestMethod.POST)
    public String uploadProjectBidFile(MultipartFile bidFile, Long projectId) {
        projectService.uploadProjectFile(projectId, bidFile, 1);
        return "redirect:/project/detail/" + projectId;
    }

    /**
     * 更新评分和专利信息
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/result/score", method = RequestMethod.POST)
    public String modifyScoreInfo(Project project) {
        projectService.modifyScoreAndPatentById(project);
        return "redirect:/project/detail/" + project.getId();
    }

    /**
     * 审核项目项目
     * 
     * @param projectId 项目ID
     * @param status 修改状态
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/release/audit", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson auditProject(Long projectId, Integer changeStatus) {
        if (changeStatus == Project.IN_BIDDING) {
            // 修改状态：招标中（已审核）以及是否发布：Y
            projectService.modifyProjectAuditStatus(projectId, changeStatus, Project.YES);
        }
        else {
            // 修改状态：审核未通过
            projectService.modifyProjectAuditStatus(projectId, changeStatus, null);
        }

        return new SuccessJson();
    }

    /**
     * 查看已发布项目明细
     * 
     * @param projectId 项目ID
     * @return String 已发布项目明细页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/release/detail/{projectId}", method = RequestMethod.GET)
    public String toProjectReleaseDetail(@PathVariable Long projectId, Model model) {
        // 项目基本信息
        model.addAttribute("project", projectService.getOneProject(projectId));
        // 项目附件
        model.addAttribute("projectFiles", projectService.getProjectFiles(projectId));
        // 已投标公司
        model.addAttribute("allBidService", projectService.getAllBidService(projectId));

        return "/project/project_detail";
    }

    /**
     * 下载库存excel和图片文件下载
     * 
     * @param filePath
     * @param response
     * @throws Exception
     * 
     * @date 2014-7-18
     * @author gaoyang
     */
    @RequestMapping(value = "/doc/download", method = RequestMethod.GET)
    public void downLoadExcelAndImg(String filePath, HttpServletResponse response) throws Exception {
        BufferedInputStream br = null;
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            File f = new File(uploadPath + filePath);
            if (!f.exists()) {
                response.sendError(404, "File not found!");
            }
            br = new BufferedInputStream(new FileInputStream(f));
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset(); // 非常重要
            String filename = new String(f.getName().getBytes("gbk"), "iso-8859-1");
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            out = response.getOutputStream();
            while ((len = br.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        finally {
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 取消项目
     * 
     * <pre>
     *  1. 修改项目状态
     *  2. 通知已投标的服务商
     * </pre>
     * 
     * @param projectId 项目ID
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/cancel/{projectId}", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson auditProject(@PathVariable Long projectId) {
        // 修改状态：已取消
        projectService.cancelProject(projectId);

        return new SuccessJson();
    }

    /**
     * 访问系统推荐服务商页
     * 
     * @param projectId 项目ID
     * @param model
     * @return Strig 统推荐服务商页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/service/auto", method = RequestMethod.GET)
    public String toRecommendServicers(Long projectId, Model model) {
        model.addAttribute("projectId", projectId);

        return "/project/service_recommend";
    }

    /**
     * 访问项目标签匹配服务商页
     * 
     * @param projectId 项目ID
     * @param model
     * @return Strig 项目标签匹配服务商页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/service/list", method = RequestMethod.GET)
    public String toAllServicers(Long projectId, Model model) {
        model.addAttribute("projectId", projectId);
        // 标签匹配供应商
        model.addAttribute("projectService", projectService.getTagMatchServices(projectId));
        // 所有已投标的服务商
        model.addAttribute("allBidService", projectService.getAllBidService(projectId));

        return "/project/service_all";
    }

    /**
     * 访问已投标服务商页
     * 
     * @param projectId 项目ID
     * @param model
     * @return Strig 已投标服务商页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/service/bid", method = RequestMethod.GET)
    public String tBidServicers(Long projectId, Model model) {
        model.addAttribute("projectId", projectId);

        model.addAttribute("allBidService", projectService.getAllBidService(projectId));

        return "/project/service_bid";
    }

    /**
     * 邀请服务商投标
     * 
     * @param projectId 项目ID
     * @param serviceInfo 服务商信息
     * @return Strig 已投标服务商页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/service/invite", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson inviteService(Long projectId, String serviceInfo) {
        projectService.inviteService(projectId, serviceInfo);

        return new SuccessJson();
    }

    /**
     * 选标
     * 
     * @param bidId 项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/service/select", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson selectService(Long bidId, Long projectId) {
        projectService.selectService(projectId, bidId);
        return new SuccessJson();
    }

    /**
     * 审核选标
     * 
     * @param projectId 项目ID
     * @param status 修改状态
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/service/audit", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson auditBidProject(Long projectId, Integer changeStatus, Integer bidStatus) {
        projectService.modifyProjectAndBidStatus(projectId, changeStatus, bidStatus);
        return new SuccessJson();
    }

    /**
     * 验收通过
     * 
     * @param projectId 项目ID
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/result/success", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson resultSucc(Long projectId) {
        projectService.modifyProjectAndBidStatus(projectId, Project.COMPLETED, Bid.COMPLETED);
        return new SuccessJson();
    }

    /**
     * 验收失败
     * 
     * @param projectId 项目ID
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/result/fail", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson resultFail(Long projectId) {
        projectService.modifyProjectAndBidStatus(projectId, Project.ACCEPT_FAIL, Bid.CHECK_FAIL);
        return new SuccessJson();
    }

    /**
     * 删除项目文件
     * 
     * @param fileId 文件ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/doc/remove", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson removeDoc(Long fileId) {
        projectService.modifyProjectFileToDisabled(fileId);

        return new SuccessJson();
    }

    // TODO 服务商操作

    /**
     * 邀请服务商投标
     * 
     * @param projectId 项目ID
     * @param serviceInfo 服务商信息
     * @return Strig 已投标服务商页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/invite/list", method = RequestMethod.GET)
    public String toAccept(BidPage page, Model model) {
        page.setNowStatus(Bid.WATING_BID);
        model.addAttribute("page", projectService.getBidListPage(page));

        return "/project/invite_bid_list";
    }

    /**
     * 接受投标
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/invite/accept", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson acceptBid(Long bidId, Long projectId) {
        projectService.acceptBid(bidId, projectId);

        return new SuccessJson();
    }

    /**
     * 拒绝投标
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/invite/refuse", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson refuseBid(Long bidId) {
        projectService.modifyBidStatus(bidId, Bid.REFUSED);
        return new SuccessJson();
    }

    /**
     * 放弃投标
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/bid/cancel", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson cancelBid(Long bidId) {
        projectService.modifyBidStatus(bidId, Bid.CANCELED);
        return new SuccessJson();
    }

    /**
     * 访问已投标项目页
     * 
     * @param projectId 项目ID
     * @param serviceInfo 服务商信息
     * @return Strig 已投标服务商页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/bid/list", method = RequestMethod.GET)
    public String bidListPage(BidPage page, Model model) {
        model.addAttribute("page", projectService.getHasBidListPage(page));

        return "/project/bid_list";
    }

    /**
     * 查看已发布项目明细
     * 
     * @param projectId 项目ID
     * @return String 已发布项目明细页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/bid/detail/{projectId}", method = RequestMethod.GET)
    public String toBidProjectDetail(@PathVariable Long projectId, Model model) {
        // 项目基本信息
        model.addAttribute("project", projectService.getOneProject(projectId));
        // 项目附件
        model.addAttribute("projectFiles", projectService.getProjectFiles(projectId));
        // 投标方信息
        model.addAttribute("bidService", projectService.getBidServiceByProjectId(projectId));

        return "/project/bid_detail";
    }

    /**
     * 确认接受中标
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/bid/confirm", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson confirmBid(Long bidId, Long projectId) {
        projectService.modifyProjectAndBidStatus(projectId, Project.PRODUCTING, bidId, Bid.PRODUCTING);
        return new SuccessJson();
    }

    /**
     * 上传投标文件
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/bid/upload", method = RequestMethod.POST)
    public String uploadBidFile(Long bidId, MultipartFile bidFile, Long projectId, Integer mark) {
        projectService.uploadBidFile(bidId, bidFile, 1);
        if (mark == 1) {
            return "redirect:/project/bid/detail/" + projectId;
        }
        else {
            return "redirect:/project/detail/" + projectId;
        }
    }

    /**
     * 上传交付文件
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/result/upload", method = RequestMethod.POST)
    public String uploadResultFile(Long bidId, MultipartFile bidFile, Long projectId) {
        projectService.uploadBidFile(bidId, bidFile, 2);
        return "redirect:/project/bid/detail/" + projectId;
    }

    /**
     * 申请验收
     * 
     * @param bidId 被邀请项目ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/result/submit", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson submitCheck(Long bidId, Long projectId) {
        projectService.modifyProjectAndBidStatus(projectId, Project.WATING_ACCEPTING, bidId, Bid.WATING_ACCEPT);

        return new SuccessJson();
    }

    /**
     * 下载文件
     * 
     * @param filePath
     * @param response
     * @throws Exception
     * 
     * @date 2014-7-18
     * @author gaoyang
     */
    @RequestMapping(value = "/bid/download", method = RequestMethod.GET)
    public void downLoadBidFile(String filePath, HttpServletResponse response) throws Exception {
        BufferedInputStream br = null;
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            File f = new File(uploadPath + filePath);
            if (!f.exists()) {
                response.sendError(404, "File not found!");
            }
            br = new BufferedInputStream(new FileInputStream(f));
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset(); // 非常重要
            String filename = new String(f.getName().getBytes("gbk"), "iso-8859-1");
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            out = response.getOutputStream();
            while ((len = br.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        finally {
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    /**
     * 删除投标文件
     * 
     * @param fileId 文件ID
     * @return baseJson 处理结果
     *
     * @author gaoyang
     * @since 2017年8月10日
     */
    @RequestMapping(value = "/bid/remove", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson confirmBid(Long fileId) {
        projectService.modifyBidFileDisabled(fileId);

        return new SuccessJson();
    }

    /**
     * 下载交付文件
     * 
     * @param filePath
     * @param response
     * @throws Exception
     * 
     * @date 2014-7-18
     * @author gaoyang
     */
    @RequestMapping(value = "/result/download", method = RequestMethod.GET)
    public void downLoadResultFile(String filePath, HttpServletResponse response) throws Exception {
        BufferedInputStream br = null;
        OutputStream out = null;
        try {
            response.setCharacterEncoding("utf-8");
            File f = new File(uploadPath + filePath);
            if (!f.exists()) {
                response.sendError(404, "File not found!");
            }
            br = new BufferedInputStream(new FileInputStream(f));
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset(); // 非常重要
            String filename = new String(f.getName().getBytes("gbk"), "iso-8859-1");
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
            out = response.getOutputStream();
            while ((len = br.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
        }
        finally {
            if (br != null) {
                br.close();
            }
            if (out != null) {
                out.close();
            }
        }
    }

    // TODO 需求大厅

    /**
     * 需求大厅
     * 
     * @param page 查询条件
     * @param model
     * @return Strig 已投标项目页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String toProjectListPage(ProjectPage page, Model model) {
        // page.setNowStatus(Project.WATING_AUDIT);
        model.addAttribute("page", projectService.getDemandProjectListPage(page));

        return "/project/demand_project_list";
    }

    /**
     * 查看已发布项目明细
     * 
     * @param projectId 项目ID
     * @return String 已发布项目明细页
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/detail/{projectId}", method = RequestMethod.GET)
    public String toProjectDetail(@PathVariable Long projectId, Model model) {
        // 项目基本信息
        model.addAttribute("project", projectService.getOneProject(projectId));
        // 项目附件
        model.addAttribute("projectFiles", projectService.getProjectFiles(projectId));
        // 已投标公司
        model.addAttribute("allBidService", projectService.getAllBidService(projectId));
        // 是否收藏
        model.addAttribute("collectCount", projectService.getCollectCount(projectId, 4L));
        // 已上传文件
        model.addAttribute("bidFiles", projectService.getBidFileByProjectIdAndMemberId(projectId, 4L));
        // 是否投标
        int bidCount = projectService.getBidCountByProjectId(projectId, 4L);
        model.addAttribute("bidCount", bidCount);
        if (bidCount > 0) {
            // 获取投标信息
            model.addAttribute("bidInfo", projectService.getBidService(projectId, 4l));
        }

        return "/project/demand_project_detail";
    }

    /**
     * 主动投标项目
     * 
     * @param projectId 项目ID
     * @param status 修改状态
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/bid", method = RequestMethod.POST)
    public String bidProject(MultipartFile bidFile, Long projectId) {
        projectService.bidProject(projectId, bidFile);

        return "redirect:/project/detail/" + projectId;
    }

    /**
     * 收藏项目
     * 
     * @param projectId 项目ID
     * @return 处理结果
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    @RequestMapping(value = "/collect", method = RequestMethod.POST)
    @ResponseBody
    public BaseJson collectProject(Long projectId) {
        projectService.addMyCollect(projectId);
        return new SuccessJson();
    }

}
