<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/idea/edit" method="POST">
        <input type="hidden" name="id" value="${idea.id}" />
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">编辑创意</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">

<div class="form-item">
    <h6 class="form-label">标题:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="ideaTitle" value="" placeholder="请输入标题" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">描述:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="ideaDesc" value="" placeholder="请输入描述" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">分类ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="categoryId" value="" placeholder="请输入分类ID,关联FAW_CATEGORY.ID" maxlength="12" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">是否是创意:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="isIdea" value="" placeholder="请输入是否是创意,Y:是,N:否,默认N" maxlength="1" />
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

