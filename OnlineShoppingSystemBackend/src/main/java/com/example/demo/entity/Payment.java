package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Payment")
public class Payment {
	
	@Column(name = "Payment_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int payment_Id;
	
	@Column(name = "Payment_mode")
	@NotNull(message = "Payment mode can not be empty")
	@Size(max=20,message = "Payment Mode can't be more than 20 characters")
	@Size(min=4,message = "Payment mode must be more than 4 characters")
    private String payment_mode;
	
	@Column(name = "Payment_date")
	@NotNull(message = "Payment date can not be empty")
    private Date payment_date;

	
	@Column(name = "cvv")
	private int cvv;

	@Column(name = "pincode")
	private int pincode;
    public Payment() {
    	
    }

	public Payment(int payment_Id, String payment_mode, Date payment_date, int cvv, int pincode) {
		super();
		this.payment_Id = payment_Id;
		this.payment_mode = payment_mode;
		this.payment_date = payment_date;
		this.cvv = cvv;
		this.pincode = pincode;
	}

	public int getPayment_Id() {
		return payment_Id;
	}

	public void setPayment_Id(int payment_Id) {
		this.payment_Id = payment_Id;
	}

	public String getPayment_mode() {
		return payment_mode;
	}

	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	public Date getPayment_date() {
		return payment_date;
	}

	public void setPayment_date(Date payment_date) {
		this.payment_date = payment_date;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	
}
