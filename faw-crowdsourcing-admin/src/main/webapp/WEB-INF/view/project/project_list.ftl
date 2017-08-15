<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />项目列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "project" />
			
			<div class="frame-wrapper">
				<@menu.project "${name}" />
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">项目列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/project/list" method="GET">
	                        <input type="hidden" name="name" value="${name}"/>
	                        <input type="hidden" name="hasBid" value="${page.hasBid}"/>
	                        <input type="hidden" name="finished" value="${page.finished}"/>
	                        <input type="hidden" name="isPatent" value="${page.isPatent}"/>
	                        <input type="hidden" name="nowStatus" value="${page.nowStatus}"/>
                            <table class="glb-tables">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>
											创建时间
										</th>
                                        <th>
											更新时间
										</th>
                                        <th>
											发标企业
										</th>
                                        <th>
											招标截止日期
										</th>
                                        <th>
											是否公开
										</th>
                                        <th>
											是否发布
										</th>
                                        <th>
											标题
										</th>
                                        <th>
											价格(元)
										</th>
                                        <th>
											制作周期(月数)
										</th>
                                        <th>
											是否有专利
										</th>
										<th>
											状态
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="24">
                                            <span class="iconfont icon-data"></span>没有查询到符合条件的记录
                                        </td>
                                    </tr>
                                </tbody>
                                
                            	<#else>
                                <tbody>
                                	<#list page.projectList as project>
                                    <tr>
                                        <td>${project_index + 1}</td>
                                        <td>
                                        	<#if project.createTime ??>
                                        		${project.createTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>
                                        	<#if project.updateTime ??>
                                        		${project.updateTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>${project.companyName}</td>
                                        <td>
                                        	<#if project.bidEndTime ??>
                                        		${project.bidEndTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>
                                        	<#if project.isOpen == 'Y'>
                                        		是
                                        	<#else>
                                        		否
                                        	</#if>
                                        </td>
                                        <td>
                                        	<#if project.isRelease == 'Y'>
                                        		是
                                        	<#else>
                                        		否
                                        	</#if>
                                        </td>
                                        <td>${project.projectTitle}</td>
                                        <td>${project.price?string(",###0.00#")}</td>
                                        <td>${project.period}</td>
                                        <td>
                                        	<#if project.isPatent == 'Y'>
                                        		是
                                        	<#else>
                                        		否
                                        	</#if>
                                        </td>
                                        <td>
                                        	<#if project.nowStatus == -8>
											 	已过期
											 <#elseif project.nowStatus == -9>
											 	已取消
											 <#elseif project.nowStatus == -1>
											 	待审核
											 <#elseif project.nowStatus == -2>
											 	审核未通过
											 <#elseif project.nowStatus == 0>
											 	已完成
											 <#elseif project.nowStatus == 1>
											 	招标中
											 <#elseif project.nowStatus == 2>
											 	选标中
											 <#elseif project.nowStatus == 3>
											 	已选标,待审核
											 <#elseif project.nowStatus == 4>
											 	审核成功待确认
											 <#elseif project.nowStatus == 5>
											 	选标审核未通过
											 <#elseif project.nowStatus == 6>
												已确认,生产中
											 <#elseif project.nowStatus == 7>
											 	待验收
											 <#elseif project.nowStatus == 8>
												验收失败
											 <#elseif project.nowStatus == 9>
												已评分
											 </#if>
                                        </td>
                                        <td>
                                            <a class="project-edit-btn" href="${webServer}/project/info/${project.id}?name=${name}" data-id="${project.id}">查看</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="24">
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
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

    <script type="text/javascript">
    
        $(function() {



			<#-- 点击删除按钮 -->
			$(".project-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该项目?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/project/remove/' + id,
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