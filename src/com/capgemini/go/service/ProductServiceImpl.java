package com.capgemini.go.service;

import java.util.Map;

import com.capgemini.go.dao.ProductDao;
import com.capgemini.go.dao.ProductDaoImpl;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public class ProductServiceImpl implements ProductService 
{
	ProductDao pDao;

	public ProductServiceImpl() 
	{
	}

	public ProductServiceImpl(ProductDao pDao2) {
		this.pDao = pDao2;
	}

	@Override
	public boolean addProd(ProductDTO prod) throws ProductException
	{

		return pDao.addProd(prod);
	}

	// @Override
	// public boolean deleteProd(String pro1) {
	// // TODO Auto-generated method stub
	// return pDao.deleteProd(pro1);
	// }

	@Override
	public boolean editProd(ProductDTO pro) throws ProductException
	{

		return pDao.editProd(pro);
	}

	@Override
	public ProductDTO getProd(String id) 
	{

		return pDao.getProd(id);
	}

//	@Override
//	public ProductDTO getPro(String productID1) {
//
//		return pDao.getProd(productID1);
//	}

//	@Override
//	public ProductDTO getPro1(String id) {
//
//		return pDao.getPro1(id);
//	}

	@Override
	public boolean deleteProd(String productID) throws ProductException 
	{

		return pDao.deleteProd(productID);
	}

	@Override
	public Map<String, ProductDTO> getMap() 
	{

		return pDao.getProMap();
	}

	// public Map<String, ProductDTO> returnRepositeryServices() {
	// // TODO Auto-generated method stub
	// return new ProductDaoImpl().returnRepositery();
	// }

}
