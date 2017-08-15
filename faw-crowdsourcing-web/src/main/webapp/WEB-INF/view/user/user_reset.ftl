<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/user/addUserReset">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">忘记密码</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">用户名:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="loginId" value="" placeholder="请输入用户名称" maxlength="16" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">手机号码:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="mobileNo" value="" placeholder="请输入手机号码" maxlength="11" />
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