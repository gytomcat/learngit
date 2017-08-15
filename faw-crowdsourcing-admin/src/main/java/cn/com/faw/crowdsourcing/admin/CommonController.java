package cn.com.faw.crowdsourcing.admin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.common.UEditorUploadResult;

/**
 * 通用控制器
 * 
 * @author zbq
 */
@Controller
public class CommonController {

	/**
	 * 上传文件根目录
	 */
    @Value("${dir.upload}")
	private String fileDir;

	/**
	 * 获取ueditor配置
	 * 
	 * @param file
	 *            文件
	 * @return 文件上传后的相对路径
	 */
	@RequestMapping("/ueditor/conf")
	public String ueditorConf(String action) {
		return "common/ueditor_config";
	}

//	/**
//	 * 上传图片文件
//	 * 
//	 * @param image
//	 *            图片
//	 * @return UEditor返回对象,可参见UEditor文档
//	 */
//	@RequestMapping("/ueditor/upload")
//	@ResponseBody
//	public UEditorUploadResult ueditorUpload(MultipartFile image) {
//		String imagePath = IOx.uploadFile(image, fileDir);
//		return new UEditorUploadResult(imagePath);
//	}
//
//	/**
//	 * 上传文件
//	 * 
//	 * @param file
//	 *            文件
//	 * @return 上传成功返回文件路径
//	 */
//	@RequestMapping("/upload/file")
//	@ResponseBody
//	public BaseJson uploadFile(MultipartFile file) {
//		String path = IOx.uploadFile(file, fileDir);
//		return new SuccessJson(path);
//	}

}
