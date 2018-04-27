package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.fpgl.fpcx.dao.FpmxDAO;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("fpmxService")
public class FpmxServiceImpl implements IFpmxService {
    @Autowired
    private FpmxDAO fpmxDao;

    @Override
    public TableDataInfo selectFpmxList(PageRequest pageRequest, Fpmx fpmx) {
        Page<Fpmx> pageFpzb = fpmxDao.findAllByLike("",pageRequest);
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(pageFpzb.getContent());
        rspData.setTotal(pageFpzb.getTotalElements());
        return rspData;
    }

    @Override
    public Fpmx selectFpmxById(String fpmxId) {
        return fpmxDao.findOne(fpmxId);
    }

    @Override
    public List<Fpmx> selectFpmxDetailByZbid(String fpzbId) {
        return fpmxDao.getFpmxListByZbid(fpzbId);
    }

}
