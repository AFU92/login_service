package com.dasetova.login_service.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.dasetova.login_service.model.Role;
import com.dasetova.login_service.repositories.IRoleRepository;
import com.dasetova.login_service.services.IRoleService;

public class RoleService implements IRoleService {

	/** The role repository. */
	@Autowired
	private IRoleRepository roleRepository;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role createRole(Role role) {
		return roleRepository.save(role);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<Role> findById(final Integer id) {
		Assert.notNull(id, "Role identifier must not be empty");
		return Optional.ofNullable(roleRepository.findOne(id));
	}

}
