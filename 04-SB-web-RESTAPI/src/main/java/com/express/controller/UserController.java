package com.express.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.express.entities.User;
import com.express.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/user")
@Slf4j
public class UserController {
	@Autowired
	private UserService userService;
    
	//json
	@PostMapping
	
	@ResponseStatus(code= HttpStatus.CREATED)
	public void createUser(@RequestBody User user) {
		log.info("UserController::createUser{} ",user.getEmail());
		userService.createUser(user);
	}
	
	@GetMapping("{userId}")
	public User getUserById(@PathVariable Long userId) {
		log.info("UserController:: getUserById {} ",userId);
		return userService.findUserById(userId);
	}
	@GetMapping("username/{userId}")
	public void fetchUserInformationByUsername(@PathVariable Long userId) {
		log.info("UserController:: getUserById {} ",userId);
		//return userService.findUserById(userId);
	}
	
	@PutMapping("{userId}")
	@Operation(summary = "Update a user", description = "Updates the details of an existing user by their ID")
	public void updateUser(@PathVariable Long userId, @RequestBody User user) {
		userService.updateUser(userId, user);
	}
	
	// http://localhost:8080/api/v1/user/changepwd/{45}
		@PatchMapping("changepwd/{userId}")
		public void updatePassword(@PathVariable Long userId,@RequestBody User user) {
			userService.updatePassword(userId, user);
		}
	@DeleteMapping("{userId}")
	public void deleteuser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}
	
	@GetMapping("/login/{username}/{password}")
	public User fetchUser(@PathVariable String username,@PathVariable String password) {
		return userService.fetchUserData(username,password);
	}
}
