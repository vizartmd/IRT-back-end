package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.swing.text.html.Option;
import java.util.Optional;


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
    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=:email", User.class);
        query.setParameter("email", email);

        return query.getResultList().stream().findFirst();
    }

    public List<String> findAllUsernamesBySpecialty(String specialty) {
        SpecialtyName sn = SpecialtyName.valueOf(specialty);
        Query query = entityManager.createQuery("SELECT u.username FROM User u WHERE u.specialty=:specialty");
        query.setParameter("specialty", sn);

        return (List<String>) query.getResultList();
    }
}
