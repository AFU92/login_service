package com.dasetova.login_service.services;

import java.util.List;

import com.dasetova.login_service.model.Role;

/**
 * The Interface IRoleService.
 */
public interface IRoleService {

	/**
	 * Creates the role.
	 *
	 * @param role the role
	 * @return the role created
	 */
	Role createRole(Role role);

	/**
	 * Update role.
	 *
	 * @param role the role
	 * @return the role updated
	 */
	Role updateRole(Role role);

	/**
	 * Gets all created roles.
	 *
	 * @return A List with all created roles
	 */
	List<Role> getAllRoles();
	
	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return Role
	 */
	Role findById(final Integer id);

}
