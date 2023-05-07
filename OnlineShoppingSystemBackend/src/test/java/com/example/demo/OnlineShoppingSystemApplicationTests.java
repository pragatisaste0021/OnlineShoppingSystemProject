package com.example.demo;

import java.util.Scanner;
import java.text.ParseException;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.example.demo.dao.AdministratorDao;
import com.example.demo.dao.ModeratorDao;
import com.example.demo.dao.PaymentDao;
import com.example.demo.dao.ProductDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.entity.Administrator;
import com.example.demo.entity.Moderator;
import com.example.demo.entity.Payment;


@SpringBootTest
@ContextConfiguration(classes = OnlineShoppingSystemApplication.class)
class OnlineShoppingSystemApplicationTests {
	
	@Autowired
	AdministratorDao dao1;
	@Test
	void contextLoads() {
	}

	@Test
	public void testCreate1() throws ParseException {
		Administrator a = new Administrator();
		a.setAdmin_name("Shankar");
		a.setAdmin_address("Satara");
		a.setAdmin_emailId("shankar29@gmail.com");
		a.setAdmin_password("shankar@123");
		a.setAdmin_mobile_no(7896057436L);
		a.setModerator_id(1001);
		dao1.save(a);
	}

	@Autowired
	ModeratorDao dao2;
	@Test
	void contextLoads2() {
	}

	@Test
	public void testCreate2() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Moderator m = new Moderator();
		System.out.println("Enter the date");
		String dateOfBirth = sc.next();
		
		Date date = FormattingDate.StringToDate(dateOfBirth);
		m.setModID(1003);
		m.setModName("Sakshi");
		m.setModAddress("Satara");
		m.setEmailId("sakshi01@gmail.com");
		m.setEducation("BTech");
		m.setAge(27);
		m.setDateOfBirth(date);
		m.setMob_no(8967548334L);
		dao2.save(m);
	}
	
	@Autowired
	UserDao dao3;
	
	@Test
	void contextLoads3() {
	}
	
	@Test
	public void testCreate3() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		User u = new User();
		System.out.println("Enter the date");
		
		String dateOfBirth = sc.next();
		Date date = FormattingDate.StringToDate(dateOfBirth);
		u.setUser_Id(4);
		u.setUser_first_name("Abhimanyu");
		u.setUser_last_name("Rathod");
		u.setUser_emailId("abhirathod@gmail.com");
		u.setUser_gender("male");
		u.setUser_age(30);
		u.setUser_dateOfBirth(date);
		u.setUser_mobile_no(7058493758L);
		u.setUser_address("Mumbai");
		u.setPay_Id(10);
		u.setProduct_Id(155);
		dao3.save(u);
	}
	
	@Autowired
	ProductDao dao4;
	@Test
	void contextLoads4() {
	}

	@Test
	public void testCreate4() throws ParseException {
		Product p = new Product();
		p.setPdt_Id(152);
		p.setPdt_name("WashingMachine");
		p.setPdt_type("TopLoad");
		p.setPdt_description("Semi-Automatic");
		p.setPdt_quantity(2);
		p.setPdt_brand("Bosch");
		p.setPdt_color("White");
		p.setPdt_cost(9000);
		dao4.save(p);
	}
	
	@Autowired
	PaymentDao dao5;
	
	@Test
	void contextLoads5() {
		
	}
	
	@Test
	public void testCreate5() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Payment p = new Payment();
		System.out.println("Enter the date");
		String payment_date = sc.next();
		Date date = FormattingDate.StringToDate(payment_date);
		p.setPayment_Id(11);
		p.setPayment_date(date);
		p.setPayment_mode("Online");
		p.setCvv(123);
		p.setPincode(123456);
	}
}
