package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

	@Autowired
	ProductService service;
	
	@GetMapping("/list")
	public List<Product> findAllProducts(){
		return service.findAllProducts();
	}

	@GetMapping("/find/{id}")
	public ResponseEntity <Product> getProductById(@PathVariable ("id") int id) {
		return new ResponseEntity <Product> (service.findProductById(id), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity <Product> addModerator(@Valid @RequestBody Product p){
		return new ResponseEntity <Product> (service.addProduct(p), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <Product> updateModerator(@Valid @RequestBody Product p, @PathVariable int id){
		return new ResponseEntity <Product> (service.updateProduct(p, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> deleteProduct(@PathVariable ("id") int id){
		service.deleteProduct(id);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}
}
