package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.UserProductDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.UserProduct;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class UserProductServiceImp implements UserProductService{

	@Autowired
	UserProductDao dao;
	
	@Autowired
	ProductDao dao1;
	@Override
	public List<UserProduct> findAllUserProducts() {
		List<UserProduct> list = dao.findAll();
		return list;
	}

	@Override
	public UserProduct findUserProductById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Product does not exist with id : " + id));
	}

	@Override
	public UserProduct addUserProduct(UserProduct p) {
				p.setUserpdt_Id(p.getUserpdt_Id());
				p.setUserpdt_name(p.getUserpdt_name());
				p.setUserpdt_image(p.getUserpdt_image());
				p.setPdt_Id(p.getPdt_Id());
				return dao.save(p);
	}
	

	@Override
	public UserProduct updateUserProduct(UserProduct p, int id) {
		UserProduct existingProduct = dao.findById(id).orElse(null);
		if(existingProduct != null) {
			p.setUserpdt_name(p.getUserpdt_name());
			p.setUserpdt_image(p.getUserpdt_image());
			p.setPdt_Id(id);
			return dao.save(p);
		}
		else {
			throw new ResourceNotFoundException("Product id does not exist");
		}
	}

	@Override
	public void deleteUserProduct(int id) {
		UserProduct existingProduct = dao.findById(id).orElse(null);
		if(existingProduct != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Product id does not exist");
		}
	}
	

}
