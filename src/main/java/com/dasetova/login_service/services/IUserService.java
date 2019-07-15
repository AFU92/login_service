package com.dasetova.login_service.services;

import java.util.List;

import com.dasetova.login_service.model.Role;
import com.dasetova.login_service.model.User;

/**
 * The Interface IUserService.
 */
public interface IUserService {

	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the user created
	 */
	User createUser(User user);
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @return the user updated
	 */
	User updateUser(User user);
	
	/**
	 * Gets all created users.
	 *
	 * @return A List with all created users
	 */
	List<User> getAllUsers();
	
	/**
	 * Gets all roles that a user has.
	 *
	 * @return All user roles
	 */
	List<Role> getAllUserRoles(Integer userId); 
	
	/**
	 * Find User by id.
	 *
	 * @param id the user identifier
	 * @return Optional with User, empty if user doesn't exists
	 */
	User findById(Integer id);
}
