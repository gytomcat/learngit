package cn.com.faw.crowdsourcing.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.model.Company;
import cn.com.faw.crowdsourcing.model.page.CompanyPage;
import cn.com.faw.crowdsourcing.service.CompanyService;

/**
 * 企业控制器
 */
@Controller
public class CompanyController {

	/**
	 * 企业业务逻辑
	 */
	@Resource
	private CompanyService service;

	/**
	 * 全部企业列表
	 * 
	 * @param page 企业分页查询对象
	 * @param map Spring数据对象
	 * @return 企业列表模板
	 */
	@RequestMapping("/company/list")
	public String companyList(CompanyPage page, ModelMap map) {
		service.loadCompanyList(page);
		map.put("page", page);

		return "company/company_list";
	}

	/**
	 * 跳转至添加企业
	 * 
	 * @param map Spring数据对象
	 * @return 添加企业页面模板
	 */
	@RequestMapping(value = "/company/add", method = RequestMethod.GET)
	public String toAddCompany(ModelMap map) {
		return "company/add_company";
	}

	/**
	 * 添加企业
	 * 
	 * @param company 企业数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/company/add", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson addCompany(Company company) {
		service.addOneCompany(company);
		return new SuccessJson();
	}
	
	/**
	 * 跳转至编辑企业
	 * 
	 * @param id 企业ID
	 * @param map Spring数据对象
	 * @return 编辑企业模板
	 */
	@RequestMapping(value = "/company/edit/{id}", method = RequestMethod.GET)
	public String toEditCompany(@PathVariable Long id, ModelMap map) {
		map.put("company", service.getOneCompany(id));
		return "company/edit_company";
	}

	/**
	 * 编辑企业
	 * 
	 * @param company 企业数据对象
	 * @param map Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/company/edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson editCompany(Company company, ModelMap map) {
		service.modifyOneCompany(company);
		return new SuccessJson();
	}

	/**
	 * 删除企业
	 * 
	 * @param id 企业ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/company/remove/{id}")
	@ResponseBody
	public BaseJson removeCompany(@PathVariable Long id) {
		service.removeOneCompany(id);
		return new SuccessJson();
	}

}
