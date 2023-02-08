package com.easylife.eservices.service;

import java.util.List;

import com.easylife.eservices.model.User;


public interface UserService {
	
	List<User> findAllUsers();

	User saveUser(User user);

	User updateUser(User user);

	void deleteUserById(int id);

}
