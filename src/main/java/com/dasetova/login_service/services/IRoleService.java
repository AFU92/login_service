package com.dasetova.login_service.services;

import java.util.List;

import com.dasetova.login_service.model.Role;

public interface IRoleService {

	void createRole(Role role);

	void updateRole(Role role);

	List<Role> getAllRoles();

	Role findById(int id);

}
