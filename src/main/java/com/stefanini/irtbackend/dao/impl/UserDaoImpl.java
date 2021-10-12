package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    @PersistenceContext
    protected EntityManager entityManager;

    UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findByUserName(String userName) {
        User user = null;
        try {
            TypedQuery<User> query = entityManager.createQuery( "select u from User u where u.userName = :userName", User.class );
            query.setParameter( "userName", userName.toLowerCase() );
            user = query.getSingleResult();
        }
        catch ( Exception e ) {
            LOG.error( e.getMessage() );
        }
        finally {
            entityManager.close();
        }
        return user;
    }
}