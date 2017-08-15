package cn.com.faw.crowdsourcing.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.com.faw.crowdsourcing.service.ProjectService;

/**
 * 前端项目管理模块
 *
 * @author gaoyang
 * @since 2017年8月8日
 */
@Controller
@RequestMapping("/service")
public class ServiceController {

    @Resource
    private ProjectService projectService;

    /**
     * 访问服务商信息
     * 
     * @param model
     * @return Strig 服务商信息页
     *
     * @author gaoyang
     * @since 2017年8月12日
     */
    @RequestMapping(value = "/detail/{serviceId}", method = RequestMethod.GET)
    public String detailInfo(Model model, @PathVariable Long serviceId) {
        // 公司信息
        model.addAttribute("companyInfo", projectService.getCompanyInfo(serviceId));
        // 获取投标项目以及文件
        model.addAttribute("serviceProject", projectService.getBidServiceInfo(serviceId));

        return "/project/service_detail";
    }

}
