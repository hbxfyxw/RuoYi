package com.ruoyi.project.dao;

import com.ruoyi.project.fpgl.fpcx.domain.Fpzb;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static javax.persistence.LockModeType.*;

public abstract class GenericDAOImpl<T, ID extends Serializable>
        implements GenericDAO<T, ID> {

    protected final EntityManager em;
    protected final Class<T> entityClass;
    protected CriteriaBuilder criteriaBuilder;

    protected GenericDAOImpl(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
        this.criteriaBuilder = em.getCriteriaBuilder();//线程安全

    }


    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public void joinTransaction() {
        if (!em.isJoinedToTransaction())
            em.joinTransaction();
    }

    @Override
    public T findById(ID id) {
        return findById(id, NONE);
    }

    @Override
    public T findById(ID id, LockModeType lockModeType) {
        return em.find(entityClass, id, lockModeType);
    }

    @Override
    public T findReferenceById(ID id) {
        return em.getReference(entityClass, id);
    }

    @Override
    public List<T> findAll() {
        CriteriaQuery<T> criteria = criteriaBuilder.createQuery(entityClass);
        Root<T> from = criteria.from(this.entityClass);
        criteria.select(from);
        return em.createQuery(criteria).getResultList();
    }

    @Override
    public Long getCount(CriteriaQuery<Long> criteria,Root<T> root,Predicate[] predicates) {
        if(null != predicates){
            criteria.select(criteriaBuilder.count(root)).where(predicates);
        }else{
            criteria.select(criteriaBuilder.count(root));
        }
        return em.createQuery(criteria).getSingleResult();
    }

    @Override
    public void checkVersion(T entity, boolean forceUpdate) {
        em.lock(entity, forceUpdate ? OPTIMISTIC_FORCE_INCREMENT : OPTIMISTIC);
    }

    @Override
    public T makePersistent(T instance) {
        // merge() handles transient AND detached instances
        return em.merge(instance);
    }

    @Override
    public void makeTransient(T instance) {
        em.remove(instance);
    }
    // ...

}
