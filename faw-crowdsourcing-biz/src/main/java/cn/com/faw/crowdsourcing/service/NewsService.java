package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.NewsDAO;
import cn.com.faw.crowdsourcing.model.News;
import cn.com.faw.crowdsourcing.model.page.NewsPage;

/**
 * 新闻业务逻辑
 */
@Service
public class NewsService {

	/**
	 * 新闻DAO
	 */
	@Resource
	private NewsDAO newsDAO;

	/**
	 * 分页查找新闻列表
	 * 
	 * @param page 新闻分页对象
	 */
	public void loadNewsList(NewsPage page) {
		Integer total = newsDAO.selectNewsCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setNewsList(newsDAO.selectNewsList(page));
		}
	}

	/**
	 * 添加新闻
	 * 
	 * @param news 新闻
	 */
	public void addOneNews(News news) {
		 newsDAO.insertIntoNews(news);
	}

	/**
	 * 更新新闻
	 * 
	 * @param news 新闻
	 */
	public void modifyOneNews(News news) {
		 newsDAO.updateNewsById(news);
	}

	/**
	 * 获取某一新闻
	 * 
	 * @param id 新闻ID
	 * @return 新闻
	 */
	public News getOneNews(Long id) {
		return newsDAO.selectNewsById(id);
	}

	/**
	 * 删除新闻(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 新闻ID
	 */
	public void removeOneNews(Long id) {
		newsDAO.updateNewsToDisabledById(id);
	}

}
