package com.siddhey.DemoProxy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoProxyApplicationTests {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Transactional
	public void contextLoads() {
	}

}
