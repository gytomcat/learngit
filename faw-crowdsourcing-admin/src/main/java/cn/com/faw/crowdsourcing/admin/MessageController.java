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
import cn.com.faw.crowdsourcing.model.Message;
import cn.com.faw.crowdsourcing.model.page.MessagePage;
import cn.com.faw.crowdsourcing.service.MessageService;

/**
 * 消息控制器
 */
@Controller
public class MessageController {

	/**
	 * 消息业务逻辑
	 */
	@Resource
	private MessageService service;

	/**
	 * 全部消息列表
	 * 
	 * @param page 消息分页查询对象
	 * @param map Spring数据对象
	 * @return 消息列表模板
	 */
	@RequestMapping("/message/list")
	public String messageList(MessagePage page, ModelMap map) {
		service.loadMessageList(page);
		map.put("page", page);

		return "message/message_list";
	}

	/**
	 * 跳转至添加消息
	 * 
	 * @param map Spring数据对象
	 * @return 添加消息页面模板
	 */
	@RequestMapping(value = "/message/add", method = RequestMethod.GET)
	public String toAddMessage(ModelMap map) {
		return "message/add_message";
	}

	/**
	 * 添加消息
	 * 
	 * @param message 消息数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/message/add", method = RequestMethod.POST)
	public String addMessage(Message message) {
		service.addOneMessage(message);
		return "redirect:/message/list";
	}
	
	/**
	 * 跳转至编辑消息
	 * 
	 * @param id 消息ID
	 * @param map Spring数据对象
	 * @return 编辑消息模板
	 */
	@RequestMapping(value = "/message/edit/{id}", method = RequestMethod.GET)
	public String toEditMessage(@PathVariable Long id, ModelMap map) {
		map.put("message", service.getOneMessage(id));
		return "message/edit_message";
	}

	/**
	 * 编辑消息
	 * 
	 * @param message 消息数据对象
	 * @param map Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/message/edit", method = RequestMethod.POST)
	public String editMessage(Message message, ModelMap map) {
		service.modifyOneMessage(message);
		return "redirect:/message/list";
	}

	/**
	 * 删除消息
	 * 
	 * @param id 消息ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/message/remove/{id}")
	@ResponseBody
	public BaseJson removeMessage(@PathVariable Long id) {
		service.removeOneMessage(id);
		return new SuccessJson();
	}

}
