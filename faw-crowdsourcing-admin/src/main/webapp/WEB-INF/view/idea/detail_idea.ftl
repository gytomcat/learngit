<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />添加</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "" />
			
			<div class="frame-wrapper">
			
				<@menu.idea "idea" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title"> ${idea.ideaTitle}  <p>${idea.releaseTime?string('dd.MM.yyyy HH:mm:ss')}</p></h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form class="form-body" id="editIdeaForm" action="${webServer}/idea/reply" method="POST">
	                        <input type="hidden" name="ideaId" value="${idea.id}" />
	                        
描述: ${idea.ideaDesc} <br/>
分类ID,关联FAW_CATEGORY.ID: ${idea.categoryId} <br/>
浏览人数,默认0 ${idea.viewCount}  <br/>
回复人数,默认0:   ${idea.replyCount} <br/>
系统推荐分数: ${idea.systemScore} <br/>
审核员账号ID,关联FAW_MEMBER.ID:${idea.reviewerId}
评审分数:${idea.reviewScore}
评审意见: ${idea.reviewDesc}
<hr/>
<table border='1' width="100%">
<#if reply.totalRow != 0>
	<#list reply.ideaReplyList as ideaReply>
		<tr>
		<td>
		${ideaReply.ideaId}	
		</td>
		<td>
		${ideaReply.replyDesc}
		</td>
		</tr>
		<tr>
		<td colspan="2" style="text-align:right;">
			${ideaReply.replyTime?string('yyyy年MM月dd日 HH:mm:ss')}
			<span class="tbs-split">|</span>
			<a class="reply-del-btn" href="javascript:;" data-id="${ideaReply.id}">删除</a>
		</td>
		</tr>  	 
	</#list>
</#if>
</table>
	<hr/>
	<p>快速回复:</p>
	<script id="container" name="replyDesc" type="text/plain"></script>
	<hr/>
						<div class="form-action clearfix">
	                                <input type="submit" class="glb-button glb-btn-primary" value="回复" />
	                                <input type="submit" class="glb-button glb-btn-primary" value="审核" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

	
	<script type="text/javascript" src="${jsServer}/dialog.js" charset="utf-8"></script>
	<@layout.ueditorJs />
    <script type="text/javascript">
    	window.console = window.console || (function(){  
    　　　　var c = {}; c.log = c.warn = c.debug = c.info = c.error = c.time = c.dir = c.profile  
    　　　　= c.clear = c.exception = c.trace = c.assert = function(){};  
    　　　　return c;  
　　　　　　})();  
		//DOM READY
        $(function() {
			var ue = UE.getEditor('container');
			
			<#-- 点击删除按钮 -->
			$(".reply-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该回复?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/idea/reply/remove/' + id,
                    	success: function(rs){
							Frame.showResult(rs, true);
						}, 
						error: function(){
							Frame.showError("系统繁忙,请稍后再试");
						}
                    });
                    
                });
				
			});
        });
        
    </script>

</html>