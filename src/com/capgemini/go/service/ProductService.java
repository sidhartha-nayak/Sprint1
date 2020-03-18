package com.capgemini.go.service;

import java.util.Map;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public interface ProductService 
{

	boolean addProd(ProductDTO prod)throws ProductException;

	public boolean deleteProd(String productID)throws ProductException;

	boolean editProd(ProductDTO pro)throws ProductException;
	
	//public ProductDTO getPro(String id);

	public ProductDTO getProd(String productID1);

	//public ProductDTO getPro1(String id);

	//boolean deleteProd(String pro1);
	
	Map<String, ProductDTO> getMap();
}
