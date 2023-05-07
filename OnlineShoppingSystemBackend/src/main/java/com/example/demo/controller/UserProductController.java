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
import com.example.demo.entity.UserProduct;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserProductService;

@RestController
@RequestMapping("/userproduct")
@CrossOrigin(origins = "http://localhost:4200")
public class UserProductController {

	@Autowired
	UserProductService service;
	
	@GetMapping("/list")
	public List<UserProduct> findAllProducts(){
		return service.findAllUserProducts();
	}

	@GetMapping("/find/{id}")
	public ResponseEntity <UserProduct> getProductById(@PathVariable ("id") int id) {
		return new ResponseEntity <UserProduct> (service.findUserProductById(id), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity <UserProduct> addUserProduct(@Valid @RequestBody UserProduct p){
		return new ResponseEntity <UserProduct> (service.addUserProduct(p), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <UserProduct> updateUserProduct(@Valid @RequestBody UserProduct p, @PathVariable int id){
		return new ResponseEntity <UserProduct> (service.updateUserProduct(p,id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> deleteUserProduct(@PathVariable ("id") int id){
		service.deleteUserProduct(id);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}	
}
