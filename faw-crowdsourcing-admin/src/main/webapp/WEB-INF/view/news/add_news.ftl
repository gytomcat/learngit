<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="zh-CN" lang="zh-CN">
	<head>
		<meta charset="utf-8" />
		<title><@layout.globalTitle />添加新闻</title>
		<@layout.globalMeta />
		<@layout.globalCss />
		
	<script type="text/javascript" charset="utf-8" src="http://ui.dditclub.com/js/ue/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="http://ui.dditclub.com/js/ue/ueditor.all.js"> </script>
    <!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
    <!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
         <script type="text/javascript" charset="utf-8" src="http://ui.dditclub.com/js/ue/lang/zh-cn/zh-cn.js"></script>
    
    <style type="text/css">
        div{
            width:100%;
            
        }
    </style>
		
	</head>
	<body>
	
		<@layout.header />

		<div id="frameBody" class="frame-body frame-body-full">
		
			<@menu.main "system" />
			
			<div class="frame-wrapper">
			
				<@menu.system "news" />
				
                <div class="frame-page">
                    <div class="frame-main">
                        <div class="frame-main-hd">
                            <h3 class="frame-title"style="padding-left:16px;">添加新闻</h3>
                        </div>
                        <div class="frame-main-bd">
	                        <form class="form-body" id="addNewsForm" action="${webServer}/news/add" method="POST">
<div class="form-item">
    <h6 class="form-label">新闻分类</h6>
    <div class="form-entity">
        <div class="form-field">
         <dl class="glb-selector glb-selector-blk">
	<dt class="dt-empty">
	    	<input type="hidden" class="form-hidden" name="newsCategory" value="">
	</dt>
	<dd class="on">
	    <a class="option" href="javascript:;">
	        <h6>普通</h6>
	        <input class="form-cb" type="checkbox"  name="newsCategory" value="1">
	    </a>
	</dd>
	
</dl>
            
        </div>
    </div>
</div>
<div class="form-item">
    <h6 class="form-label">新闻标题:</h6>
    <div class="form-entity">
        <div class="form-field">
            <input class="form-ipt" type="text" name="newsTitle" value="" placeholder="请输入新闻标题" maxlength="100" />
        </div>
    </div>
</div>
<div>
    <textarea id="editor"  name="newsDesc"   type="text/plain" style=""></textarea>
 </div>

<div class="form-item">
    <h6 class="form-label">是否置顶</h6>
    <div class="form-entity">
        <div class="form-field">
         <dl class="glb-selector glb-selector-blk">
	<dt class="dt-empty">
	    	<input type="hidden" class="form-hidden" name="isTop" value="">
	</dt>
	<dd class="on">
	    <a class="option" href="javascript:;">
	        <h6>不置顶</h6>
	        <input class="form-cb" type="checkbox"  name="" value="N">
	    </a>
	</dd>
	<dd >
	    <a class="option" href="javascript:;">
	        <h6>置顶</h6>
	        <input class="form-cb" type="checkbox"  name="" value="Y">
	    </a>
	</dd>
</dl>
           
        </div>
    </div>
</div>
								<div class="form-action clearfix">
	                                <input type="submit" class="glb-button glb-btn-primary" value="提交" />
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </body>

	<@layout.globalJs />
	<script type="text/javascript" src="${jsServer}/validate.js" charset="utf-8"></script>
    <script type="text/javascript">
    
    //实例化编辑器
    //建议使用工厂方法getEditor创建和引用编辑器实例，如果在某个闭包下引用该编辑器，直接调用UE.getEditor('editor')就能拿到相关的实例
      
     var ue = UE.getEditor('editor',{
      toolbars: [[
            'fullscreen', 'source', '|', 'undo', 'redo', '|',
            'bold', 'italic', 'underline', 'fontborder', 'strikethrough', 'superscript', 'subscript', 'removeformat', 'formatmatch', 'autotypeset', 'blockquote', 'pasteplain', '|', 'forecolor', 'backcolor', 'insertorderedlist', 'insertunorderedlist', 'selectall', 'cleardoc', '|',
            'rowspacingtop', 'rowspacingbottom', 'lineheight', '|',
            'customstyle', 'paragraph', 'fontfamily', 'fontsize', '|',
            'directionalityltr', 'directionalityrtl', 'indent', '|',
            'justifyleft', 'justifycenter', 'justifyright', 'justifyjustify', '|', 'touppercase', 'tolowercase', '|',
            'link', 'unlink', 'anchor', '|', 'imagenone', 'imageleft', 'imageright', 'imagecenter', '|',
            'simpleupload', 'insertimage', 'emotion', 'scrawl', 'insertvideo', 'music', 'attachment', 'map', 'gmap', 'insertframe', 'insertcode', 'webapp', 'pagebreak', 'template', 'background', '|',
            'horizontal', 'date', 'time', 'spechars', 'snapscreen', 'wordimage', '|',
            'inserttable', 'deletetable', 'insertparagraphbeforetable', 'insertrow', 'deleterow', 'insertcol', 'deletecol', 'mergecells', 'mergeright', 'mergedown', 'splittocells', 'splittorows', 'splittocols', 'charts', '|',
            'print', 'preview', 'searchreplace', 'drafts', 'help'
        ]],
       
        autoHeightEnabled: false,
        autoFloatEnabled: true,
        initialFrameWidth: 600,//编辑器宽度，默认1000
        initialFrameHeight: 200,//编辑器高度，默认320
        maximumWords: 4000//最大字符数
    });
    
    
    
    
		//DOM READY
        $(function() {
		
			$("#addNewsForm").validate(addNewsRules);
			
        });
        
// form validate rule
var addNewsRules = {

	"newsCategory": {
        tip: "请输入新闻分类.1:普通,默认1",
        rule: {
        }
    },
	"newsTitle": {
        tip: "请输入新闻标题",
        rule: {
            required: ["请输入新闻标题"]
        }
    },
	"newsDesc": {
        tip: "请输入新闻内容",
        rule: {
        }
    },
	"isTop": {
        tip: "请输入是否置顶,Y:置顶,N:不置顶,默认N",
        rule: {
        }
    }

};        
    </script>

</html>