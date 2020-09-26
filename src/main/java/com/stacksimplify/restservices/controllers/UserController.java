package com.stacksimplify.restservices.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.services.UserService;

//Controller
@RestController
public class UserController {

	
	//Autowire the service
	
	@Autowired
	private UserService userService;
	
	
	//getAllUsers Method
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return userService.getAllUsers();
		
	}
	
	//CreateUser Method
	//@RequestBody
	//@PostMapping	
	@PostMapping("/users")
    public User createUser(@RequestBody User user) {
		
    	return userService.createUser(user);
	
    }
	
	//getUserById Method
	
	@GetMapping("/users/{id}")
	public Optional<User> getUserById(@PathVariable("id") Long id){
		return userService.getUserById(id);
	}
	
	//updateUserById Method
	@PutMapping("/users/{id}")
	public User updateUserById(@PathVariable("id") Long id,@RequestBody User user) {
		return userService.updateUserById(id, user);
	}
	
	
	//deleteUserById
	@DeleteMapping("/users/{id}")
	public void deleteUserById(@PathVariable("id") Long id) {
		userService.deleteUserById(id);
	}
	
	
	//getUserByUsername
	@GetMapping("/users/byusername/{username}")
	public User getUserByUserName(@PathVariable("username") String username) {
		return userService.getUserByUserName(username);
	}
	
 }
