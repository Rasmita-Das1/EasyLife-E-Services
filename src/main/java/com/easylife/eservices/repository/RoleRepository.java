package com.easylife.eservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easylife.eservices.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{

}
