package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity // class-table ->create table
@Table(name = "users")
public class UserEntity {

	@Id // primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 1 2 3 4
	private Integer userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	// fk
	@ManyToOne // 1-1 1-M M-1 M-M //order - 1user Norder
	@JoinColumn(name = "roleId")
	RoleEntity role;

	@OneToMany
	List<AddressEntity> address;

	
	//1-Many 
	@OneToMany
	@JoinColumn(name = "userId") 
	List<ContactEntity> contacts; 
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}

	public List<AddressEntity> getAddress() {
		return address;
	}

	public void setAddress(List<AddressEntity> address) {
		this.address = address;
	}

}
