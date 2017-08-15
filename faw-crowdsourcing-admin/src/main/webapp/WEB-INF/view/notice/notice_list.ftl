<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />公告列表</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		<@layout.globalJs />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "system" />
			
			<div class="frame-wrapper">
			
				<@menu.system "notice" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">公告列表</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form id="listForm" action="${webServer}/notice/list" method="GET">
	                        	<ul class="glb-search">
	                                <li class="glb-col-right">
	                                    <a id="addNoticeBtn" href="javascript:;" class="glb-button glb-btn-primary">
	                                        <span class="iconfont icon-members"></span> 添加公告
	                                    </a>
	                                </li>
	                            </ul>
	                        </form>
                            <table class="glb-tables">
                                <thead>
                                    <tr>
                                        <th>No.</th>
                                        
                                        <th>
											创建时间
										</th>
                                     
                                        <th>
											通知标题
										</th>
                                     
                                        <th>
        								 通知类型
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
                                	<#list page.noticeList as notice>
                                    <tr>
                                        <td>${notice_index + 1}</td>
                                        <td>${notice.createTime?string("yyyy-MM-dd hh:mm")}</td>
                                        <td>${notice.noticeTitle}</td>
                                       
                                        <#if notice.noticeType == 1>
                                        <td>通知</td>
                                        </#if>
                                        <td>
                                            <a class="notice-edit-btn" href="javascript:;" data-id="${notice.id}">编辑</a>
                                            <span class="tbs-split">|</span>
                                            <a class="notice-del-btn" href="javascript:;" data-id="${notice.id}">删除</a>
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
			$("#addNoticeBtn").click(function() {
			
				Dialogx.show({
	                _url: '${webServer}/notice/add',
					_rules: addNoticeRules
	            });
				
			});

			<#-- 点击编辑按钮 -->
			$(".notice-edit-btn").click(function(){
				
				var id = $(this).data("id");
			
				Dialogx.show({
	                _url: '${webServer}/notice/edit/' + id,
					_rules: editNoticeRules
	            });
				
			});

			<#-- 点击删除按钮 -->
			$(".notice-del-btn").click(function(){
				
				var id = $(this).data("id");
				
				Dialogx.confirm('删除后不可恢复,确定删除该公告?', function() {
					
					Frame.showWaiting("正在删除,请稍后");
					
                    $.ajax({
                    	url: '${webServer}/notice/remove/' + id,
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
var addNoticeRules = {

	"noticeTitle": {
        tip: "请输入通知标题",
        rule: {
            required: ["请输入通知标题"]
        }
    },
	"noticeDesc": {
        tip: "请输入通知内容",
        rule: {
        }
    },
	"noticeType": {
        tip: "请输入通知类型",
        rule: {
        required: ["通知"]
        }
    }

};
// form validate rule
var editNoticeRules = {

	"noticeTitle": {
        tip: "请输入通知标题",
        rule: {
            required: ["请输入通知标题"]
        }
    },
	"noticeDesc": {
        tip: "请输入通知内容",
        rule: {
        }
    },
	"noticeType": {
        tip: "请输入通知类型",
        rule: {
        
        }
    }

};        
    </script>

</html>