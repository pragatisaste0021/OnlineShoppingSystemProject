package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Cart;

public interface CartService {

	
	Cart addCart(Cart cart,int productId,int eluser_id);
	List<Cart> getAllCarts();
	Cart getCartById(long cartId);
	Cart updateCart(Cart cart, long cartId);
	void deleteCart(long cartId);
	
}
