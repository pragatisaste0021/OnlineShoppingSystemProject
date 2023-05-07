package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Order;

public interface OrderService {

	public List<Order> findAllOrders();
	public Order findOrderById(int id);
	public Order addOrder(Order o);
	public Order updateOrder(Order o);
	public void deleteOrder(int id);
}
