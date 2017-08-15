package cn.com.faw.crowdsourcing.admin;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.model.Project;
import cn.com.faw.crowdsourcing.model.page.ProjectPage;
import cn.com.faw.crowdsourcing.service.ProjectService;

/**
 * 项目控制器
 */
@Controller
public class ProjectController {

    /**
     * 项目业务逻辑
     */
    @Resource
    private ProjectService service;

    /**
     * 全部项目列表
     * 
     * @param page 项目分页查询对象
     * @param map Spring数据对象
     * @param name 菜单名称
     * @return 项目列表模板
     */
    @RequestMapping("/project/list")
    public String projectList(ProjectPage page, ModelMap map, String name) {
        service.loadProjectList(page);
        map.put("page", page);
        if (StringUtils.isEmpty(name)) {
            name = "all";
        }
        map.put("name", name);

        return "project/project_list";
    }

    /**
     * 跳转至项目详情页
     * 
     * @param map Spring数据对象
     * @return 项目详情页
     */
    @RequestMapping(value = "/project/info/{projectId}", method = RequestMethod.GET)
    public String toAddProject(Model model, @PathVariable Long projectId, String name) {
        // 项目基本信息
        model.addAttribute("project", service.getOneProject(projectId));
        model.addAttribute("name", name);
        // 项目附件
        model.addAttribute("projectFiles", service.getProjectFiles(projectId));
        // 已投标公司
        model.addAttribute("allBidService", service.getAllBidService(projectId));

        return "project/project_info";
    }

    /**
     * 添加项目
     * 
     * @param project 项目数据对象
     * @return 添加成功(JSON)
     */
    @RequestMapping(value = "/project/add", method = RequestMethod.POST)
    public String addProject(Project project) {
        service.addOneProject(project);
        return "redirect:/project/list";
    }

    /**
     * 跳转至编辑项目
     * 
     * @param id 项目ID
     * @param map Spring数据对象
     * @return 编辑项目模板
     */
    @RequestMapping(value = "/project/edit/{id}", method = RequestMethod.GET)
    public String toEditProject(@PathVariable Long id, ModelMap map) {
        map.put("project", service.getOneProject(id));
        return "project/edit_project";
    }

    /**
     * 编辑项目
     * 
     * @param project 项目数据对象
     * @param map Spring数据对象
     * @return 更新成功(JSON)
     */
    @RequestMapping(value = "/project/edit", method = RequestMethod.POST)
    public String editProject(Project project, ModelMap map) {
        service.modifyOneProject(project);
        return "redirect:/project/list";
    }

    /**
     * 删除项目
     * 
     * @param id 项目ID
     * @return 删除成功(JSON)
     */
    @RequestMapping("/project/remove/{id}")
    @ResponseBody
    public BaseJson removeProject(@PathVariable Long id) {
        service.removeOneProject(id);
        return new SuccessJson();
    }

}
