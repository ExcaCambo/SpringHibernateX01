package com.aeugold.repository;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;
import org.springframework.stereotype.Repository;

import com.aeugold.model.User;

@Repository
public interface UserRepository {

	/*
	 * MYBATIS CRUD C = CREATE R = READ U = UPDATE D = DELETE
	 * 
	 */
	final String C_USER = "INSERT INTO public.\"user\" (username) VALUES (#{username});";
	final String R_USER = "SELECT user_id, username FROM public.\"user\";";
	final String U_USER = "UPDATE public.\"user\" SET username=#{username} WHERE user_id = #{id};";
	final String D_USER = "DELETE FROM public.\"user\" WHERE user_id = #{id};";

	@Results(value = { @Result(property = "id", column = "user_id"),
			@Result(property = "username", column = "username") })
	@Select(R_USER)
	public ArrayList<User> getUsersX();

	@Results(value = { @Result(property = "id", column = "user_id"),
			@Result(property = "username", column = "username") })
	@Insert(C_USER)
	public boolean insertUserX(String username);

	@Results(value = { @Result(property = "id", column = "user_id"),
			@Result(property = "username", column = "username") })
	@Update(U_USER)
	public boolean updateUserX(User user);

	@Results(value = { @Result(property = "id", column = "user_id")})
	@Delete(D_USER)
	public boolean deleteUserX(int id);

}
