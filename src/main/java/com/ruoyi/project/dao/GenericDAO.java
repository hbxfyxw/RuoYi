package com.ruoyi.project.dao;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

/**
 * An interface shared by all business data access objects.
 * <p>
 * All CRUD (create, read, update, delete) basic data access operations are
 * isolated in this interface and shared across all DAO implementations.
 * The current design is for a state-management oriented persistence layer
 * (for example, there is no UPDATE statement function) which provides
 * automatic transactional dirty checking of business objects in persistent
 * state.
 */
public interface GenericDAO<T, ID extends Serializable>
    extends Serializable {

    void joinTransaction();

    T findById(ID id);

    T findById(ID id, LockModeType lockModeType);

    T findReferenceById(ID id);

    List<T> findAll();

    Long getCount(CriteriaQuery<Long> criteria, Root<T> root,Predicate[] predicate);

    T save(T entity);

    T saveAndFlush(T entity);

    T makePersistent(T entity);

    void flush();

    void makeTransient(T entity);

    void checkVersion(T entity, boolean forceUpdate);
}
