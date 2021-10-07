package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.GenericDao;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

    @Autowired
    protected EntityManagerFactory entityManagerFactory;

    @Autowired
    protected EntityManager entityManager;

    protected Class<T> clazz;

    @Override
    public T findById(Long id){
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
        } catch (HibernateException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Long create(T t) {
        //Here we need to return created object ID
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public void update(T t){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(t);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T t){
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }
}
