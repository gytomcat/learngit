<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/idea/category/add" method="POST">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">创建创意分类</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">分类名称:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="categoryName" value="" placeholder="请输入分类名称" maxlength="60" />
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