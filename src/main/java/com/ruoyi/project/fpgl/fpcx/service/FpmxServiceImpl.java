package com.ruoyi.project.fpgl.fpcx.service;

import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.dao.OffsetPage;
import com.ruoyi.project.fpgl.fpcx.dao.FpmxDAO;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.ruoyi.project.dao.Page.SortDirection.ASC;

@Service("fpmxService")
public class FpmxServiceImpl implements IFpmxService {
    @Autowired
    private FpmxDAO fpmxDao;

    @Override
    public TableDataInfo selectFpmxList(Fpmx fpmx) {
        int pageNum =  fpmx.getPageNum();
        OffsetPage page = new OffsetPage(
            /*
                The page size.
             */
                fpmx.getPageSize(),
            /*
                The default sort attribute and sort direction.
             */
                Fpmx_.xh, ASC,
            /*
                All attributes allowed as sort attributes for this page.
             */
                Fpmx_.xh
        );
        page.setCurrent(pageNum);
        List<Fpmx> list = fpmxDao.getFpmxList(page);
        Long total = page.getTotalRecords();
        TableDataInfo rspData = new TableDataInfo();
        rspData.setRows(list);
        rspData.setTotal(total);
        return rspData;
    }

    @Override
    public Fpmx selectFpmxById(String fpmxId) {
        return fpmxDao.findById(fpmxId);
    }

    @Override
    public List<Fpmx> selectFpmxDetailByZbid(String fpzbId) {
        return fpmxDao.getFpmxListByZbid(fpzbId);
    }

}
