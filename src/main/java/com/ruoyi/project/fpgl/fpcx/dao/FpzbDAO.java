package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.framework.web.dao.BaseDao;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

@Repository
public interface FpzbDAO extends BaseDao<Fpzb, String> {

    /**
     * 根据关键字获取分页
     * @param searchText
     * @param pageRequest
     * @return
     */
    Page<Fpzb> findAllByLike(String searchText, PageRequest pageRequest);
}
