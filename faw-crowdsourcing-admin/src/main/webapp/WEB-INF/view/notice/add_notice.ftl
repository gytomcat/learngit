<div class="dialog-box dialog-box-form">
    <form class="dialog-content" action="${webServer}/notice/add">
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">创建公告</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">通知标题:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="noticeTitle" value="" placeholder="请输入通知标题" maxlength="100" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">通知内容:</h6>
    <div class="form-entity">
        <div class="form-field">
            <textarea class="form-ta" type="text" name="noticeDesc" value="" placeholder="请输入通知内容" maxlength="2000" ></textarea>
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">通知类型</h6>
    <div class="form-entity">
        <div class="form-field">
         
            <dl class="glb-selector glb-selector-blk">
	<dt class="dt-empty">
	    	<input type="hidden" class="form-hidden" name="noticeType" value="">
	</dt>
	<dd class="on">
	    <a class="option" href="javascript:;">
	        <h6>通知</h6>
	        <input class="form-cb" type="checkbox"  name="noticeType" value="1">
	    </a>
	</dd>
	
</dl>
        </div>
    </div>
</div>
          
	
            
        <div class="dialog-foot">
            <a href="javascript:;" class="glb-button glb-btn-default dialog-close-btn">取消</a>
        	<input type="submit" class="glb-button glb-btn-primary value="创建" />
        </div>
    </form>
</div>