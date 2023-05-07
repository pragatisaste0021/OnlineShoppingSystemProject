package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserProduct;

public interface UserProductDao extends JpaRepository<UserProduct, Integer>{

}
