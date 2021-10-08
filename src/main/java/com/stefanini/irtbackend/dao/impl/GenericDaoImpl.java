package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.GenericDao;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> clazz;

    protected GenericDaoImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T findById(Long id) {
        return entityManager.find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        List<T> result = null;
        try {
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<T> q = cb.createQuery(clazz);
            Root<T> c = q.from(clazz);
            q.select(c);
            result = entityManager.createQuery(q).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        entityManager.flush();
        return t;
    }

    @Override
    public T update(T t) {
        return entityManager.merge(t);
    }

    @Override
    public void delete(T t) {
        entityManager.remove(entityManager.contains(t) ? t : entityManager.merge(t));
        entityManager.getTransaction().commit();
    }
}
