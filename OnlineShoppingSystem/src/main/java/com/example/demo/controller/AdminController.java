package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Administrator;
import com.example.demo.service.AdminService;

@RestController
@RequestMapping("admin1")
@CrossOrigin(origins = "http://localhost:4200")
public class AdminController {

	@Autowired
	AdminService service;
	
	
	@GetMapping("/list")
	public List<Admin> findAllAdmin(){
		List<Admin> list = service.findAllAdmin();
		return list;
	}
}
