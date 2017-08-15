<#-- 全局Title -->
<#macro globalTitle>
	一汽众包平台 - 
</#macro>

<#-- 全局Meta -->
<#macro globalMeta>
</#macro>

<#-- 全局CSS -->
<#macro globalCss>
	<link rel="shortcut icon" type="image/x-icon" href="${webServer}/images/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="${cssServer}/global.css">
	<link rel="stylesheet" type="text/css" href="${cssServer}/gla.css">
	<link rel="stylesheet" type="text/css" href="${cssServer}/theme/pure.css">
</#macro>

<#-- 全局JS -->
<#macro globalJs>
	<script type="text/javascript" src="${jsServer}/jquery.min.js"></script>
	<script type="text/javascript" src="${jsServer}/global.js"></script>
	<script type="text/javascript" src="${jsServer}/gla.js"></script>
</#macro>

<#-- 全局头部  -->
<#macro header>
	<div id="frameHeader" class="frame-head">
		<div class="frame-logo">
			<a class="frame-logo-main" href="${webServer}">
				<img src="${webServer}/images/logo_s.png" alt="faw" />
			</a>
			<p class="frame-logo-sub">
				一汽众包平台
			</p>
		</div>
		<div class="frame-topbar"></div>
	</div>
</#macro>

<#-- 全局底部  -->
<#macro bottom>
</#macro>

<#-- 富文本编辑器(UEditor)JS -->
<#macro ueditorJs> 
	<script type="text/javascript" charset="utf-8" src="${jsServer}/ue/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${jsServer}/ue/ueditor.all.js"></script>
    <script type="text/javascript" charset="utf-8" src="${jsServer}/ue/lang/zh-cn/zh-cn.js"></script>
	<script type="text/javascript">
	
		<#-- 富文本编辑器: 定义上传图片Action -->
		UE.Editor.prototype._bkGetActionUrl = UE.Editor.prototype.getActionUrl;	
        UE.Editor.prototype.getActionUrl = function(action) {
            if (action == 'uploadImage') {
                return '${webServer}/ueditor/upload';
            } else{
                return this._bkGetActionUrl.call(this, action);
            }
        };
        
	</script>
</#macro>

<#-- 全局分页 -->'}
<#macro pagination>
<#if page.totalPage gt 1>
	<ul class="glb-pagination">
        <#if page.currentPage - 5 &gt; 2>
			<li><a href="javascript:;">1</a></li>
			<li>
				<span>...</span>
			</li>
		<#elseif page.currentPage - 5 == 2>
			<li><a href="javascript:;">1</a></li>
		</#if>
		<#list page.pageList as page0>
			<#if page0 == page.currentPage>
			<li class="current"><a href="javascript:;">${page0}</a></li>
			<#else>
			<li><a href="javascript:;">${page0}</a></li>
			</#if>
	  	</#list>
		<#if page.currentPage + 6 &lt; page.totalPage>
			<li>
				<span>...</span>
			</li>
			<li><a href="javascript:;">${page.totalPage}</a></li>
		<#elseif page.currentPage + 6 == page.totalPage>
			<li><a href="javascript:;">${page.totalPage}</a></li>
		</#if>
    </ul>
    
    <script type="text/javascript">
    	var pageHd = '<input type="hidden" id="cp" name="currentPage" value="${page.currentPage}" />';
		
		$(function() {
		
			$("form").append(pageHd);
			
			// 分页
			$(".glb-pagination a").click(function() {
				if ($(this).hasClass("prev")) {
					$("#cp").val($("#cp").val() * 1 - 1);
				} else if ($(this).hasClass("next")) {
					$("#cp").val($("#cp").val() * 1 + 1);
				} else {
					$("#cp").val($(this).html());
				}
				$("form").submit();
			});
			
		});
	</script>
</#if>
</#macro>