package com.laptrinhjavaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Duy Dung
 *
 */

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "birthday")
	private String birthDay;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone")
	private int phone;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "status")
	private int status;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
}
