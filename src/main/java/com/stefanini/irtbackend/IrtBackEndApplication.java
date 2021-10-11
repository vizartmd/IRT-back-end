package com.stefanini.irtbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import javax.persistence.EntityManager;

@SpringBootApplication
public class IrtBackEndApplication  extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(IrtBackEndApplication.class, args);



	}

}
