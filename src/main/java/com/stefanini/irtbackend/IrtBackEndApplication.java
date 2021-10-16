package com.stefanini.irtbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@SpringBootApplication(scanBasePackages = "com.stefanini.irtbackend")
@EnableJpaAuditing
public class IrtBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrtBackEndApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner init(UserDao userDao) {
//        return args -> {
//            System.out.println("IrtBackEndApplication.init");
//            userDao.create(new User("EEE", "ppp", "ppp", "12345", "ppp@email.com"));
//        };
//    }

}
