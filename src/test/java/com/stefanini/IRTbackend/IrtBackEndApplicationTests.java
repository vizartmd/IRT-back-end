package com.stefanini.IRTbackend;

import com.stefanini.IRTbackend.testEntities.User;
import org.hibernate.HibernateException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
class IrtBackEndApplicationTests {

	@PersistenceContext
	EntityManager entityManager;

	@Test
	void contextLoads() {
	}

	@Test
	@Transactional
	public void testEntityManager()   {
		try {
			entityManager.persist(new User("test", "test", "test"));

			List<User> result = entityManager.createQuery("select u from User u where u.username = :test")
					.setParameter("test", "test").getResultList();
			System.out.println(result.get(0).toString());

		} catch(HibernateException e) {e.printStackTrace();}
	}



}
