package com.dasetova.login_service.services;

import java.util.List;

import com.dasetova.login_service.model.User;

public interface IUserService {

	void createUser(User user);
	
	void updateUser(User user);
	
	List<User> getAllUsers();
	
	User findById(int id);
}
