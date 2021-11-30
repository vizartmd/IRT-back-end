package com.stefanini.irtbackend.units;

import com.stefanini.irtbackend.dao.UserDao;
import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.EmailService;
import com.stefanini.irtbackend.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private EmailService emailService;

    private UserServiceImpl userServiceImplTest;

    static User user1;
    static User user2;

    @BeforeEach
    void setUp() {
        userServiceImplTest = new UserServiceImpl(userDao, passwordEncoder, emailService);

        user1 = new User();
        user1.setId(1L);
        user1.setUsername("ccc");
        user1.setPassword("password");
        user1.setEmail("user1@gmail.com");

        user2 = new User();
        user2.setId(2L);
        user2.setUsername("bbb");
        user2.setPassword("password");
        user2.setEmail("user2@gmail.com");
    }

    @Test
    void canFindByUsername_RunsOK() {
        String sampleUsername = "ccc";
        userServiceImplTest.findByUsername(sampleUsername);
        Mockito.verify(userDao).findByUsername(sampleUsername);
    }

    @Test
    void findAll_RunsOK() {
        List<User> returnUsers = new ArrayList<>();
        returnUsers.add(user1);
        returnUsers.add(user2);

        Mockito.when(userDao.findAll()).thenReturn(returnUsers);

        List<User> foundUsers = userServiceImplTest.findAll();

        Assertions.assertNotNull(foundUsers);
        Assertions.assertEquals(2, foundUsers.size());
    }

    @Test
    void createUser_RunsOK() {
        User user = new User();
        user.setId(2l);
        user.setUsername("username");
        user.setFirstName("firstname");
        user.setLastName("lastname");
        user.setPassword("1234");

        Mockito.when(userDao.create(Mockito.any(User.class))).thenReturn(user);

        User createdUser = userDao.create(user);
        Assertions.assertNotNull(createdUser.getUsername());
    }

    @Test
    public void userExistsInDb_RunsOk() {
        User user = new User();
        user.setId(3l);
        user.setUsername("aaaa");
        user.setFirstName("bbbb");
        user.setLastName("cccc");
        user.setPassword("1234");

        List<User> userList = new ArrayList<>();
        userList.add(user);

        Mockito.when(userDao.findAll()).thenReturn(userList);

        List<User> fetchedUsers = userServiceImplTest.findAll();
        assertThat(fetchedUsers.size()).isGreaterThan(0);
    }
}
