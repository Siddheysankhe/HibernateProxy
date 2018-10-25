package com.siddhey.DemoProxy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.siddhey.DemoProxy.Entitites.Post;
import com.siddhey.DemoProxy.Entitites.PostComment;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoProxyApplicationTests {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private static final Logger logger = LoggerFactory.getLogger(DemoProxyApplicationTests.class);

//	@Test
//	@Transactional
//	public void contextLoads() {
//		
//		//find
//		Post post = new Post();
//		post.setId(1L);
//		post.setTitle("Siddhey Sankhe");
//		
//		entityManager.persist(post);
//		
//		Post post1 = entityManager.find(Post.class, 1L);
//		assertEquals("Siddhey Sankhe", post1.getTitle());
//		
//		PostComment comment = new PostComment();
//		comment.setReview("Awesome book");
//		
//		Post post3 = entityManager.getReference(Post.class, 1L);
//		comment.setPost(post3);
//		 
//		entityManager.persist(comment);
//		
//		//getReference
//		
//		PostComment comment1 = new PostComment();
//		comment.setReview("Just awesome!");
//		 
//		Post post4 = entityManager.getReference(Post.class, 1L);
//		comment.setPost(post4);
//		 
//		entityManager.persist(comment1);
//		
//	}
	
	@Test
	@Transactional
	public void proxyTest() {
		Post post = new Post();
		post.setId(1L);
		post.setTitle("Siddhey Sankhe");
		entityManager.persist(post);
		
		PostComment comment = new PostComment();
		comment.setId(1L);
		comment.setReview("Awesome");
		comment.setPost(post);
		entityManager.persist(comment);
		
		PostComment comment1 = entityManager.getReference(PostComment.class, 1L);
		
		assertFalse(comment.equals(comment1));
		
		assertTrue(comment.equals(Hibernate.unproxy(comment1)));
	}

}
