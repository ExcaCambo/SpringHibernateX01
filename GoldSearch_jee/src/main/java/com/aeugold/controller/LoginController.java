package com.aeugold.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aeugold.entity.Role;
import com.aeugold.entity.User;
import com.aeugold.service.UserAuthenService;

@Controller
public class LoginController {

	@Autowired
	private UserAuthenService authenService;
	
	@RequestMapping("/getuser")
	@ResponseBody
	public User getUser(){
		return authenService.findUserByEmail("admin@gmail.com");
	}
	
	@RequestMapping("/getrole")
	@ResponseBody
	public List<Role> getRole(){
		return authenService.findUserRolesByUserId(1);
	};
}
