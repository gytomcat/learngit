<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />添加反馈</title>
		<@layout.globalMeta />
		<@layout.globalCss />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "system" />
			
			<div class="frame-wrapper">
			
				<@menu.system "feedback" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">编辑反馈</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form class="form-body" id="editFeedbackForm" action="${webServer}/feedback/edit" method="POST">
<div class="form-item">
    <h6 class="form-label">反馈人ID,关联FAW_MEMBER.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="feedbackId" value="${feedback.feedbackId}" placeholder="请输入反馈人ID,关联FAW_MEMBER.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">反馈分类.1:系统错误,2::咨询:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="feedbackType" value="${feedback.feedbackType}" placeholder="请输入反馈分类.1:系统错误,2::咨询" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">反馈标题:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="feedbackTitle" value="${feedback.feedbackTitle}" placeholder="请输入反馈标题" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">反馈内容:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="feedbackDesc" value="${feedback.feedbackDesc}" placeholder="请输入反馈内容" maxlength="500" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">是否回复.Y:已回复.N:未回复,默认N:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="isReply" value="${feedback.isReply}" placeholder="请输入是否回复.Y:已回复.N:未回复,默认N" maxlength="1" />
        </div>
    </div>
</div>
								<div class="form-action clearfix">
	                                <input type="submit" class="glb-button glb-btn-primary" value="更新" />
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
		
			$("#editFeedbackForm").validate(editFeedbackRules);
			
        });
        
// form validate rule
var editFeedbackRules = {

	"feedbackId": {
        tip: "请输入反馈人ID,关联FAW_MEMBER.ID",
        rule: {
            required: ["请输入反馈人ID,关联FAW_MEMBER.ID"]
        }
    },
	"feedbackType": {
        tip: "请输入反馈分类.1:系统错误,2::咨询",
        rule: {
        }
    },
	"feedbackTitle": {
        tip: "请输入反馈标题",
        rule: {
            required: ["请输入反馈标题"]
        }
    },
	"feedbackDesc": {
        tip: "请输入反馈内容",
        rule: {
        }
    },
	"isReply": {
        tip: "请输入是否回复.Y:已回复.N:未回复,默认N",
        rule: {
        }
    },

};        
    </script>

</html>