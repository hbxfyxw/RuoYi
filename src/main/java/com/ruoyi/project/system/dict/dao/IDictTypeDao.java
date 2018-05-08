package com.ruoyi.project.system.dict.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;

import com.ruoyi.project.system.dict.domain.DictType;
import org.springframework.stereotype.Repository;

/**
 * 字典表 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface IDictTypeDao extends BaseDao<DictType, Long>
{

    /**
     * 根据字典类型ID查询信息
     *
     * @param dictId 字典类型ID
     * @return 字典类型
     */
    public DictType findDictTypeByDictId(Long dictId);

    /**
     * 校验字典类型称是否唯一
     * 
     * @param dictType 字典类型
     * @return 结果
     */
    public DictType findDictTypeByDictType(String dictType);
}
