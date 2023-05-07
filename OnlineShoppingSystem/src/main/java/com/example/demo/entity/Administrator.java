package com.example.demo.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Administrator")
public class Administrator {

	@Column(name = "admin_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int admin_id;

	@Column(name = "admin_name")
	@NotBlank(message = "Admin name can not be empty")
	@Size(max=20,message = "Admin name can't be more than 20 characters")
	@Size(min=5,message = "Admin name must be more than 5 characters")
	private String admin_name;

	@Column(name = "admin_emailId")
	@NotBlank(message = "Admin email can not be empty")
	@Size(min=10,message = "Admin email must be more than 10 characters")
	private String admin_emailId;

	@Column(name = "admin_mobile_no")
	@NotNull(message = "Admin mobile Number can not be null")
	
	private long admin_mobile_no;

	@Column(name = "admin_address")
	@NotBlank(message = "Admin address can not be empty")
	@Size(max=20,message = "Admin address can't be more than 20 characters")
	@Size(min=5,message = "Admin address must be more than 5 characters")
	private String admin_address;

	@Column(name = "admin_password")
	private String admin_password;

	@Column(name = "moderator_id")
	@NotNull(message = "Moderator id can not be empty")
	private int moderator_id;
	
	public Administrator() {
		
	}

	public Administrator(int admin_id, String admin_name, String admin_emailId, long admin_mobile_no,
			String admin_address, String admin_password, int moderator_id) {
		super();
		this.admin_id = admin_id;
		this.admin_name = admin_name;
		this.admin_emailId = admin_emailId;
		this.admin_mobile_no = admin_mobile_no;
		this.admin_address = admin_address;
		this.admin_password = admin_password;
		this.moderator_id = moderator_id;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public String getAdmin_name() {
		return admin_name;
	}

	public void setAdmin_name(String admin_name) {
		this.admin_name = admin_name;
	}

	public String getAdmin_emailId() {
		return admin_emailId;
	}

	public void setAdmin_emailId(String admin_emailId) {
		this.admin_emailId = admin_emailId;
	}

	public long getAdmin_mobile_no() {
		return admin_mobile_no;
	}

	public void setAdmin_mobile_no(long admin_mobile_no) {
		this.admin_mobile_no = admin_mobile_no;
	}

	public String getAdmin_address() {
		return admin_address;
	}

	public void setAdmin_address(String admin_address) {
		this.admin_address = admin_address;
	}

	public String getAdmin_password() {
		return admin_password;
	}

	public void setAdmin_password(String admin_password) {
		this.admin_password = admin_password;
	}

	public int getModerator_id() {
		return moderator_id;
	}

	public void setModerator_id(int moderator_id) {
		this.moderator_id = moderator_id;
	}

}
