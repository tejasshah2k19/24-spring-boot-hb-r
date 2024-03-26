package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.AddressEntity;

public interface AddressRepository extends JpaRepository<AddressEntity, Integer> {

	
}
