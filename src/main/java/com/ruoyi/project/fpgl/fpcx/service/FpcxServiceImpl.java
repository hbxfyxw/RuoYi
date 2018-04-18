package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.project.fpgl.fpcx.dao.IFpcxDao;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.monitor.operlog.domain.OperLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 操作日志 服务层处理
 * 
 * @author ruoyi
 */
@Service("fpcxService")
public class FpcxServiceImpl implements IFpcxService
{
    @Autowired
    private IFpcxDao fpcxDao;


    /**
     * 查询系统操作日志集合
     * 
     * @param operLog 操作日志对象
     * @return 操作日志集合
     */
    @Override
    public List<Fpzb> selectFpcxList(Fpzb fpzb)
    {
        return fpcxDao.selectFpcxList(fpzb);
    }

    @Override
    public Fpzb selectFpcxById(String fpzbId) {
        return fpcxDao.selectFpcxById(fpzbId);
    }

    @Override
    public List<Fpmx> selectFpcxDetailList(String fpzbId) {
        return fpcxDao.selectFpcxDetailList(fpzbId);
    }


}
