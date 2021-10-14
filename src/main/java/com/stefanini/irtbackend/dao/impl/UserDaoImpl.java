package com.stefanini.irtbackend.dao.impl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Optional;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {
    @PersistenceContext
    protected EntityManager entityManager;

    UserDaoImpl() {
        super(User.class);
    }

    // TODO
    @Override
    public Optional<User> findByUserName(String userName) {
        User user = null;
        try {
            TypedQuery<User> query = entityManager.createQuery( "select u from User u where u.userName = :userName", User.class );
            query.setParameter( "userName", userName.toLowerCase() );
            user = query.getSingleResult();
        }
        catch ( Exception e ) {
//            log.error( e.getMessage() );
        }
        finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> optionalUser  = null;
        try {
            TypedQuery<User> query = entityManager.createQuery( "select u from User u where u.email = :email", User.class );
            query.setParameter( "email", email.toLowerCase() );
            optionalUser = Optional.ofNullable(query.getSingleResult());
        }
        catch ( Exception e ) {
//            log.error( e.getMessage() );
        }
        finally {
            entityManager.close();
        }
        User user = optionalUser.orElse(null);
        return user;
    }
}