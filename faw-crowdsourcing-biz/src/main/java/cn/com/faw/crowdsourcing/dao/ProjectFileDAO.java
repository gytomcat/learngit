package cn.com.faw.crowdsourcing.dao;

import org.springframework.stereotype.Repository;
import java.util.List;

import cn.com.faw.crowdsourcing.model.ProjectFile;
import cn.com.faw.crowdsourcing.model.page.ProjectFilePage;

/**
 * 项目附件DAO(表名: FAW_PROJECT_FILE)
 */
@Repository
public interface ProjectFileDAO {

    /**
     * 查找项目附件数量
     * 
     * @param page 项目附件分页对象
     * @return 项目附件数量
     */
    Integer selectProjectFileCount(ProjectFilePage page);

    /**
     * 查找项目附件列表
     * 
     * @param page 项目附件分页对象
     * @return 项目附件列表
     */
    List<ProjectFile> selectProjectFileList(ProjectFilePage page);

    /**
     * 根据ID查找项目附件
     * 
     * @param id 项目附件id
     * @return 项目附件
     */
    ProjectFile selectProjectFileById(Long id);

    /**
     * 添加项目附件
     * 
     * @param projectFile 项目附件
     */
    void insertIntoProjectFile(ProjectFile projectFile);

    /**
     * 根据ID更新项目附件
     * 
     * @param projectFile 项目附件
     * @return 更新成功条数
     */
    Integer updateProjectFileById(ProjectFile projectFile);

    /**
     * 根据ID删除项目附件(逻辑删除, 更新状态为不可用)
     * 
     * @param id 项目附件id
     * @return 项目附件成功数量
     */
    Integer updateProjectFileToDisabledById(Long id);

    /**
     * 根据项目ID获取文件列表
     * 
     * @param projectId 项目id
     * @return list 文件列表
     *
     * @author gaoyang
     * @since 2017年8月8日
     */
    List<ProjectFile> selectProjectFilesByProjectId(Long projectId);

}
