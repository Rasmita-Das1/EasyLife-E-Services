package com.easylife.eservices.srvcimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.easylife.eservices.model.User;
import com.easylife.eservices.repository.UserRepository;



public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("Sorry!! \nCould not find the user");
		}

		return new MyUserDetails(user);
	}
}
