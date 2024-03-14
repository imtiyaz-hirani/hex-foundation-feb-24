package com.service;

import java.util.Arrays;
import java.util.List;

import com.exception.InvalidInputException;

public class NameService {

	public double processInfo(String fname, String lname, String city) 
	throws InvalidInputException{
		// fname should not be blank or null
		if(fname.equals("null") || fname.equals(""))
			throw new InvalidInputException("fname is invalid");
		
		//lname should not be blank or null
		if(lname.equals("null") || lname.equals(""))
			throw new InvalidInputException("lname is invalid");
		
		//city shd not be blank or null
		if(city.equals("null") || city.equals(""))
			throw new InvalidInputException("city is invalid");
		
		//city shd be from given list ["mumbai","chennai"]
		String[] cities = {"mumbai","chennai"}; 
	    List<String> cityList = Arrays.asList(cities);
	     
	    if(!(cityList.contains(city))) {
	    	throw new InvalidInputException("City not in prescribed list"); 
	    }
		
		return 9;
	}

}
