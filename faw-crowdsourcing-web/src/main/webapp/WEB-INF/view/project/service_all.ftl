<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发布项目列表页</title>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			/**
			 * 邀请多个服务商
			 */
			$("#inviteMuch").click(function(){
				var serviceIds = '';
				$('input:checkbox[name=serviceId]:checked').each(function(i){
			        if(0==i){
			        	serviceIds = $(this).val();
			        }else{
			        	serviceIds += (","+$(this).val());
			        }
		        });
		        
		        if(serviceIds == ''){
					alert("请选择所要邀请的服务商");
					return;
				}
				
				if(confirm("是否确认邀请所选服务商？")){
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
			
			/**
			 * 邀请一个服务商
			 */
			$(".inviteBtn").click(function(){
				var projectId = $("#projectId").val();
				var serviceInfo = $(this).attr("serviceInfo");
				if(confirm("是否确认邀请所选服务商？")){
					$.ajax({
						url : "${webServer}/project/service/invite",
						type : "post",
						data : {
							projectId : projectId,
							serviceInfo : serviceInfo
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
<form action="${webServer}/project/release/list" method="get">
	<h1>项目标签推荐供应商 </h1>
	<h2><a href="${webServer}/project/service/bid?projectId=${projectId}">已投标供应商</a> </h2>
	<#list projectService as ps>
		 <input type="checkbox" name="serviceId" value="${ps.bidCompanyId}-${ps.bidAgencyId}-${ps.bidMemberId}">${ps.project.companyName} 
		 <#assign isSame="0">
		 <#list allBidService as ab>
		 	<#if ab.bidCompanyId == ps.bidCompanyId>
		 		<#assign isSame="1">
		 		<#break>
		 	</#if>
		 </#list>
		 
		 <#if isSame == 0>
			 <a href="javascript:;" serviceInfo="${ps.bidCompanyId}-${ps.bidAgencyId}-${ps.bidMemberId}" class="inviteBtn">邀请</a>
		 </#if>
		 | <a href="${webServer}/service/detail/${ps.bidMemberId}">查看服务商信息</a>
		 <br/>
	</#list>
	<input type="hidden" id="projectId" value="${projectId}" />
</form>
</body>
</html>