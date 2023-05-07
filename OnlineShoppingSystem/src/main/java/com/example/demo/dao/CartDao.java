package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.entity.Cart;

@RepositoryRestResource(path="cart")
@CrossOrigin("http://localhost:4200")
public interface CartDao extends JpaRepository<Cart, Long> {
	

}
