package com.knongdai.restaurant.services.impl;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knongdai.restaurant.entities.Roles;
import com.knongdai.restaurant.entities.UploadedFileInfo;
import com.knongdai.restaurant.entities.Users;
import com.knongdai.restaurant.entities.Users.Users2;
import com.knongdai.restaurant.repositories.UserRepository;
import com.knongdai.restaurant.services.FileUploadService;
import com.knongdai.restaurant.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Override
	public ArrayList<Users> getAllUsers() {
		return userRepository.getAllUsers();
	}

	@Override
	public boolean insertUser(Users user) {
		
		return userRepository.insertUser(user);
	}

	

	@Override
	public boolean deleteUser(int id) {
		return userRepository.deleteUser(id);
	}

	@Override
	public Users findUserById(int id) {
		return userRepository.findUserById(id);
	}


	@Override
	public ArrayList<Roles> findRolesByRoleId(int role_id) {
		
		return userRepository.findRolesByRoleId(role_id);
	}

	@Override
	public Users findUserByUsername(String username) {
		
		return userRepository.findUserByUsername(username);
	}

	@Override
	@Transactional
	public boolean signUpUser(Users2 user2) {
		if(!user2.getUser_file().isEmpty()){
			UploadedFileInfo picture = fileUploadService.upload(user2.getUser_file(), "user");
			
			for(String picture_file : picture.getNames()){
				user2.setPicture(picture_file);
				System.out.println(user2);
			}
			
			return userRepository.signUpUser(user2);
			
		}
		
		return false;
		
	}

	@Override
	@Transactional
	public boolean addUser(Users2 user2) {
		
		if(!user2.getUser_file().isEmpty()){
			UploadedFileInfo picture = fileUploadService.upload(user2.getUser_file(), "user");
			
			for(String picture_file : picture.getNames()){
				user2.setPicture(picture_file);
			}
			
			return userRepository.insertUser(user2);
			
		}
		
		return false;
	}

	@Override
	public ArrayList<Users> getUserOwner() {
		
		return userRepository.getUserOwner();
	}

	@Override
	public int countUser(int role_id) {
		return userRepository.countUser(role_id);
	}

	@Override
	public boolean updateUser2(Users2 user2) {
		if(!user2.getUser_file().isEmpty()){
			UploadedFileInfo picture = fileUploadService.upload(user2.getUser_file(), "user");
			
			for(String picture_file : picture.getNames()){
				user2.setPicture(picture_file);
			}
			
			return userRepository.updateUser2(user2);
			
		}else{
			return userRepository.updateUser2(user2);
		}
		
	}

	// Knongdai user integration. EAN SOKCHOMRERN. 14/10/2016
	@Override
	public Users findUserByUserHash(String user_hash) {
		// TODO Auto-generated method stub
		return userRepository.findUserByUserHash(user_hash);
	}


}
