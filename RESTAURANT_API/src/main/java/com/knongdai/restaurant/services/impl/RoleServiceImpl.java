package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Roles;
import com.knongdai.restaurant.repositories.RoleRepository;
import com.knongdai.restaurant.services.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public ArrayList<Roles> getAllRoles() {
		return roleRepository.getAllRoles();
	}

	@Override
	public boolean insertRole(Roles role) {
		return roleRepository.insertRole(role);
	}

	@Override
	public boolean updateRole(Roles role) {
		return roleRepository.updateRole(role);
	}

	@Override
	public boolean deleteRole(int id) {
		return roleRepository.deleteRole(id);
	}

	@Override
	public ArrayList<Roles> getRoleById(int id) {
		return roleRepository.getRoleById(id);
	}

}
