package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Administrator;

@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	AdminDao dao;
	@Override
	public List<Admin> findAllAdmin() {
		List<Admin> list = dao.findAll();
		return list;
	}

}
