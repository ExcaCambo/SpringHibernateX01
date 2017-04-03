package com.kshrd.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kshrd.model.User;
import com.kshrd.model.UserOne;
import com.kshrd.services.UserService;

@Controller
class MyController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/get")
	@ResponseBody
	public ArrayList<UserOne> findUsers(){
		return userService.findUsers();
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public boolean update(){
		User user = new User();
		user.setId(1);
		user.setUsername("TTTTT");
		user.setClassroom("KSP");
		return userService.updateUser(user);
	}

	
}
