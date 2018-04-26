package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.dao.OffsetPage;
import com.ruoyi.project.fpgl.fpcx.dao.FpzbDAO;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.ruoyi.project.dao.Page.SortDirection.ASC;
import static com.ruoyi.project.dao.Page.SortDirection.DESC;

import java.util.List;

@Service("fpcxService")
public class FpzbServiceImpl implements IFpzbService {

    @Autowired
    private FpzbDAO fpzbDao;

    @Override
    public TableDataInfo selectFpcxList(Fpzb fpzb) {
        int pageNum =  fpzb.getPageNum();
        OffsetPage page = new OffsetPage(
                fpzb.getPageSize(),
                Fpzb_.fphm, fpzb.getIsAsc().equals("desc")? DESC:ASC,
                Fpzb_.fphm,Fpzb_.fpdm
        );
        page.setCurrent(pageNum);
        List<Fpzb> list = fpzbDao.getFpzbList(page,fpzb);
        Long total = page.getTotalRecords();
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(total);
        return rspData;
    }

    @Override
    public Fpzb selectFpzbById(String fpzbId) {
        return fpzbDao.findById(fpzbId);
    }

}
