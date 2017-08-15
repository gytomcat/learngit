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
import cn.com.faw.crowdsourcing.model.News;
import cn.com.faw.crowdsourcing.model.page.NewsPage;
import cn.com.faw.crowdsourcing.service.NewsService;

/**
 * 新闻控制器
 */
@Controller
public class NewsController {

	/**
	 * 新闻业务逻辑
	 */
	@Resource
	private NewsService service;

	/**
	 * 全部新闻列表
	 * 
	 * @param page 新闻分页查询对象
	 * @param map Spring数据对象
	 * @return 新闻列表模板
	 */
	@RequestMapping("/news/list")
	public String newsList(NewsPage page, ModelMap map) {
		service.loadNewsList(page);
		map.put("page", page);

		return "news/news_list";
	}

	/**
	 * 跳转至添加新闻
	 * 
	 * @param map Spring数据对象
	 * @return 添加新闻页面模板
	 */
	@RequestMapping(value = "/news/add", method = RequestMethod.GET)
	public String toAddNews(ModelMap map) {
		return "news/add_news";
	}

	/**
	 * 添加新闻
	 * 
	 * @param news 新闻数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/news/add", method = RequestMethod.POST)
	public String addNews(News news) {
		service.addOneNews(news);
		return "redirect:/news/list";
	}
	
	/**
	 * 跳转至编辑新闻
	 * 
	 * @param id 新闻ID
	 * @param map Spring数据对象
	 * @return 编辑新闻模板
	 */
	@RequestMapping(value = "/news/edit/{id}", method = RequestMethod.GET)
	public String toEditNews(@PathVariable Long id, ModelMap map) {
		map.put("news", service.getOneNews(id));
		return "news/edit_news";
	}

	/**
	 * 编辑新闻 
	 * 
	 * @param news 新闻数据对象
	 * @param map Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value ="/news/edit/{id}" , method = RequestMethod.POST)
	public String editNews(News news, ModelMap map) {
		service.modifyOneNews(news);
		return "redirect:/news/list";
	}

	/**
	 * 删除新闻           
	 * 
	 * @param id 新闻ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/news/remove/{id}")
	@ResponseBody
	public BaseJson removeNews(@PathVariable Long id) {
		service.removeOneNews(id);
		return new SuccessJson();
	}

}
