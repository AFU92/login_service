package com.dasetova.login_service.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dasetova.login_service.model.Role;
import com.dasetova.login_service.repositories.IRoleRepository;
import com.dasetova.login_service.services.IRoleService;

public class RoleService implements IRoleService {

	@Autowired
	private IRoleRepository roleRepository;

	@Override
	public void createRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public void updateRole(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		return roleRepository.findOne(id);
	}

}
