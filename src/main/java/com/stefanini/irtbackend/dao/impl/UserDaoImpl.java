package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.domain.entity.enums.RoleName;
import com.stefanini.irtbackend.domain.entity.enums.SpecialtyName;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;
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

    @Override
    public List<String> findAllUsernamesByRole(String role) {
        RoleName rn = RoleName.valueOf(role);
        Query query = entityManager.createQuery("SELECT u.username FROM User u WHERE u.role=:role");
        query.setParameter("role", rn);

        return (List<String>) query.getResultList();
    }


    public List<String> findAllUsernamesBySpecialty(String specialty) {
        SpecialtyName sn = SpecialtyName.valueOf(specialty);
        Query query = entityManager.createQuery("SELECT u.username FROM User u WHERE u.specialty=:specialty");
        query.setParameter("specialty", sn);

        return (List<String>) query.getResultList();
    }

    public List<User> findAllBySpecialty(String specialty) {
        SpecialtyName sn = SpecialtyName.valueOf(specialty);
        Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.specialty=:specialty");
        query.setParameter("specialty", sn);

        return (List<User>) query.getResultList();
    }
}
