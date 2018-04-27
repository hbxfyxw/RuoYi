package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.framework.web.dao.IBaseDao;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FpmxDAO extends IBaseDao<Fpmx, String> {
    Page<Fpmx> findAllByLike(String searchText, PageRequest pageRequest);
    List<Fpmx> getFpmxListByZbid(String fpzbId);
}
