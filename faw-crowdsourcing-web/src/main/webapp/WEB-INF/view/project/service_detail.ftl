<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发布项目列表页</title>
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<h4>
		公司信息：${companyInfo.companyName}<br/>
		公司描述：${companyInfo.companyDesc}<br/>
	</h4>
	<#list serviceProject as ps>
		项目名称：${ps.project.projectTitle}<br>
		状态：
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
		文件列表:<br/>
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
	</#list>
</body>
</html>