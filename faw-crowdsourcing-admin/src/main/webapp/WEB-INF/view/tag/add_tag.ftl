<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/tag/add">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">创建标签</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">标签名称:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="tagName" value="" placeholder="请输入标签名称" maxlength="20" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">标签描述:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="tagDesc" value="" placeholder="请输入标签描述" maxlength="200" />
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