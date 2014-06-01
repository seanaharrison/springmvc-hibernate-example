package com.example.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bo.UserBO;
import com.example.domain.User;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	UserBO userBO;

	@Autowired
	public void setUserBO(UserBO userBO) {
		this.userBO = userBO;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Homepage requested");
		return "home";
	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public @ResponseBody List<User> getUserList() {
		return userBO.getUserList();
	}

	@RequestMapping(value = "/userid/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUserById(@PathVariable int userId) {
		return userBO.getUserById(userId);
	}
	
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public @ResponseBody User getUserByUsername(@PathVariable String username) {
		return userBO.getUserByName(username);
	}
	
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public @ResponseBody void addUser(@RequestBody User user) {		
		userBO.createUser(user);
	}

}
