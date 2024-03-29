package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AddressEntity;
import com.entity.UserEntity;
import com.repository.AddressRepository;
import com.repository.UserRepository;

@RestController
@RequestMapping("/address")
public class AddressController {

	@Autowired
	AddressRepository addressRepository;

	@Autowired
	UserRepository userRepo;

	@PostMapping("/save/{userId}")
	public ResponseEntity<?> addAddress(@RequestBody AddressEntity address,@PathVariable("userId") Integer userId) {
		// city addressLine pincode state
		addressRepository.save(address);// address insert

		// user_address
		UserEntity user = userRepo.findById(userId).get(); 
		user.getAddress().add(address);
		userRepo.save(user);//user_address
		
		return ResponseEntity.ok(address);
	}
}
