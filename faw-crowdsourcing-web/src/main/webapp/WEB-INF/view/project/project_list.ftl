<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发布项目列表页</title>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/**
			 * 审核通过
			 */
			$(".auditPass").click(function(){
				var projectId = $(this).attr("projectId");
				if(confirm("是否确认审核通过？")){
					$.ajax({
						url : "${webServer}/project/release/audit",
						type : "post",
						data : {
							projectId : projectId,
							changeStatus : 1
						},
						success : function(data){
							alert("操作成功");
							location.reload();
						},
						error : function(){
							alert("操作失败,请重试或联系管理员");
							location.reload();
						}
						
					});
				}
			});
			
			/**
			 * 审核不通过
			 */
			$(".auditNotPass").click(function(){
				var projectId = $(this).attr("projectId");
				if(confirm("是否确认审核不通过？")){
					$.ajax({
						url : "${webServer}/project/release/audit",
						type : "post",
						data : {
							projectId : projectId,
							changeStatus : -2
						},
						success : function(data){
							alert("操作成功");
							location.reload();
						},
						error : function(){
							alert("操作失败,请重试或联系管理员");
							location.reload();
						}
						
					});
				}
			});
			
			/**
			 * 取消
			 */
			$(".cancelProject").click(function(){
				var projectId = $(this).attr("projectId");
				if(confirm("是否确认取消该项目？")){
					$.ajax({
						url : "${webServer}/project/cancel/" + projectId,
						type : "post",
						success : function(data){
							alert("操作成功");
							location.reload();
						},
						error : function(){
							alert("操作失败,请重试或联系管理员");
							location.reload();
						}
						
					});
				}
			});
		});
	</script>
</head>
<body>
<form action="${webServer}/project/release/list" method="get">
	<p><a href="${webServer}/project/release/add">发布项目</a></p>
	<table>
		<tr>
			<td>序号</td>
			<td>发布时间</td>
			<td>标题</td>
			<td>发布企业</td>
			<td>价格</td>
			<td>截止日期</td>
			<td>制作周期（月）</td>
			<td>当前状态</td>
			<td>操作</td>
		</tr>
		<#list page.projectList as project>
		<tr>
			<td>${project_index + 1}</td>
			<td>
				<#if project.releaseTime ??>
					${project.releaseTime?string("yyyy-MM-dd")}
				</#if>
			</td>
			<td>${project.projectTitle}</td>
			<td>${project.companyName}</td>
			<td>${project.price?string(",###0.00#")}</td>
			<td>${project.bidEndTime?string("yyyy-MM-dd ")}</td>
			<td>${project.period}</td>
			<td>
			 <#if project.nowStatus == -8>
			 	已过期
			 <#elseif project.nowStatus == -9>
			 	已取消
			 <#elseif project.nowStatus == -1>
			 	待审核
			 <#elseif project.nowStatus == -2>
			 	审核未通过
			 <#elseif project.nowStatus == 0>
			 	已完成
			 <#elseif project.nowStatus == 1>
			 	招标中
			 <#elseif project.nowStatus == 2>
			 	选标中
			 <#elseif project.nowStatus == 3>
			 	已选标,待审核
			 <#elseif project.nowStatus == 4>
			 	审核成功待确认
			 <#elseif project.nowStatus == 5>
			 	选标审核未通过
			 <#elseif project.nowStatus == 6>
				已确认,生产中
			 <#elseif project.nowStatus == 7>
			 	待验收
			 <#elseif project.nowStatus == 8>
				验收失败
			 <#elseif project.nowStatus == 9>
				已评分
			 </#if>
			</td>
			<td>
				<a href="${webServer}/project/release/detail/${project.id}">查看</a> 
				<#--未审核-->
				<#if project.nowStatus == -1>
				| <a href="javascript:;" class="auditPass" projectId="${project.id}">审核通过</a> 
				| <a href="javascript:;" class="auditNotPass" projectId="${project.id}">审核未通过</a>
				</#if>
				<#-- 招标中 -->
				<#if project.nowStatus == 1>
				| <a href="${webServer}/project/service/list?projectId=${project.id}">招标</a> 
				</#if>
				<#if project.nowStatus &gt; 0 && project.nowStatus &lt; 3>
				| <a href="javascript:;" class="cancelProject" projectId="${project.id}">取消项目</a> 
				</#if>
				<#if project.nowStatus == 3>
				| <a href="${webServer}/project/detail/${project.id}">选标审核</a> 
				</#if>
			</td>
		</tr>
		</#list>
		<#if page.totalPage gte 1>
			<@layout.pagination />
		</#if>
	</table>
</form>
</body>
</html>