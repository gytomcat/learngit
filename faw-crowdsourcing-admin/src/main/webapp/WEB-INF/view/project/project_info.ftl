<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />项目详情</title>
		<@layout.globalMeta />
		<@layout.globalCss />
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
                            <h3 class="frame-title">项目详情</h3>
                        </div>
						<div class="form-item">
						    <h6 class="form-label">项目名称：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.projectTitle}
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">项目简介：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.projectDesc}
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">发标企业：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.companyName}
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">发标部门：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.deptName}
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">发布人：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.memberName}
						        </div>
						    </div>
						</div>
						<#if project.reviewTime ??>
						<div class="form-item">
						    <h6 class="form-label">审核时间：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.reviewTime?string("yyyy-MM-dd hh:mm")}
						        </div>
						    </div>
						</div>
						</#if>
						<div class="form-item">
						    <h6 class="form-label">是否有专利：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            <#if project.isPatent == 'Y'>
                                		是
                                	<#else>
                                		否
                                	</#if>
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">是否公开：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						        	<#if project.isOpen == 'Y'>
                                		是
                                	<#else>
                                		否
                                	</#if>
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">是否发布：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            <#if project.isRelease == 'Y'>
                                		是
                                	<#else>
                                		否
                                	</#if>
						        </div>
						    </div>
						</div>
						<#if project.releaseTime ??>
						<div class="form-item">
						    <h6 class="form-label">发布时间：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.releaseTime?string("yyyy-MM-dd hh:mm")}
						        </div>
						    </div>
						</div>
						</#if>
						<#if project.bidEndTime ??>
						<div class="form-item">
						    <h6 class="form-label">招标截止时间：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.bidEndTime?string("yyyy-MM-dd hh:mm")}
						        </div>
						    </div>
						</div>
                        </#if>
						<div class="form-item">
						    <h6 class="form-label">价格：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						        	<#if project.price??>
						             ${project.price?string(",###0.00#")} 元
						            </#if>
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">制作周期：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.period} 个月
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">投标人数：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.bidAmount} 人
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">中标人数：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.winAmount} 人
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">中标供应商：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            dd
						        </div>
						    </div>
						</div>
						<div class="form-item">
						    <h6 class="form-label">评分：</h6>
						    <div class="form-entity">
						        <div class="form-field">
						            ${project.score} 分
						        </div>
						    </div>
						</div>
						<hr/>
						附件信息：<br/>
						<#list projectFiles as pfile>
							${pfile.filePath}/${pfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
							<#if pfile.fileType == 1>
								发标文件
							<#else>
								专利
							</#if>
							<a href="${webServer}/project/doc/download?filePath=${pfile.filePath}" target="_blank">下载</a>
							<br/>
						</#list>
						<hr/>
						投标公司：<br/>
						<#assign bidCount = 0>
						<#list allBidService as ps>
							<#if ps.nowStatus == 2>
							<#assign bidCount= bidCount +  1>
							</#if>
						</#list>
						<#list allBidService as ps>
							 ${ps.project.companyName} 
							 <#if ps.nowStatus == -1>
							 	已取消
							 <#elseif ps.nowStatus == 1>
							 	待投标
							 <#elseif ps.nowStatus == 2>
							 	已投标
							 <#elseif ps.nowStatus == 3>
							 	已拒绝
							 <#elseif ps.nowStatus == 4>
							 	未中标
							 <#elseif ps.nowStatus == 5>
							 	已中标待审核
							 <#elseif ps.nowStatus == 6>
							 	审核成功待确认
							 <#elseif ps.nowStatus == 7>
						 		审核未通过
							 <#elseif ps.nowStatus == 8>
							 	已确认,生产中
							 <#elseif ps.nowStatus == 9>
							 	待验收
							 <#elseif ps.nowStatus == 10>
							 	验收失败
							 <#elseif ps.nowStatus == 0>
							 	已完成
							 </#if>
							 <#if (bidCount > 2) >
							 	<#if ps.nowStatus == 2>
							 		<a href="javascript:;" class="chooseBid" bidId="${ps.id}">选标</a>
							 	</#if>
							 </#if>
							 <br/>
							投标文件：<br/>
							 <#list ps.bidFiles as bfile>
								${bfile.filePath}/${bfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
								<#if bfile.fileType == 1>
									投标文件
								<#elseif bfile.fileType == 2>
									交付文件
								<#else>
									发票
								</#if>
								/ <a href="${webServer}/project/bid/download?filePath=${bfile.filePath}" target="_blank">下载</a>
								<br/>
							</#list>
							<br/>
							<#if ps.nowStatus &gt; 7 || ps.nowStatus == 0>
							交付文件：<br/>
							<#list ps.checkFiles as bfile>
								${bfile.filePath}/${bfile.createTime?string("yyyy-MM-dd HH:mm:ss")}/
								<#if bfile.fileType == 1>
									投标文件
								<#elseif bfile.fileType == 2>
									交付文件
								<#else>
									发票
								</#if>
								/ <a href="${webServer}/project/result/download?filePath=${bfile.filePath}" target="_blank">下载</a>
								<br/>
							</#list>
							</#if>
						</#list>
						<br/>
	            	</div>
	            </div>
	        </div>
	    </div>
	</body>
		
	<@layout.globalJs />
</html>