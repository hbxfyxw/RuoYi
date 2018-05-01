package com.ruoyi.project.monitor.job.dao;

import java.util.List;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.monitor.operlog.domain.OperLog;
import org.apache.ibatis.annotations.Mapper;
import com.ruoyi.project.monitor.job.domain.Job;
import org.springframework.stereotype.Repository;

/**
 * 调度任务信息 数据层
 * 
 * @author ruoyi
 */
@Repository
public interface IJobDao extends BaseDao<Job, Long>
{

    /**
     * 通过调度ID查询调度任务信息
     *
     * @param jobId 调度ID
     * @return 角色对象信息
     */
    public Job findJobByJobId(Long jobId);

}
