<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />创意分类列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "idea" />
			
			<div class="frame-wrapper">
			
				<@menu.idea "ideaCategory" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">创意分类列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/idea/category/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addIdeaCategoryBtn" href="javascript:;" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加创意分类
	                                    </a>
	                                </li>
	                            </ul>
	                        </form>
                            <table class="glb-tables">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>ID.</th>
                                        <th>
											分类名称
										</th>
                                        <th>
											创意数量
										</th>
                                        <th>
											创建时间
										</th>
                                        <th>
											更新时间
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="8">
                                            <span class="iconfont icon-data"></span>没有查询到符合条件的记录
                                        </td>
                                    </tr>
                                </tbody>
                                
                            	<#else>
                                <tbody>
                                	<#list page.ideaCategoryList as ideaCategory>
                                    <tr>
                                        <td>${ideaCategory_index + 1}</td>
                                        <td>${ideaCategory.id}</td>
                                        <td>${ideaCategory.categoryName}</td>
                                        <td>${ideaCategory.ideaCount}</td>
                                        <td>${ideaCategory.createTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${ideaCategory.updateTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>
                                            <a class="ideaCategory-edit-btn" href="javascript:;" data-id="${ideaCategory.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="ideaCategory-del-btn" href="javascript:;" data-id="${ideaCategory.id}">删除</a>
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="8">
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
			$("#addIdeaCategoryBtn").click(function() {
			
				Dialogx.show({
	                _url: '${webServer}/idea/category/add',
					_rules: addIdeaCategoryRules
	            });
				
			});

			<#-- 点击编辑按钮 -->
			$(".ideaCategory-edit-btn").click(function(){
				
				var id = $(this).data("id");
			
				Dialogx.show({
	                _url: '${webServer}/idea/category/edit/' + id,
					_rules: editIdeaCategoryRules
	            });
				
			});

			<#-- 点击删除按钮 -->
			$(".ideaCategory-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该创意分类?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/idea/category/remove/' + id,
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
var addIdeaCategoryRules = {

	"categoryName": {
        tip: "请输入分类名称",
        rule: {
            required: ["请输入分类名称"]
        }
    }

};
// form validate rule
var editIdeaCategoryRules = {

	"categoryName": {
        tip: "请输入分类名称",
        rule: {
            required: ["请输入分类名称"]
        }
    }

};        
    </script>

</html>