<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/company/add">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">创建企业</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">企业名称:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyName" value="" placeholder="请输入企业名称" maxlength="60" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">企业描述:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyDesc" value="" placeholder="请输入企业描述" maxlength="400" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">管理员账号ID,关联FAW_MEMBER.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="adminId" value="" placeholder="请输入管理员账号ID,关联FAW_MEMBER.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">审核员账号ID,关联FAW_MEMBER.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="reviewerId" value="" placeholder="请输入审核员账号ID,关联FAW_MEMBER.ID" maxlength="12" />
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