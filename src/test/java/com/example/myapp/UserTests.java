package com.example.myapp;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.example.bo.UserBO;
import com.example.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:servlet-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class UserTests {

	private static Log log = LogFactory.getLog(User.class);

	@Autowired
	private SessionFactory sessionFactory;
	@Autowired
	private UserBO userBO;

	private User testUser;

	@Before
	public void setUpTestDataWithinTransaction() throws ParseException {
		testUser = new User();
		testUser.setUsername("new user 33");
		testUser.setPassword("1234");
		log.info("Created test user");
	}

	@Test
	public void applicationsExists() {
		List<User> userList = userBO.getUserList();
		log.info(userList.toString());
		boolean contains = userList.isEmpty();
		assertEquals(contains, false);
	}

	@Test
	public void createUser() {
		userBO.createUser(testUser);
		sessionFactory.getCurrentSession().flush();
		User savedUser = userBO.getUserByName(testUser.getUsername());
		assertEquals(savedUser.getPassword(), testUser.getPassword());
		log.info("Test User Password= " + testUser.getPassword()
				+ " / Saved User Password = " + savedUser);
	}

	@After
	public void tearDownWithinTransaction() {
		testUser = null;
		log.info("Transaction teared down");
	}

}
