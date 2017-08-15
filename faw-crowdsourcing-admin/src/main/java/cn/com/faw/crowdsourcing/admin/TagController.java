package cn.com.faw.crowdsourcing.admin;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.faw.crowdsourcing.common.BaseJson;
import cn.com.faw.crowdsourcing.common.SuccessJson;
import cn.com.faw.crowdsourcing.model.Tag;
import cn.com.faw.crowdsourcing.model.page.TagPage;
import cn.com.faw.crowdsourcing.service.TagService;

/**
 * 标签控制器
 */
@Controller
public class TagController {

	/**
	 * 标签业务逻辑
	 */
	@Resource
	private TagService service;

	/**
	 * 全部标签列表
	 * 
	 * @param page 标签分页查询对象
	 * @param map Spring数据对象
	 * @return 标签列表模板
	 */
	@RequestMapping("/tag/list")
	public String tagList(TagPage page, ModelMap map) {
		service.loadTagList(page);
		map.put("page", page);

		return "tag/tag_list";
	}

	/**
	 * 跳转至添加标签
	 * 
	 * @param map Spring数据对象
	 * @return 添加标签页面模板
	 */
	@RequestMapping(value = "/tag/add", method = RequestMethod.GET)
	public String toAddTag(ModelMap map) {
		return "tag/add_tag";
	}

	/**
	 * 添加标签
	 * 
	 * @param tag 标签数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/tag/add", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson addTag(Tag tag) {
		service.addOneTag(tag);
		return new SuccessJson();
	}
	
	/**
	 * 跳转至编辑标签
	 * 
	 * @param id 标签ID
	 * @param map Spring数据对象
	 * @return 编辑标签模板
	 */
	@RequestMapping(value = "/tag/edit/{id}", method = RequestMethod.GET)
	public String toEditTag(@PathVariable Long id, ModelMap map) {
		map.put("tag", service.getOneTag(id));
		return "tag/edit_tag";
	}

	/**
	 * 编辑标签
	 * 
	 * @param tag 标签数据对象
	 * @param map Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/tag/edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson editTag(Tag tag, ModelMap map) {
		service.modifyOneTag(tag);
		return new SuccessJson();
	}

	/**
	 * 删除标签
	 * 
	 * @param id 标签ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/tag/remove/{id}")
	@ResponseBody
	public BaseJson removeTag(@PathVariable Long id) {
		service.removeOneTag(id);
		return new SuccessJson();
	}

}
