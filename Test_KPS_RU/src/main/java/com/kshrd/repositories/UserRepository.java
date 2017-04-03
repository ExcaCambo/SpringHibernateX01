package com.kshrd.repositories;

import java.util.ArrayList;

import com.kshrd.model.User;
import com.kshrd.model.UserOne;

public interface UserRepository {
	
	public ArrayList<UserOne> findUsers();
	public boolean updateUser(User user);

}
