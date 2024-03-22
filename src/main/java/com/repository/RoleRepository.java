package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

	//we dont need to write any query 
	//we can use entiy /table column in findBy 
	//that means we can have findByRoleName , findByRoleId , nothing else 
	
	List<RoleEntity> findByRoleName(String roleName);
	
}
