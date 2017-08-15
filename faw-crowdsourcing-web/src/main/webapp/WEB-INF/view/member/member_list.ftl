<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title>用户列表</title>
	</head>
	<body>
		<div id="frameBody" class="frame-body frame-body-full">
			<div class="frame-wrapper">
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">用户列表</h3>
                        </div>
                        <div class="frame-main-bd">
                            <table class="glb-tables">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>
											ID
										</th>
                                        <th>
											注册时间
										</th>
                                        <th>
											用户名称
										</th>
                                        <th>
											姓名
										</th>
                                        <th>
                                        	操作
                                        </th>
                                    </tr>
                                </thead>
                                <#if page != null>
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="9">
                                            <span class="iconfont icon-data"></span>没有查询到符合条件的记录
                                        </td>
                                    </tr>
                                </tbody>
                            	<#else>
                                <tbody>
                                	<#list page.memberList as member>
                                    <tr>
                                        <td>${member_index + 1}</td>
                                        <td>${member.id}</td>
                                        <td>${member.registerTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${member.loginId}</td>
                                        <td>${member.fullName}</td>
                                        <td>
                                            <a class="member-edit-btn" href="javascript:;" data-id="${member.id}">审批</a>
                                            <span class="tbs-split">|</span>
                                            <a class="member-del-btn" href="javascript:;" data-id="${member.id}">拒绝</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="9">
                                        <div class="glb-left glb-col-left">
                                            <a href="javascript:;" class="glb-button glb-btn-default">
                                                <span class="iconfont icon-refresh"></span> 刷新
                                            </a>
                                        </div>
										<@layout.pagination />
                                    </td>
                                </tfoot>
								</#if>
								</#if>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

	<script type="text/javascript" src="${jsServer}/validate.js" charset="utf-8"></script>
	<script type="text/javascript" src="${jsServer}/dialog.js" charset="utf-8"></script>
    <script type="text/javascript">
        $(function() {
			<#-- 点击审批按钮 -->
			$(".member-edit-btn").click(function(){
				var id = $(this).data("id");
             	$.ajax({
                	url: '${webServer}/member/approve/' + id,
                	success: function(rs){
						Frame.showResult(rs, true);
					}, 
					error: function(){
						Frame.showError("系统繁忙,请稍后再试");
					}
                });
			});
			<#-- 点击拒绝按钮 -->
			$(".company-del-btn").click(function(){
				var id = $(this).data("id");
				Dialogx.confirm('拒绝后不可恢复,确定拒绝该用户?', function() {
					Frame.showWaiting("正在拒绝,请稍后");
                    $.ajax({
                    	url: '${webServer}/member/refuse/' + id,
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