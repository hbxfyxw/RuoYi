package com.ruoyi.project.fpgl.fpcx.dao;

import com.ruoyi.project.dao.GenericDAOImpl;
import com.ruoyi.project.dao.Page;
import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service("fpzbDAOImpl")
public class FpzbDAOImpl extends GenericDAOImpl<Fpzb, String>
        implements FpzbDAO {

    @Autowired
    public FpzbDAOImpl(EntityManager em) {
        super(em, Fpzb.class);
    }

    @Override
    public List<Fpzb> getFpzbList(Page page) {
          /*
            This is a regular criteria query you have seen many times before.
         */
        CriteriaBuilder cb =
                getEntityManager().getCriteriaBuilder();

        CriteriaQuery<Fpzb> criteria =
                cb.createQuery(Fpzb.class);

        Root<Fpzb> i = criteria.from(Fpzb.class);

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
        TypedQuery<Fpzb> query =
                page.createQuery(em, criteria, i);

        return query.getResultList();
    }
}
