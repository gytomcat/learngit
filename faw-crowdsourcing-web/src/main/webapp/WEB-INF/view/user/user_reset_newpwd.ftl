<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/user/updateUserReset">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">忘记密码</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
            <div class="form-item" style="display:none;">
    <h6 class="form-label">新密码:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="id" value="9" maxlength="16" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">新密码:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="loginPasswd" value="123456789" placeholder="请输入密码" maxlength="16" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">确认密码:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="" value="" placeholder="请确认密码" maxlength="16" />
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