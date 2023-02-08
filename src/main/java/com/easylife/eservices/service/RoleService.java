package com.easylife.eservices.service;

import java.util.List;

import com.easylife.eservices.model.Role;

public interface RoleService {
	
	List<Role> findAllRoles();

	Role saveRole(Role role);

	Role updateRole(Role role);

	void deleteRoleById(int id);

}
