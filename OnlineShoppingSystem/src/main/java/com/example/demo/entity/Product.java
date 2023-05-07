package com.example.demo.entity;


import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "product")

public class Product {

	@Column(name = "pdt_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pdt_Id;
	
	@Column(name = "pdt_name")
	@NotBlank(message = "Product name can not be empty")
	@Size(max=20,message = "Product name can't be more than 20 characters")
	@Size(min=4,message = "Product name must be more than 4 characters")
    private String pdt_name;
	
	@Column(name = "pdt_type")
	@NotBlank(message = "Product type can not be empty")
	@Size(max=20,message = "Product type can't be more than 20 characters")
	@Size(min=3,message = "Product type must be more than 3 characters")
    private String pdt_type;
	
	@Column(name = "pdt_cost")
	@NotNull(message = "Product cost can not be empty")
	@Max(value=100000, message ="Product cost should not be greater than 100000" )
	@Min(value=500, message="Product cost must be greater than 500")
    private float pdt_cost;
	
	@Column(name = "pdt_quantity")
	@NotNull(message = "Product quantity can not be empty")
	@Max(value=100, message ="Product quantity should not be greater than 100" )
	@Min(value=1, message="Product quantity must be greater than 1")
    private int pdt_quantity;
	
	@Column(name = "pdt_description")
	@NotBlank(message = "Product description can not be empty")
	@Size(max = 20,message = "Product description can't be more than 20 characters")
	@Size(min=5, message="Product description must be more than 5 characters")
    private String pdt_description;
	
	@Column(name = "pdt_color")
	@Size(max = 8,message = "Product color can't be more than 8 characters")
	@Size(min=2, message="Product color must be more than 2 characters")
    private String pdt_color;
	
	@NotBlank(message = "Product image can not be empty")
	@Column(name = "pdt_image")
	private String pdt_image;
	
	@Column(name = "pdt_brand")
	@Size(max = 15,message = "Product brand can't be more than 15 characters")
	@Size(min=2, message="Product brand must be more than 2 characters")
    private String pdt_brand;
    
	@OneToMany(mappedBy = "product")
	private Set<User> user;
	
	@OneToMany(mappedBy = "product")
	private Set<UserProduct> userproduct;
	

public Product() {
    	
    }

	public Product(int pdt_Id, String pdt_name, String pdt_type, float pdt_cost, int pdt_quantity,
			String pdt_description, String pdt_color, String pdt_image, String pdt_brand) {
		super();
		this.pdt_Id = pdt_Id;
		this.pdt_name = pdt_name;
		this.pdt_type = pdt_type;
		this.pdt_cost = pdt_cost;
		this.pdt_quantity = pdt_quantity;
		this.pdt_description = pdt_description;
		this.pdt_color = pdt_color;
		this.pdt_image = pdt_image;
		this.pdt_brand = pdt_brand;
	}

	public int getPdt_Id() {
		return pdt_Id;
	}

	public void setPdt_Id(int pdt_Id) {
		this.pdt_Id = pdt_Id;
	}

	public String getPdt_name() {
		return pdt_name;
	}

	public void setPdt_name(String pdt_name) {
		this.pdt_name = pdt_name;
	}

	public String getPdt_type() {
		return pdt_type;
	}

	public void setPdt_type(String pdt_type) {
		this.pdt_type = pdt_type;
	}

	public float getPdt_cost() {
		return pdt_cost;
	}

	public void setPdt_cost(float pdt_cost) {
		this.pdt_cost = pdt_cost;
	}

	public int getPdt_quantity() {
		return pdt_quantity;
	}

	public void setPdt_quantity(int pdt_quantity) {
		this.pdt_quantity = pdt_quantity;
	}

	public String getPdt_description() {
		return pdt_description;
	}

	public void setPdt_description(String pdt_description) {
		this.pdt_description = pdt_description;
	}

	public String getPdt_color() {
		return pdt_color;
	}

	public void setPdt_color(String pdt_color) {
		this.pdt_color = pdt_color;
	}

	public String getPdt_brand() {
		return pdt_brand;
	}

	public void setPdt_brand(String pdt_brand) {
		this.pdt_brand = pdt_brand;
	}
    
	public String getPdt_image() {
		return pdt_image;
	}

	public void setPdt_image(String pdt_image) {
		this.pdt_image = pdt_image;
	}
	
}
