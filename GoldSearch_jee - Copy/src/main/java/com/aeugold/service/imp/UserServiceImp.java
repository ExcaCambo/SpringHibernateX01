package com.aeugold.service.imp;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeugold.model.User;
import com.aeugold.repository.UserRepository;
import com.aeugold.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRep;

	@Override
	public ArrayList<User> getUsersX() {
		return userRep.getUsersX();
	}

	@Override
	public boolean updateUserX(User user) {
		return userRep.updateUserX(user);
	}

	@Override
	public boolean deleteUserX(int userid) {
		return userRep.deleteUserX(userid);
	}

	@Override
	public boolean insertUserX(String username) {
		return userRep.insertUserX(username);
	}

}
