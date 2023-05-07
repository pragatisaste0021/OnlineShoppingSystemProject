package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Product;
import com.example.demo.entity.UserProduct;

public interface UserProductService {

	public List<UserProduct> findAllUserProducts();
	public UserProduct findUserProductById(int id);
	public UserProduct addUserProduct(UserProduct p);
	public UserProduct updateUserProduct(UserProduct p, int id);
	public void deleteUserProduct(int id);
}
