package com.kshrd.repositories.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kshrd.model.User;
import com.kshrd.model.UserOne;
import com.kshrd.repositories.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private DataSource dataSource;
	
	private Connection cnn;

	@Override
	public ArrayList<UserOne> findUsers() {
		ArrayList<UserOne> arr = new ArrayList<UserOne>();
		String sql ="SELECT "
				+ "		user_id, "
				+ "		username, "
				+ "		password"
				+ "	FROM "
				+ "		users;";
		try{
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				arr.add(new UserOne(rs.getInt("user_id"), rs.getString("username"), rs.getString("password")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return arr;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "UPDATE "
				+ "		TBLUSER "
				+ "	SET "
				+ "		username=? , "
				+ "		class_room=? "
				+ "WHERE "
				+ "		id=?";
		try{
			cnn = dataSource.getConnection();
			PreparedStatement ps = cnn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getClassroom());
			ps.setInt(3, user.getId());
			if(ps.executeUpdate() > 0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	

}
