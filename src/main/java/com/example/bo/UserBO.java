package com.example.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.dao.UserDAO;
import com.example.domain.User;

@Service
@Transactional
public class UserBO {

	private UserDAO userDAO;

	@Autowired
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public List<User> getUserList() {
		return this.userDAO.getUserList();
	}

	public void createUser(User user) {
		this.userDAO.createUser(user);
	}

	public User getUserByName(String username) {
		return this.userDAO.getUserByName(username);
	}

	public User getUserById(int userId) {
		return this.userDAO.getUserById(userId);
	}

}
