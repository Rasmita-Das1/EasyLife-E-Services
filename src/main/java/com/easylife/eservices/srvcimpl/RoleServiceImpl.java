package com.easylife.eservices.srvcimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easylife.eservices.model.Role;
import com.easylife.eservices.repository.RoleRepository;
import com.easylife.eservices.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepo;

	
	@Override
	public List<Role> findAllRoles() {
		return roleRepo.findAll();
	}

	
	@Override
	public Role saveRole(Role role) {
		return roleRepo.save(role);
	}

	
	@Override
	public Role updateRole(Role updatedRole) {
		
		Role savedRole = roleRepo.findById(updatedRole.getId()).get();

		savedRole.setName(updatedRole.getName());
		return roleRepo.save(savedRole);
	}

	
	@Override
	public void deleteRoleById(int id) {
		roleRepo.deleteById(id);
	}
	

}
