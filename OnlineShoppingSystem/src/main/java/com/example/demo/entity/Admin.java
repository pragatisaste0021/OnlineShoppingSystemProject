package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_Id")
	private int admin_Id;
	
	@Column(name = "admin_name")
	private String admin_name;
	
	public Admin() {
		
	}
	public Admin(int admin_Id, String admin_name) {
		super();
		this.admin_Id = admin_Id;
		this.admin_name = admin_name;
	}
	
	
	public int getAdmin_Id() {
		return admin_Id;
	}
	public void setAdmin_Id(int admin_Id) {
		this.admin_Id = admin_Id;
	}
	public String getAdmin_name() {
		return admin_name;
	}
	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}
	
	
	

	
}
