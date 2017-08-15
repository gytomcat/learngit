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
import cn.com.faw.crowdsourcing.model.Member;
import cn.com.faw.crowdsourcing.model.page.MemberPage;
import cn.com.faw.crowdsourcing.service.MemberService;

/**
 * 会员控制器
 */
@Controller
public class MemberController {

	/**
	 * 会员业务逻辑
	 */
	@Resource
	private MemberService service;

	/**
	 * 全部会员列表
	 * 
	 * @param page
	 *            会员分页查询对象
	 * @param map
	 *            Spring数据对象
	 * @return 会员列表模板
	 */
	@RequestMapping("/member/list")
	public String memberList(MemberPage page, ModelMap map) {
		service.loadMemberList(page);
		map.put("page", page);

		return "member/member_list";
	}

	/**
	 * 跳转至添加会员
	 * 
	 * @param map
	 *            Spring数据对象
	 * @return 添加会员页面模板
	 */
	@RequestMapping(value = "/member/add", method = RequestMethod.GET)
	public String toAddMember(ModelMap map) {
		return "member/add_member";
	}

	/**
	 * 添加会员
	 * 
	 * @param member
	 *            会员数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/member/add", method = RequestMethod.POST)
	public String addMember(Member member) {
		service.addOneMember(member);
		return "redirect:/member/list";
	}

	/**
	 * 跳转至编辑会员
	 * 
	 * @param id
	 *            会员ID
	 * @param map
	 *            Spring数据对象
	 * @return 编辑会员模板
	 */
	@RequestMapping(value = "/member/edit/{id}", method = RequestMethod.GET)
	public String toEditMember(@PathVariable Long id, ModelMap map) {
		map.put("member", service.getOneMember(id));
		return "member/edit_member";
	}

	/**
	 * 编辑会员
	 * 
	 * @param member
	 *            会员数据对象
	 * @param map
	 *            Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/member/edit", method = RequestMethod.POST)
	public String editMember(Member member, ModelMap map) {
		service.modifyOneMember(member);
		return "redirect:/member/list";
	}

	/**
	 * 删除会员
	 * 
	 * @param id
	 *            会员ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/member/remove/{id}")
	@ResponseBody
	public BaseJson removeMember(@PathVariable Long id) {
		service.removeOneMember(id);
		return new SuccessJson();
	}
	
	/**
	 * 跳转修改密码-填写新密码
	 * @return 填写新密码模板
	 */
	@RequestMapping(value ="member/update" , method = RequestMethod.GET)
	public String toMemberResetPwd() {
		System.out.println("==========跳转至填写新密码========");
		return "member/update_newpwd";
	}

}
