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
import cn.com.faw.crowdsourcing.model.Notice;
import cn.com.faw.crowdsourcing.model.page.NoticePage;
import cn.com.faw.crowdsourcing.service.NoticeService;

/**
 * 公告控制器
 */
@Controller
public class NoticeController {

	/**
	 * 公告业务逻辑
	 */
	@Resource
	private NoticeService service;

	/**
	 * 全部公告列表
	 * 
	 * @param page 公告分页查询对象
	 * @param map Spring数据对象
	 * @return 公告列表模板
	 */
	@RequestMapping("/notice/list")
	public String noticeList(NoticePage page, ModelMap map) {
		service.loadNoticeList(page);
		map.put("page", page);

		return "notice/notice_list";
	}

	/**
	 * 跳转至添加公告
	 * 
	 * @param map Spring数据对象
	 * @return 添加公告页面模板
	 */
	@RequestMapping(value = "/notice/add", method = RequestMethod.GET)
	public String toAddNotice(ModelMap map) {
		return "notice/add_notice";
	}

	/**
	 * 添加公告
	 * 
	 * @param notice 公告数据对象
	 * @return 添加成功(JSON)
	 */
	@RequestMapping(value = "/notice/add", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson addNotice(Notice notice) {
		service.addOneNotice(notice);
		return new SuccessJson();
	}
	
	/**
	 * 跳转至编辑公告
	 * 
	 * @param id 公告ID
	 * @param map Spring数据对象
	 * @return 编辑公告模板
	 */
	@RequestMapping(value = "/notice/edit/{id}", method = RequestMethod.GET)
	public String toEditNotice(@PathVariable Long id, ModelMap map) {
		map.put("notice", service.getOneNotice(id));
		return "notice/edit_notice";
	}

	/**
	 * 编辑公告
	 * 
	 * @param notice 公告数据对象
	 * @param map Spring数据对象
	 * @return 更新成功(JSON)
	 */
	@RequestMapping(value = "/notice/edit", method = RequestMethod.POST)
	@ResponseBody
	public BaseJson editNotice(Notice notice, ModelMap map) {
		service.modifyOneNotice(notice);
		return new SuccessJson();
	}

	/**
	 * 删除公告
	 * 
	 * @param id 公告ID
	 * @return 删除成功(JSON)
	 */
	@RequestMapping("/notice/remove/{id}")
	@ResponseBody
	public BaseJson removeNotice(@PathVariable Long id) {
		service.removeOneNotice(id);
		return new SuccessJson();
	}

}
