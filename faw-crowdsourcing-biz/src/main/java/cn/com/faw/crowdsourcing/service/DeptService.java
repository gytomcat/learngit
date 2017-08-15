package cn.com.faw.crowdsourcing.service;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.DeptDAO;
import cn.com.faw.crowdsourcing.dao.MemberDAO;
import cn.com.faw.crowdsourcing.model.Dept;
import cn.com.faw.crowdsourcing.model.Member;
import cn.com.faw.crowdsourcing.model.page.DeptPage;

/**
 * 部门业务逻辑
 */
@Service
public class DeptService {

	/**
	 * 部门DAO
	 */
	public static final Logger logger = Logger.getLogger(DeptService.class);
	@Resource
	private DeptDAO deptDAO;
	@Resource
	private MemberDAO memberDAO;
	
	
	

	/**
	 * 获取数据
	 * @param page 部门分页对象
	 */	
	public List<Dept> getDeptList(DeptPage page) {
		List<Dept>  list = deptDAO.selectDeptList(page);
		return list;
	}

	/**
	 * 查找部门列表
	 * 根据部门名称，企业ID，上级部门查询数据
	 * @param page 部门分页对象
	 * @return 部门列表
	 */
	public List<Dept> selectDept(Dept dept){
		List<Dept>  list = deptDAO.selectDept(dept);
		return list;
	}
	/**
	 * 分页查找部门列表
	 * 
	 * @param page 部门分页对象
	 */
	public void loadDeptList(DeptPage page) {
		Integer total = deptDAO.selectDeptCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setDeptList(deptDAO.selectDeptList(page));
		}
	}

	/**
	 * 添加部门
	 * 
	 * @param Dept 部门
	 */
	public void addOneDept(Dept Dept) {
		deptDAO.insertIntoDept(Dept);
	}

	/**
	 * 更新部门
	 * 
	 * @param Dept 部门
	 */
	public void modifyOneDept(Dept Dept) {
		deptDAO.updateDeptById(Dept);
	}

	/**
	 * 获取某一部门
	 * 
	 * @param id 部门ID
	 * @return 部门
	 */
	public Dept getOneDept(Long id) {
		return deptDAO.selectDeptById(id);
	}

	/**
	 * 删除部门(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 部门ID
	 */
	public void removeOneDept(Long id) {
		deptDAO.updateDeptToDisabledById(id);
	}
	
	
	/**
	 *通过获取的表格 批量导入数据
	 * */
	public int InsertJigou(Workbook wb,String qyId){
		int num = 0;
		try{
			Sheet sheet = wb.getSheetAt(0);
	        //批量导入部门信息
	        if(sheet!=null &&sheet.getLastRowNum()>0){
	    		InsertDept(sheet,qyId);
	            num=1;
	        }else{
	            num=0;        	
	        }
	        Sheet sheet1 = wb.getSheetAt(1);
	        //批量导入用户信息
	        if(sheet1!=null &&sheet1.getLastRowNum()>0){
	        	importMember(sheet1,qyId);
	        	num=1;
	        }else{
	            num=0;        	
	        }
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("DeptService-InsertJigou:"+e.getMessage());
		}
		return num;
	}
	
	/**
	 * 根据excel内容添加部门
	 * */
	public void InsertDept(Sheet sheet,String qyid){
		try{
			for(int i =1 ;i<sheet.getLastRowNum()+1 ;i++){
				// 填充上面的表格,数据需要从数据库查询
				XSSFRow row = (XSSFRow) sheet.getRow(i); // 获得工作薄的第i行
				XSSFCell cellbmmc = row.getCell(0);// 获得第i行的第1个单元格			
				//部门名称
				String bmmc = cellbmmc.getStringCellValue().trim();
				//判断部门名称是否有值并且带有上级部门： 例如：配件厂-配件队-配件一组-配件1
				if(bmmc.length()>0&&bmmc.indexOf("-")>0){
					//带有上级部门
					String bmmcZ[] = bmmc.split("-");
					//上级部门id
					long sjbmid = 0;
					for(int j=0; j < bmmcZ.length ; j++ ){
						//获取部门名称
						String mc = bmmcZ[j];
						if(j==0){
							//第一级部门
							sjbmid = -1;
							sjbmid =getSjbm(qyid,mc,sjbmid,row);
						}else {
							sjbmid =getSjbm(qyid,mc,sjbmid,row);
						}
					}
				}else{
					//只有一个部门名称时执行的方法
					long sjbmid = -1;
					sjbmid =getSjbm(qyid,bmmc,sjbmid,row);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("DeptService-InsertMember:"+e.getMessage());
		}
	}
	/**
	 * 根据企业id，部门名称，上级部门ID 查询部门表中是否存在数据
	 * 
	 * */
	public long getSjbm(String qyid,String mc,long sjbm,XSSFRow row){
		long id = 0;
		try{
			Dept dept = new Dept();
			Date now = new Date(); 
			XSSFCell deptDesc = row.getCell(1);// 获得第i行的第2个单元格	
			dept.setCreateTime(now);									//CREATE_TIME创建时间
			dept.setEnabled("Y");										//ENABLED是否有效,Y:有效,N:无效,默认N',
			dept.setCompanyId(Long.parseLong(qyid));					//COMPANY_ID企业ID,关联FAW_COMPANY.ID',
			dept.setDeptName(mc);										//DEPT_NAME部门名称',
			dept.setDeptDesc(deptDesc.getStringCellValue().trim());		//DEPT_DESC部门描述',
			dept.setDeptLevel(-1);										//DEPT_LEVEL部门级别',
			dept.setParentId(sjbm);										//PARENT_ID 上级部门IID,关联FAW_AGENCY.ID,顶级部门I为-1',
			dept.setMemberCount(0);										//MEMBER_COUNT会员数量,默认0',
			dept.setBidCount(0);										//BID_COUNT投标数量,默认0',
			dept.setWinCount(0);										//WIN_COUNT中标数量,默认0',
			dept.setAcceptCount(0);										//ACCEPT_COUNT接受数量,默认0',
			dept.setIdeaCount(0);										//IDEA_COUNT创意数量,默认0',
			List<Dept> Deptlist = selectDept(dept);
			if(Deptlist!=null&&Deptlist.size()>0){
				//判断是否存在，存在获取当前部门ID
				id = Deptlist.get(0).getId();
			}else{
				//判断不存在后，存储新数据，并获取部门id
				addOneDept(dept);
				//添加管理员用户，审核员用户
				id = dept.getId();
				insertAdminReviewer(id,Long.parseLong(qyid));
			}	
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("DeptService-getSjbm:"+e.getMessage());
		}
		return id ;
	}
	
	/**
	 * 根据excel内容添加用户
	 * */
	public void importMember(Sheet sheet,String qyid){
		try{
			for(int i =1 ;i<sheet.getLastRowNum()+1 ;i++){
				// 填充上面的表格,数据需要从数据库查询
				XSSFRow row = (XSSFRow) sheet.getRow(i); // 获得工作薄的第i行
				XSSFCell cellbmmc = row.getCell(0);// 获得第i行的第1个单元格			
				//部门名称
				String bmmc = cellbmmc.getStringCellValue().trim();
				//判断部门名称是否有值并且带有上级部门： 例如：配件厂-配件队-配件一组-配件1
				long sjbmid = 0;
				if(bmmc.length()>0&&bmmc.indexOf("-")>0){
					//带有上级部门
					String bmmcZ[] = bmmc.split("-");
					//上级部门id
					for(int j=0; j < bmmcZ.length ; j++ ){
						//获取部门名称
						String mc = bmmcZ[j];
						if(j==0){
							//第一级部门
							sjbmid = -1;
							sjbmid =getSjbm(qyid,mc,sjbmid,row);
						}else {
							sjbmid =getSjbm(qyid,mc,sjbmid,row);
						}
					}
				}else{
					//只有一个部门名称时执行的方法
					sjbmid = -1;
					sjbmid =getSjbm(qyid,bmmc,sjbmid,row);
				}
				if(sjbmid!=0){
					insertMember(sjbmid,Long.parseLong(qyid),row);
				}
			}			
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("DeptService-InsertMemberDept:"+e.getMessage());
		}
	}
	/**
	 * 添加用户信息
	 * */
	public void insertMember(long agencyId,long companyId,XSSFRow row){
		try{
			XSSFCell loginId = row.getCell(1);// 获得第i行的第2个单元格	
			XSSFCell loginPasswd = row.getCell(2);// 获得第i行的第3个单元格	
			XSSFCell fullName = row.getCell(3);// 获得第i行的第4个单元格	
			XSSFCell mobileNo = row.getCell(4);// 获得第i行的第5个单元格	
			XSSFCell memberDesc= row.getCell(5);// 获得第i行的第6个单元格	
			XSSFCell isfuzeren= row.getCell(6);// 获得第i行的第7个单元格	  是否选择是负责人
			//出现科学计数法 转换类型
			DecimalFormat df = new DecimalFormat("0");  
			String cellValue = df.format(mobileNo.getNumericCellValue());
			Member member = new Member();
			member.setCompanyId(companyId);									//企业ID,关联FAW_COMPANY.ID',
			member.setAgencyId(agencyId);									//组织ID,关联FAW_AGENCY.ID',
			member.setLoginId(loginId.getStringCellValue().trim());			//用户名
			member.setLoginPasswd(loginPasswd.getStringCellValue().trim());	//密码
			member.setFullName(fullName.getStringCellValue().trim());		//姓名
			member.setMobileNo(cellValue);		//联系电话
			member.setMemberDesc(memberDesc.getStringCellValue().trim());	//用户描述
			Date now = new Date(); 
			member.setCreateTime(now);										//CREATE_TIME创建时间
			member.setRegisterTime(now);									//REGISTER_TIME注册时间
			member.setReviewTime(now);										//REVIEW_TIME审核时间
			member.setEnabled("Y");											//ENABLED是否有效,Y:有效,N:无效,默认N',
			member.setNowStatus(0);											//NOW_STATUS用户状态:0.正常,1.待审核,2:拒绝.默认1',
			member.setMemberType(1);										//MEMBER_TYPE用户类型.1:批量导入,2:注册,默认1',
			member.setIsFirstLogin("Y");									//IS_FIRST_LOGIN是否初次登录,Y:初次,N:非初次,默认Y',
			member.setMemberRole(1);										//MEMBER_ROLE'用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1',
			member.setTagCount(0);											//TAG_COUNT标签数量,默认0',
			member.setBidCount(0);											//BID_COUNT投标数量,默认0',
			member.setWinCount(0);											//WIN_COUNT中标数量,默认0',
			member.setInviteCount(0);										//INVITE_COUNT被邀请数量,默认0',
			member.setAcceptCount(0);										//ACCEPT_COUNT接受数量,默认0',
			member.setIdeaCount(0);											//IDEA_COUNT创意数量,默认0',
			member.setBbsPoint(0);											//BBS_POINT论坛积分,默认0',
			memberDAO.insertIntoMember(member);
			long id = member.getId();
			if(isfuzeren!=null){
				Dept dept = getOneDept(agencyId);
				if(dept!=null){
					//判断是否存在，存在获取当前部门ID
					dept.setManagerId(id);
					modifyOneDept(dept);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("DeptService-insertMember:"+e.getMessage());
		}
		
	}
	/**
	 * 添加管理员用户，审核员用户
	 * */
	public void insertAdminReviewer(long agencyId,long companyId){
		try{
			//添加管理员
			Member member = new Member();
			member.setCompanyId(companyId);									//企业ID,关联FAW_COMPANY.ID',
			member.setAgencyId(agencyId);									//组织ID,关联FAW_AGENCY.ID',
			String loginAdmin = "admin" +companyId+agencyId;
			member.setLoginId(loginAdmin);										//用户名
			member.setLoginPasswd("0000");									//密码
			Date now = new Date(); 
			member.setCreateTime(now);										//CREATE_TIME创建时间
			member.setRegisterTime(now);									//REGISTER_TIME注册时间
			member.setReviewTime(now);										//REVIEW_TIME审核时间
			member.setEnabled("Y");											//ENABLED是否有效,Y:有效,N:无效,默认N',
			member.setNowStatus(0);											//NOW_STATUS用户状态:0.正常,1.待审核,2:拒绝.默认1',
			member.setMemberType(1);										//MEMBER_TYPE用户类型.1:批量导入,2:注册,默认1',
			member.setIsFirstLogin("Y");									//IS_FIRST_LOGIN是否初次登录,Y:初次,N:非初次,默认Y',
			member.setMemberRole(2);										//MEMBER_ROLE'用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1',
			member.setTagCount(0);											//TAG_COUNT标签数量,默认0',
			member.setBidCount(0);											//BID_COUNT投标数量,默认0',
			member.setWinCount(0);											//WIN_COUNT中标数量,默认0',
			member.setInviteCount(0);										//INVITE_COUNT被邀请数量,默认0',
			member.setAcceptCount(0);										//ACCEPT_COUNT接受数量,默认0',
			member.setIdeaCount(0);											//IDEA_COUNT创意数量,默认0',
			member.setBbsPoint(0);											//BBS_POINT论坛积分,默认0',
			memberDAO.insertIntoMember(member);
			//添加审核员
			Member member1 = new Member();
			member1.setCompanyId(companyId);									//企业ID,关联FAW_COMPANY.ID',
			member1.setAgencyId(agencyId);									//组织ID,关联FAW_AGENCY.ID',
			String loginReviewer = "reviewer" +companyId+agencyId;
			member1.setLoginId(loginReviewer);										//用户名
			member1.setLoginPasswd("0000");									//密码
			member1.setCreateTime(now);										//CREATE_TIME创建时间
			member1.setRegisterTime(now);									//REGISTER_TIME注册时间
			member1.setReviewTime(now);										//REVIEW_TIME审核时间
			member1.setEnabled("Y");										//ENABLED是否有效,Y:有效,N:无效,默认N',
			member1.setNowStatus(0);										//NOW_STATUS用户状态:0.正常,1.待审核,2:拒绝.默认1',
			member1.setMemberType(1);										//MEMBER_TYPE用户类型.1:批量导入,2:注册,默认1',
			member1.setIsFirstLogin("Y");									//IS_FIRST_LOGIN是否初次登录,Y:初次,N:非初次,默认Y',
			member1.setMemberRole(3);										//MEMBER_ROLE'用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1',
			member1.setTagCount(0);											//TAG_COUNT标签数量,默认0',
			member1.setBidCount(0);											//BID_COUNT投标数量,默认0',
			member1.setWinCount(0);											//WIN_COUNT中标数量,默认0',
			member1.setInviteCount(0);										//INVITE_COUNT被邀请数量,默认0',
			member1.setAcceptCount(0);										//ACCEPT_COUNT接受数量,默认0',
			member1.setIdeaCount(0);										//IDEA_COUNT创意数量,默认0',
			member1.setBbsPoint(0);											//BBS_POINT论坛积分,默认0',
			memberDAO.insertIntoMember(member1);
			long adminId = member.getId();
			long reviewerId = member.getId();
			Dept dept = getOneDept(agencyId);
			if(dept!=null){
				//判断是否存在，存在获取当前部门ID
				dept.setAdminId(adminId);
				dept.setReviewerId(reviewerId);
				modifyOneDept(dept);
			}
		}catch (Exception e) {
			e.printStackTrace();
			logger.debug("DeptService-insertAdminReviewer:"+e.getMessage());
		}
	}
}
