package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Roles;
import com.knongdai.restaurant.entities.Users;
import com.knongdai.restaurant.entities.Users.Users2;

@Service
public interface UserService {
	public ArrayList<Users> getAllUsers();
	
	
	
	public boolean insertUser(Users user);
	
	public boolean signUpUser(Users2 user2);
	
	public boolean  updateUser2(Users2 user2);
	
/*	public boolean  updateUser(Users user);*/
	
	public boolean deleteUser(int id);
	
	public Users findUserById(int id);
	
	public ArrayList<Roles> findRolesByRoleId( int role_id);
	
	public Users findUserByUsername(String username);
	
	public boolean addUser(Users2 user);
	
	public ArrayList<Users> getUserOwner();
	
	public int countUser(int role_id);
	
	// Knongdai user integration. EAN SOKCHOMRERN. 14/10/2016
	public Users findUserByUserHash(String user_hash);
}
