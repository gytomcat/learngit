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
import cn.com.faw.crowdsourcing.model.Idea;
import cn.com.faw.crowdsourcing.model.IdeaCategory;
import cn.com.faw.crowdsourcing.model.IdeaReply;
import cn.com.faw.crowdsourcing.model.page.IdeaCategoryPage;
import cn.com.faw.crowdsourcing.model.page.IdeaPage;
import cn.com.faw.crowdsourcing.model.page.IdeaReplyPage;
import cn.com.faw.crowdsourcing.service.IdeaService;

/**
 * 创意控制器
 */
@Controller
public class IdeaController {

	/**
	 * 创意业务逻辑
	 */
	@Resource
	private IdeaService service;

	/**
	 * 全部列表
	 * 
	 * @param page
	 *            分页查询对象
	 * @param map
	 *            Spring数据对象
	 * @return 列表模板
	 */
	@RequestMapping(value = "/idea/list", method = RequestMethod.GET)
	public String ideaList(IdeaPage page,ModelMap map) {
		service.loadIdeaList(page);
		map.put("page", page);

		return "idea/idea_list";
	}

	/**
	 * 跳转至添加
	 * 
	 * @param map
	 *            Spring数据对象
	 * @return 添加页面模板
	 */
	@RequestMapping(value = "/idea/add", method = RequestMethod.GET)
	public String toAddIdea(ModelMap map) {
		return "idea/add_idea";
	}

	/**
	 * 添加
	 * 
	 * @param idea
	 *            数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/idea/add", method = RequestMethod.POST)
	public String addIdea(Idea idea) {
		IdeaCategory ideaCategory = service.getOneIdeaCategory(idea.getCategoryId());
		ideaCategory.setIdeaCount(ideaCategory.getIdeaCount()+1);
		service.modifyOneIdeaCategory(ideaCategory);
		service.addOneIdea(idea);
		return "redirect:/idea/list";
	}

	/**
	 * 跳转至编辑
	 * 
	 * @param id
	 *            ID
	 * @param map
	 *            Spring数据对象
	 * @return 编辑模板
	 */
	@RequestMapping(value = "/idea/detail/{id}", method = RequestMethod.GET)
	public String toEditIdea(@PathVariable Long id, ModelMap map) {
		Idea idea = service.getOneIdea(id);
		idea.setViewCount(idea.getViewCount()+1);
		service.modifyOneIdea(idea);
		map.put("idea", idea);
		
		IdeaReplyPage page = new IdeaReplyPage(id);
		page.setOrderByColumn("REPLY_TIME");
		page.setOrderByType("ASC");
		service.loadIdeaReplyList(page);
		map.put("reply", page);
		return "/idea/detail_idea";
	}

	/**
	 * 编辑
	 * 
	 * @param idea
	 *            数据对象
	 * @param map
	 *            Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/idea/edit", method = RequestMethod.POST)
	public String editIdea(Idea idea, ModelMap map) {
		service.modifyOneIdea(idea);
		return "redirect:/idea/list";
	}

	/**
	 * 删除
	 * 
	 * @param id
	 *            ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/idea/remove/{id}")
	@ResponseBody
	public BaseJson removeIdea(@PathVariable Long id) {
		service.removeOneIdea(id);
		return new SuccessJson();
	}

	/**
	 * 全部创意分类列表
	 * 
	 * @param page
	 *            创意分类分页查询对象
	 * @param map
	 *            Spring数据对象
	 * @return 创意分类列表模板
	 */
	@RequestMapping("/idea/category/list")
	public String ideaCategoryList(IdeaCategoryPage page, ModelMap map) {
		service.loadIdeaCategoryList(page);
		map.put("page", page);

		return "idea/idea_category_list";
	}

	/**
	 * 跳转至添加创意分类
	 * 
	 * @param map
	 *            Spring数据对象
	 * @return 添加创意分类页面模板
	 */
	@RequestMapping(value = "/idea/category/add", method = RequestMethod.GET)
	public String toAddIdeaCategory(ModelMap map) {
		return "idea/add_idea_category";
	}

	/**
	 * 添加创意分类
	 * 
	 * @param ideaCategory
	 *            创意分类数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/idea/category/add", method = RequestMethod.POST)
	public String addIdeaCategory(IdeaCategory ideaCategory) {
		service.addOneIdeaCategory(ideaCategory);
		return "redirect:/idea/category/list";
	}

	/**
	 * 跳转至编辑创意分类
	 * 
	 * @param id
	 *            创意分类ID
	 * @param map
	 *            Spring数据对象
	 * @return 编辑创意分类模板
	 */
	@RequestMapping(value = "/idea/category/edit/{id}", method = RequestMethod.GET)
	public String toEditIdeaCategory(@PathVariable Long id, ModelMap map) {
		map.put("ideaCategory", service.getOneIdeaCategory(id));
		return "idea/edit_idea_category";
	}

	/**
	 * 编辑创意分类
	 * 
	 * @param ideaCategory
	 *            创意分类数据对象
	 * @param map
	 *            Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/idea/category/edit", method = RequestMethod.POST)
	public String editIdeaCategory(IdeaCategory ideaCategory, ModelMap map) {
		service.modifyOneIdeaCategory(ideaCategory);
		return "redirect:/idea/category/list";
	}

	/**
	 * 删除创意分类
	 * 
	 * @param id
	 *            创意分类ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/idea/category/remove/{id}")
	@ResponseBody
	public BaseJson removeIdeaCategory(@PathVariable Long id) {
		service.removeOneIdeaCategory(id);
		return new SuccessJson();
	}

	
	@RequestMapping(value = "/idea/reply", method = RequestMethod.POST)
	public String replyIdea(IdeaReply reply, ModelMap map) {
		service.addOneIdeaReply(reply);
		
		Idea idea = service.getOneIdea(reply.getIdeaId());
		idea.setReplyCount(idea.getReplyCount()+1);
		service.modifyOneIdea(idea);
//		return "idea/idea_list";
		return "redirect:/idea/detail/"+reply.getIdeaId();
	}
	
	
	/**
	 * 删除回复
	 * 
	 * @param id
	 *            回复ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/idea/reply/remove/{id}")
	@ResponseBody
	public BaseJson removeReply(@PathVariable Long id) {
		IdeaReply ideaReply = service.getOneIdeaReply(id);
		Idea idea = service.getOneIdea(ideaReply.getIdeaId());
		idea.setReplyCount(idea.getReplyCount()-1);
		service.removeOneIdeaReply(id);
		service.modifyOneIdea(idea);
		return new SuccessJson();
	}
}
