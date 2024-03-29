package com.github.PiotrDuma.YourListener.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceEngine implements UserDetailsService{
	
	private UserRepository userRepository;
	
	@Autowired
	public UserDetailServiceEngine (UserRepository userRepository){
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userRepository.findUserByUsername(username);
	}

}
