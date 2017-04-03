package com.knongdai.restaurant.repositories;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import org.springframework.stereotype.Repository;

import com.knongdai.restaurant.entities.Roles;
import com.knongdai.restaurant.entities.Users;
import com.knongdai.restaurant.entities.Users.Users2;


@Repository
public interface UserRepository {
	
	//=========================  GET RESTAURANT OWNER ==================
	String R_WUSER= "SELECT U.user_id, U.first_name, U.last_name, U.username, U.email, U.password, U.dob,"
			+ " U.gender, U.joined, U.picture, R.role_id, R.role_name"
			+ " FROM users U"
			+ " INNER JOIN"
			+ " roles R"
			+ " ON U.role_id= R.role_id WHERE R.role_id =2  and "
			+ " U.user_id NOT IN (SELECT DISTINCT coalesce(user_id,0) FROM restaurants) ORDER BY U.user_id ";
	@Select(R_WUSER)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" )
	})
	public ArrayList<Users> getUserOwner();
	
	String R_USER= "SELECT U.user_id, U.first_name, U.last_name, U.username, U.email, U.password, U.dob,"
			+ " U.gender, U.joined, U.picture, R.role_id, R.role_name"
			+ " FROM users U"
			+ " INNER JOIN"
			+ " roles R"
			+ " ON U.role_id= R.role_id ORDER BY U.user_id ";
	@Select(R_USER)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" )
	})
	public ArrayList<Users> getAllUsers();
	
	// Knongdai user integration. EAN SOKCHOMRERN. 14/10/2016	
	String R_USER_BY_USER_HASH= "SELECT U.user_id, U.first_name, U.last_name, U.username, U.email, U.password, U.dob,"
			+ " U.gender, U.joined, U.picture, R.role_id, R.role_name, U.user_hash "
			+ " FROM users U"
			+ " INNER JOIN"
			+ " roles R"
			+ " ON U.role_id= R.role_id "
			+ " WHERE U.user_hash=#{user_hash} "
			+ " ORDER BY U.user_id ";
	@Select(R_USER_BY_USER_HASH)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" )
	})
	public Users findUserByUserHash(@Param("user_hash") String user_hash);
	
	
	
	
	
	String C_USER="INSERT INTO"
			+ " users (first_name, last_name, username, email, password, dob, gender, picture, role_id, user_hash) "
			+ " VALUES(#{first_name},#{last_name},#{username},#{email},#{password},#{dob},#{gender}, #{picture},#{role.id},#{user_hash}) ";
	
	@Insert(C_USER)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" )
	})
	public boolean insertUser(Users user);
	
	/*=========Sing Up User=================*/
	String S_USER="INSERT INTO"
			+ " users (first_name, last_name, username, email, password, dob, gender, picture, role_id)"
			+ " VALUES(#{first_name},#{last_name},#{username},#{email},#{password},#{dob},#{gender}, #{picture},1)";
	
	@Insert(S_USER)
	@Results(value={
			@Result(property="role.name", column="role_name" )
	})
	public boolean signUpUser(Users user);
	
	
	String U_USER="UPDATE users "
			+ " SET first_name=#{first_name},"
			+ " last_name=#{last_name},"
			+ " username=#{username},"
			+ " email=#{email},"
			+ " password=#{password},"
			+ " dob=#{dob},"
			+ " gender=#{gender},"
			+ " picture=#{picture},"
			+ " role_id=#{role.id} WHERE user_id=#{user_id}";
	
	@Update(U_USER)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" )
	})
	public boolean  updateUser2(Users2 user);
	
	String D_USER="DELETE"
				+ " FROM"
				+ " users "
				+ " WHERE "
				+ " user_id=#{user_id} ";
	@Delete(D_USER)
	public boolean deleteUser(int id);
	
	String F_USER="SELECT U.user_id, U.first_name, U.last_name, U.username, U.email,"
			+ " U.gender, U.password, U.dob, U.joined,"
			+ " U.picture, R.role_id, R.role_name"
			+ " FROM users U"
			+ " INNER JOIN"
			+ " roles R"
			+ " ON U.role_id= R.role_id WHERE U.user_id=#{U.user_id}";
	@Select(F_USER)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" )
	})
	public Users findUserById(int id);
	
	String F_USERNAME = "SELECT user_id, "
			+ "	username, password, "
			+ "	first_name, last_name, "
			+ "	picture, dob, "
			+ "	email, role_id "
			+ "	FROM users WHERE username=#{username}";
	
	@Select(F_USERNAME)
	@Results(value = {
			@Result(property = "user_id" , column = "user_id"),
			@Result(property = "username" , column = "user_name"),
			@Result(property = "email" , column = "email"),
			@Result(property = "password" , column = "password"),
			@Result(property = "role.id" , column = "role_id"),
			@Result(property = "role.name" , column = "role_name"),
			@Result(property = "role_name" , column = "role_name"),
			@Result(property = "roles", column = "role_id",
				many = @Many(select = "findRolesByRoleId")
			)
	})
	public Users findUserByUsername(@Param("username") String username);
	
	
	@Select("SELECT role_id, role_name FROM roles WHERE role_id=#{role_idddd}")
	@Results(value = {
			@Result(property="id" , column="role_id"),
			@Result(property="name" , column="role_name")
		})
	public ArrayList<Roles> findRolesByRoleId(int role_idddd);
	
	//==========================Insert into user with picture
	/*String CP_USER="INSERT INTO"
			+ " users (first_name, last_name, username, email, password, dob, gender, picture, role_id)"
			+ " VALUES(#{first_name},#{last_name},#{username},#{email},#{password},#{dob},#{gender}, #{picture},#{role.id})";
	
	@Insert(CP_USER)
	@Results(value={
			@Result(property="role.id", column="role_id"),
			@Result(property="role.name", column="role_name" ),
			@Result(property="picture", column="role_name" )
	})*/
	
	@Select("SELECT COUNT(*) From users where role_id=#{role_id}")
	public int countUser(@Param("role_id") int role_id);
	
	
}
