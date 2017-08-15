<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />添加消息</title>
		<@layout.globalMeta />
		<@layout.globalCss />
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "system" />
			
			<div class="frame-wrapper">
			
				<@menu.system "message" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title">编辑消息</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form class="form-body" id="editMessageForm" action="${webServer}/message/edit" method="POST">
<div class="form-item">
    <h6 class="form-label">发送人ID,关联FAW_MEMBER.ID,系统发送为-1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="senderId" value="${message.senderId}" placeholder="请输入发送人ID,关联FAW_MEMBER.ID,系统发送为-1" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">消息标题:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="msgTitle" value="${message.msgTitle}" placeholder="请输入消息标题" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">消息内容:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="msgDesc" value="${message.msgDesc}" placeholder="请输入消息内容" maxlength="500" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">消息类型,1.系统消息,2.站内信:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="msgType" value="${message.msgType}" placeholder="请输入消息类型,1.系统消息,2.站内信" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">消息类别.1:系统消息,2.招投标,3.活动,4.论坛:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="msgCategory" value="${message.msgCategory}" placeholder="请输入消息类别.1:系统消息,2.招投标,3.活动,4.论坛" maxlength="1" />
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
		
			$("#editMessageForm").validate(editMessageRules);
			
        });
        
// form validate rule
var editMessageRules = {

	"senderId": {
        tip: "请输入发送人ID,关联FAW_MEMBER.ID,系统发送为-1",
        rule: {
            required: ["请输入发送人ID,关联FAW_MEMBER.ID,系统发送为-1"]
        }
    },
	"msgTitle": {
        tip: "请输入消息标题",
        rule: {
            required: ["请输入消息标题"]
        }
    },
	"msgDesc": {
        tip: "请输入消息内容",
        rule: {
        }
    },
	"msgType": {
        tip: "请输入消息类型,1.系统消息,2.站内信",
        rule: {
            required: ["请输入消息类型,1.系统消息,2.站内信"]
        }
    },
	"msgCategory": {
        tip: "请输入消息类别.1:系统消息,2.招投标,3.活动,4.论坛",
        rule: {
        }
    }

};        
    </script>

</html>