package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Moderator")
public class Moderator {

	@Column(name = "modId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int modID;
	
	@NotBlank(message = "Moderator name can not be empty")
	@Size(max=20,message = "Moderator name can't be more than 20 characters")
	@Size(min=5,message = "Moderator name must be more than 5 characters")
	@Column(name = "modName")
    private String modName;
	
	@NotBlank(message = "Moderator address can not be empty")
	@Size(max=20,message = "Moderator address can't be more than 20 characters")
	@Size(min=5,message = "Moderator address must be more than 5 characters")
	@Column(name = "modAddress")
    private String modAddress;
	
	@NotNull(message = "Moderator age can not be null")
	@Max(value=60, message = "Moderator age should not be greater than 60")
	@Min(value=20, message = "Salary must be greater than 20")
	@Column(name = "age")
    private int age;
	
	@NotBlank(message = "Moderator education can not be empty")
	@Size(max=20,message = "Moderator education can't be more than 20 characters")
	@Size(min=3,message = "Moderator address must be more than 3 characters")
	@Column(name = "education")
    private String education;
	
	@Column(name = "dataOfBirth")
    private Date dateOfBirth;
	
	@NotBlank(message = "Moderator email can not be empty")
	@Size(min=10,message = "Moderator email must be more than 10 characters")
	@Column(name = "emailId")
    private String emailId;
	
	@NotNull(message = "Moderator mob no can not be empty")
	@Column(name = "mob_no")
    private long mob_no;
	
    public Moderator() {
    	
    }

	public Moderator(int modID, String modName, String modAddress, int age, String education, Date dateOfBirth,
			String emailId, long mob_no) {
		super();
		this.modID = modID;
		this.modName = modName;
		this.modAddress = modAddress;
		this.age = age;
		this.education = education;
		this.dateOfBirth = dateOfBirth;
		this.emailId = emailId;
		this.mob_no = mob_no;
	}

	public int getModID() {
		return modID;
	}

	public void setModID(int modID) {
		this.modID = modID;
	}

	public String getModName() {
		return modName;
	}

	public void setModName(String modName) {
		this.modName = modName;
	}

	public String getModAddress() {
		return modAddress;
	}

	public void setModAddress(String modAddress) {
		this.modAddress = modAddress;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMob_no() {
		return mob_no;
	}

	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}
    
    
}
