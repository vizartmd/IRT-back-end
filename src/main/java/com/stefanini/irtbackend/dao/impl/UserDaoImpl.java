package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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

    public List<User> findAllBySpecialty(String specialty) {
        SpecialtyName sn = SpecialtyName.valueOf(specialty);
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.specialty=:specialty");
        query.setParameter("specialty", sn);

        return (List<User>) query.getResultList();
    }
}
