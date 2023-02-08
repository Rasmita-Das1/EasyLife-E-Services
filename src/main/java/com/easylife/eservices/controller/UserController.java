package com.easylife.eservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easylife.eservices.model.User;
import com.easylife.eservices.service.UserService;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userSrvc;

	@GetMapping
	public List<User> listAllUsers() {
		return userSrvc.findAllUsers();
	}

	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userSrvc.saveUser(user);
	}

	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userSrvc.updateUser(user);
	}

	@DeleteMapping("/{userId}")
	public String deleteUserById(@PathVariable("userId") int id) {
		userSrvc.deleteUserById(id);

		return "Deleted user with id : " + id;
	}

}
