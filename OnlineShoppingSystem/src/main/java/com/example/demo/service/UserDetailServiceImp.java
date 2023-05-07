package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dao.UserDetailDao;
import com.example.demo.entity.UserDetail;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserDetailServiceImp implements UserDetailService{

	@Autowired	
	UserDetailDao dao;
		@Override
		public com.example.demo.entity.UserDetail findByUsername(String uname) {
			// TODO Auto-generated method stub
			return dao.findByUsername(uname) ;
		}
		
		@PostMapping("/login")
		public ResponseEntity<?> loginUser(@RequestBody UserDetail userData) {
			UserDetail user = dao.findByUsername(userData.getUsername());

			if (user.getUserpassword().equals(userData.getUserpassword())) {
				UserDetail senduser=new UserDetail();
				senduser.setUser_id(userData.getUser_id());
				senduser.setUsername(userData.getUsername());
				senduser.setFirst_name(userData.getFirst_name());
				senduser.setLast_name(userData.getLast_name());
				senduser.setMobile_no(userData.getMobile_no());
				senduser.setPermanentAddress(userData.getPermanentAddress());
				senduser.setResidentialAddress(userData.getResidentialAddress());
				return ResponseEntity.ok(senduser);
			} else {
				return (ResponseEntity<?>) ResponseEntity.internalServerError();
			}
		}

		@Override
		public ResponseEntity<?> saveUser(com.example.demo.entity.UserDetail user) {
			UserDetail u=dao.findByUsername(user.getUsername());
			if(u!=null) {
				return (ResponseEntity<?>) ResponseEntity.internalServerError();	
			}
			else {
				dao.save(user);
				return ResponseEntity.ok(user);
			}	}
		
	@Override
	public UserDetail getUserById(int userId) {
			
			return dao.findById(userId).orElseThrow(()->new ResourceNotFoundException("Customer"));
		}


		@Override
		public UserDetail saveCustomer(UserDetail customer) {
			
			return dao.save(customer);
		}
		
		/*public Customer getCustomerByEmail(Customer customer)
		{
			return this.customerRepository.findByEmailID(customer.emailID).orElseThrow(()->new ResourceNotFoundException("Customer ", "Email",customer.emailID ));
		}*/


		@Override
		public UserDetail updateUser(UserDetail user,int userId) {
		
		UserDetail existingUser=dao.findById(userId).orElseThrow(()->new ResourceNotFoundException("Customer"));	
		existingUser.setFirst_name(user.getFirst_name());
		existingUser.setLast_name(user.getLast_name());
		existingUser.setUsername(user.getUsername());
		existingUser.setUserpassword(user.getUserpassword());
		existingUser.setResidentialAddress(user.getResidentialAddress());
		existingUser.setPermanentAddress(user.getPermanentAddress());

		
		dao.save(existingUser);
		return existingUser;
		}



		@Override
		public List<UserDetail> getAllUsers() {
		
			return dao.findAll();
		}



		@Override
		public void deleteUser(int userId) {
			dao.findById(userId).orElseThrow(()->new ResourceNotFoundException("Customer"));
			dao.deleteById(userId);
			
		}
		
		
}
