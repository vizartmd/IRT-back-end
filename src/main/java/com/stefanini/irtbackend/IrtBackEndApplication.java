package com.stefanini.irtbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(scanBasePackages = "com.stefanini.irtbackend")
@EnableJpaAuditing
public class IrtBackEndApplication {

    public static void main(String[] args) {
        SpringApplication.run(IrtBackEndApplication.class, args);
    }

}
