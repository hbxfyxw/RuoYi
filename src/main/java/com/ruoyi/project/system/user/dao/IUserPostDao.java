package com.ruoyi.project.system.user.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.system.user.domain.UserPost;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 用户与岗位 表 数据层
 * 
 */
@Repository
public interface IUserPostDao extends BaseDao<UserPost, Long>
{

    /**
     * 通过用户ID删除用户和岗位关联
     *
     * @param userId 用户ID
     * @return 结果
     */
    @Modifying
    @Query(value = "delete from sys_user_post where user_id= ?1",nativeQuery = true)
    public void deleteUserPostByUserId(Long userId);

}
