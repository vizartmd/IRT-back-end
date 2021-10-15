package com.stefanini.irtbackend.dao.impl;

import com.google.common.collect.Lists;
import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.entity.User;
import com.stefanini.irtbackend.security.UserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeUserDao implements UserDao {

    private final PasswordEncoder passwordEncoder;

    @PersistenceContext
    protected EntityManager entityManager;


    @Autowired
    public FakeUserDao(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    public List<User> findAll() {
        List<User> users = Lists.newArrayList(
                new User(
                        "user1",
                        passwordEncoder.encode("pass123"),
                        UserRole.USER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "developer1",
                        passwordEncoder.encode("pass123"),
                        UserRole.DEVELOPER.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                ),
                new User(
                        "admin1",
                        passwordEncoder.encode("pass123"),
                        UserRole.ADMIN.getGrantedAuthorities(),
                        true,
                        true,
                        true,
                        true
                )
        );

        return users;
    }

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public Optional<User> selectUserByUsername(String userName) {
        return findAll().stream().filter(user -> userName.equals(user.getUsername())).findFirst();
    }
}
