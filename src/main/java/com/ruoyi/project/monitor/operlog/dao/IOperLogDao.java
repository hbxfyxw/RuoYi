package com.ruoyi.project.monitor.operlog.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.monitor.operlog.domain.OperLog;
import org.springframework.stereotype.Repository;

/**
 * 操作日志 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface IOperLogDao extends BaseDao<OperLog, Long>
{

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public OperLog findOperLogByOperId(Long operId);

}
