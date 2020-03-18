package com.capgemini.go.dao;

import java.util.Map;

import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public interface ProductDao {

	boolean addProd(ProductDTO prod)throws ProductException;
	Map<String, ProductDTO> getProMap();

	//boolean addpro(ProductDTO pro);

	//public ProductDTO getPro(String id);
	
	public boolean editProd(ProductDTO prod)throws ProductException;
	
	public ProductDTO getPro1(String id);

	//boolean deleteProd(ProductDTO pro1);

	public boolean deleteProd(String prod)throws ProductException;

	public ProductDTO getProd(String productID);

}
