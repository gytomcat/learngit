<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>项目详情页</title>
	
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/**
			 * 收藏
			 */
			$("#collectProject").click(function(){
				var projectId = $("#projectId").val();
				if(confirm("确认收藏此项目？")){
					$.ajax({
						url : "${webServer}/project/collect",
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
			 * 投标
			 */
			$("#bidProject").click(function(){
				if(confirm("是否确认投标投标此项目？")){
					$("#bidForm").submit();
				}
			});
			
			/**
			 * 上传投标文件
			 */
			$("#uploadBidFile").click(function(){
				if($("#bidFile").val().length == 0){
					alert("请选择需要上传的文件");
					return;
				}
				
				if(confirm("是否确认上传投标文件？")){
					$("#aceptBidForm").submit();
				}
			});
		});
	</script>
</head>
<body>
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
		<br/>
	</#list>
	<hr/>
	
	投标文件：<br/>
	 <#list bidFiles as bfile>
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
	<#-- 上传投标文件 -->
	<#if project.bidEndTime?date gt .now?date && bidCount gt 0 && project.nowStatus lt 3>
		<form id="aceptBidForm" action="${webServer}/project/bid/upload" method="post" enctype="multipart/form-data">
			上传文件:<br/>
			<input type="file" name="bidFile" id="bidFile"/><br/>
			<input type="hidden" name="bidId" value="${bidInfo.id}" />
			<input type="hidden" name="projectId" value="${project.id}" />
			<input type="hidden" name="mark" value="2" />
			<a href="javascript:;" id="uploadBidFile" bidId="${bidService.id}">上传投标文件</a> 
		</form>
	</#if>
	
	<hr/>
	投标公司：<br/>
	
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
		 <br/>
	</#list>
	<br/>
	<hr/>
	<#if bidCount == 0>
		<form id="bidForm" action="${webServer}/project/bid" method="post" enctype="multipart/form-data">
			上传文件:<br/>
			<input type="file" name="bidFile" id="bidFile"/><br/>
			<input type="hidden" name="projectId" value="${project.id}" />
		</form>
		<h4><a href="javascript:;" id="bidProject">投标</h4>
	<#else>
		<h3>
			 <#if bidInfo.nowStatus == -1>
			 	已取消
			 <#elseif bidInfo.nowStatus == 1>
			 	待投标
			 <#elseif bidInfo.nowStatus == 2>
			 	已投标
			 <#elseif bidInfo.nowStatus == 3>
			 	已拒绝
			 <#elseif bidInfo.nowStatus == 4>
			 	未中标
			 <#elseif bidInfo.nowStatus == 5>
			 	已中标待审核
			 <#elseif bidInfo.nowStatus == 6>
			 	审核成功待确认
			 <#elseif bidInfo.nowStatus == 7>
		 		审核未通过
			 <#elseif bidInfo.nowStatus == 8>
			 	已确认,生产中
			 <#elseif bidInfo.nowStatus == 9>
			 	待验收
			 <#elseif bidInfo.nowStatus == 10>
			 	验收失败
			 <#elseif bidInfo.nowStatus == 0>
			 	已完成
			 </#if>
		</h3>
	</#if>
	
	<#if collectCount == 0>
		<h4><a href="javascript:;" id="collectProject">收藏</h4>
	<#else>
		<h3>已收藏</h3>
	</#if>
</body>
</html>