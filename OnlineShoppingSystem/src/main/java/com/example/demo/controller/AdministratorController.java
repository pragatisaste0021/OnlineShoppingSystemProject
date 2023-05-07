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

import com.example.demo.entity.Administrator;
import com.example.demo.entity.Moderator;
import com.example.demo.service.AdministratorService;
import com.example.demo.service.ModeratorService;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministratorController {

	@Autowired
	AdministratorService service;
	
	@Autowired
	ModeratorService mservice;
	
	@GetMapping("/list")
	public List<Administrator> findAllAdministrator(){
		List<Administrator> list = service.findAllAdministrator();
		return list;
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<Administrator> getAdministratorById(@PathVariable("id") int id){
		return new ResponseEntity<Administrator> (service.findAdministratorById(id), HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Administrator> addAdministrator(@Valid @RequestBody Administrator a){
		return new ResponseEntity<Administrator> (service.addAdministrator(a), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Administrator> updateAdministrator(@Valid @RequestBody Administrator a){
		return new ResponseEntity<Administrator> (service.updateAdministrator(a), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity <Boolean> deleteAdministrator(@PathVariable ("id") int id){
		service.deleteAdministrator(id);
		boolean flag = true;
		return new ResponseEntity <Boolean> (flag, HttpStatus.OK);
	}
}
