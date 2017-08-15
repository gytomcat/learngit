package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Notice;
import cn.com.faw.crowdsourcing.model.page.NoticePage;

/**
 * 公告DAO(表名: FAW_NOTICE)
 */
@Repository
public interface NoticeDAO {

	/**
	 * 查找公告数量
	 * 
	 * @param page 公告分页对象
	 * @return 公告数量
	 */
	Integer selectNoticeCount(NoticePage page);

	/**
	 * 查找公告列表
	 * 
	 * @param page 公告分页对象
	 * @return 公告列表
	 */
	List<Notice> selectNoticeList(NoticePage page);

	/**
	 * 根据ID查找公告
	 * 
	 * @param id 公告id
	 * @return 公告
	 */
	Notice selectNoticeById(Long id);

	/**
	 * 添加公告
	 * 
	 * @param notice 公告
	 */
	void insertIntoNotice(Notice notice);

	/**
	 * 根据ID更新公告
	 * 
	 * @param notice 公告
	 * @return 更新成功条数
	 */
	Integer updateNoticeById(Notice notice);

	/**
	 * 根据ID删除公告(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 公告id
	 * @return 公告成功数量
	 */
	Integer updateNoticeToDisabledById(Long id);

}
