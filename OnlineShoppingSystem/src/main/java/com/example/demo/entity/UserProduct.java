package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "userproduct")
public class UserProduct {


	@Column(name = "userpdt_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userpdt_Id;
	
	@Column(name = "userpdt_name")
	private String userpdt_name;
	
	@Column(name = "userpdt_image")
	private String userpdt_image;
	
	@Column(name = "user_Id")
	private int user_Id;
	
	@Column(name = "pdt_Id")
	private int pdt_Id;
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Id", insertable = false, updatable = false)
	private User user;
	
	@ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "pdt_Id", insertable = false, updatable = false)
	private Product product;

	UserProduct(){
		
	}

	public UserProduct(String userpdt_name, String userpdt_image, int user_Id, int pdt_Id) {
		super();
	
		this.userpdt_name = userpdt_name;
		this.userpdt_image = userpdt_image;
		this.user_Id = user_Id;
		this.pdt_Id = pdt_Id;
	}

	public int getUserpdt_Id() {
		return userpdt_Id;
	}

	public void setUserpdt_Id(int userpdt_Id) {
		this.userpdt_Id = userpdt_Id;
	}

	public String getUserpdt_name() {
		return userpdt_name;
	}

	public void setUserpdt_name(String userpdt_name) {
		this.userpdt_name = userpdt_name;
	}

	public String getUserpdt_image() {
		return userpdt_image;
	}

	public void setUserpdt_image(String userpdt_image) {
		this.userpdt_image = userpdt_image;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getPdt_Id() {
		return pdt_Id;
	}

	public void setPdt_Id(int pdt_Id) {
		this.pdt_Id = pdt_Id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
