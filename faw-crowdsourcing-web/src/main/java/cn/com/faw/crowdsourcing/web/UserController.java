package cn.com.faw.crowdsourcing.web;

import java.io.File;
import java.util.Date;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.ErrorJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.common.util.Mail;
import cn.com.faw.crowdsourcing.model.Member;
import cn.com.faw.crowdsourcing.model.Sms;
import cn.com.faw.crowdsourcing.service.MemberService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	public static final Logger logger = Logger.getLogger(UserController.class);
	
	@Resource
	private MemberService service;

	/**
	 * 跳转至注册用户
	 * 
	 * @return 注册用户模板
	 */
	@RequestMapping(value = "toUserReg", method = RequestMethod.GET)
	public String toUserReg() {
		System.out.println("==========跳转至注册用户========");
		return "user/user_reg";
	}

	/**
	 * 注册用户
	 * 
	 * @return 注册用户模板
	 */
	@RequestMapping("addUserReg")
	@ResponseBody
	public BaseJson addUserReg(Member member, String code,
			HttpServletRequest request) {
		System.out.println("==========添加用户信息========");
		int result = 0;
		try {
			// 这里应该通过邀请码判断用户是否可以注册
			Sms smsEntity = (Sms) request.getServletContext().getAttribute(
					"email_" + code);
			// 如果不可注册返回失败
			if (null == smsEntity) {
				return new ErrorJson("邀请码无效，请重新验证");
			}
			// 验证时效性
			Long nowTime = new Date().getTime();
			Long beforeTime = smsEntity.getCreateDate();
			Long between = (nowTime - beforeTime) / 1000;
			Long min = between / 60;
			if (min > 180) {
				return new ErrorJson("邀请码过期，请重新验证");
			}
			// 如果成功获取生成验证码时候的企业ID,组织ID,邀请人ID,用户角色,
			member.setCompanyId(smsEntity.getCompanyId());
			member.setAgencyId(smsEntity.getAgencyId());
			// member.setInviterId(smsEntity.getInviterId());
			member.setInviterId((long) 1);
			result = service.addOneMember(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("UserController-addUserReg:"+e.getMessage());
		}
		if (result == 0) {
			return new ErrorJson();
		} else {
			return new SuccessJson();
		}
	}
	
	/**
	 * 跳转忘记密码
	 * 
	 * @return 忘记密码模板
	 */
	@RequestMapping(value = "toUserCheck", method = RequestMethod.GET)
	public String toUserReset() {
		System.out.println("==========跳转至忘记密码========");
		return "user/user_reset";
	}

	/**
	 * 验证用户是否有效
	 * @return 验证用户信息
	 */
	@RequestMapping("getUserCheck")
	@ResponseBody
	public BaseJson getUserCheck(Member member) {
		int result = service.selectMemberByNameAndTel(member);
		if (result == 0) {
			return new ErrorJson();
		} else {
			return new SuccessJson();
		}
	}

	/**
	 * 跳转忘记密码-填写新密码
	 * 
	 * @return 填写新密码模板
	 */
	@RequestMapping(value = "toUserResetPwd", method = RequestMethod.GET)
	public String toUserResetPwd() {
		System.out.println("==========跳转至填写新密码========");
		return "user/user_reset_newpwd";
	}

	/**
	 * 更新密码
	 * 
	 * @return 更新密码
	 */
	@RequestMapping("updateUserReset")
	@ResponseBody
	public BaseJson updateUserReset(Member member) {
		int result = service.modifyOneMemberPwd(member);
		if (result == 0) {
			return new ErrorJson();
		} else {
			return new SuccessJson();
		}
	}

	/**
	 * 跳转个人资料
	 * 
	 * @return 个人资料模板
	 */
	@RequestMapping(value = "toUserInfo", method = RequestMethod.GET)
	public String toUserInfo() {
		System.out.println("==========个人资料========");
		return "user/user_info";
	}

	/**
	 * 修改个人资料
	 * 
	 * @return 修改个人资料模板
	 */
	@RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson updateUserInfo(String id, String loginId, String fullName,
			String age, String portrial, String gender, String mobileNo,
			HttpServletRequest request, HttpServletResponse response) {
		System.out.println("==========修改个人资料========");
		int result = 0;
		try {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			MultipartFile file = multipartRequest.getFile("file1");
			String filename = "";
			if (!file.isEmpty()) {
				try {
					filename = "upload/"
							+ loginId
							+ "_portrial"
							+ file.getOriginalFilename()
									.substring(
											file.getOriginalFilename()
													.lastIndexOf("."));
					// 文件保存路径
					String filePath = request.getSession().getServletContext()
							.getRealPath("/")
							+ filename;
					file.transferTo(new File(filePath));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			// 将修改的参数赋值
			Member member = new Member();
			member.setId(Long.parseLong(id));
			member.setLoginId(loginId);
			member.setFullName(fullName);
			member.setAge(Integer.parseInt(age));
			member.setPortrial(filename);
			member.setGender(gender);
			member.setMobileNo(mobileNo);
			result = service.modifyOneMemberInfo(member);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("UserController-updateUserInfo:"+e.getMessage());
		}
		if (result == 0) {
			return new ErrorJson();
		} else {
			return new SuccessJson();
		}

	}

	/**
	 * 跳转至生成邀请码
	 * 
	 * @return 声称验证码模板
	 */
	@RequestMapping(value = "toInviteCode", method = RequestMethod.GET)
	public String toInviteCode() {
		System.out.println("==========跳转至生成验证码========");
		return "user/user_invitecode";
	}

	/**
	 * 生成邀请码并发送邮件
	 * 
	 * @return 生成邀请码并发送邮件
	 */
	@RequestMapping("addInviteCode")
	@ResponseBody
	public BaseJson addInviteCode(Sms sms, HttpServletRequest request) {
		System.out.println("==========生成验证码========");
		int result = 0;
		Mail mail = new Mail();
		try {
			// 生成验证码
			StringBuilder sb = new StringBuilder();
			Random rand = new Random();
			sb.append(rand.nextInt(899999) + 100000);
			String code = sb.toString();
			// 填充对象
			Sms smsEntity = new Sms();
			smsEntity.setCode(code);
			smsEntity.setCompanyId(sms.getCompanyId());
			smsEntity.setAgencyId(sms.getAgencyId());
			Long nowTime = new Date().getTime();
			smsEntity.setCreateDate(nowTime);
			// smsEntity.setInviterId("获取发送时候登录系统人员的id，此id应在登录后设为常量");
			// 保存在session中
			request.getServletContext()
					.setAttribute("email_" + code, smsEntity);
			String regHttp = "https://www.baidu.com";
			String codeMsg = "为验证权限，请在注册页面:" + regHttp
					+ " \r\n输入下方的邀请码：\r\n\r\n " + code
					+ "\r\n\r\n邀请码将会在此邮件送出后三小时失效。\r\n如果您并没有提出注册要求，您可以忽略此邮件。"
					+ "\r\n软件唯有输入邀请码后才可注册";
			result = mail.sendMail(sms.getEmail(), "邀请注册", codeMsg);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.debug("UserController-addInviteCode:"+e.getMessage());
		}
		if (result == 0) {
			return new ErrorJson();
		} else {
			return new SuccessJson();
		}
	}
}
