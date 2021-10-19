package com.stefanini.irtbackend;

import com.stefanini.irtbackend.dao.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IrtBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrtBackEndApplication.class, args);

    }

    @Bean
    public CommandLineRunner init(UserDao userDao) {
        return args -> {
            System.out.println("IrtBackEndApplication.init");
            //userDao.create(new User("ggg", "gg", "gg", "12345", "gggg@email.com"));
        };
    }
}
