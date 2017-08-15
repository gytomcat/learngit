<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />会员列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "user" />
			
			<div class="frame-wrapper">
			
				<@menu.user "member" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">会员列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/member/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addMemberBtn" href="${webServer}/member/add" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加会员
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
											注册时间
										</th>
                                        <th>
											审核时间
										</th>
                                        <th>
											用户状态:0.正常,1.待审核,2:拒绝.默认1
										</th>
                                        <th>
											用户类型.1:批量导入,2:注册,默认1
										</th>
                                        <th>
											用户名
										</th>
                                        <th>
											密码
										</th>
                                        <th>
											是否初次登录,Y:初次,N:非初次,默认Y
										</th>
                                        <th>
											企业ID,关联FAW_COMPANY.ID
										</th>
                                        <th>
											组织ID,关联FAW_AGENCY.ID
										</th>
                                        <th>
											用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1
										</th>
                                        <th>
											姓名
										</th>
                                        <th>
											年龄
										</th>
                                        <th>
											职称
										</th>
                                        <th>
											头像
										</th>
                                        <th>
											性别.M:男,F:女
										</th>
                                        <th>
											联系电话
										</th>
                                        <th>
											标签数量,默认0
										</th>
                                        <th>
											用户描述
										</th>
                                        <th>
											投标数量,默认0
										</th>
                                        <th>
											中标数量,默认0
										</th>
                                        <th>
											被邀请数量,默认0
										</th>
                                        <th>
											接受数量,默认0
										</th>
                                        <th>
											创意数量,默认0
										</th>
                                        <th>
											论坛积分,默认0
										</th>
                                        <th>
											邀请人ID,关联FAW_MEMBER.ID,导入用户为-1
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="30">
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
                                        <td>${member.createTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${member.updateTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${member.registerTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${member.reviewTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${member.nowStatus}</td>
                                        <td>${member.memberType}</td>
                                        <td>${member.loginId}</td>
                                        <td>${member.loginPasswd}</td>
                                        <td>${member.isFirstLogin}</td>
                                        <td>${member.companyId}</td>
                                        <td>${member.agencyId}</td>
                                        <td>${member.memberRole}</td>
                                        <td>${member.fullName}</td>
                                        <td>${member.age}</td>
                                        <td>${member.title}</td>
                                        <td>${member.portrial}</td>
                                        <td>${member.gender}</td>
                                        <td>${member.mobileNo}</td>
                                        <td>${member.tagCount}</td>
                                        <td>${member.memberDesc}</td>
                                        <td>${member.bidCount}</td>
                                        <td>${member.winCount}</td>
                                        <td>${member.inviteCount}</td>
                                        <td>${member.acceptCount}</td>
                                        <td>${member.ideaCount}</td>
                                        <td>${member.bbsPoint}</td>
                                        <td>${member.inviterId}</td>
                                        <td>
                                            <a class="member-edit-btn" href="${webServer}/member/edit/${member.id}" data-id="${member.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="member-del-btn" href="javascript:;" data-id="${member.id}">删除</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="30">
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
			$(".member-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该会员?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/member/remove/' + id,
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