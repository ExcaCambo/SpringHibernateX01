package com.kshrd.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.kshrd.model.User;
import com.kshrd.model.UserOne;

public interface UserService {

	public ArrayList<UserOne> findUsers();
	public boolean updateUser(User user);
}
