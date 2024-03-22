package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.UserEntity;
import com.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepo;

	@PostMapping("/save")
	public ResponseEntity<?> addUser(@RequestBody UserEntity user) {

		System.out.println(user.getRole());
		System.out.println(user.getRole().getRoleId());

		userRepo.save(user);// insert

		return ResponseEntity.ok(user);
	}

	// read users table
	// select * from users

	@GetMapping("/all")
	public ResponseEntity<?> getAllUsers() {
		List<UserEntity> users = userRepo.findAll();
		return ResponseEntity.ok(users);
	}
	
	//delete from users -> this will remove all the records 
	//delete from users where userId = 1 

	
	@DeleteMapping("/remove/{userId}")
	public ResponseEntity<?> removeUser(@PathVariable("userId") Integer userId){
		
		userRepo.deleteById(userId);
		return ResponseEntity.ok("User Removed");
	}

	//get user by userId 
	//select * from users where userId = 1 
	@GetMapping("/get/{userId}")
	public ResponseEntity<?> getUserById(@PathVariable("userId") Integer userId){

		if(userRepo.findById(userId).isPresent() ) {
			UserEntity user = userRepo.findById(userId).get();
			return ResponseEntity.ok(user);	
		}else {
			return ResponseEntity.noContent().build();	
			
		}
		
		//getById ->invalid ->empty -> return Entity -> error  
		//findById -> Optional  
	}
	
	
	//update -> mapping ?
	@PutMapping("/update")
	public ResponseEntity<?> updateUser(@RequestBody UserEntity user){
		UserEntity oldUser = userRepo.findById(user.getUserId()).get();

		//fn 
		if(user.getFirstName() != null) {
			oldUser.setFirstName(user.getFirstName());
		}
		//ln 
		if(user.getLastName() != null) {
			oldUser.setFirstName(user.getLastName());
		}
		
		
		userRepo.save(oldUser);// save -> entity id present update 
		return ResponseEntity.ok(oldUser); 
		
	}
	
	//swagger doc 
	
}

