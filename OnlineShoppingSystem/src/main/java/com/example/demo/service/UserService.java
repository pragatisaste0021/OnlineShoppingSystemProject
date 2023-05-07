package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;

public interface UserService {

	public List<User> findAllUser();
	public User findUserById(int id);
	public User addUsers(User u);
	public User updateUser(User u);
	public void deleteUser(int id);
}
