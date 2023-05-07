package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;

public interface ProductService {

	public List<Product> findAllProducts();
	public Product findProductById(int id);
	public Product addProduct(Product p);
	public Product updateProduct(Product p, int id);
	public void deleteProduct(int id);
}
