package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.project.dao.GenericDAOImpl;
import com.ruoyi.project.dao.Page;
import com.ruoyi.project.fpgl.fpcx.domain.Fpmx;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("fpmxDAOImpl")
public class FpmxDAOImpl extends GenericDAOImpl<Fpmx, String>
        implements FpmxDAO {

    @Autowired
    public FpmxDAOImpl(EntityManager em) {
        super(em, Fpmx.class);
    }

    @Override
    public List<Fpmx> getFpmxList(Page page) {
          /*
            This is a regular criteria query you have seen many times before.
         */
        CriteriaBuilder cb =
                getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Fpmx> criteria =
                cb.createQuery(Fpmx.class);

        Root<Fpmx> i = criteria.from(Fpmx.class);

       // Some query details...
       /* criteria.select(cb.construct(
                Fpzb.class,
                i.get(Fpzb_.id),
                i.get(Fpzb_.fpdm),
                i.get(Fpzb_.fphm),
                i.get(Fpzb_.gfmc),
                i.get(Fpzb_.xfmc),
                i.get(Fpzb_.kprq),
                i.get(Fpzb_.bz),
                i.get(Fpzb_.zfbz),
                i.get(Fpzb_.fplx),
                i.get(Fpzb_.gfdw),
                i.get(Fpzb_.mfdw)
        ));
*/
        /*
            Delegate finishing the query to the given <code>Page</code>.
         */
        TypedQuery<Fpmx> query =
                page.createQuery(em, criteria, i);

        return query.getResultList();
    }

    @Override
    public List<Fpmx> getFpmxListByZbid(String fpzbId) {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Fpmx> criteria = cb.createQuery(Fpmx.class);
        Root<Fpmx> i = criteria.from(Fpmx.class);
        criteria.select(i).where(cb.equal(i.get("cheadguid"),fpzbId));
        TypedQuery<Fpmx> q = em.createQuery(criteria);
        return q.getResultList();
    }
}
