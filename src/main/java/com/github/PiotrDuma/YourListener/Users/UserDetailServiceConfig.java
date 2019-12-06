package com.github.PiotrDuma.YourListener.Users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceConfig implements UserDetailsService{
	
	private UserRepository userRepository;
	
	@Autowired
	UserDetailServiceConfig (UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findUserByUsername(username);
	}

}
