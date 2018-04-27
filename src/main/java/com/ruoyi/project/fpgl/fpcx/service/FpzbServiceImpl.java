package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.fpgl.fpcx.dao.FpzbDAO;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fpcxService")
public class FpzbServiceImpl implements IFpzbService {

    @Autowired
    private FpzbDAO fpzbDao;

    @Override
    public TableDataInfo selectFpcxList(PageRequest pageRequest, Fpzb fpzb) {
        Page<Fpzb> pageFpzb = fpzbDao.findAllByLike("",pageRequest);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(pageFpzb.getContent());
        rspData.setTotal(pageFpzb.getTotalElements());
        return rspData;
    }

    @Override
    public Fpzb selectFpzbById(String fpzbId) {
        return fpzbDao.findOne(fpzbId);
    }

}
