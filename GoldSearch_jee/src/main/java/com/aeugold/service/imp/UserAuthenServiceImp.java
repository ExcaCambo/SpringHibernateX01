package com.aeugold.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aeugold.entity.Role;
import com.aeugold.entity.User;
import com.aeugold.repository.UserAuthenRepository;
import com.aeugold.service.UserAuthenService;

@Service
public class UserAuthenServiceImp implements UserAuthenService{
	
	@Autowired
	private UserAuthenRepository authenRep;

	@Override
	public User findUserByEmail(String userEmail) {
		// TODO Auto-generated method stub
		return authenRep.findUserByEmail(userEmail);
	}

	@Override
	public List<Role> findUserRolesByUserId(int roleId) {
		// TODO Auto-generated method stub
		return authenRep.findUserRolesByUserId(roleId);
	}

}
