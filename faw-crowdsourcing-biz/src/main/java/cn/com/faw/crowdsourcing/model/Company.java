package cn.com.faw.crowdsourcing.model;

import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 企业ORM数据对象(Table: FAW_COMPANY)
 */
public class Company extends BaseModel {

	// ID(Column: ID)
	private Long id;
	
	// 创建时间(Column: CREATE_TIME)
	private Date createTime;
	
	// 更新时间(Column: UPDATE_TIME)
	private Date updateTime;
	
	// 是否有效,Y:有效,N:无效.默认N(Column: ENABLED)
	private String enabled;
	
	// 企业名称(Column: COMPANY_NAME)
	private String companyName;
	
	// 企业描述(Column: COMPANY_DESC)
	private String companyDesc;
	
	// 管理员账号ID,关联FAW_MEMBER.ID(Column: ADMIN_ID)
	private Long adminId;
	
	// 审核员账号ID,关联FAW_MEMBER.ID(Column: REVIEWER_ID)
	private Long reviewerId;
	
	
	/**
	 * 获取ID
	 */
	public Long getId() {
		return id;
	}

	/**
	 * 设置ID
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * 获取创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	/**
	 * 获取更新时间
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 设置更新时间
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	/**
	 * 获取是否有效,Y:有效,N:无效.默认N
	 */
	public String getEnabled() {
		return enabled;
	}

	/**
	 * 设置是否有效,Y:有效,N:无效.默认N
	 */
	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}
	
	/**
	 * 获取企业名称
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * 设置企业名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	/**
	 * 获取企业描述
	 */
	public String getCompanyDesc() {
		return companyDesc;
	}

	/**
	 * 设置企业描述
	 */
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	
	/**
	 * 获取管理员账号ID,关联FAW_MEMBER.ID
	 */
	public Long getAdminId() {
		return adminId;
	}

	/**
	 * 设置管理员账号ID,关联FAW_MEMBER.ID
	 */
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
	/**
	 * 获取审核员账号ID,关联FAW_MEMBER.ID
	 */
	public Long getReviewerId() {
		return reviewerId;
	}

	/**
	 * 设置审核员账号ID,关联FAW_MEMBER.ID
	 */
	public void setReviewerId(Long reviewerId) {
		this.reviewerId = reviewerId;
	}
	

}
