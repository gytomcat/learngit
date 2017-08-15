<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发布项目列表页</title>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/**
			 * 接受
			 */
			$(".agreeBtn").click(function(){
				var bidId = $(this).attr("bidId");
				if(confirm("是否确认接受该项目？")){
					$.ajax({
						url : "${webServer}/project/invite/accept",
						type : "post",
						data : {
							bidId : bidId,
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
							bidId : bidId,
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
			<td>邀请时间</td>
			<td>发布企业</td>
			<td>项目标题</td>
			<td>价格</td>
			<td>截止日期</td>
			<td>制作周期（月）</td>
			<td>状态</td>
			<td>操作</td>
		</tr>
		<#list page.bidList as bid>
		<tr>
			<td>${bid_index + 1}</td>
			<td>
				<#if bid.createTime ??>
					${bid.createTime?string("yyyy-MM-dd")}
				</#if>
			</td>
			<td>${bid.project.companyName}</td>
			<td>${bid.project.projectTitle}</td>
			<td>${bid.project.price?string(",###0.00#")}</td>
			<td>${bid.project.bidEndTime?string("yyyy-MM-dd ")}</td>
			<td>${bid.project.period}</td>
			<td>
				 <#if bid.nowStatus == -1>
				 	已取消
				 <#elseif bid.nowStatus == 1>
				 	待投标
				 <#elseif bid.nowStatus == 2>
				 	已投标
				 <#elseif bid.nowStatus == 3>
				 	已拒绝
				 <#elseif bid.nowStatus == 4>
				 	未中标
				 <#elseif bid.nowStatus == 5>
				 	已中标待审核
				 <#elseif bid.nowStatus == 6>
				 	审核成功待确认
				 <#elseif bid.nowStatus == 7>
				 	审核未通过
				 <#elseif bid.nowStatus == 8>
				 	已确认,生产中
				 <#elseif bid.nowStatus == 9>
				 	待验收
				 <#elseif bid.nowStatus == 10>
				 	验收失败
				 <#elseif bid.nowStatus == 0>
				 	已完成
				 </#if>
			</td>
			<td>
				<a href="${webServer}/project/bid/detail/${bid.projectId}">查看</a> 
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