package com.example.demo.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orderDetail")
public class Order {

	@Column(name  = "order_Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_Id;

	@Column(name = "track_Id")
	@NotNull(message = "Track Id can not be empty")
    private int track_Id;
	
	@Column(name = "order_date")
	@NotNull(message = "Order date can not be empty")
    private Date order_date;
	
	@Column(name = "deliver_date")
	@NotNull(message = "Deliver date can not be empty")
    private Date deliver_date;
	
	@Column(name = "order_status")
	@NotNull(message = "Order status can not be empty")
    private String order_status ;
	
	@Column(name = "order_comment")
	@Size(max=20,message = "Order comment can't be more than 20 characters")
	@Size(min=4,message = "Order comment must be more than 4 characters")
    private String comment;
	
	@Column(name = "user_Id")
	@NotNull(message = "User Id can not be empty")
    private int user_Id;
	
	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_Id", insertable = false, updatable = false)
	private User user;
    public Order() {
    	
    }

	public Order(int order_Id, int track_Id, Date order_date, Date deliver_date, String order_status, String comment,
			int user_Id) {
		super();
		this.order_Id = order_Id;
		this.track_Id = track_Id;
		this.order_date = order_date;
		this.deliver_date = deliver_date;
		this.order_status = order_status;
		this.comment = comment;
		this.user_Id = user_Id;
	}

	

	public int getOrder_Id() {
		return order_Id;
	}

	public void setOrder_Id(int order_Id) {
		this.order_Id = order_Id;
	}

	public int getTrack_Id() {
		return track_Id;
	}

	public void setTrack_Id(int track_Id) {
		this.track_Id = track_Id;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public Date getDeliver_date() {
		return deliver_date;
	}

	public void setDeliver_date(Date deliver_date) {
		this.deliver_date = deliver_date;
	}

	public String getOrder_status() {
		return order_status;
	}

	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

    
}

