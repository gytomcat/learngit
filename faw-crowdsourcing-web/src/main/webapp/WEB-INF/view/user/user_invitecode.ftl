<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/user/addInviteCode">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">发送邀请码</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">收件人邮箱:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="email" value="" placeholder="收件人邮箱" maxlength="16" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">所属企业:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyId" value="" placeholder="所属企业:" maxlength="32" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">所属部门:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="agencyId" value="" placeholder="所属部门:" maxlength="32" />
        </div>
    </div>
</div>
            </div>
        </div>
        <div class="dialog-foot">
            <a href="javascript:;" class="glb-button glb-btn-default dialog-close-btn">取消</a>
        	<input type="submit" class="glb-button glb-btn-primary value="创建" />
        </div>
    </form>
</div>