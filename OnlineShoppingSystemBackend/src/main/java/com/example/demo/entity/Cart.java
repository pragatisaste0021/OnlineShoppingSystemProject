package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "cart_table")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cart_id")
	private long cartId;

//	@Column(name="image")
//	private String image;
	
	@Column(name = "quantity")
	private int quantity;

	@Column(name = "mrp_price", nullable = false)
	private double mrpPrice;

//	// @Size(min = 2, max = 10)
//	@Column(name = "price", nullable = false)
//	private double price;
	
	
	
	
	public Cart() {

	}



	public long getCartId() {
		return cartId;
	}



	public void setCartId(long cartId) {
		this.cartId = cartId;
	}



	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getMrpPrice() {
		return mrpPrice;
	}



	public void setMrpPrice(double mrpPrice) {
		this.mrpPrice = mrpPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", quantity=" + quantity + ", mrpPrice=" + mrpPrice + "]";
	}



	
	


	


}
