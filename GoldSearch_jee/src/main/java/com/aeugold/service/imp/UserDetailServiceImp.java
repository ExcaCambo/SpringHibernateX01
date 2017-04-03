package com.aeugold.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.aeugold.entity.User;
import com.aeugold.service.UserAuthenService;

@Service("userDetail")
public class UserDetailServiceImp implements UserDetailsService{

	@Autowired
	private UserAuthenService userAuth;
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = userAuth.findUserByEmail(arg0);
		if(u == null){
			System.out.println("NOT FOUND !");
			throw new UsernameNotFoundException("User not found!");
		}else{
			System.out.println("USER FOUND ! USERANME : " + u.getUsername());
		}
		return u;
	}

}
