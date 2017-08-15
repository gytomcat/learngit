package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Feedback;
import cn.com.faw.crowdsourcing.model.page.FeedbackPage;

/**
 * 反馈DAO(表名: FAW_FEEDBACK)
 */
@Repository
public interface FeedbackDAO {

	/**
	 * 查找反馈数量
	 * 
	 * @param page 反馈分页对象
	 * @return 反馈数量
	 */
	Integer selectFeedbackCount(FeedbackPage page);

	/**
	 * 查找反馈列表
	 * 
	 * @param page 反馈分页对象
	 * @return 反馈列表
	 */
	List<Feedback> selectFeedbackList(FeedbackPage page);

	/**
	 * 根据ID查找反馈
	 * 
	 * @param id 反馈id
	 * @return 反馈
	 */
	Feedback selectFeedbackById(Long id);

	/**
	 * 添加反馈
	 * 
	 * @param feedback 反馈
	 */
	void insertIntoFeedback(Feedback feedback);

	/**
	 * 根据ID更新反馈
	 * 
	 * @param feedback 反馈
	 * @return 更新成功条数
	 */
	Integer updateFeedbackById(Feedback feedback);

	/**
	 * 根据ID删除反馈(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id 反馈id
	 * @return 反馈成功数量
	 */
	Integer updateFeedbackToDisabledById(Long id);

}
