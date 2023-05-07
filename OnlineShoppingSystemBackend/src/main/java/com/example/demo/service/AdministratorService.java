package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Administrator;
import com.example.demo.entity.Moderator;
import com.example.demo.entity.User;

public interface AdministratorService {

	public List<Administrator> findAllAdministrator();
	public Administrator findAdministratorById(int id);
	public Administrator addAdministrator(Administrator a);
	public Administrator updateAdministrator(Administrator a);
	public void deleteAdministrator(int id);
}
