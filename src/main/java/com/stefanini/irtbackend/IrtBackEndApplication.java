package com.stefanini.irtbackend;

import org.hibernate.Session;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class IrtBackEndApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(IrtBackEndApplication.class, args);
	}

}
