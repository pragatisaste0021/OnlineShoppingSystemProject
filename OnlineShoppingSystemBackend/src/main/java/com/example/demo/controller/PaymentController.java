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

import com.example.demo.entity.Payment;
import com.example.demo.service.PaymentService;

@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "http://localhost:4200")

public class PaymentController {
	
	@Autowired
	PaymentService service;
	
	@GetMapping("/list")
	public List<Payment> findAll(){
		return service.findAll();
	}
	
	@GetMapping("/find/{id}")
	public ResponseEntity <Payment> getProductById(@PathVariable ("id") int id) {
		return new ResponseEntity <Payment> (service.findById(id), HttpStatus.OK);
	}
	
	@PostMapping("save")
	public ResponseEntity <Payment> addModerator(@Valid @RequestBody Payment p){
		return new ResponseEntity <Payment> (service.addPayment(p), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity <Payment> updateModerator(@Valid @RequestBody Payment p){
		return new ResponseEntity <Payment> (service.updatePayment(p), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> deletePayment(@PathVariable ("id") int id){
		service.deleteById(id);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}
}
