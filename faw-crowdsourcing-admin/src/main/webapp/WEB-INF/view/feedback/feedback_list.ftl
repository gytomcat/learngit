<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />反馈列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "system" />
			
			<div class="frame-wrapper">
			
				<@menu.system "feedback" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">反馈列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/feedback/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addFeedbackBtn" href="${webServer}/feedback/add" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加反馈
	                                    </a>
	                                </li>
	                            </ul>
	                        </form>
                            <table class="glb-tables">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>
											ID
										</th>
                                        <th>
											创建时间
										</th>
                                        <th>
											更新时间
										</th>
                                        <th>
											反馈人ID,关联FAW_MEMBER.ID
										</th>
                                        <th>
											反馈分类.1:系统错误,2::咨询
										</th>
                                        <th>
											反馈标题
										</th>
                                        <th>
											反馈内容
										</th>
                                        <th>
											是否回复.Y:已回复.N:未回复,默认N
										</th>
                                        <th>
											回复时间
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="11">
                                            <span class="iconfont icon-data"></span>没有查询到符合条件的记录
                                        </td>
                                    </tr>
                                </tbody>
                                
                            	<#else>
                                <tbody>
                                	<#list page.feedbackList as feedback>
                                    <tr>
                                        <td>${feedback_index + 1}</td>
                                        <td>${feedback.id}</td>
                                        <td>${feedback.createTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${feedback.updateTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${feedback.feedbackId}</td>
                                        <td>${feedback.feedbackType}</td>
                                        <td>${feedback.feedbackTitle}</td>
                                        <td>${feedback.feedbackDesc}</td>
                                        <td>${feedback.isReply}</td>
                                        <td>${feedback.replyTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>
                                            <a class="feedback-edit-btn" href="${webServer}/feedback/edit/${feedback.id}" data-id="${feedback.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="feedback-del-btn" href="javascript:;" data-id="${feedback.id}">删除</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="11">
                                        <div class="glb-left glb-col-left">
                                            <a href="javascript:;" class="glb-button glb-btn-default">
                                                <span class="iconfont icon-refresh"></span> 刷新
                                            </a>
                                        </div>
										<@layout.pagination />
                                    </td>
                                </tfoot>
								</#if>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script type="text/javascript">
    
        $(function() {



			<#-- 点击删除按钮 -->
			$(".feedback-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该反馈?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/feedback/remove/' + id,
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