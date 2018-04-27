package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.monitor.operlog.domain.OperLog;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 发票主表操作
 * 
 */
public interface IFpzbService
{

    /**
     * 查询发票集合
     * @param fpzb
     * @return
     */
    public TableDataInfo selectFpcxList(PageRequest pageRequest, Fpzb fpzb);

    /**
     * 根据ID查询发票
     * @param fpzbId
     * @return
     */
    public Fpzb selectFpzbById(String fpzbId);

}
