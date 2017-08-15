package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.News;
import cn.com.faw.crowdsourcing.model.page.NewsPage;

/**
 * 新闻DAO(表名: FAW_NEWS)
 */
@Repository
public interface NewsDAO {

	/**
	 * 查找新闻数量
	 * 
	 * @param page 新闻分页对象
	 * @return 新闻数量
	 */
	Integer selectNewsCount(NewsPage page);

	/**
	 * 查找新闻列表
	 * 
	 * @param page 新闻分页对象
	 * @return 新闻列表
	 */
	List<News> selectNewsList(NewsPage page);

	/**
	 * 根据ID查找新闻
	 * 
	 * @param id 新闻id
	 * @return 新闻
	 */
	News selectNewsById(Long id);

	/**
	 * 添加新闻
	 * 
	 * @param news 新闻
	 */
	Integer insertIntoNews(News news);

	/**
	 * 根据ID更新新闻
	 * 
	 * @param news 新闻
	 * @return 更新成功条数
	 */
	Integer updateNewsById(News news);

	/**
	 * 根据ID删除新闻(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 新闻id
	 * @return 新闻成功数量
	 */
	Integer updateNewsToDisabledById(Long id);

}
