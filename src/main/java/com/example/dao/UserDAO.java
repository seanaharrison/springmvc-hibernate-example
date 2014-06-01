package com.example.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;

@Repository
@Transactional(readOnly = true)
public class UserDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return this.sessionFactory;
	}

	public List<User> getUserList() {
		Criteria criteria = this.getSessionFactory().getCurrentSession()
				.createCriteria(User.class);
		@SuppressWarnings("unchecked")
		List<User> userList = criteria.list();
		return userList;
	}

	@Transactional(readOnly = false)
	public void createUser(User user) {
		this.sessionFactory.getCurrentSession().save(user);
	}

	public User getUserByName(String username) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("username", username));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	public User getUserById(int userId) {
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(
				User.class);
		criteria.add(Restrictions.eq("userId", userId));
		User user = (User) criteria.uniqueResult();
		return user;
	}

}
