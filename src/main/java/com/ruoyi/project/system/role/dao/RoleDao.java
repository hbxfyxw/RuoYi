package com.ruoyi.project.system.role.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.system.role.domain.Role;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * 角色表 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface RoleDao extends BaseDao<Role, Long>
{

    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    @Query(value = "SELECT r.* FROM sys_user u " +
            "LEFT JOIN sys_user_role ur ON u.user_id = ur.user_id " +
            "LEFT JOIN sys_role r ON ur.role_id = r.role_id " +
            "WHERE ur.user_id = ?1",nativeQuery = true)
    public List<Role> selectRolesByUserId(Long userId);


    /**
     * 通过角色ID查询角色
     *
     * @param roleId 角色ID
     * @return 角色对象信息
     */
    public Role findByRoleId(Long roleId);


    /**
     * 批量角色用户信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Modifying
    @Query(value = "delete from sys_role where role_id in (?1)", nativeQuery = true)
    public boolean batchDeleteRole(String ids);
    
}
