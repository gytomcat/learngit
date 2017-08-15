package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.CompanyDAO;
import cn.com.faw.crowdsourcing.dao.DeptDAO;
import cn.com.faw.crowdsourcing.model.Company;
import cn.com.faw.crowdsourcing.model.Dept;
import cn.com.faw.crowdsourcing.model.page.CompanyPage;
import cn.com.faw.crowdsourcing.model.page.DeptPage;

/**
 * 企业业务逻辑
 */
@Service
public class CompanyService {

	/**
	 * 企业DAO
	 */
	@Resource
	private CompanyDAO companyDAO;

	/**
	 * 部门DAO
	 */
	@Resource
	private DeptDAO deptDAO;

	/**
	 * 分页查找企业列表
	 * 
	 * @param page
	 *            企业分页对象
	 */
	public void loadCompanyList(CompanyPage page) {
		Integer total = companyDAO.selectCompanyCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setCompanyList(companyDAO.selectCompanyList(page));
		}
	}

	/**
	 * 添加企业
	 * 
	 * @param company
	 *            企业
	 */
	public void addOneCompany(Company company) {
		companyDAO.insertIntoCompany(company);
	}

	/**
	 * 更新企业
	 * 
	 * @param company
	 *            企业
	 */
	public void modifyOneCompany(Company company) {
		companyDAO.updateCompanyById(company);
	}

	/**
	 * 获取某一企业
	 * 
	 * @param id
	 *            企业ID
	 * @return 企业
	 */
	public Company getOneCompany(Long id) {
		return companyDAO.selectCompanyById(id);
	}

	/**
	 * 删除企业(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id
	 *            企业ID
	 */
	public void removeOneCompany(Long id) {
		companyDAO.updateCompanyToDisabledById(id);
	}

	/**
	 * 分页查找部门列表
	 * 
	 * @param page
	 *            部门分页对象
	 */
	public void loadDeptList(DeptPage page) {
		Integer total = deptDAO.selectDeptCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setDeptList(deptDAO.selectDeptList(page));
		}
	}

	/**
	 * 添加部门
	 * 
	 * @param dept
	 *            部门
	 */
	public void addOneDept(Dept dept) {
		deptDAO.insertIntoDept(dept);
	}

	/**
	 * 更新部门
	 * 
	 * @param dept
	 *            部门
	 */
	public void modifyOneDept(Dept dept) {
		deptDAO.updateDeptById(dept);
	}

	/**
	 * 获取某一部门
	 * 
	 * @param id
	 *            部门ID
	 * @return 部门
	 */
	public Dept getOneDept(Long id) {
		return deptDAO.selectDeptById(id);
	}

	/**
	 * 删除部门(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id
	 *            部门ID
	 */
	public void removeOneDept(Long id) {
		deptDAO.updateDeptToDisabledById(id);
	}
}
