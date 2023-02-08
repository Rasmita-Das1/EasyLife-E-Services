package com.easylife.eservices.srvcimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.easylife.eservices.model.User;
import com.easylife.eservices.repository.UserRepository;
import com.easylife.eservices.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	
	@Override
	public List<User> findAllUsers() {
		return userRepo.findAll();
	}

	
	@Override
	public User saveUser(User user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	
	@Override
	public User updateUser(User updatedUser) {
		User savedUser = userRepo.findById(updatedUser.getId()).get();

		savedUser.setUsername(updatedUser.getUsername());
		savedUser.setPassword(bcryptEncoder.encode(updatedUser.getPassword()));
		savedUser.setRoles(updatedUser.getRoles());
		
		return userRepo.save(savedUser);
	}

	
	@Override
	public void deleteUserById(int id) {
		userRepo.deleteById(id);
	}

}
