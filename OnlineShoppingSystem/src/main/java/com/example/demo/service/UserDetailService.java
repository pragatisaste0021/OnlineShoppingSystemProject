package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.UserDetail;

public interface UserDetailService {

	UserDetail findByUsername(String uname);
	public ResponseEntity<?> saveUser(@RequestBody UserDetail user) ;
	UserDetail updateUser(UserDetail user, int userId);
	List<UserDetail> getAllUsers();
	void deleteUser(int userId);
	UserDetail getUserById(int userId);
	UserDetail saveCustomer(UserDetail customer);
}
