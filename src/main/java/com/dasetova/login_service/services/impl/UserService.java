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
import com.dasetova.login_service.services.IRoleService;
import com.dasetova.login_service.services.IUserService;

@Service
public class UserService implements IUserService {

	private static final String USER_NOT_FOUND = "The user with id %s doesn't exists";

	/** The user repository. */
	@Autowired
	private IUserRepository userRepository;

	@Autowired
	private IRoleService roleService;

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
		if (!userRepository.exists(user.getId())) {
			throw new NotFoundException(String.format(USER_NOT_FOUND, user.getId()));
		}
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
		return Optional.ofNullable(userRepository.findOne(id))
				.orElseThrow(() -> new NotFoundException(String.format(USER_NOT_FOUND, id)));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> getAllUserRoles(final Integer userId) {
		Assert.notNull(userId, "User identifier must not be empty");
		return findById(userId).getRoles();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User addRoleToUser(final Integer id, final Integer roleId) {
		User user = this.findById(id);
		user.getRoles().add(this.roleService.findById(roleId));
		return userRepository.save(user);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User removeRoleFromUser(Integer id, Integer roleId) {
		User user = this.findById(id);
		Role role = this.roleService.findById(roleId);
		if (!user.getRoles().contains(role)) {
			throw new NotFoundException(
					String.format("User with id %s doesn't have the role with id %s", id, roleId));
		}
		user.getRoles().remove(this.roleService.findById(roleId));
		return userRepository.save(user);
	}

}
