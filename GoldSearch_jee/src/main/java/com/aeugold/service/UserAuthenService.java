package com.aeugold.service;

import java.util.List;

import com.aeugold.entity.Role;
import com.aeugold.entity.User;


public interface UserAuthenService {
	
	public User findUserByEmail(String userEmail);
	public List<Role> findUserRolesByUserId( int roleId);
}
