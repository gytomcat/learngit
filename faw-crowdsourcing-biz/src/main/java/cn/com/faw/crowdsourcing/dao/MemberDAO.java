package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Member;
import cn.com.faw.crowdsourcing.model.page.MemberPage;

/**
 * 会员DAO(表名: FAW_MEMBER)
 */
@Repository
public interface MemberDAO {

	/**
	 * 查找会员数量
	 * 
	 * @param page 会员分页对象
	 * @return 会员数量
	 */
	Integer selectMemberCount(MemberPage page);

	/**
	 * 查找会员列表
	 * 
	 * @param page 会员分页对象
	 * @return 会员列表
	 */
	List<Member> selectMemberList(MemberPage page);

	/**
	 * 根据ID查找会员
	 * 
	 * @param id 会员id
	 * @return 会员
	 */
	Member selectMemberById(Long id);

	/**
	 * 添加会员
	 * 
	 * @param member 会员
	 */
	Integer insertIntoMember(Member member);
	
	/**
	 * 根据用户名与手机号
	 * 
	 * @param id 会员id
	 * @return 会员
	 */
	Integer selectMemberByNameAndTel(Member member);
	
	/**
	 * 根据ID更新会员密码
	 * 
	 * @param member 会员
	 * @return 更新成功条数
	 */
	Integer updateMemberPwdById(Member member);
	
	/**
	 * 根据ID更新会员资料
	 * 
	 * @param member 会员
	 * @return 更新成功条数
	 */
	Integer updateMemberInfoById(Member member);

	/**
	 * 根据ID更新会员
	 * 
	 * @param member 会员
	 * @return 更新成功条数
	 */
	Integer updateMemberById(Member member);

	/**
	 * 根据ID删除会员(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 会员id
	 * @return 会员成功数量
	 */
	Integer updateMemberToDisabledById(Long id);

}
