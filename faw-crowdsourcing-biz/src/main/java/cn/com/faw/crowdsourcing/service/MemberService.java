package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.MemberDAO;
import cn.com.faw.crowdsourcing.model.Member;
import cn.com.faw.crowdsourcing.model.page.MemberPage;

/**
 * 会员业务逻辑
 */
@Service
public class MemberService {

	/**
	 * 会员DAO
	 */
	@Resource
	private MemberDAO memberDAO;

	/**
	 * 分页查找会员列表
	 * 
	 * @param page 会员分页对象
	 */
	public void loadMemberList(MemberPage page) {
		Integer total = memberDAO.selectMemberCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setMemberList(memberDAO.selectMemberList(page));
		}
	}

	/**
	 * 添加会员
	 * 
	 * @param member 会员
	 */
	public Integer addOneMember(Member member) {
		return memberDAO.insertIntoMember(member);
	}
	
	/**
	 * 根据用户名与手机号码查询用户是否存在
	 * @param loginId 用户民
	 * @param mobileNo 手机号
	 * @return
	 */
	public Integer selectMemberByNameAndTel(Member member){
		return memberDAO.selectMemberByNameAndTel(member);
	}

	/**
	 * 更新会员
	 * 
	 * @param member 会员
	 */
	public Integer modifyOneMember(Member member) {
		return memberDAO.updateMemberById(member);
	}
	
	/**
	 * 更新会员密码
	 * 
	 * @param member 会员
	 */
	public Integer modifyOneMemberPwd(Member member) {
		return memberDAO.updateMemberPwdById(member);
	}
	
	/**
	 * 更新会员资料
	 * 
	 * @param member 会员
	 */
	public Integer modifyOneMemberInfo(Member member) {
		return memberDAO.updateMemberInfoById(member);
	}
	
	
	/**
	 * 获取某一会员
	 * 
	 * @param id 会员ID
	 * @return 会员
	 */
	public Member getOneMember(Long id) {
		return memberDAO.selectMemberById(id);
	}

	/**
	 * 删除会员(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 会员ID
	 */
	public void removeOneMember(Long id) {
		memberDAO.updateMemberToDisabledById(id);
	}

}
