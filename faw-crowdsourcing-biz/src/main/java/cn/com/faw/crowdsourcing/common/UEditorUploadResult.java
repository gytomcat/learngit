package cn.com.faw.crowdsourcing.common;

import org.apache.commons.lang3.StringUtils;

/**
 * UEditor上传返回对象
 * 
 * <pre>
 * 根据UEditor文档需要返回如下对象
 * state: 成功为SUCCESS
 * url: 上传后的文件相对路径
 * title: 图片img标签的title属性,不需要,可以设置为""
 * original: 原图片名称, 图片img标签的alt属性,不需要,可以设置为""
 * </pre>
 * 
 * @author zbq
 */
public class UEditorUploadResult {

	private String state = "SUCCESS";
	private String url;
	private String title = StringUtils.EMPTY;
	private String original = StringUtils.EMPTY;

	public UEditorUploadResult(String url) {
		this.url = url;
	}

	public UEditorUploadResult(String url, String title) {
		this.url = url;
		this.title = title;
	}

	public UEditorUploadResult(String url, String title, String original) {
		this.url = url;
		this.title = title;
		this.original = original;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOriginal() {
		return original;
	}

	public void setOriginal(String original) {
		this.original = original;
	}

}
