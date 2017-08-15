<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>已投标服务商</title>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h1>已投标服务商 </h1>
	<h2><a href="${webServer}/project/service/list?projectId=${projectId}">项目标签推荐供应商</a> </h2>
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
		 	审核失败
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
</body>
</html>