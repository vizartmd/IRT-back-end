package com.stefanini.irtbackend.dao.daoimpl;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Repository
class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

    UserDaoImpl() {
        super(User.class);
    }
}
//
//@Repository
//public class UserDaoImpl implements UserDao{
//
//    @Autowired
//    private EntityManagerFactory entityManagerFactory;
//
//    @Autowired
//    private EntityManager entityManager;
//
//
//    @Override
//    public User create(User user) {
//        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(user);
//        entityManager.flush();
//        entityManager.getTransaction().commit();
//        System.out.println("Generated User ID = " + user.getId());
//        return user;
//    }
//
//    @Override
//    public void delete(User user) {
//        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        User userForDelete = findById(user.getId());
//        if (userForDelete != null) {
//            entityManager.remove(userForDelete);
//            entityManager.flush();
//            entityManager.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public User update(User user) {
//        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.merge(user);
//        entityManager.flush();
//        entityManager.getTransaction().commit();
//        return user;
//    }
//
//    @Override
//    public User findById(Long id) {
//        entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        User userById = entityManager.find(User.class, id);
//        if(userById != null) {
//            entityManager.getTransaction().commit();
//            entityManager.flush();
//            System.out.println("Generated User ID = " + userById.getId());
//        }
//        return userById;
//    }
//
//    @Override
//    public List<User> findAll() {
//        return null;
//    }
//}
