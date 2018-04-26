package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.project.dao.GenericDAOImpl;
import com.ruoyi.project.dao.Page;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb_;
import org.apache.commons.lang3.StringUtils;
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
        //计数
        CriteriaQuery<Long> criteriaC = criteriaBuilder.createQuery(Long.class);//CriteriaQuery 实例唯一
        Root<Fpzb> iC = criteriaC.from(Fpzb.class);//选择 唯一
        Predicate[] predicatesC = addCondition(fpzb,iC);//条件 唯一
        page.setTotalRecords(getCount(criteriaC,iC,predicatesC));
        //查询
        CriteriaQuery<Fpzb> criteria = criteriaBuilder.createQuery(Fpzb.class);
        Root<Fpzb> i = criteria.from(Fpzb.class);//选择
        criteria.select(i);
        Predicate[] predicates = addCondition(fpzb,i);//条件
        if(null != predicates){
            criteria.where(predicates);
        }
        TypedQuery<Fpzb> query = page.createQuery(em, criteria, i);

        return query.getResultList();
    }

    //查询条件
    private Predicate[] addCondition(Fpzb fpzb,Root<Fpzb> i){
        List<Predicate> predicates = new ArrayList<Predicate>();
        String searchVal = fpzb.getSearchValue();
        if(null != fpzb.getSearchValue() && !StringUtils.isBlank(searchVal)){
            predicates.add(criteriaBuilder.or(criteriaBuilder.equal(i.get(Fpzb_.fphm),searchVal),
                    criteriaBuilder.equal(i.get(Fpzb_.fpdm),searchVal)));
        }
        if(predicates.size() == 0)
            return null;
        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
