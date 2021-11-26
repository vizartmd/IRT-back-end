package com.stefanini.irtbackend.units;

import com.stefanini.irtbackend.domain.entity.User;
import com.stefanini.irtbackend.service.UserService;
import com.stefanini.irtbackend.web.UserController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    UserController userController;

    List<User> users;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();
        User user1 = new User();
        user1.setId(1L);
        user1.setUsername("username1");

        User user2 = new User();
        user2.setId(2L);
        user2.setUsername("username2");
        users.add(user1);
        users.add(user2);

        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

    }

    @Test
    public void findAllUsersTest() throws Exception {
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}
