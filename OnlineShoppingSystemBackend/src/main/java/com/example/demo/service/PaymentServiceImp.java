package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.PaymentDao;
import com.example.demo.entity.Payment;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class PaymentServiceImp implements PaymentService{

	@Autowired
	PaymentDao dao;
	
	@Override
	public List<Payment> findAll() {
		List<Payment> list = dao.findAll();
		return list;
		}

	@Override
	public Payment findById(int id) {
		return dao.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Payment id does not exist with id : " + id));
	}

	@Override
	public Payment addPayment(Payment p) {
		Payment existingPaymentDetail = dao.findById(p.getPayment_Id()).orElse(null);
		if(existingPaymentDetail == null) {
			p.setPayment_Id(p.getPayment_Id());
			p.setPayment_date(p.getPayment_date());
			p.setPayment_mode(p.getPayment_mode());
			p.setCvv(p.getCvv());
			p.setPincode(p.getPincode());
			return dao.save(p);
		}
		else {
			throw new ResourceNotFoundException("Payment id already exists");
		}
	}

	@Override
	public Payment updatePayment(Payment p) {
		Payment existingPaymentDetail = dao.findById(p.getPayment_Id()).orElse(null);
		if(existingPaymentDetail != null) {
			p.setPayment_date(p.getPayment_date());
			p.setPayment_mode(p.getPayment_mode());
			p.setCvv(p.getCvv());
			p.setPincode(p.getPincode());
			return dao.save(p);
		}
		else {
			throw new ResourceNotFoundException("Payment id does not exist");
		}
	}

	@Override
	public void deleteById(int id) {
		Payment existingPaymentDetail = dao.findById(id).orElse(null);
		if(existingPaymentDetail != null) {
			dao.deleteById(id);
		}
		else {
			throw new ResourceNotFoundException("Payment id does not exist");
		}
	}

}
