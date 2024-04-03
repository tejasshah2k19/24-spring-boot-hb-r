package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.ContactEntity;
import com.entity.UserEntity;
import com.repository.ContactRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactRepository contactRepo;

	@Autowired
	UserRepository userRepository;

	@PostMapping("/save/{userId}")
	public ResponseEntity<?> addContact(@RequestBody ContactEntity contact, @PathVariable("userId") Integer userId) {

		UserEntity user = userRepository.findById(userId).get();
		contactRepo.save(contact);
		user.getContacts().add(contact);
		
		userRepository.save(user);
		return ResponseEntity.ok(user);
	}
	@GetMapping("/all")
	public ResponseEntity<?> getAllContact(){
		return ResponseEntity.ok(contactRepo.findAll());
	}
}
