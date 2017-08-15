<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />添加会员</title>
		<@layout.globalMeta />
		<@layout.globalCss />
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
                            <h3 class="frame-title">编辑会员</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form class="form-body" id="editMemberForm" action="${webServer}/member/edit" method="POST">
<div class="form-item">
    <h6 class="form-label">用户状态:0.正常,1.待审核,2:拒绝.默认1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="nowStatus" value="${member.nowStatus}" placeholder="请输入用户状态:0.正常,1.待审核,2:拒绝.默认1" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">用户类型.1:批量导入,2:注册,默认1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="memberType" value="${member.memberType}" placeholder="请输入用户类型.1:批量导入,2:注册,默认1" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">用户名:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="loginId" value="${member.loginId}" placeholder="请输入用户名" maxlength="40" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">密码:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="loginPasswd" value="${member.loginPasswd}" placeholder="请输入密码" maxlength="32" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">是否初次登录,Y:初次,N:非初次,默认Y:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="isFirstLogin" value="${member.isFirstLogin}" placeholder="请输入是否初次登录,Y:初次,N:非初次,默认Y" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">企业ID,关联FAW_COMPANY.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyId" value="${member.companyId}" placeholder="请输入企业ID,关联FAW_COMPANY.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">组织ID,关联FAW_AGENCY.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="agencyId" value="${member.agencyId}" placeholder="请输入组织ID,关联FAW_AGENCY.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="memberRole" value="${member.memberRole}" placeholder="请输入用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">姓名:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="fullName" value="${member.fullName}" placeholder="请输入姓名" maxlength="20" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">年龄:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="age" value="${member.age}" placeholder="请输入年龄" maxlength="3" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">职称:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="title" value="${member.title}" placeholder="请输入职称" maxlength="40" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">头像:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="portrial" value="${member.portrial}" placeholder="请输入头像" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">性别.M:男,F:女:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="gender" value="${member.gender}" placeholder="请输入性别.M:男,F:女" maxlength="1" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">联系电话:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="mobileNo" value="${member.mobileNo}" placeholder="请输入联系电话" maxlength="20" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">标签数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="tagCount" value="${member.tagCount}" placeholder="请输入标签数量,默认0" maxlength="3" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">用户描述:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="memberDesc" value="${member.memberDesc}" placeholder="请输入用户描述" maxlength="200" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">投标数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="bidCount" value="${member.bidCount}" placeholder="请输入投标数量,默认0" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">中标数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="winCount" value="${member.winCount}" placeholder="请输入中标数量,默认0" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">被邀请数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="inviteCount" value="${member.inviteCount}" placeholder="请输入被邀请数量,默认0" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">接受数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="acceptCount" value="${member.acceptCount}" placeholder="请输入接受数量,默认0" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">创意数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="ideaCount" value="${member.ideaCount}" placeholder="请输入创意数量,默认0" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">论坛积分,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="bbsPoint" value="${member.bbsPoint}" placeholder="请输入论坛积分,默认0" maxlength="6" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">邀请人ID,关联FAW_MEMBER.ID,导入用户为-1:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="inviterId" value="${member.inviterId}" placeholder="请输入邀请人ID,关联FAW_MEMBER.ID,导入用户为-1" maxlength="12" />
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
		
			$("#editMemberForm").validate(editMemberRules);
			
        });
        
// form validate rule
var editMemberRules = {

	"nowStatus": {
        tip: "请输入用户状态:0.正常,1.待审核,2:拒绝.默认1",
        rule: {
        }
    },
	"memberType": {
        tip: "请输入用户类型.1:批量导入,2:注册,默认1",
        rule: {
        }
    },
	"loginId": {
        tip: "请输入用户名",
        rule: {
            required: ["请输入用户名"]
        }
    },
	"loginPasswd": {
        tip: "请输入密码",
        rule: {
            required: ["请输入密码"]
        }
    },
	"isFirstLogin": {
        tip: "请输入是否初次登录,Y:初次,N:非初次,默认Y",
        rule: {
        }
    },
	"companyId": {
        tip: "请输入企业ID,关联FAW_COMPANY.ID",
        rule: {
        }
    },
	"agencyId": {
        tip: "请输入组织ID,关联FAW_AGENCY.ID",
        rule: {
        }
    },
	"memberRole": {
        tip: "请输入用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1",
        rule: {
            required: ["请输入用户角色,1.普通会员,2:管理员,3:审核员,4专家,.默认1"]
        }
    },
	"fullName": {
        tip: "请输入姓名",
        rule: {
        }
    },
	"age": {
        tip: "请输入年龄",
        rule: {
        }
    },
	"title": {
        tip: "请输入职称",
        rule: {
        }
    },
	"portrial": {
        tip: "请输入头像",
        rule: {
        }
    },
	"gender": {
        tip: "请输入性别.M:男,F:女",
        rule: {
        }
    },
	"mobileNo": {
        tip: "请输入联系电话",
        rule: {
        }
    },
	"tagCount": {
        tip: "请输入标签数量,默认0",
        rule: {
        }
    },
	"memberDesc": {
        tip: "请输入用户描述",
        rule: {
        }
    },
	"bidCount": {
        tip: "请输入投标数量,默认0",
        rule: {
        }
    },
	"winCount": {
        tip: "请输入中标数量,默认0",
        rule: {
        }
    },
	"inviteCount": {
        tip: "请输入被邀请数量,默认0",
        rule: {
        }
    },
	"acceptCount": {
        tip: "请输入接受数量,默认0",
        rule: {
        }
    },
	"ideaCount": {
        tip: "请输入创意数量,默认0",
        rule: {
        }
    },
	"bbsPoint": {
        tip: "请输入论坛积分,默认0",
        rule: {
        }
    },
	"inviterId": {
        tip: "请输入邀请人ID,关联FAW_MEMBER.ID,导入用户为-1",
        rule: {
        }
    }

};        
    </script>

</html>