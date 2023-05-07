package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Moderator;
import com.example.demo.entity.Product;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class ProductServiceImp implements ProductService{

	@Autowired
	ProductDao dao;
	@Override
	public List<Product> findAllProducts() {
		List<Product> list = dao.findAll();
		return list;
	}
	
	@Override
	public Product findProductById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Product does not exist with id : " + id));
	}
	
	@Override
	public Product addProduct(Product p) {
		Product existingProduct = dao.findById(p.getPdt_Id()).orElse(null);
		if(existingProduct == null) {
			p.setPdt_Id(p.getPdt_Id());
			p.setPdt_name(p.getPdt_name());
			p.setPdt_type(p.getPdt_color());
			p.setPdt_cost(p.getPdt_cost());
			p.setPdt_color(p.getPdt_color());
			p.setPdt_description(p.getPdt_description());
			p.setPdt_quantity(p.getPdt_quantity());
			p.setPdt_image(p.getPdt_image());
			p.setPdt_brand(p.getPdt_brand());
			return dao.save(p);
		}
		else {
			throw new ResourceNotFoundException("Product id already exists");
		}
	}
	
	@Override
	public Product updateProduct(Product p, int id) {
		Product existingProduct = dao.findById(p.getPdt_Id()).orElse(null);
		if(existingProduct != null) {
			p.setPdt_name(p.getPdt_name());
			p.setPdt_type(p.getPdt_type());
			p.setPdt_cost(p.getPdt_cost());
			p.setPdt_color(p.getPdt_color());
			p.setPdt_description(p.getPdt_description());
			p.setPdt_quantity(p.getPdt_quantity());
			p.setPdt_image(p.getPdt_image());
			p.setPdt_brand(p.getPdt_brand());
			return dao.save(p);
		}
		else {
			throw new ResourceNotFoundException("Product id does not exist");
		}
	}
	
	@Override
	public void deleteProduct(int id) {
		Product existingProduct = dao.findById(id).orElse(null);
		if(existingProduct != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Product id does not exist");
		}
	}

}
