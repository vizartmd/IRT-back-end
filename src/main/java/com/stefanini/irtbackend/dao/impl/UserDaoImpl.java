package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    UserDaoImpl() {
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.username=:user_name");
        query.setParameter("user_name", username);

        return (User) query.getSingleResult();
    }

    @Override
    public User findByEmail(String email) {
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=:email");
        query.setParameter("email", email);

        return (User) query.getSingleResult();
    }
}
