package com.stefanini.irtbackend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@SpringBootTest
class IrtBackEndApplicationTests {

	@Autowired
	EntityManager entityManager;
	@Test
	void contextLoads() {

		Query query1 = entityManager.createNativeQuery("show columns from User");
		List<Object[]> results = query1.getResultList();
		for (Object[] obj : results) {
			System.out.println("field: " + obj[0]);
			System.out.println("\ttype: " + obj[1]);
			System.out.println("\tnullable: " + obj[2]);
			System.out.println("\tkey: " + obj[3]);
			System.out.println("\tdefault: " + obj[4]);
		}
	}


}
