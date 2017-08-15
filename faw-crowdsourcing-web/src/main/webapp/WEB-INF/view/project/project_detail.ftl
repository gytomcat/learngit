<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>项目详情页</title>
	
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/**
			 * 上传投标文件
			 */
			$("#submitScore").click(function(){
				if(confirm("是否确认添加评分和专利？")){
					$("#scoreForm").submit();
				}
			});
			/**
			 * 上传投标文件
			 */
			$("#uploadBidFile").click(function(){
				if($("#bidFile").val() == ""){
					alert("请选择需要上传的文件");
					return;
				}
				
				if(confirm("是否确认上传项目相关文件？")){
					$("#aceptBidForm").submit();
				}
			});
			
			/**
			 * 选标
			 */
			$(".chooseBid").click(function(){
				var bidId = $(this).attr("bidId");
				var projectId = $("#projectId").val();
				if(confirm("是否确认选标此服务商？")){
					$.ajax({
						url : "${webServer}/project/service/select",
						type : "post",
						data : {
							bidId : bidId,
							projectId : projectId
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
			 * 审核选标通过
			 */
			$("#auditSucc").click(function(){
				var projectId = $("#projectId").val();
				if(confirm("是否确认此项目选标审核通过")){
					$.ajax({
						url : "${webServer}/project/service/audit",
						type : "post",
						data : {
							projectId : projectId,
							changeStatus : 4,
							bidStatus : 6
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
			 * 审核选标不通过
			 */
			$("#auditFail").click(function(){
				var projectId = $("#projectId").val();
				if(confirm("是否确认此项目选标审核不通过")){
					$.ajax({
						url : "${webServer}/project/service/audit",
						type : "post",
						data : {
							projectId : projectId,
							changeStatus : 5,
							bidStatus : 7
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
			 * 删除投标文件
			 */
			$(".removeDocFile").click(function(){
				var fileId = $(this).attr("fileId");
				if(confirm("是否确认删除该项目文件？")){
					$.ajax({
						url : "${webServer}/project/doc/remove",
						type : "post",
						data : {
							fileId : fileId
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
			 * 验收通过
			 */
			$("#acceptSucc").click(function(){
				var projectId = $("#projectId").val();
				if(confirm("是否确认此项目选标审核通过")){
					$.ajax({
						url : "${webServer}/project/result/success",
						type : "post",
						data : {
							projectId : projectId
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
			 * 验收失败
			 */
			$("#acceptFail").click(function(){
				var projectId = $("#projectId").val();
				if(confirm("是否确认此项目选标审核通过")){
					$.ajax({
						url : "${webServer}/project/result/fail",
						type : "post",
						data : {
							projectId : projectId
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
		});
	</script>
</head>
<body>
${.now}
<#if project.createTime?date gt .now?date>
1
<#else>
2
</#if>
	<h3>状态:
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
	</h3>
	<#-- 已选标,待审核  -->
	<#if project.nowStatus == 3>
	<h4><a href="javascript:;" id="auditSucc">审核通过</a> | <a href="javascript:;" id="auditFail">审核未通过</a></h4>
	</#if>
	<#if project.nowStatus == 7>
	<h4><a href="javascript:;" id="acceptSucc">验收通过</a> | <a href="javascript:;" id="acceptFail">验收失败</a></h4>
	</#if>
	标题：${project.projectTitle}<br/>
	要求：${project.projectDesc}<br/>
	价格：${project.price?string(",###0.00#")}<br/>
	制作周期：${project.period} 月<br/>
	<#--招标人数：<input id="bidAmount" type="text" name="bidAmount" value="1" /><br/>
	中标人数：<input id="winAmount" type="text" name="winAmount" value="2" /><br/>-->
	截止日期：${project.bidEndTime?string("yyyy-MM-dd")}<br/>
	是否公开：
	<#if project.isOpen == 'Y'>
		是
	<#else>
	   	 否
	</#if><br/>
	是否有专利：
	<#if project.isPatent == 'Y'>
		是
	<#else>
	   	 否
	</#if><br/>
	创建时间：${project.createTime?string("yyyy-MM-dd HH:mm:ss")}
	更新时间：${project.updateTime?string("yyyy-MM-dd")}<br/>
	<input id="projectId" type="hidden" name="projectId" value="${project.id}" /
	是否发布：
	<#if project.isRelease == 'Y'>
		是,发布时间：${project.releaseTime?string("yyyy-MM-dd HH:mm:ss")}
	<#else>
	   	 否
	</#if><br/>
	审核时间：
		<#if project.reviewTime ??>
			${project.reviewTime?string("yyyy-MM-dd HH:mm:ss")}
		</#if>
		<br/>
	投保人数：${project.bidAmount}<br/>
	中标人数：${project.winAmount}<br/>
	企业名称：${project.companyName}<br/>
	发布人：${project.memberName}<br/>
	<hr/>
	附件信息：<br/>
	<#list projectFiles as pfile>
		${pfile.filePath}/${pfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
		<#if pfile.fileType == 1>
			发标文件
		<#else>
			专利
		</#if>
		<a href="${webServer}/project/doc/download?filePath=${pfile.filePath}" target="_blank">下载</a>
		<#-- 招标期内 -->
		<#if project.bidEndTime?date gt .now?date>
		|<a href="javascript:;" class="removeDocFile" fileId="${pfile.id}">删除</a>
		</#if>
		<br/>
	</#list>
	<#-- 上传投标文件 -->
	<#if project.nowStatus &gt;= -1 && project.nowStatus &lt; 2 && project.nowStatus != 0>
	<form id="aceptBidForm" action="${webServer}/project/doc/upload" method="post" enctype="multipart/form-data">
	<input type="file" name="bidFile" id="bidFile" /><br/>
	<input type="hidden" name="projectId" value="${project.id}" />
		<a href="javascript:;" id="uploadBidFile">上传项目文件</a> 
	</form>
	</#if>
	
	<hr/>
	投标公司：<br/>
	<#assign bidCount = 0>
	<#list allBidService as ps>
		<#if ps.nowStatus == 2>
		<#assign bidCount= bidCount +  1>
		</#if>
	</#list>
	
	<#list allBidService as ps>
		 ${ps.project.companyName} 
		 <#if ps.nowStatus == -1>
		 	已取消
		 <#elseif ps.nowStatus == 1>
		 	待投标
		 <#elseif ps.nowStatus == 2>
		 	已投标
		 <#elseif ps.nowStatus == 3>
		 	已拒绝
		 <#elseif ps.nowStatus == 4>
		 	未中标
		 <#elseif ps.nowStatus == 5>
		 	已中标待审核
		 <#elseif ps.nowStatus == 6>
		 	审核成功待确认
		 <#elseif ps.nowStatus == 7>
	 		审核未通过
		 <#elseif ps.nowStatus == 8>
		 	已确认,生产中
		 <#elseif ps.nowStatus == 9>
		 	待验收
		 <#elseif ps.nowStatus == 10>
		 	验收失败
		 <#elseif ps.nowStatus == 0>
		 	已完成
		 </#if>
		 <#if (bidCount > 2) >
		 	<#if ps.nowStatus == 2>
		 		<a href="javascript:;" class="chooseBid" bidId="${ps.id}">选标</a>
		 	</#if>
		 </#if>
		 <br/>
		投标文件：<br/>
		 <#list ps.bidFiles as bfile>
			${bfile.filePath}/${bfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
			<#if bfile.fileType == 1>
				投标文件
			<#elseif bfile.fileType == 2>
				交付文件
			<#else>
				发票
			</#if>
			/ <a href="${webServer}/project/bid/download?filePath=${bfile.filePath}" target="_blank">下载</a>
			<br/>
		</#list>
		<br/>
		<#if ps.nowStatus &gt; 7>
		交付文件：<br/>
		<#list ps.checkFiles as bfile>
			${bfile.filePath}/${bfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
			<#if bfile.fileType == 1>
				投标文件
			<#elseif bfile.fileType == 2>
				交付文件
			<#else>
				发票
			</#if>
			/ <a href="${webServer}/project/result/download?filePath=${bfile.filePath}" target="_blank">下载</a>
			<br/>
		</#list>
		</#if>
	</#list>
	<br/>
	<#if project.nowStatus == 9>
		评分：${project.score}分 <br/>
		是否有专利：
		<#if project.isPatent == 'Y'>
			是<br/>
			专利描述：${project.patentDesc}
		<#else>
		   	 否
		</#if><br/>
	</#if>
	<#if project.nowStatus == 0>
		<form id="scoreForm" action="${webServer}/project/result/score" method="post">
		<input type="hidden" name="id" value="${project.id}" /> 
		评分：<input id="score" type="text" name="score" value="0" /> 分
		是否有专利：<input id="isPatent" type="radio" name="isPatent" value="Y" checked="checked"/>是
		<input id="isPatent" type="radio" name="isPatent" value="N" />否<br/>
		专利描述：<input id="patentDesc" type="text" name="patentDesc" value="" /> 
		<h3><a href="javascript:;" id="submitScore"> 提交 </a></h3>
		</form>
	</#if>

</body>
</html>