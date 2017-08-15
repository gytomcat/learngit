package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Company;
import cn.com.faw.crowdsourcing.model.page.CompanyPage;

/**
 * 企业DAO(表名: FAW_COMPANY)
 */
@Repository
public interface CompanyDAO {

	/**
	 * 查找企业数量
	 * 
	 * @param page 企业分页对象
	 * @return 企业数量
	 */
	Integer selectCompanyCount(CompanyPage page);

	/**
	 * 查找企业列表
	 * 
	 * @param page 企业分页对象
	 * @return 企业列表
	 */
	List<Company> selectCompanyList(CompanyPage page);

	/**
	 * 根据ID查找企业
	 * 
	 * @param id 企业id
	 * @return 企业
	 */
	Company selectCompanyById(Long id);

	/**
	 * 添加企业
	 * 
	 * @param company 企业
	 */
	void insertIntoCompany(Company company);

	/**
	 * 根据ID更新企业
	 * 
	 * @param company 企业
	 * @return 更新成功条数
	 */
	Integer updateCompanyById(Company company);

	/**
	 * 根据ID删除企业(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 企业id
	 * @return 企业成功数量
	 */
	Integer updateCompanyToDisabledById(Long id);

}
