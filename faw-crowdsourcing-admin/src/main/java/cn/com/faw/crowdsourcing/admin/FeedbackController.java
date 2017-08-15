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
import cn.com.faw.crowdsourcing.model.Feedback;
import cn.com.faw.crowdsourcing.model.page.FeedbackPage;
import cn.com.faw.crowdsourcing.service.FeedbackService;

/**
 * 反馈控制器
 */
@Controller
public class FeedbackController {

	/**
	 * 反馈业务逻辑
	 */
	@Resource
	private FeedbackService service;

	/**
	 * 全部反馈列表
	 * 
	 * @param page 反馈分页查询对象
	 * @param map Spring数据对象
	 * @return 反馈列表模板
	 */
	@RequestMapping("/feedback/list")
	public String feedbackList(FeedbackPage page, ModelMap map) {
		service.loadFeedbackList(page);
		map.put("page", page);

		return "feedback/feedback_list";
	}

	/**
	 * 跳转至添加反馈
	 * 
	 * @param map Spring数据对象
	 * @return 添加反馈页面模板
	 */
	@RequestMapping(value = "/feedback/add", method = RequestMethod.GET)
	public String toAddFeedback(ModelMap map) {
		return "feedback/add_feedback";
	}

	/**
	 * 添加反馈
	 * 
	 * @param feedback 反馈数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/feedback/add", method = RequestMethod.POST)
	public String addFeedback(Feedback feedback) {
		service.addOneFeedback(feedback);
		return "redirect:/feedback/list";
	}
	
	/**
	 * 跳转至编辑反馈
	 * 
	 * @param id 反馈ID
	 * @param map Spring数据对象
	 * @return 编辑反馈模板
	 */
	@RequestMapping(value = "/feedback/edit/{id}", method = RequestMethod.GET)
	public String toEditFeedback(@PathVariable Long id, ModelMap map) {
		map.put("feedback", service.getOneFeedback(id));
		return "feedback/edit_feedback";
	}

	/**
	 * 编辑反馈
	 * 
	 * @param feedback 反馈数据对象
	 * @param map Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/feedback/edit", method = RequestMethod.POST)
	public String editFeedback(Feedback feedback, ModelMap map) {
		service.modifyOneFeedback(feedback);
		return "redirect:/feedback/list";
	}

	/**
	 * 删除反馈
	 * 
	 * @param id 反馈ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/feedback/remove/{id}")
	@ResponseBody
	public BaseJson removeFeedback(@PathVariable Long id) {
		service.removeOneFeedback(id);
		return new SuccessJson();
	}

}
