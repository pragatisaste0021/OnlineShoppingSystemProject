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

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;

@RestController
@RequestMapping("/order")
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping("/list")
	public List<Order> findAllOrders(){
		return service.findAllOrders();
	}

	@GetMapping("find/{id}")
	public ResponseEntity <Order> getOrderById(@PathVariable ("id") int id) {
		return new ResponseEntity <Order> (service.findOrderById(id), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity <Order> addOrder(@Valid @RequestBody Order o){
		return new ResponseEntity <Order> (service.addOrder(o), HttpStatus.CREATED);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity <Order> updateOrder(@Valid @RequestBody Order o){
		return new ResponseEntity <Order> (service.updateOrder(o), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> deleteOrder(@PathVariable ("id") int id){
		service.deleteOrder(id);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}
}
