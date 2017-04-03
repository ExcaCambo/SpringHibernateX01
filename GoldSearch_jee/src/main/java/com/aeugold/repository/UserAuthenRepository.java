package com.aeugold.repository;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.aeugold.entity.Role;
import com.aeugold.entity.User;

@Repository
public interface UserAuthenRepository {

	@Select("SELECT user_id, username, password , email , role_id FROM users WHERE email=#{userEmail}")
	@Results(value={
			@Result(property="roles" , column="role_id" , 
					many=@Many(select="findUserRolesByUserId")
			)
	})
	public User findUserByEmail(@Param("userEmail") String userEmail);
	
	@Select("SELECT role_id , role_name FROM roles WHERE role_id=#{roleId} ")
	@Results(value={
			@Result(property="id" , column="role_id"),
			@Result(property="roleName" , column="role_name")
	})
	public List<Role> findUserRolesByUserId(@Param("roleId") int roleId);
	
}
