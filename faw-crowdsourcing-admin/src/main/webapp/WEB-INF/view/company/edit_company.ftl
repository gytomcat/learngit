<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/company/edit">
    	<input type="hidden" name="id" value="${company.id}" />
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">编辑企业</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">企业名称:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyName" value="${company.companyName}" placeholder="请输入企业名称" maxlength="60" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">企业描述:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="companyDesc" value="${company.companyDesc}" placeholder="请输入企业描述" maxlength="400" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">管理员账号ID,关联FAW_MEMBER.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="adminId" value="${company.adminId}" placeholder="请输入管理员账号ID,关联FAW_MEMBER.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">审核员账号ID,关联FAW_MEMBER.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="reviewerId" value="${company.reviewerId}" placeholder="请输入审核员账号ID,关联FAW_MEMBER.ID" maxlength="12" />
        </div>
    </div>
</div>
            </div>
        </div>
        <div class="dialog-foot">
            <a href="javascript:;" class="glb-button glb-btn-default dialog-close-btn">取消</a>
        	<input type="submit" class="glb-button glb-btn-primary value="更新" />
        </div>
    </form>
</div>