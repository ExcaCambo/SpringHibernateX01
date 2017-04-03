package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Roles;

@Service
public interface RoleService {
	public ArrayList<Roles> getAllRoles();
	public boolean insertRole(Roles role);
	public boolean  updateRole(Roles role);
	public boolean deleteRole(int id);
	public ArrayList<Roles> getRoleById(int id);
}
