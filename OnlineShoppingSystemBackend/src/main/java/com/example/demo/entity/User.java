package com.example.demo.entity;

import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {

	@Column(name = "user_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_Id;
	
	@Column(name = "user_first_name")
	@NotBlank(message = "User first name can not be empty")
	@Size(max=20,message = "User first name can't be more than 20 characters")
	@Size(min=4,message = "User first name must be more than 4 characters")
    private String user_first_name;
	
	@Column(name = "user_last_name")
	@NotBlank(message = "User last name can not be empty")
	@Size(max=20,message = "User last name can't be more than 20 characters")
	@Size(min=4,message = "User last name must be more than 4 characters")
    private String user_last_name;
	
	@Column(name = "user_age")
	@NotNull(message = "User age can not be null")
	@Max(value=60, message = "User age should not be greater than 60")
	@Min(value=20, message = "User age must be greater than 20")
    private int user_age; 
	
	@Column(name = "user_address")
	@NotBlank(message = "User address can not be empty")
	@Size(max=20,message = "User address can't be more than 20 characters")
	@Size(min=5,message = "User address must be more than 5 characters")
    private String user_address;
	
	@Column(name = "user_dateOfBirth")
    private Date user_dateOfBirth;
	
	@Column(name = "user_emailId")
	@NotBlank(message = "User email Id can not be empty")
	@Size(min=10,message = "User Id must be more than 10 characters")
    private String user_emailId;

	@Column(name = "user_mobile_no")
	@NotNull(message = "User mob no can not be empty")
	
	private long user_mobile_no;
	
	@Column(name = "user_gender")
    private String user_gender;
	
	@Column(name = "noOfProducts")
	private int noOfProducts;
	
	@Column(name = "pay_Id")
	@NotNull(message = "Payment Id can not be null")
	private int pay_Id;
	
	@Column(name = "product_Id")
	@NotNull(message = "Product Id can not be null")
	private int product_Id;

	@ManyToOne(targetEntity = Product.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_Id", insertable = false, updatable = false)
	private Product product;
	
	@OneToMany(mappedBy = "user")
	private Set<Order> orderDetail;
	
	
	@OneToMany(mappedBy = "user")
	private Set<UserProduct> userproduct;
	
	@OneToOne()
	@JoinColumn(name = "pay_Id", insertable = false, updatable = false)
	private Payment payment;
	
    public User() {
    	
    }
    
    public User(int user_Id, String user_first_name, String user_last_name, int user_age, String user_address,
			Date user_dateOfBirth, String user_emailId, long user_mobile_no, String user_gender, int noOfProducts, int pay_Id, int product_Id) {
		super();
		this.user_Id = user_Id;
		this.user_first_name = user_first_name;
		this.user_last_name = user_last_name;
		this.user_age = user_age;
		this.user_address = user_address;
		this.user_dateOfBirth = user_dateOfBirth;
		this.user_emailId = user_emailId;
		this.user_mobile_no = user_mobile_no;
		this.user_gender = user_gender;
		this.noOfProducts = noOfProducts;
		this.pay_Id = pay_Id;
		this.product_Id = product_Id;
	}
    
	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public Date getUser_dateOfBirth() {
		return user_dateOfBirth;
	}

	public void setUser_dateOfBirth(Date user_dateOfBirth) {
		this.user_dateOfBirth = user_dateOfBirth;
	}

	public String getUser_emailId() {
		return user_emailId;
	}

	public void setUser_emailId(String user_emailId) {
		this.user_emailId = user_emailId;
	}

	public String getUser_first_name() {
		return user_first_name;
	}

	public void setUser_first_name(String user_first_name) {
		this.user_first_name = user_first_name;
	}

	public String getUser_last_name() {
		return user_last_name;
	}

	public void setUser_last_name(String user_last_name) {
		this.user_last_name = user_last_name;
	}

	public int getUser_age() {
		return user_age;
	}

	public void setUser_age(int user_age) {
		this.user_age = user_age;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}

	public long getUser_mobile_no() {
		return user_mobile_no;
	}

	public void setUser_mobile_no(long user_mobile_no) {
		this.user_mobile_no = user_mobile_no;
	}

	public String getUser_gender() {
		return user_gender;
	}

	public void setUser_gender(String user_gender) {
		this.user_gender = user_gender;
	}

	public int getNoOfProducts() {
		return noOfProducts;
	}

	public void setNoOfProducts(int noOfProducts) {
		this.noOfProducts = noOfProducts;
	}

	public int getPay_Id() {
		return pay_Id;
	}

	public void setPay_Id(int pay_Id) {
		this.pay_Id = pay_Id;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public int getProduct_Id() {
		return product_Id;
	}

	public void setProduct_Id(int product_Id) {
		this.product_Id = product_Id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
    
}
