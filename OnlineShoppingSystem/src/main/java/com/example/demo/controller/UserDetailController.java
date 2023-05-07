package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dao.UserDetailDao;
import com.example.demo.entity.User;
import com.example.demo.entity.UserDetail;
import com.example.demo.service.UserDetailService;

@Controller
@RequestMapping(path = "/userdetail")
@CrossOrigin("http://localhost:4200")
public class UserDetailController {

	@Autowired
	private UserDetailDao dao;
	@Autowired
	private UserDetailService service;

	@GetMapping("/list")
	public List<UserDetail>getAllUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping("/list/{id}")
	public ResponseEntity<UserDetail> findUserById(@PathVariable("id") int id){
		return new ResponseEntity<UserDetail> (service.getUserById(id), HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody UserDetail userData) {
		UserDetail user = dao.findByUsername(userData.getUsername());

		if (user.getUserpassword().equals(userData.getUserpassword())) {
			UserDetail senduser=new UserDetail();
			senduser.setUser_id(userData.getUser_id());
			senduser.setFirst_name(userData.getFirst_name());
			senduser.setLast_name(userData.getLast_name());
			senduser.setResidentialAddress(userData.getResidentialAddress());
			senduser.setPermanentAddress(userData.getPermanentAddress());
			senduser.setUsername(userData.getUsername());
			return ResponseEntity.ok(senduser);
		} else {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();
		}
	}

//	@GetMapping("/getid")
//	public int getidbyuname(@RequestParam("uname") String uname) {
//		User user=reposit.findByUsername(uname);
//		return user.getEluser_id();
//		
//	}
	@PostMapping("/saveuser")
	public ResponseEntity<?> saveUser(@RequestBody UserDetail user) {
		UserDetail u=dao.findByUsername(user.getUsername());
		if(u!=null) {
			return (ResponseEntity<?>) ResponseEntity.internalServerError();	
		}
		else {
			dao.save(user);
			return ResponseEntity.ok(user);
		}
	}

	@GetMapping("customer/{id}")
	public ResponseEntity<UserDetail> getUserById(@PathVariable("id") int userId) {
		return new ResponseEntity<UserDetail>(service.getUserById(userId), HttpStatus.OK);
	}
}
