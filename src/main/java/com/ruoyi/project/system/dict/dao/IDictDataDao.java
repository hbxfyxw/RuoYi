package com.ruoyi.project.system.dict.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.system.dict.domain.DictData;
import org.springframework.stereotype.Repository;

/**
 * 字典表 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface IDictDataDao  extends BaseDao<DictData, Long>
{

    /**
     * 根据字典数据ID查询信息
     * 
     * @param dictCode 字典数据ID
     * @return 字典数据
     */
    public DictData findDictDataByDictCode(Long dictCode);


}
