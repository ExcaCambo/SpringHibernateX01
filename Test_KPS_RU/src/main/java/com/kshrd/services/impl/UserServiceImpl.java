package com.kshrd.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kshrd.model.User;
import com.kshrd.model.UserOne;
import com.kshrd.repositories.UserRepository;
import com.kshrd.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public ArrayList<UserOne> findUsers() {
		return userRepo.findUsers();
	}

	@Override
	public boolean updateUser(User user) {
		return userRepo.updateUser(user);
	}

}
