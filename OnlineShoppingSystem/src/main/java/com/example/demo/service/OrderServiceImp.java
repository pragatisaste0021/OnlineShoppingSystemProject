package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.OrderDao;
import com.example.demo.entity.Order;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class OrderServiceImp implements OrderService{

	@Autowired
	OrderDao dao;
	@Override
	public List<Order> findAllOrders() {
		List<Order> list = dao.findAll();
		return list;
	}
	
	@Override
	public Order findOrderById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Order does not exist with id : " + id));
	}
	
	@Override
	public Order addOrder(Order o) {
		Order existingProduct = dao.findById(o.getOrder_Id()).orElse(null);
		if(existingProduct == null) {
			o.setOrder_Id(o.getOrder_Id());
			o.setUser_Id(o.getUser_Id());
			o.setOrder_Id(o.getOrder_Id());
			o.setTrack_Id(o.getTrack_Id());
			o.setOrder_date(o.getOrder_date());
			o.setDeliver_date(o.getDeliver_date());
			o.setOrder_status(o.getOrder_status());
			return dao.save(o);
		}
		else {
			throw new ResourceNotFoundException("Order id already exists");
		}
	}
	
	@Override
	public Order updateOrder(Order o) {
		Order existingOrder = dao.findById(o.getOrder_Id()).orElse(null);
		if(existingOrder != null) {
			o.setOrder_Id(o.getOrder_Id());
			o.setUser_Id(o.getUser_Id());
			o.setOrder_Id(o.getOrder_Id());
			o.setTrack_Id(o.getTrack_Id());
			o.setOrder_date(o.getOrder_date());
			o.setDeliver_date(o.getDeliver_date());
			o.setOrder_status(o.getOrder_status());
			return dao.save(o);
		}
		else {
			throw new ResourceNotFoundException("Order id does not exist");
		}
	}
	
	@Override
	public void deleteOrder(int id) {
		Order existingOrder = dao.findById(id).orElse(null);
		if(existingOrder != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Order id does not exist");
		}
	}

}
