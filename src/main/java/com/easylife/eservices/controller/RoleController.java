package com.easylife.eservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easylife.eservices.model.Role;
import com.easylife.eservices.service.RoleService;


@RestController
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleService roleSrvc;
	
	@GetMapping
	public List<Role> listAllRoles() {
		return roleSrvc.findAllRoles();
	}
	
	
	@PostMapping	
//	@ResponseStatus(CREATED)
	public Role saveRole(@RequestBody Role role) {
		return roleSrvc.saveRole(role);
	}
	
	
	@PutMapping
	public Role updateRole(@RequestBody Role role) {
		return roleSrvc.updateRole(role);
	}
	
	
	@DeleteMapping("/{roleId}")
	public String deleteRoleById(@PathVariable("roleId") int id) {
		roleSrvc.deleteRoleById(id);

		return "Deleted role with id : " + id;
	}
	
	
}
