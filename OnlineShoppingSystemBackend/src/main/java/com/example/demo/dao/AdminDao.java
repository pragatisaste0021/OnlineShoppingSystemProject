package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Admin;



@RepositoryRestResource(path="admin1")
@CrossOrigin("http://localhost:4200")
public interface AdminDao extends JpaRepository<Admin,Integer>{

}
