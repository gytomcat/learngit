<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />添加项目</title>
		<@layout.globalMeta />
		<@layout.globalCss />
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
                            <h3 class="frame-title">添加项目</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form class="form-body" id="addProjectForm" action="${webServer}/project/add" method="POST">
<div class="form-item">
    <h6 class="form-label">状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="nowStatus" value="" placeholder="请输入状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收." maxlength="2" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">发标企业ID,关联FAW_COMPANY.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyId" value="" placeholder="请输入发标企业ID,关联FAW_COMPANY.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">发标部门ID,关联FAW_DEPT.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="agencyId" value="" placeholder="请输入发标部门ID,关联FAW_DEPT.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">发布人ID,关联FAW_MEMBER.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="releaseId" value="" placeholder="请输入发布人ID,关联FAW_MEMBER.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">是否公开.Y:公开,N:不公开,默认N:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="isOpen" value="" placeholder="请输入是否公开.Y:公开,N:不公开,默认N" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">是否发布.Y:已发布,N:未发布,默认N:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="isRelease" value="" placeholder="请输入是否发布.Y:已发布,N:未发布,默认N" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">标题:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="projectTitle" value="" placeholder="请输入标题" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">要求:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="projectDesc" value="" placeholder="请输入要求" maxlength="" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">价格:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="price" value="" placeholder="请输入价格" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">制作周期:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="period" value="" placeholder="请输入制作周期" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">投标人数,不限人数为-1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="bidAmount" value="" placeholder="请输入投标人数,不限人数为-1" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">中标人数,默认1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="winAmount" value="" placeholder="请输入中标人数,默认1" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">中标ID,关联FAW_BID.ID未选标是为-1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="winBidId" value="" placeholder="请输入中标ID,关联FAW_BID.ID未选标是为-1" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">创意ID,关联FAW_IDEA.ID,无创意为-1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="ideaId" value="" placeholder="请输入创意ID,关联FAW_IDEA.ID,无创意为-1" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">是否有专利,Y:有专利,N:无专利,默认N:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="isPatent" value="" placeholder="请输入是否有专利,Y:有专利,N:无专利,默认N" maxlength="1" />
        </div>
    </div>
</div>
								<div class="form-action clearfix">
	                                <input type="submit" class="glb-button glb-btn-primary" value="提交" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

	<@layout.globalJs />
	<script type="text/javascript" src="${jsServer}/validate.js" charset="utf-8"></script>
    <script type="text/javascript">
    
		//DOM READY
        $(function() {
		
			$("#addProjectForm").validate(addProjectRules);
			
        });
        
// form validate rule
var addProjectRules = {

	"nowStatus": {
        tip: "请输入状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收.",
        rule: {
            required: ["请输入状态,-8.已过期,-9.已取消,-1:待审核,-2:审核未通过,0:已完成,1.招标中,2.选标中,3.已选标,4.生产中,5.待验收."]
        }
    },
	"companyId": {
        tip: "请输入发标企业ID,关联FAW_COMPANY.ID",
        rule: {
            required: ["请输入发标企业ID,关联FAW_COMPANY.ID"]
        }
    },
	"agencyId": {
        tip: "请输入发标部门ID,关联FAW_DEPT.ID",
        rule: {
            required: ["请输入发标部门ID,关联FAW_DEPT.ID"]
        }
    },
	"releaseId": {
        tip: "请输入发布人ID,关联FAW_MEMBER.ID",
        rule: {
            required: ["请输入发布人ID,关联FAW_MEMBER.ID"]
        }
    },
	"isOpen": {
        tip: "请输入是否公开.Y:公开,N:不公开,默认N",
        rule: {
        }
    },
	"isRelease": {
        tip: "请输入是否发布.Y:已发布,N:未发布,默认N",
        rule: {
        }
    },
	"projectTitle": {
        tip: "请输入标题",
        rule: {
            required: ["请输入标题"]
        }
    },
	"projectDesc": {
        tip: "请输入要求",
        rule: {
        }
    },
	"price": {
        tip: "请输入价格",
        rule: {
        }
    },
	"period": {
        tip: "请输入制作周期",
        rule: {
        }
    },
	"bidAmount": {
        tip: "请输入投标人数,不限人数为-1",
        rule: {
        }
    },
	"winAmount": {
        tip: "请输入中标人数,默认1",
        rule: {
        }
    },
	"winBidId": {
        tip: "请输入中标ID,关联FAW_BID.ID未选标是为-1",
        rule: {
        }
    },
	"ideaId": {
        tip: "请输入创意ID,关联FAW_IDEA.ID,无创意为-1",
        rule: {
        }
    },
	"isPatent": {
        tip: "请输入是否有专利,Y:有专利,N:无专利,默认N",
        rule: {
        }
    }

};        
    </script>

</html>