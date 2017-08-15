package cn.com.faw.crowdsourcing.model;

import java.util.Date;

import cn.com.faw.crowdsourcing.common.BaseModel;

/**
 * 会员ORM数据对象(Table: FAW_MEMBER)
 */
public class Member extends BaseModel {

    /**
     * 用户角色：1.普通会员
     */
    public static final int NOMAL_USER = 1;

    /**
     * 用户角色：2:管理员
     */
    public static final int ADMIN = 2;

    /**
     * 用户角色：3:审核员
     */
    public static final int AUDITER = 3;

    /**
     * 用户角色：4专家
     */
    public static final int EXPERT = 4;

    /**
     * 用户状态:0.正常
     */
    public static final int USEFUL = 0;

    /**
     * 用户状态:1.待审核
     */
    public static final int WAITING_AUDIT = 1;

    /**
     * 用户状态:2:已拒绝
     */
    public static final int REFUSED = 2;

    /**
     * 用户类型.1:批量导入
     */
    public static final int USER_IMPORT = 1;

    /**
     * 用户类型.2:注册
     */
    public static final int USER_REG = 2;

    // 注册时间(Column: REGISTER_TIME)
    private Date registerTime;

    // 审核时间(Column: REVIEW_TIME)
    private Date reviewTime;

    // 用户状态:0.正常,1.待审核,2:拒绝.默认1(Column: NOW_STATUS)
    private Integer nowStatus;

    // 用户类型.1:批量导入,2:注册,默认1(Column: MEMBER_TYPE)
    private Integer memberType;

    // 用户名(Column: LOGIN_ID)
    private String loginId;

    // 密码(Column: LOGIN_PASSWD)
    private String loginPasswd;

    // 是否初次登录,Y:初次,N:非初次,默认Y(Column: IS_FIRST_LOGIN)
    private String isFirstLogin;

    // 企业ID,关联FAW_COMPANY.ID(Column: COMPANY_ID)
    private Long companyId;

    // 组织ID,关联FAW_AGENCY.ID(Column: AGENCY_ID)
    private Long agencyId;

    // 用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1(Column: MEMBER_ROLE)
    private Integer memberRole;

    // 姓名(Column: FULL_NAME)
    private String fullName;

    // 年龄(Column: AGE)
    private Integer age;

    // 职称(Column: TITLE)
    private String title;

    // 头像(Column: PORTRIAL)
    private String portrial;

    // 性别.M:男,F:女(Column: GENDER)
    private String gender;

    // 联系电话(Column: MOBILE_NO)
    private String mobileNo;

    // 标签数量,默认0(Column: TAG_COUNT)
    private Integer tagCount;

    // 用户描述(Column: MEMBER_DESC)
    private String memberDesc;

    // 投标数量,默认0(Column: BID_COUNT)
    private Integer bidCount;

    // 中标数量,默认0(Column: WIN_COUNT)
    private Integer winCount;

    // 被邀请数量,默认0(Column: INVITE_COUNT)
    private Integer inviteCount;

    // 接受数量,默认0(Column: ACCEPT_COUNT)
    private Integer acceptCount;

    // 创意数量,默认0(Column: IDEA_COUNT)
    private Integer ideaCount;

    // 论坛积分,默认0(Column: BBS_POINT)
    private Integer bbsPoint;

    // 邀请人ID,关联FAW_MEMBER.ID,导入用户为-1(Column: INVITER_ID)
    private Long inviterId;

    /**
     * 获取注册时间
     */
    public Date getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册时间
     */
    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    /**
     * 获取审核时间
     */
    public Date getReviewTime() {
        return reviewTime;
    }

    /**
     * 设置审核时间
     */
    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    /**
     * 获取用户状态:0.正常,1.待审核,2:拒绝.默认1
     */
    public Integer getNowStatus() {
        return nowStatus;
    }

    /**
     * 设置用户状态:0.正常,1.待审核,2:拒绝.默认1
     */
    public void setNowStatus(Integer nowStatus) {
        this.nowStatus = nowStatus;
    }

    /**
     * 获取用户类型.1:批量导入,2:注册,默认1
     */
    public Integer getMemberType() {
        return memberType;
    }

    /**
     * 设置用户类型.1:批量导入,2:注册,默认1
     */
    public void setMemberType(Integer memberType) {
        this.memberType = memberType;
    }

    /**
     * 获取用户名
     */
    public String getLoginId() {
        return loginId;
    }

    /**
     * 设置用户名
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    /**
     * 获取密码
     */
    public String getLoginPasswd() {
        return loginPasswd;
    }

    /**
     * 设置密码
     */
    public void setLoginPasswd(String loginPasswd) {
        this.loginPasswd = loginPasswd;
    }

    /**
     * 获取是否初次登录,Y:初次,N:非初次,默认Y
     */
    public String getIsFirstLogin() {
        return isFirstLogin;
    }

    /**
     * 设置是否初次登录,Y:初次,N:非初次,默认Y
     */
    public void setIsFirstLogin(String isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

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
     * 获取组织ID,关联FAW_AGENCY.ID
     */
    public Long getAgencyId() {
        return agencyId;
    }

    /**
     * 设置组织ID,关联FAW_AGENCY.ID
     */
    public void setAgencyId(Long agencyId) {
        this.agencyId = agencyId;
    }

    /**
     * 获取用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1
     */
    public Integer getMemberRole() {
        return memberRole;
    }

    /**
     * 设置用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1
     */
    public void setMemberRole(Integer memberRole) {
        this.memberRole = memberRole;
    }

    /**
     * 获取姓名
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 设置姓名
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 获取年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取职称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置职称
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取头像
     */
    public String getPortrial() {
        return portrial;
    }

    /**
     * 设置头像
     */
    public void setPortrial(String portrial) {
        this.portrial = portrial;
    }

    /**
     * 获取性别.M:男,F:女
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置性别.M:男,F:女
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取联系电话
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * 设置联系电话
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * 获取标签数量,默认0
     */
    public Integer getTagCount() {
        return tagCount;
    }

    /**
     * 设置标签数量,默认0
     */
    public void setTagCount(Integer tagCount) {
        this.tagCount = tagCount;
    }

    /**
     * 获取用户描述
     */
    public String getMemberDesc() {
        return memberDesc;
    }

    /**
     * 设置用户描述
     */
    public void setMemberDesc(String memberDesc) {
        this.memberDesc = memberDesc;
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
     * 获取被邀请数量,默认0
     */
    public Integer getInviteCount() {
        return inviteCount;
    }

    /**
     * 设置被邀请数量,默认0
     */
    public void setInviteCount(Integer inviteCount) {
        this.inviteCount = inviteCount;
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

    /**
     * 获取论坛积分,默认0
     */
    public Integer getBbsPoint() {
        return bbsPoint;
    }

    /**
     * 设置论坛积分,默认0
     */
    public void setBbsPoint(Integer bbsPoint) {
        this.bbsPoint = bbsPoint;
    }

    /**
     * 获取邀请人ID,关联FAW_MEMBER.ID,导入用户为-1
     */
    public Long getInviterId() {
        return inviterId;
    }

    /**
     * 设置邀请人ID,关联FAW_MEMBER.ID,导入用户为-1
     */
    public void setInviterId(Long inviterId) {
        this.inviterId = inviterId;
    }

}
