package com.capgemini.go.util;

import java.util.regex.Pattern;

import com.capgemini.go.exception.ProductException;

import java.util.regex.Matcher;


public class ProductValidator {

//	public boolean checkProductId(String ID) {
//		//String IDCheck[]= new String[1];
//		boolean check = true;
////		if(ID.length()<2)check=false;
//		String checki = "^[A-Z0-9]+$";
//		
//		
////		for (String regex : IDCheck) {
////			Pattern pattern = Pattern.compile(regex);
////			Matcher matcher = pattern.matcher(ID);
////			if(!matcher.matches())check=false;
////			
////		}
//		check = ID.matches(checki); 
//		if(check==false) {
//		
//			System.out.println("|ProductID should be AlphaNumeric|");
//	       
//		}
//		return check;
//	}

	

	public static boolean ValidateProductId(String productId) {
		boolean flag = true;
		String id=String.valueOf(productId);
		flag=id.matches("^[a-zA-Z][0-9]+$");
		return flag;
	}

	}


