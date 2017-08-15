<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/idea/category/edit" method="POST">
    	<input type="hidden" name="id" value="${ideaCategory.id}" />
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">编辑创意分类</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">分类名称:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="categoryName" value="${ideaCategory.categoryName}" placeholder="请输入分类名称" maxlength="60" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">创意数量,默认0:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="ideaCount" value="${ideaCategory.ideaCount}" placeholder="请输入创意数量,默认0" maxlength="8" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">最后回复ID,关联FAW_IDEA_REPLY.ID:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="lastReplyId" value="${ideaCategory.lastReplyId}" placeholder="请输入最后回复ID,关联FAW_IDEA_REPLY.ID" maxlength="12" />
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