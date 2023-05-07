package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CartDao;
import com.example.demo.entity.Cart;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class CartServiceImp implements CartService{

	@org.springframework.beans.factory.annotation.Autowired(required=true)
	public CartDao dao;
	
//	@Autowired
//	public ProductRepository productRepository;

	@Autowired
	public ProductService productService;
	
	@Autowired
	public UserService customerService;
	


@Override
public Cart addCart(Cart cart,int productId,int customerId) {

	Product product =productService.findProductById(productId) ;
	User customer =customerService.findUserById(customerId) ;
	   product.setPdt_quantity(product.getPdt_quantity()-cart.getQuantity());
	 productService.updateProduct( product,product.getPdt_quantity()-1);
	//cart.setProduct(product);
	cart.setMrpPrice(product.getPdt_cost());
	//cart.setCustomer(customer);
	  System.out.println("product"+product);
	  System.out.println("customer"+customer);
	  System.out.println("cart"+cart);
	  
		    	
	return dao.save(cart);
}



@Override
public List<Cart> getAllCarts() {
	return dao.findAll();
}



@Override
public Cart getCartById(long cartId) {
	
	return dao.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart"));
}



@Override
public Cart updateCart(Cart cart, long cartId) {
	Cart existingCart=dao.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart"));
	existingCart.setQuantity(cart.getQuantity());
	//existingCart.setPrice(cart.getPrice());
	existingCart.setMrpPrice(cart.getMrpPrice());
	//existingCart.setImage(cart.getImage());
	existingCart.setCartId(cart.getCartId());
	//existingCart.setCustomerId(cart.getCustomerId());
	return existingCart;
}



@Override
public void deleteCart(long cartId) {
	dao.findById(cartId).orElseThrow(()->new ResourceNotFoundException("Cart"));
	dao.deleteById(cartId);
	
}
}
