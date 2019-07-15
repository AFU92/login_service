package com.dasetova.login_service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.dasetova.login_service.model.Role;
import com.dasetova.login_service.model.User;
import com.dasetova.login_service.model.exceptions.NotFoundException;
import com.dasetova.login_service.repositories.IUserRepository;
import com.dasetova.login_service.services.IUserService;

@Service
public class UserService implements IUserService {

	/** The user repository. */
	@Autowired
	private IUserRepository userRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findById(final Integer id) {
		Assert.notNull(id, "User identifier must not be empty");
		return Optional.ofNullable(userRepository.findOne(id)).orElseThrow(() -> new NotFoundException()); 
	}

	@Override
	public List<Role> getAllUserRoles(final Integer userId) {
		Assert.notNull(userId, "User identifier must not be empty");
		return findById(userId).getRoles();
	}

}
