package cn.com.faw.crowdsourcing.model.page;


import java.util.List;

import cn.com.faw.crowdsourcing.common.util.Pagex;
import cn.com.faw.crowdsourcing.model.Company;

/**
 * 企业ORM数据分页对象(Table: FAW_COMPANY)
 */
public class CompanyPage extends Pagex {


	// 企业列表
	private List<Company> companyList;



	/**
	 * 获取企业ORM数据分页对象
	 */
	public List<Company> getCompanyList() {
		return companyList;
	}

	/**
	 * 设置企业ORM数据分页对象
	 */
	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

}
