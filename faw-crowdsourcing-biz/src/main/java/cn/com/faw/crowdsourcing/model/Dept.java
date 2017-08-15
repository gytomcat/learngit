package cn.com.faw.crowdsourcing.model;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 部门ORM数据对象(Table: FAW_DEPT)
 */
public class Dept extends BaseModel {

	// 企业ID,关联FAW_COMPANY.ID(Column: COMPANY_ID)
	private Long companyId;

	// 部门名称(Column: DEPT_NAME)
	private String deptName;

	// 部门描述(Column: DEPT_DESC)
	private String deptDesc;

	// 部门级别(Column: DEPT_LEVEL)
	private Integer deptLevel;

	// 上级部门IID,关联FAW_AGENCY.ID,顶级部门I为-1(Column: PARENT_ID)
	private Long parentId;

	// 管理员账号ID,关联FAW.MEMBER.ID(Column: ADMIN_ID)
	private Long adminId;

	// 审核员账号ID,关联FAW_MEMBER.ID(Column: REVIEWER_ID)
	private Long reviewerId;

	// 负责人ID,关联FAW.MEMBER.ID(Column: MANAGER_ID)
	private Long managerId;

	// 会员数量,默认0(Column: MEMBER_COUNT)
	private Integer memberCount;

	// 投标数量,默认0(Column: BID_COUNT)
	private Integer bidCount;

	// 中标数量,默认0(Column: WIN_COUNT)
	private Integer winCount;

	// 接受数量,默认0(Column: ACCEPT_COUNT)
	private Integer acceptCount;

	// 创意数量,默认0(Column: IDEA_COUNT)
	private Integer ideaCount;

	/**
	 * 获取企业ID,关联FAW_COMPANY.ID
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * 设置企业ID,关联FAW_COMPANY.ID
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * 获取部门名称
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * 设置部门名称
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * 获取部门描述
	 */
	public String getDeptDesc() {
		return deptDesc;
	}

	/**
	 * 设置部门描述
	 */
	public void setDeptDesc(String deptDesc) {
		this.deptDesc = deptDesc;
	}

	/**
	 * 获取部门级别
	 */
	public Integer getDeptLevel() {
		return deptLevel;
	}

	/**
	 * 设置部门级别
	 */
	public void setDeptLevel(Integer deptLevel) {
		this.deptLevel = deptLevel;
	}

	/**
	 * 获取上级部门IID,关联FAW_AGENCY.ID,顶级部门I为-1
	 */
	public Long getParentId() {
		return parentId;
	}

	/**
	 * 设置上级部门IID,关联FAW_AGENCY.ID,顶级部门I为-1
	 */
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	/**
	 * 获取管理员账号ID,关联FAW.MEMBER.ID
	 */
	public Long getAdminId() {
		return adminId;
	}

	/**
	 * 设置管理员账号ID,关联FAW.MEMBER.ID
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

	/**
	 * 获取负责人ID,关联FAW.MEMBER.ID
	 */
	public Long getManagerId() {
		return managerId;
	}

	/**
	 * 设置负责人ID,关联FAW.MEMBER.ID
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	/**
	 * 获取会员数量,默认0
	 */
	public Integer getMemberCount() {
		return memberCount;
	}

	/**
	 * 设置会员数量,默认0
	 */
	public void setMemberCount(Integer memberCount) {
		this.memberCount = memberCount;
	}

	/**
	 * 获取投标数量,默认0
	 */
	public Integer getBidCount() {
		return bidCount;
	}

	/**
	 * 设置投标数量,默认0
	 */
	public void setBidCount(Integer bidCount) {
		this.bidCount = bidCount;
	}

	/**
	 * 获取中标数量,默认0
	 */
	public Integer getWinCount() {
		return winCount;
	}

	/**
	 * 设置中标数量,默认0
	 */
	public void setWinCount(Integer winCount) {
		this.winCount = winCount;
	}

	/**
	 * 获取接受数量,默认0
	 */
	public Integer getAcceptCount() {
		return acceptCount;
	}

	/**
	 * 设置接受数量,默认0
	 */
	public void setAcceptCount(Integer acceptCount) {
		this.acceptCount = acceptCount;
	}

	/**
	 * 获取创意数量,默认0
	 */
	public Integer getIdeaCount() {
		return ideaCount;
	}

	/**
	 * 设置创意数量,默认0
	 */
	public void setIdeaCount(Integer ideaCount) {
		this.ideaCount = ideaCount;
	}

}
