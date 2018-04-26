package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.project.dao.GenericDAOImpl;
import com.ruoyi.project.dao.Page;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * JPA 概念封装
 */
@Service("fpzbDAOImpl")
public class FpzbDAOImpl extends GenericDAOImpl<Fpzb, String>
        implements FpzbDAO {

    @Autowired
    public FpzbDAOImpl(EntityManager em) {
        super(em, Fpzb.class);
    }

    @Override
    public List<Fpzb> getFpzbList(Page page,Fpzb fpzb) {
        CriteriaQuery<Fpzb> criteria = criteriaBuilder.createQuery(Fpzb.class);
        Root<Fpzb> i = criteria.from(Fpzb.class);
        addCondition(criteria,fpzb,i);
        TypedQuery<Fpzb> query = page.createQuery(em, criteria, i);
        return query.getResultList();
    }

    //查询条件
    private Predicate[] addCondition(CriteriaQuery<Fpzb> criteria,Fpzb fpzb,Root<Fpzb> i){

        List<Predicate> predicates = new ArrayList<Predicate>();
        if(null != fpzb.getFphm()){
            criteria.select(i).where(criteriaBuilder.equal(i.get("fphm"),fpzb.getFphm()));
        }
        if(predicates.size() == 0)
            return null;
        return  predicates.toArray(new Predicate[0]);
    }
}
