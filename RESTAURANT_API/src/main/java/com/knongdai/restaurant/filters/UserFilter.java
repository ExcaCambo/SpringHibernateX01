package com.knongdai.restaurant.filters;

public class UserFilter {

	private String username;
	private String email;
	private String firstname;
	private String lastname;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	@Override
	public String toString() {
		return "UserFilter [username=" + username + ", email=" + email + ", firstname=" + firstname + ", lastname="
				+ lastname + "]";
	}
	
}
