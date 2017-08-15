<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />消息列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "system" />
			
			<div class="frame-wrapper">
			
				<@menu.system "message" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">消息列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/message/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addMessageBtn" href="${webServer}/message/add" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加消息
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
											发送人ID,关联FAW_MEMBER.ID,系统发送为-1
										</th>
                                        <th>
											消息标题
										</th>
                                        <th>
											消息内容
										</th>
                                        <th>
											消息类型,1.系统消息,2.站内信
										</th>
                                        <th>
											消息类别.1:系统消息,2.招投标,3.活动,4.论坛
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="10">
                                            <span class="iconfont icon-data"></span>没有查询到符合条件的记录
                                        </td>
                                    </tr>
                                </tbody>
                                
                            	<#else>
                                <tbody>
                                	<#list page.messageList as message>
                                    <tr>
                                        <td>${message_index + 1}</td>
                                        <td>${message.id}</td>
                                        <td>${message.createTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${message.updateTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${message.senderId}</td>
                                        <td>${message.msgTitle}</td>
                                        <td>${message.msgDesc}</td>
                                        <td>${message.msgType}</td>
                                        <td>${message.msgCategory}</td>
                                        <td>
                                            <a class="message-edit-btn" href="${webServer}/message/edit/${message.id}" data-id="${message.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="message-del-btn" href="javascript:;" data-id="${message.id}">删除</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="10">
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
			$(".message-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该消息?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/message/remove/' + id,
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