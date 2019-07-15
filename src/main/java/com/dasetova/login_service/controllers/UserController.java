package com.dasetova.login_service.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dasetova.login_service.model.User;
import com.dasetova.login_service.services.IUserService;
import com.dasetova.login_service.utils.Validator;

@RestController
@RequestMapping("/api/users")
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user){
		LOGGER.info("Creating new User with email %{}", user.getEmail());
		return new ResponseEntity<User>(this.userService.createUser(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<User> updateUser(@PathVariable String userId, @RequestBody User user){
		user.setId(Validator.validateIntegerId(userId));
		LOGGER.info("Updating User with email %{}", user.getEmail());
		return new ResponseEntity<User>(this.userService.updateUser(user), HttpStatus.OK);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<User> getUser(@PathVariable String userId){
		LOGGER.info("Getting User with id %{}", userId);
		return new ResponseEntity<User>(this.userService.findById(Validator.validateIntegerId(userId)), HttpStatus.OK);
	}
	
	@GetMapping({"/", ""})
	public ResponseEntity<List<User>> getAllUsers(){
		LOGGER.info("Getting all Users");
		return new ResponseEntity<List<User>>(this.userService.getAllUsers(), HttpStatus.OK);
	}
	
	@PostMapping("/{userId}/roles/{roleId}")
	public ResponseEntity<User> addRoleToUser(@PathVariable String userId, @PathVariable String roleId){
		LOGGER.info("Creating role with id %{} to user with Id %{}", roleId, userId);
		return new ResponseEntity<User>(this.userService.addRoleToUser(Validator.validateIntegerId(userId),
				Validator.validateIntegerId(roleId)), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{userId}/roles/{roleId}")
	public ResponseEntity<User> removeRoleFromUser(@PathVariable String userId, @PathVariable String roleId){
		LOGGER.info("Removing role with id %{} to user with Id %{}", roleId, userId);
		return new ResponseEntity<User>(this.userService.removeRoleFromUser(Validator.validateIntegerId(userId),
				Validator.validateIntegerId(roleId)), HttpStatus.OK);
	}

}
