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
			
				<@menu.project "project" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">项目列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/project/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addProjectBtn" href="${webServer}/project/add" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加项目
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
											状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.
										</th>
                                        <th>
											发标企业ID,关联FAW_COMPANY.ID
										</th>
                                        <th>
											发标部门ID,关联FAW_DEPT.ID
										</th>
                                        <th>
											发布人ID,关联FAW_MEMBER.ID
										</th>
                                        <th>
											发布时间
										</th>
                                        <th>
											审核时间
										</th>
                                        <th>
											招标截止日期
										</th>
                                        <th>
											是否公开.Y:公开,N:不公开,默认N
										</th>
                                        <th>
											是否发布.Y:已发布,N:未发布,默认N
										</th>
                                        <th>
											标题
										</th>
                                        <th>
											要求
										</th>
                                        <th>
											价格
										</th>
                                        <th>
											制作周期
										</th>
                                        <th>
											投标人数,不限人数为-1
										</th>
                                        <th>
											中标人数,默认1
										</th>
                                        <th>
											选标时间
										</th>
                                        <th>
											中标ID,关联FAW_BID.ID未选标是为-1
										</th>
                                        <th>
											创意ID,关联FAW_IDEA.ID,无创意为-1
										</th>
                                        <th>
											是否有专利,Y:有专利,N:无专利,默认N
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
                                        <td>${project.id}</td>
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
                                        <td>${project.companyId}</td>
                                        <td>${project.agencyId}</td>
                                        <td>${project.releaseId}</td>
                                        <td>
                                        	<#if project.releaseTime ??>
                                        		${project.releaseTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>
                                        	<#if project.reviewTime ??>
                                        		${project.reviewTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>
                                        	<#if project.bidEndTime ??>
                                        		${project.bidEndTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>${project.isOpen}</td>
                                        <td>${project.isRelease}</td>
                                        <td>${project.projectTitle}</td>
                                        <td>${project.projectDesc}</td>
                                        <td>${project.price}</td>
                                        <td>${project.period}</td>
                                        <td>${project.bidAmount}</td>
                                        <td>${project.winAmount}</td>
                                        <td>
                                        	<#if project.selectTime ??>
                                        		${project.selectTime?string("yyyy-MM-dd hh:mm")}
                                        	</#if>
                                        </td>
                                        <td>${project.winBidId}</td>
                                        <td>${project.ideaId}</td>
                                        <td>${project.isPatent}</td>
                                        <td>
                                            <a class="project-edit-btn" href="${webServer}/project/edit/${project.id}" data-id="${project.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="project-del-btn" href="javascript:;" data-id="${project.id}">删除</a>
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