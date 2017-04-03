package com.aeugold.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.aeugold.model.User;

@Service
public interface UserService {

	public ArrayList<User> getUsersX();

	public boolean insertUserX(String username);

	public boolean updateUserX(User user);

	public boolean deleteUserX(int userid);
}
