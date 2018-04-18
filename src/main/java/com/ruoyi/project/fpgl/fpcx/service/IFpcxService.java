package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.monitor.operlog.domain.OperLog;

import java.util.List;

/**
 * 操作日志 服务层
 * 
 * @author ruoyi
 */
public interface IFpcxService
{

    /**
     * 查询系统操作日志集合
     * 
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<Fpzb> selectFpcxList(Fpzb fpzb);

    /**
     * 查询操作日志详细
     *
     * @param operId 操作ID
     * @return 操作日志对象
     */
    public Fpzb selectFpcxById(String fpzbId);

    /**
     * 查询系统操作日志集合
     *
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    public List<Fpmx> selectFpcxDetailList(String fpzbId);

}
