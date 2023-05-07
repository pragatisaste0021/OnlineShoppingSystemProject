package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "userdetail")
public class UserDetail {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int user_id;
	
	//@Size(min=2, max=30) 
	//@NotNull

	@Column(name="first_name")
	private String first_name;
	//@Size(min=2, max=30) 
	//@NotNull

	@Column(name="last_name")
	private String last_name;
	//@Size(min=2, max=30) 
	//@NotNull


	@Column(name="user_name")
	private String username;
	//@Size(min=2, max=30) 
	//@NotNull

	@Column(name="user_password")
	private String userpassword;
	//@Size(min=2, max=30) 
	//@NotNull 

	@Column(name="residential_address")
	private String residentialAddress;
	//@Size(min=2, max=30) 
	//@NotNull

	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Column(name="mobile_no")
	private long mobile_no;
	
	public UserDetail() {
		
	}

	public UserDetail(int user_id, String first_name, String last_name, String username, String userpassword,
			String residentialAddress, String permanentAddress, long mobile_no) {
		super();
		this.user_id = user_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.userpassword = userpassword;
		this.residentialAddress = residentialAddress;
		this.permanentAddress = permanentAddress;
		this.mobile_no = mobile_no;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getResidentialAddress() {
		return residentialAddress;
	}

	public void setResidentialAddress(String residentialAddress) {
		this.residentialAddress = residentialAddress;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public long getMobile_no() {
		return mobile_no;
	}

	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}

	
}
