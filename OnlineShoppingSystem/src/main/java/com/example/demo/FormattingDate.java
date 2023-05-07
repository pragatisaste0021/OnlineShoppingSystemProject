package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormattingDate {
	
	public static Date StringToDate(String dob) throws ParseException {
	      //Instantiating the SimpleDateFormat class
	      SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	      //Parsing the given String to Date object
	      Date date = formatter.parse(dob);
	      System.out.println("Date object value: "+date);
	      return date;
	   }
}
