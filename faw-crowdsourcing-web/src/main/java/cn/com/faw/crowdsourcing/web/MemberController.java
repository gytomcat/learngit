package cn.com.faw.crowdsourcing.web;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.ErrorJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.model.Dept;
import cn.com.faw.crowdsourcing.model.Member;
import cn.com.faw.crowdsourcing.model.page.DeptPage;
import cn.com.faw.crowdsourcing.model.page.MemberPage;
import cn.com.faw.crowdsourcing.service.DeptService;
import cn.com.faw.crowdsourcing.service.MemberService;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/**
 * 会员控制器
 */
@Controller
public class MemberController {

	/**
	 * 会员业务逻辑
	 */
	public static final Logger logger = Logger.getLogger(MemberController.class);
	@Resource
	private MemberService service;
	@Resource	
	private DeptService deptService;
	/**
	 * 访问导入机构用户页  个人中心点击[导入机构]链接
	 * @throws IOException 
	 */
	@RequestMapping(value = "/member/import", method = RequestMethod.GET)
	public String toImportMember(ModelMap map) throws IOException {
		//service.modifyOneMember(member);
		String num = "";
		num="1";
		return "/member/member_import";
	}
	/**
	 * 导入组织机构/用户 导入机构页中点击[批量导入]按钮
	 * @throws IOException 
	 */
	@RequestMapping(value = "member/import", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson importMember(HttpServletRequest request,HttpServletResponse response) throws Exception{
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile file = multipartRequest.getFile("upLoadFile");
		String filePath = "";
		if (!file.isEmpty()) {
			try {
				String filename = "upload/model"+file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
				// 文件保存路径
				filePath = request.getSession().getServletContext().getRealPath("/") + filename;
				file.transferTo(new File(filePath));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		File execlfile = new File(filePath); 
        FileInputStream execlstream = new FileInputStream(execlfile);
        Workbook wb = new XSSFWorkbook(execlstream);
        int num=deptService.InsertJigou(wb, "1");
        if (num == 0) {
			return new ErrorJson();
		} else {
			return new SuccessJson();
		}
	}
	
	
	
	/**
	 * 下载组织机构模板  个人中心点击[下载导入模板]链接
	 * @param member
	 * @param map
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/member/template", method = RequestMethod.GET)
	public void uploadMember(HttpServletRequest request,HttpServletResponse response, ModelMap map)throws Exception {
		String filename = request.getSession().getServletContext().getRealPath("static/data/model.xls"); // 生成文件的文件名称 这个需要动态的获取
        System.out.println(filename);
        String fileName = "模板";
        OutputStream out;// 输出响应正文的输出流
        InputStream in;// 读取本地文件的输入流
        // 获得本地输入流
        File file = new File(filename);
        in = new FileInputStream(file);
        // 设置响应正文的MIME类型
        response.setContentType("Content-Disposition;charset=GB2312");
        response.setHeader("Content-Disposition", "attachment;" + " filename="+ new String(fileName.getBytes(), "ISO-8859-1")+ ".xls");
        // 把本地文件发送给客户端
        out = response.getOutputStream();
        int byteRead = 0;
        byte[] buffer = new byte[512];
        while ((byteRead = in.read(buffer)) != -1) {
            out.write(buffer, 0, byteRead);
        }
        in.close();
        out.close();
	}
	

	/**
	 * 访问用户列表  个人中心点击[用户管理]链接
	 * @param member
	 * @param map
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public String listMember(MemberPage page, ModelMap map) {
//		try{
//			service.loadMemberList(page);
//			if(page!=null&&page.getMemberList()!=null){
//				map.put("page", page);
//			}	
//		}catch (Exception e) {
//			e.printStackTrace();
//		}			
		return "/member/member_list";
	}
	

	/**
	 * 审核新用户 用户列表页点击[通过]按钮
	 * @param member
	 * @param map
	 * @return 
	 */
	@RequestMapping(value = "/member/approve", method = RequestMethod.GET)
	public String approveMember(Member member, ModelMap map) {
		member.setEnabled("Y");
		Date now = new Date(); 
		member.setReviewTime(now);
		member.setNowStatus(0);
		service.modifyOneMember(member);
		return "/member/member_approve";
	}

	/**
	 * 拒绝新用户  用户列表页点击[拒绝]按钮
	 * @param member
	 * @param map
	 * @return 
	 */
	@RequestMapping(value = "/member/refuse", method = RequestMethod.GET)
	public String refuseMember(Member member, ModelMap map) {
		Date now = new Date(); 
		member.setReviewTime(now);
		member.setNowStatus(2);
		service.modifyOneMember(member);
		return "/member/member_refuse";
	}
}
