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
			$("#uploadBidFile").click(function(){
				if($("#bidFile").val().length == 0){
					alert("请选择需要上传的文件");
					return;
				}
				
				if(confirm("是否确认上传投标文件？")){
					$("#aceptBidForm").submit();
				}
			});
			
			/**
			 * 上传投标文件
			 */
			$("#uploadResultFile").click(function(){
				if($("#bidFile").val().length == 0){
					alert("请选择需要上传的文件");
					return;
				}
				
				if(confirm("是否确认上传交付文件？")){
					$("#checkForm").submit();
				}
			});
			
			/**
			 * 接受
			 */
			$(".agreeBtn").click(function(){
				var bidId = $(this).attr("bidId");
				var projectId = $("#projectId").val();
				if(confirm("是否确认接受该项目？")){
					$.ajax({
						url : "${webServer}/project/invite/accept",
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
			 * 拒绝
			 */
			$(".refuseBtn").click(function(){
				var bidId = $(this).attr("bidId");
				if(confirm("是否确认拒绝该项目？")){
					$.ajax({
						url : "${webServer}/project/invite/refuse",
						type : "post",
						data : {
							bidId : bidId
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
			$(".removeBidFile").click(function(){
				var fileId = $(this).attr("fileId");
				if(confirm("是否确认删除该投标文件？")){
					$.ajax({
						url : "${webServer}/project/bid/remove",
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
			 * 确认中标
			 */
			$("#confirmBtn").click(function(){
				var bidId = $(this).attr("bidId");
				var projectId = $("#projectId").val();
				if(confirm("是否确认接受此次中标？")){
					$.ajax({
						url : "${webServer}/project/bid/confirm",
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
			 * 放弃投标
			 */
			$("#cancelBtn").click(function(){
				var bidId = $(this).attr("bidId");
				if(confirm("是否确认放弃此次投标？")){
					$.ajax({
						url : "${webServer}/project/bid/cancel",
						type : "post",
						data : {
							bidId : bidId
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
			 * 提交验收
			 */
			$("#checkBtn").click(function(){
				var bidId = $(this).attr("bidId");
				var projectId = $("#projectId").val();
				if(confirm("是否确认申请验收？")){
					$.ajax({
						url : "${webServer}/project/result/submit",
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
	创建时间：${project.createTime?string("yyyy-MM-dd")}
	更新时间：${project.updateTime?string("yyyy-MM-dd")}<br/>
	<input id="projectId" type="hidden" name="projectId" value="${project.id}" />
	是否发布：
	<#if project.isOpen == 'Y'>
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
	标书信息：<br/>
	<#list projectFiles as pfile>
		${pfile.filePath}/${pfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
		<#if pfile.fileType == 1>
			发表文件
		<#else>
			专利
		</#if>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${webServer}/project/doc/download?filePath=${pfile.filePath}" target="_blank">下载</a>
		<br/>
	</#list>
	<br/>
	
	<h3>
		${bidService.project.companyName} 
		 <#if bidService.nowStatus == -1>
		 	已取消
		 <#elseif bidService.nowStatus == 1>
		 	待投标
		 <#elseif bidService.nowStatus == 2>
		 	已投标
		 <#elseif bidService.nowStatus == 3>
		 	已拒绝
		 <#elseif bidService.nowStatus == 4>
		 	未中标
		 <#elseif bidService.nowStatus == 5>
		 	已中标待审核
		 <#elseif bidService.nowStatus == 6>
		 	审核成功待确认
		 <#elseif bidService.nowStatus == 7>
	 		审核未通过
		 <#elseif bidService.nowStatus == 8>
		 	已确认,生产中
		 <#elseif bidService.nowStatus == 9>
		 	待验收
		 <#elseif bidService.nowStatus == 10>
		 	验收失败
		 <#elseif bidService.nowStatus == 0>
		 	已完成
		 </#if>
		</h3><br/>
		<hr/>
		
		投标文件：<br/>
		<#list bidService.bidFiles as bfile>
			${bfile.filePath}/${bfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
			<#if bfile.fileType == 1>
				投标文件
			<#elseif bfile.fileType == 2>
				交付文件
			<#else>
				发票
			</#if>
			/ <a href="${webServer}/project/bid/download?filePath=${bfile.filePath}" target="_blank">下载</a>
			<#if project.bidEndTime?date gt .now?date>
			/ <a href="javascript:;" class="removeBidFile" fileId="${bfile.id}">删除</a>
			</#if>
			
			<br/>
		</#list>
		<br/>
		
		<#-- 上传投标文件 -->
		<#if bidService.nowStatus == 1>
		<form id="aceptBidForm" action="${webServer}/project/bid/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="bidFile" id="bidFile"/><br/>
		<input type="hidden" name="bidId" value="${bidService.id}" />
		<input type="hidden" name="projectId" value="${project.id}" />
		<input type="hidden" name="mark" value="1" />
			<a href="javascript:;" id="uploadBidFile" bidId="${bidService.id}">上传投标文件</a> 
		</form>
		</#if>
		
		<#if bidService.nowStatus &gt; 7 || bidService.nowStatus == 0>
			交付文件:<br/>
			<#list bidService.checkFiles as bfile>
				${bfile.filePath}/${bfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
				<#if bfile.fileType == 1>
					投标文件
				<#elseif bfile.fileType == 2>
					交付文件
				<#else>
					发票
				</#if>
				/ <a href="${webServer}/project/result/download?filePath=${bfile.filePath}" target="_blank">下载</a>
				/ <a href="javascript:;" class="removeBidFile" fileId="${bfile.id}">删除</a>
				<br/>
			</#list>
			
			<#-- 状态未8，上传交付文件 -->
			<#if bidService.nowStatus == 8>
			<form id="checkForm" action="${webServer}/project/result/upload" method="post" enctype="multipart/form-data">
			<input type="file" name="bidFile" id="bidFile"/><br/>
			<input type="hidden" name="bidId" value="${bidService.id}" />
			<input type="hidden" name="projectId" value="${project.id}" />
				<a href="javascript:;" id="uploadResultFile" bidId="${bidService.id}">上传交付文件</a> 
			</form>
			</#if>
		</#if>
		<hr/>
		
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
		
		<#-- 确认投标 -->
		<#if bidService.nowStatus == 1>
			<h3><a href="javascript:;" class="agreeBtn" bidId="${bidService.id}">接受投标</a> 
			| <a href="javascript:;" class="refuseBtn" bidId="${bidService.id}">拒绝投标</a></h3>
		</form>
		</#if>
		
		<#-- 申请验收 -->
		<#if bidService.nowStatus == 8>
		投标文件：<br/>
			<a href="javaScript:;" id="checkBtn" bidId="${bidService.id}"><h4>申请验收</h4></a> 
		</#if>
		
		
		<#-- 放弃投标 -->
		<#if project.nowStatus &gt; 0 && project.nowStatus &lt; 3 && project.bidEndTime?date gt.now?date>
			<a href="javaScript:;" id="cancelBtn" bidId="${bidService.id}"><h4>放弃投标</h4></a> 
		</#if>
		
		<#-- 已审核待确认 -->
		<#if bidService.nowStatus == 6>
			<a href="javaScript:;" id="confirmBtn" bidId="${bidService.id}"><h4>确认接受</h4></a> 
		</#if>
		
</body>
</html>