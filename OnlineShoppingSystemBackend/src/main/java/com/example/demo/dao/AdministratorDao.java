package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Administrator;

@RepositoryRestResource(path="admin")
@CrossOrigin("http://localhost:4200")

public interface AdministratorDao extends JpaRepository<Administrator, Integer>{

	
}



