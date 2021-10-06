package com.stefanini.irtbackend.dao.daoimpl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Autowired
    private EntityManager entityManager;

    @Override
    public User saveUser(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        System.out.println("Generated User ID = " + user.getId());
        return user;
    }

    @Override
    public User deleteUser(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User userForDelete = getUser(user.getId());
        if (userForDelete != null) {
            entityManager.remove(userForDelete);
            entityManager.getTransaction().commit();
        }
        return userForDelete;
    }

    @Override
    public User updateUser(User user) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public User getUser(long id) {
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        User userById = entityManager.find(User.class, id);
        if(userById != null) {
            entityManager.getTransaction().commit();
            System.out.println("Generated User ID = " + userById.getId());
        }
        return userById;
    }
}
