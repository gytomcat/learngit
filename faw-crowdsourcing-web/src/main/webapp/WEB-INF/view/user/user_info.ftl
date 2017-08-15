<div class="dialog-box dialog-box-form">
<input type="hidden" name="id" id="id" value="9"> 　　
        <div class="dialog-head">
            <a class="dialog-close-btn" href="javascript:;">×</a>
            <h4 class="dialog-title">个人资料</h4>
        </div>
        <div class="dialog-body">
            <div class="form-body">
<div class="form-item">
    <h6 class="form-label">真实姓名:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" id="fullName" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">用户名:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" id="loginId"/>
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">年龄:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" id="age" />
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">性别:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" id="gender"/>
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">手机号:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" id="mobileNo"/>
        </div>
    </div>
</div>


<div class="form-item">
    <h6 class="form-label">照片:</h6>
    <div class="form-entity">
        <div class="form-field">
            <span id="preview"><img src="" style="width:100px;height:100px;"/></span>
            <input type="button" value="上传图片" onclick="file1.click();"></input>
        </div>
    </div>
</div>
<input type="file" name="file1" id="file1" style="width:80%;display:none" onchange="preview(this,'preview');"/>   
            </div>
        </div>
        <div class="dialog-foot">
            <a href="javascript:;" class="glb-button glb-btn-default dialog-close-btn">取消</a>
        	<input type="submit" onclick="ajaxFileUpload()"  class="glb-button glb-btn-primary value="创建" />
        </div>

</div>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${jsServer}/ajaxfileupload.js" charset="utf-8"></script>

<script type="text/javascript">      
		//展示图片
        function preview(file,previewid){  
        	
            var prevDivId = previewid.toString();  
            var prevDiv = document.getElementById(prevDivId);    
            if (file.files && file.files[0]){    
                var reader = new FileReader();    
                reader.onload = function(evt){    
                    prevDiv.innerHTML = '<img width="100" height="100" src="' + evt.target.result + '" />';    
                }      
                reader.readAsDataURL(file.files[0]);    
            }else{    
                prevDiv.innerHTML = '<div class="img" style="filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale,src=\'' + file.value + '\'"></div>';    
            }    
        }
       
       //上传
        function ajaxFileUpload() {
            $.ajaxFileUpload
            (
                {
                    url: '${webServer}/user/updateUserInfo', //用于文件上传的服务器端请求地址
                    secureuri: false, //是否需要安全协议，一般设置为false
                    data: {
                    	id:$("#id").val(),
                    	loginId:$("#loginId").val(),
                    	fullName:$("#fullName").val(),
                    	age:$("#age").val(),
                    	portrial:$("#loginId").val(),
                    	gender:$("#gender").val(),
                    	mobileNo:$("#mobileNo").val()
                    },
                    fileElementId: 'file1', //文件上传域的ID
                    dataType: 'json', //返回值类型 一般设置为json
                    success: function (data, status)  //服务器成功响应处理函数
                    {
                        alert(status);
                    },
                    error: function (data, status, e)//服务器响应失败处理函数
                    {
                        alert(e);
                    }
                }
            )
            return false;
        }
            
 </script> 
       