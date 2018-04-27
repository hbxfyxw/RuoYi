package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 发票明细操作
 * 
 */
public interface IFpmxService
{

    /**
     * 查询发票明细集合
     * @param fpmx
     * @return
     */
    public TableDataInfo selectFpmxList(PageRequest pageRequest, Fpmx fpmx);

    /**
     * 根据ID查询发票明细
     * @param fpmxId
     * @return
     */
    public Fpmx selectFpmxById(String fpmxId);

    /**
     * 根据发票主表ID查询明细
     * @param fpzbId
     * @return
     */
    public List<Fpmx> selectFpmxDetailByZbid(String fpzbId);

}
