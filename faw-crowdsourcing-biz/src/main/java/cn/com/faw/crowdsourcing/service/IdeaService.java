package cn.com.faw.crowdsourcing.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.IdeaCategoryDAO;
import cn.com.faw.crowdsourcing.dao.IdeaDAO;
import cn.com.faw.crowdsourcing.dao.IdeaReplyDAO;
import cn.com.faw.crowdsourcing.model.Idea;
import cn.com.faw.crowdsourcing.model.IdeaCategory;
import cn.com.faw.crowdsourcing.model.IdeaReply;
import cn.com.faw.crowdsourcing.model.page.IdeaCategoryPage;
import cn.com.faw.crowdsourcing.model.page.IdeaPage;
import cn.com.faw.crowdsourcing.model.page.IdeaReplyPage;

/**
 * 创意业务逻辑
 */
@Service
public class IdeaService {

	/**
	 * 创意DAO
	 */
	@Resource
	private IdeaDAO ideaDAO;

	/**
	 * 创意分类DAO
	 */
	@Resource
	private IdeaCategoryDAO ideaCategoryDAO;

	/**
	 * 创意回复DAO
	 */
	@Resource
	private IdeaReplyDAO ideaReplyDAO;

	/**
	 * 分页查找列表
	 * 
	 * @param page
	 *            分页对象
	 */
	public void loadIdeaList(IdeaPage page) {
		Integer total = ideaDAO.selectIdeaCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setIdeaList(ideaDAO.selectIdeaList(page));
		}
	}

	/**
	 * 添加
	 * 
	 * @param idea
	 */
	public void addOneIdea(Idea idea) {
		ideaDAO.insertIntoIdea(idea);
	}

	/**
	 * 更新
	 * 
	 * @param idea
	 */
	public void modifyOneIdea(Idea idea) {
		ideaDAO.updateIdeaById(idea);
	}

	/**
	 * 获取某一
	 * 
	 * @param id
	 *            ID
	 * @return
	 */
	public Idea getOneIdea(Long id) {
		return ideaDAO.selectIdeaById(id);
	}

	/**
	 * 删除(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id
	 *            ID
	 */
	public void removeOneIdea(Long id) {
		ideaDAO.updateIdeaToDisabledById(id);
	}

	/**
	 * 分页查找创意分类列表
	 * 
	 * @param page
	 *            创意分类分页对象
	 */
	public void loadIdeaCategoryList(IdeaCategoryPage page) {
		Integer total = ideaCategoryDAO.selectIdeaCategoryCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setIdeaCategoryList(ideaCategoryDAO.selectIdeaCategoryList(page));
		}
	}

	/**
	 * 添加创意分类
	 * 
	 * @param ideaCategory
	 *            创意分类
	 */
	public void addOneIdeaCategory(IdeaCategory ideaCategory) {
		ideaCategoryDAO.insertIntoIdeaCategory(ideaCategory);
	}

	/**
	 * 更新创意分类
	 * 
	 * @param ideaCategory
	 *            创意分类
	 */
	public void modifyOneIdeaCategory(IdeaCategory ideaCategory) {
		ideaCategoryDAO.updateIdeaCategoryById(ideaCategory);
	}

	/**
	 * 获取某一创意分类
	 * 
	 * @param id
	 *            创意分类ID
	 * @return 创意分类
	 */
	public IdeaCategory getOneIdeaCategory(Long id) {
		return ideaCategoryDAO.selectIdeaCategoryById(id);
	}

	/**
	 * 删除创意分类(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id
	 *            创意分类ID
	 */
	public void removeOneIdeaCategory(Long id) {
		ideaCategoryDAO.updateIdeaCategoryToDisabledById(id);
	}

	/**
	 * 分页查找创意回复列表
	 * 
	 * @param page
	 *            创意回复分页对象
	 */
	public void loadIdeaReplyList(IdeaReplyPage page) {
		Integer total = ideaReplyDAO.selectIdeaReplyCount(page);

		if (total > 0) {
			page.setTotalRow(total);
			page.setIdeaReplyList(ideaReplyDAO.selectIdeaReplyList(page));
		}
	}

	/**
	 * 添加创意回复
	 * 
	 * @param ideaReply
	 *            创意回复
	 */
	public void addOneIdeaReply(IdeaReply ideaReply) {
		ideaReplyDAO.insertIntoIdeaReply(ideaReply);
	}

	/**
	 * 更新创意回复
	 * 
	 * @param ideaReply
	 *            创意回复
	 */
	public void modifyOneIdeaReply(IdeaReply ideaReply) {
		ideaReplyDAO.updateIdeaReplyById(ideaReply);
	}

	/**
	 * 获取某一创意回复
	 * 
	 * @param id
	 *            创意回复ID
	 * @return 创意回复
	 */
	public IdeaReply getOneIdeaReply(Long id) {
		return ideaReplyDAO.selectIdeaReplyById(id);
	}

	/**
	 * 删除创意回复(逻辑删除, 更新状态为不可用)
	 * 
	 * @param id
	 *            创意回复ID
	 */
	public void removeOneIdeaReply(Long id) {
		ideaReplyDAO.updateIdeaReplyToDisabledById(id);
	}

}
