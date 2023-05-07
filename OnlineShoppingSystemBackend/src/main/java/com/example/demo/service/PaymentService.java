package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Payment;

public interface PaymentService {

	public List<Payment> findAll();
	public Payment findById(int id);
	public Payment addPayment(Payment p);
	public Payment updatePayment(Payment p);
	public void deleteById(int id);
}
