package com.aeugold.entity;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String roleName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return roleName;
	}

}
