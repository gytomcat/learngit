<#-- 分页 -->
<#macro pagination>
<#if page.totalPage gt 1>
	<script type="text/javascript">
		$(function(){
			$(".prev").click(function(){
				var currentPage = ${page.currentPage};
				$("#cp").val(currentPage-1);
				$("form").submit();
			});
			
			$(".next").click(function(){
				var currentPage = ${page.currentPage};
				$("#cp").val(currentPage+1);
				$("form").submit();
			});
			$(".nowPage").click(function(){
				$("#cp").val($(this).attr("pid"));
				$("form").submit();
			});
		});
	</script>
	<div class="pagination">
        <input type="hidden" id="cp" name="currentPage" value="${page.currentPage}" />
        <#if page.currentPage !=  1>
			<a class="nowPage" href="javascript:;" pid="1">首页</a>
		</#if>
		<#if page.currentPage !=  1>
			<a class="prev" href="javascript:;">上一页</a>
		<#else>
        	<span class="prev">上一页</span>
		</#if>
		
		<#list page.pageList as page0>
			<#if page0 == page.currentPage>
			<span class="pg-active">${page0}</span>
			<#else>
			<a href="javascript:;" class="nowPage" pid="${page0}">${page0}</a>
			</#if>
	  	</#list>
	  	
		<#if page.currentPage != page.totalPage>
        	<a class="next" href="javascript:;">下一页</a>
        <#else>
        	<span class="next">下一页</span>
        </#if>
         <#if page.currentPage !=  page.totalPage>
			<a class="nowPage" href="javascript:;" pid="${page.totalPage}">末页</a>
		</#if>
    </div>
</#if>
</#macro>