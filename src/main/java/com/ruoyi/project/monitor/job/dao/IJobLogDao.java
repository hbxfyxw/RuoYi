package com.ruoyi.project.monitor.job.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;

import com.ruoyi.project.monitor.job.domain.JobLog;
import org.springframework.stereotype.Repository;

/**
 * 调度任务日志信息 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface IJobLogDao extends BaseDao<JobLog, Long>
{

    /**
     * 通过调度任务日志ID查询调度信息
     *
     * @param jobId 调度任务日志ID
     * @return 调度任务日志对象信息
     */
    public JobLog findJobLogByJobLogId(Long jobLogId);


}
