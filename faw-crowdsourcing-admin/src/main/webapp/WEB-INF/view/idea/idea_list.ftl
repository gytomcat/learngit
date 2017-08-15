<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />创意列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "idea" />
			
			<div class="frame-wrapper">
			
				<@menu.idea "idea" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">创意列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/idea/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addIdeaBtn" href="javascript:;"  class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加创意
	                                    </a>
	                                </li>
	                            </ul>
	                        </form>
                            <table class="glb-tables">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        <th>
											标题
										</th>
										<th>
											描述
										</th>
                                        
                                        <th>
											发布人ID,
										</th>
                                        <th>
											发布时间
										</th>
                                        <th>
											更新时间
										</th>
                                        <th>
											浏览人数
										</th>
                                        <th>
											回复人数
										</th>
                                        <th>
											最后回复人
										</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                
								<#if page.totalRow == 0>
                                <tbody>
                                    <tr>
                                        <td class="tbs-col-nodata" colspan="19">
                                            <span class="iconfont icon-data"></span>没有查询到符合条件的记录
                                        </td>
                                    </tr>
                                </tbody>
                                
                            	<#else>
                                <tbody>
                                	<#list page.ideaList as idea>
                                    <tr>
                                        <td>${idea_index + 1}</td>
                                        <td>${idea.ideaTitle}</td>
                                        <td>${idea.ideaDesc}</td>
                                        
                                        <td>${idea.releaseId}</td>
                                        <td>${idea.releaseTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${idea.updateTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${idea.viewCount}</td>
                                        <td>${idea.replyCount}</td>
                                        <td>${idea.lastReplyContent}</td>
                                        <#-- 
                                        <#if idea.reviewTime??>
                                        <td>${idea.reviewTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <#else>
                                        <td>待定</td>
                                        </#if>
                                        -->
                                        <td>
                                            <a class="idea-detail-btn" href="${webServer}/idea/detail/${idea.id}" data-id="${idea.id}">查看创意详细</a>
                                            <#--<a id="editIdeaBtn" class="idea-edit-btn" href="javascript:;" data-id="${idea.id}">编辑</a>-->
                                        </td>
                                    </tr>
                                    </#list>
                                </tbody>
                                <tfoot>
                                    <td colspan="19">
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
			$("#addIdeaBtn").click(function() {
			
				Dialogx.show({
	                _url: '${webServer}/idea/add',
					_rules: addIdeaRules
	            });
				
			});

			<#-- 点击编辑按钮 
			$("#editIdeaBtn").click(function(){
				
				var id = $(this).data("id");
			
				Dialogx.show({
	                _url: '${webServer}/idea/edit/' + id,
					_rules: editIdeaRules
	            });
				
			});
			-->
			<#-- 点击删除按钮 -->
			$(".idea-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/idea/remove/' + id,
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
var addIdeaRules = {

	"ideaTitle": {
        tip: "请输入标题",
        rule: {
            required: ["请输入标题"]
        }
    },
	"ideaDesc": {
        tip: "请输入描述",
        rule: {
        }
    },
	"categoryId": {
        tip: "请输入分类ID,关联FAW_CATEGORY.ID",
        rule: {
            required: ["请输入分类ID,关联FAW_CATEGORY.ID"]
        }
    },
	"isIdea": {
        tip: "请输入是否是创意,Y:是,N:否,默认N",
        rule: {
        }
    }

};
// form validate rule
var editIdeaRules = {

	"ideaTitle": {
        tip: "请输入标题",
        rule: {
            required: ["请输入标题"]
        }
    },
	"ideaDesc": {
        tip: "请输入描述",
        rule: {
        }
    },
	"categoryId": {
        tip: "请输入分类ID,关联FAW_CATEGORY.ID",
        rule: {
            required: ["请输入分类ID,关联FAW_CATEGORY.ID"]
        }
    },
	"isIdea": {
        tip: "请输入是否是创意,Y:是,N:否,默认N",
        rule: {
        }
    }


};        
    </script>

</html>