package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.project.dao.GenericDAO;
import com.ruoyi.project.dao.Page;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;

import java.util.List;

public interface FpzbDAO extends GenericDAO<Fpzb, String> {
    List<Fpzb> getFpzbList(Page page);

}
