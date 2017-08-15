package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.Tag;
import cn.com.faw.crowdsourcing.model.page.TagPage;

/**
 * 标签DAO(表名: FAW_TAG)
 */
@Repository
public interface TagDAO {

    /**
     * 查找标签数量
     * 
     * @param page 标签分页对象
     * @return 标签数量
     */
    Integer selectTagCount(TagPage page);

    /**
     * 查找标签列表
     * 
     * @param page 标签分页对象
     * @return 标签列表
     */
    List<Tag> selectTagList(TagPage page);

    /**
     * 根据ID查找标签
     * 
     * @param id 标签id
     * @return 标签
     */
    Tag selectTagById(Long id);

    /**
     * 添加标签
     * 
     * @param tag 标签
     */
    void insertIntoTag(Tag tag);

    /**
     * 根据ID更新标签
     * 
     * @param tag 标签
     * @return 更新成功条数
     */
    Integer updateTagById(Tag tag);

    /**
     * 根据ID删除标签(逻辑删除, 更新状态为不可用)
     * 
     * @param id 标签id
     * @return 标签成功数量
     */
    Integer updateTagToDisabledById(Long id);

    /**
     * 获取所有标签
     * 
     * @return list
     *
     * @author gaoyang
     * @since 2017年8月9日
     */
    List<Tag> selectAllTagList();

}
