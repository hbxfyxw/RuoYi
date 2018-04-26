package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.project.dao.GenericDAO;
import com.ruoyi.project.dao.Page;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;

import java.util.List;

public interface FpmxDAO extends GenericDAO<Fpmx, String> {
    List<Fpmx> getFpmxList(Page page);
    List<Fpmx> getFpmxListByZbid(String fpzbId);
}
