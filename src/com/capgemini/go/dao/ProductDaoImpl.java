package com.capgemini.go.dao;

import java.util.Map;
import org.apache.log4j.Logger;

import com.capgemini.go.database.ProductMap;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public class ProductDaoImpl implements ProductDao 
{
	private Logger logger = Logger.getLogger(ProductDaoImpl.class);

	// private Map<String, ProductDTO> proMap = new HashMap<>();

	@Override
	public Map<String, ProductDTO> getProMap() 
	{
		return ProductMap.getProMap();

	}

	@Override
	public ProductDTO getProd(String id) 
	{

		return ProductMap.getProduct(id);
	}

	@Override
	public boolean addProd(ProductDTO prod) throws ProductException {
		String key = prod.getProductId();
		Map<String, ProductDTO> map = ProductMap.getProMap();
		if (map!=null && map.containsKey(key)) {
			throw new ProductException("Product already exist");
		}
		logger.info("added products :" + prod);
		System.out.println(prod);
		ProductDTO pro = ProductMap.addProd(prod);
		return true;
	}

	@Override
	// public boolean deleteProd(String pro1) {
	// ProductDTO prod = ProductMap.deleteProd(pro1);
	//
	// logger.info("deleted products :" + pro1);
	// return true;
	// }

	public boolean editProd(ProductDTO prod) {
		// Set<String> prod=proMap.keySet();
		logger.info("edited products :" + prod);
		ProductDTO p = ProductMap.editProd(prod);
		System.out.println("``p== " + p);// null if not present earlier
		return true;
	}

	// proMap.put(pro.getProductId(), pro);
	public ProductDTO getPro1(String id) {
		return ProductMap.getProduct(id);
	}

	@Override
	public boolean deleteProd(String prod) {
		ProductDTO pro = ProductMap.deleteProd(prod);

		logger.info("deleted products :" + pro);

		return true;
	}

	

	
}
