package cn.com.faw.crowdsourcing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.faw.crowdsourcing.dao.TagDAO;
import cn.com.faw.crowdsourcing.model.Tag;
import cn.com.faw.crowdsourcing.model.page.TagPage;

/**
 * 标签业务逻辑
 */
@Service
public class TagService {

    /**
     * 标签DAO
     */
    @Resource
    private TagDAO tagDAO;

    /**
     * 分页查找标签列表
     * 
     * @param page 标签分页对象
     */
    public void loadTagList(TagPage page) {
        Integer total = tagDAO.selectTagCount(page);

        if (total > 0) {
            page.setTotalRow(total);
            page.setTagList(tagDAO.selectTagList(page));
        }
    }

    /**
     * 添加标签
     * 
     * @param tag 标签
     */
    public void addOneTag(Tag tag) {
        tagDAO.insertIntoTag(tag);
    }

    /**
     * 更新标签
     * 
     * @param tag 标签
     */
    public void modifyOneTag(Tag tag) {
        tagDAO.updateTagById(tag);
    }

    /**
     * 获取某一标签
     * 
     * @param id 标签ID
     * @return 标签
     */
    public Tag getOneTag(Long id) {
        return tagDAO.selectTagById(id);
    }

    /**
     * 删除标签(逻辑删除, 更新状态为不可用)
     * 
     * @param id 标签ID
     */
    public void removeOneTag(Long id) {
        tagDAO.updateTagToDisabledById(id);
    }

    /**
     * 获取所有标签
     * 
     * @return list
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    public List<Tag> getAllTagList() {
        return tagDAO.selectAllTagList();
    }

}
