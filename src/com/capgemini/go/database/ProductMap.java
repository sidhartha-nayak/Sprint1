package com.capgemini.go.database;

import java.util.HashMap;
import java.util.Map;

import com.capgemini.go.dto.ProductDTO;

public class ProductMap {

	private static Map<String, ProductDTO> proMap = new HashMap<>();
	static{
		proMap.put("123", new ProductDTO("123",12, "col","dim" ,"spec", "mfr",55, 55, "name"));
	}

	public static Map<String, ProductDTO> getProMap() {
		if(proMap.isEmpty()){
			return null;
		}
		return proMap;
	}

	public static ProductDTO getProduct(String id) {
		// TODO Auto-generated method stub
		return proMap.get(id);
	}

	public static ProductDTO addProd(ProductDTO prod) {
		// TODO Auto-generated method stub
		return proMap.put(prod.getProductId(), prod);
	}

	//public static ProductDTO deleteProd(String pro1) {
		// TODO Auto-generated method stub
		//return proMap.put(pro1.getProductId(), pro1);
	

	public ProductMap() {
		proMap.put("123", new ProductDTO(12, "col","col" ,"col", "col",55, 55, "col"));
	}

	public static ProductDTO editProd(ProductDTO prod) {
		// TODO Auto-generated method stub
		return proMap.put(prod.getProductId(), prod); 
	}
	public static ProductDTO getPro1(String id){
			return proMap.get(id);
			
		}

	public static ProductDTO deleteProd(String prod) {
		// TODO Auto-generated method stub
		ProductDTO del = proMap.get(prod);
		proMap.remove(prod);
		return del;
	}
}
	

