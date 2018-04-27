package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FpmxDAO extends BaseDao<Fpmx, String> {
    List<Fpmx> findByCheadguid(String fpzbId);
}
