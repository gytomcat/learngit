<!--<div class="dialog-box dialog-box-form">
    <div class="dialog-foot">
    	<input type="file" id="mobanFile" name="wordFilePath" />
    	<button id="btnUpload" type="button" class="btn btn-primary" >上传模板</button>
    	<button id="btnDown" type="button" class="btn btn-primary" onclick="fileDown()">下载模板</button>
    </div>
</div>-->
<div class="col-lg-9 col-padding-main">
    <div id="sysglPanel" class="panel panel-default">
        <div class="panel-body">
            <div id="sysglToolbar" class="btn-group">
                <button id="importBtn" type="button" class="btn btn-primary" onclick="fileUpload()">
                    <span class="glyphicon glyphicon-import" aria-hidden="true"></span>批量导入
                </button>
            </div>
        </div>
    </div>
</div>
<div class="modal-body">
	<div class="input-group" onclick="$('#upLoadFile')[0].click();">
	    <input class="form-control" id="editFileText" readonly="readonly" type="text" placeholder="请选择文件"> 
	    <span class="input-group-btn"> 
	    	<input type="file" id="upLoadFile" name="upLoadFile" onchange="fileInputChange(this.value,'.doc,.docx,.xlsx,.xls','editFileText')" />
	        <button class="btn btn-primary" type="button">选择文件...</button>
	    </span>
	</div>
</div>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${jsServer}/ajaxfileupload.js" charset="utf-8"></script>
<script type="text/javascript">
	function fileUpload(){
		$.ajaxFileUpload({
			type:'POST',
	        url: '${webServer}/member/import/', //用于文件上传的服务器端请求地址
	        secureuri: false, //是否需要安全协议，一般设置为false
	        fileElementId: 'upLoadFile', //文件上传域的ID
	        dataType: 'json', //返回值类型 一般设置为json
	        success: function (data, status)  //服务器成功响应处理函数
	        {
	            alert(data);
	        },
	        error: function (data, status, e)//服务器响应失败处理函数
	        {
	            alert("2"+e);
	        }
	    });
	}
</script>