package com.siddhey.DemoProxy;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.siddhey.DemoProxy.Entitites.User;

@Component
public class ProjectRunner implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(ProjectRunner.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void run(final String... args) throws Exception {

		logger.info("-----------------------------");
		logger.info("Adding Tom as Admin");
		logger.info("-----------------------------");
		final User tom = new User("Tom", "Admin");
		entityManager.persist(tom);
		logger.info("Added tom" + tom);
		logger.info("-----------------------------");
		logger.info("Retrieving Tom ");
		User tom1 = entityManager.find(User.class, 1L);
		logger.info(tom1.toString());
		logger.info("-----------------------------");

		assertThat(tom1).isInstanceOf(User.class).isSameAs(tom);

	}
}
