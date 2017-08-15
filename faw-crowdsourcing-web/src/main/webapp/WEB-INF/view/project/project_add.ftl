<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>发布项目页</title>
	
	<script type="text/javascript" src="/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#subBtn").click(function(){
				var projectTitle = $.trim($("#projectTitle").val());
				var projectDesc = $.trim($("#projectDesc").val());
				var price = $.trim($("#price").val());
				var period = $.trim($("#period").val());
				var bidEndTime = $.trim($("#bidEndTime").val());
				
				if(projectTitle.length == 0){
					alert("请输入标题，标题在100个字以内");
					return;
				}
				if(projectDesc.length == 0){
					alert("请输入项目描述");
					return;
				}
				if(price.length == 0){
					alert("请输入价格，最多保留两位小数");
					return;
				}
				if(period.length == 0){
					alert("请输入项目周期");
					return;
				}
				if(bidEndTime.length == 0){
					alert("请输入招标截止日期");
					return;
				}
				
				var projectTagIds = '';
				$('input:checkbox[name=tag]:checked').each(function(i){
			        if(0==i){
			        	projectTagIds = $(this).val();
			        }else{
			        	projectTagIds += (","+$(this).val());
			        }
		        });
		        
		        if(projectTagIds == ''){
					alert("请选择项目标签");
					return;
				}
				else {
					$("#projectTagIds").val(projectTagIds);
				}
				
				if(confirm("是否确认发布项目？")){
					$("#addProjectForm").submit();
				}
			});
		});
	</script>
</head>
<body>
<form id="addProjectForm" action="${webServer}/project/release/add" method="post" enctype="multipart/form-data">
	标题：<input id="projectTitle" type="text" name="projectTitle" value="1111" /><br/>
	要求：<textarea id="projectDesc" name="projectDesc">w221</textarea><br/>
	价格：<input id="price" type="text" name="price" value="333" onkeyup= "if(!/^([1-9]\d{0,20}|0)([.]?|(\.\d{1,2})?)$/.test(this.value)){this.value='';}" /><br/>
	制作周期：<input id="period" type="text" name="period" value="12" onkeyup= "if(! /^[1-9]*[1-9][0-9]*$/.test(this.value)){this.value='';}"/>月<br/>
	<#--招标人数：<input id="bidAmount" type="text" name="bidAmount" value="1" /><br/>
	中标人数：<input id="winAmount" type="text" name="winAmount" value="2" /><br/>-->
	截止日期：<input id="bidEndTime" type="text" name="bidEndTime" value="2019-09-01 12:09:00" /><br/>
	是否公开：<input id="isOpen" type="radio" name="isOpen" value="Y" checked="checked"/>是
	<input id="isOpen" type="radio" name="isOpen" value="N" />否<br/>
	是否有专利：<input id="isPatent" type="radio" name="isPatent" value="Y" checked="checked"/>是
	<input id="isPatent" type="radio" name="isPatent" value="N" />否<br/>
	
	标签：<br/>
	<#list allTags as tag>
		 <input type="checkbox" name="tag" value="${tag.id}">${tag.tagName}
	</#list>
	<input type="hidden" id="projectTagIds" name="projectTagIds" value="" />
	<br/>
	<hr/>
	标书：<br/>
	<input type="file" name="file" />
	<hr/>
	<a href="javascript:;" id="subBtn">提交</a>
</form>
</body>
</html>