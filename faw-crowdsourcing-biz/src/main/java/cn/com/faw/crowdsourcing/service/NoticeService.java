package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.NoticeDAO;
import cn.com.faw.crowdsourcing.model.Notice;
import cn.com.faw.crowdsourcing.model.page.NoticePage;

/**
 * 公告业务逻辑
 */
@Service
public class NoticeService {

	/**
	 * 公告DAO
	 */
	@Resource
	private NoticeDAO noticeDAO;

	/**
	 * 分页查找公告列表
	 * 
	 * @param page 公告分页对象
	 */
	public void loadNoticeList(NoticePage page) {
		Integer total = noticeDAO.selectNoticeCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setNoticeList(noticeDAO.selectNoticeList(page));
		}
	}

	/**
	 * 添加公告
	 * 
	 * @param notice 公告
	 */
	public void addOneNotice(Notice notice) {
		noticeDAO.insertIntoNotice(notice);
	}

	/**
	 * 更新公告
	 * 
	 * @param notice 公告
	 */
	public void modifyOneNotice(Notice notice) {
		noticeDAO.updateNoticeById(notice);
	}

	/**
	 * 获取某一公告
	 * 
	 * @param id 公告ID
	 * @return 公告
	 */
	public Notice getOneNotice(Long id) {
		return noticeDAO.selectNoticeById(id);
	}

	/**
	 * 删除公告(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 公告ID
	 */
	public void removeOneNotice(Long id) {
		noticeDAO.updateNoticeToDisabledById(id);
	}

}
