<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />企业列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "org" />
			
			<div class="frame-wrapper">
			
				<@menu.org "company" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">企业列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/company/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addCompanyBtn" href="javascript:;" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加企业
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
											企业名称
										</th>
                                        <th>
											企业描述
										</th>
                                        <th>
											管理员账号ID,关联FAW_MEMBER.ID
										</th>
                                        <th>
											审核员账号ID,关联FAW_MEMBER.ID
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
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
                                	<#list page.companyList as company>
                                    <tr>
                                        <td>${company_index + 1}</td>
                                        <td>${company.id}</td>
                                        <td>${company.createTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${company.updateTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${company.companyName}</td>
                                        <td>${company.companyDesc}</td>
                                        <td>${company.adminId}</td>
                                        <td>${company.reviewerId}</td>
                                        <td>
                                            <a class="company-edit-btn" href="javascript:;" data-id="${company.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="company-del-btn" href="javascript:;" data-id="${company.id}">删除</a>
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

			<#-- 点击添加按钮 -->
			$("#addCompanyBtn").click(function() {
			
				Dialogx.show({
	                _url: '${webServer}/company/add',
					_rules: addCompanyRules
	            });
				
			});

			<#-- 点击编辑按钮 -->
			$(".company-edit-btn").click(function(){
				
				var id = $(this).data("id");
			
				Dialogx.show({
	                _url: '${webServer}/company/edit/' + id,
					_rules: editCompanyRules
	            });
				
			});

			<#-- 点击删除按钮 -->
			$(".company-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该企业?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/company/remove/' + id,
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

// form validate rule
var addCompanyRules = {

	"companyName": {
        tip: "请输入企业名称",
        rule: {
            required: ["请输入企业名称"]
        }
    },
	"companyDesc": {
        tip: "请输入企业描述",
        rule: {
        }
    },
	"adminId": {
        tip: "请输入管理员账号ID,关联FAW_MEMBER.ID",
        rule: {
        }
    },
	"reviewerId": {
        tip: "请输入审核员账号ID,关联FAW_MEMBER.ID",
        rule: {
        }
    }

};
// form validate rule
var editCompanyRules = {

	"companyName": {
        tip: "请输入企业名称",
        rule: {
            required: ["请输入企业名称"]
        }
    },
	"companyDesc": {
        tip: "请输入企业描述",
        rule: {
        }
    },
	"adminId": {
        tip: "请输入管理员账号ID,关联FAW_MEMBER.ID",
        rule: {
        }
    },
	"reviewerId": {
        tip: "请输入审核员账号ID,关联FAW_MEMBER.ID",
        rule: {
        }
    }

};        
    </script>

</html>