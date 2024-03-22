package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.RoleEntity;
import com.repository.RoleRepository;

@RestController
@RequestMapping("role")
public class RoleController {

	@Autowired
	RoleRepository roleRepo;

	@PostMapping("/save")
	public ResponseEntity<?> saveRole(@RequestBody RoleEntity role) {

		if (roleRepo.findByRoleName(role.getRoleName()).size() != 0) {
			return ResponseEntity.status(HttpStatusCode.valueOf(409)).body(role);
		}
		roleRepo.save(role);
		return ResponseEntity.ok(role);
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllRoles() {
		return ResponseEntity.ok(roleRepo.findAll());
	}

}
