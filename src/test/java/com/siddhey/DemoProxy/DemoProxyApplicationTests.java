package com.siddhey.DemoProxy;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.siddhey.DemoProxy.Entitites.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoProxyApplicationTests {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void contextLoads() {
		final User tom = new User("Tom", "Admin");
		entityManager.persist(tom);
		User tom1 = entityManager.getReference(User.class, tom.getId());
		assertThat(tom1).isInstanceOf(User.class);
		assertThat(tom).isSameAs(tom1);
	}

}
