package cn.com.faw.crowdsourcing.model;



public class Sms {
	//收件人邮箱
	private String email;
	//邀请码
	private String code;
	//被邀请时的创建时间
	private long createDate;
	//企业id
	private long companyId;
	//组织id
	private long agencyId;
	//邀请人id
	private Long inviterId;
	
	
	public Long getInviterId() {
		return inviterId;
	}
	public void setInviterId(Long inviterId) {
		this.inviterId = inviterId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public long getCreateDate() {
		return createDate;
	}
	public void setCreateDate(long createDate) {
		this.createDate = createDate;
	}
	public long getCompanyId() {
		return companyId;
	}
	public void setCompanyId(long companyId) {
		this.companyId = companyId;
	}
	public long getAgencyId() {
		return agencyId;
	}
	public void setAgencyId(long agencyId) {
		this.agencyId = agencyId;
	}
}
