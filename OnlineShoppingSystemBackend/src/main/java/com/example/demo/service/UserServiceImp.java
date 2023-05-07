package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserDao dao;
	
	@Override
	public List<User> findAllUser() {
		List<User> list = dao.findAll();
		return list;
	}

	@Override
	public User findUserById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException("User id does not exist"));
	}

	@Override
	public User addUsers(User u) {
		User existingUser = dao.findById(u.getUser_Id()).orElse(null);
		if(existingUser == null) {
			u.setUser_Id(u.getUser_Id());
			u.setUser_first_name(u.getUser_first_name());
			u.setUser_last_name(u.getUser_last_name());
			u.setUser_address(u.getUser_address());
			u.setUser_emailId(u.getUser_emailId());
			u.setUser_gender(u.getUser_gender());
			u.setUser_age(u.getUser_age());
			u.setUser_dateOfBirth(u.getUser_dateOfBirth());
			u.setUser_mobile_no(u.getUser_mobile_no());
			u.setNoOfProducts(u.getNoOfProducts());
			u.setPay_Id(u.getPay_Id());
			u.setProduct_Id(u.getProduct_Id());
			return dao.save(u);
		}
		else {
			throw new ResourceNotFoundException("User id already exists");
		}
	}

	@Override
	public User updateUser(User u) {
		User existingUser = dao.findById(u.getUser_Id()).orElse(null);
		if(existingUser != null) {
			u.setUser_first_name(u.getUser_first_name());
			u.setUser_last_name(u.getUser_last_name());
			u.setUser_address(u.getUser_address());
			u.setUser_emailId(u.getUser_emailId());
			u.setUser_age(u.getUser_age());
			u.setUser_dateOfBirth(u.getUser_dateOfBirth());
			u.setUser_gender(u.getUser_gender());
			u.setUser_mobile_no(u.getUser_mobile_no());
			u.setNoOfProducts(u.getNoOfProducts());
			u.setPay_Id(u.getPay_Id());
			u.setProduct_Id(u.getProduct_Id());
			return dao.save(u);
		}
		else {
			throw new ResourceNotFoundException("User id does not exist");
		}
	}

	@Override
	public void deleteUser(int id) {
		User existingUser = dao.findById(id).orElse(null);
		if(existingUser != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("User id does not exist");
		}
	}

	
}
