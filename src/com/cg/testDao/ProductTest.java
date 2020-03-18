package com.cg.testDao;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.capgemini.go.dao.ProductDaoImpl;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;

public class ProductTest
{
	private static ProductDaoImpl pDao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		pDao = new ProductDaoImpl();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Test
	public void testGetProMap()
	{
		assertNotNull(pDao.getProMap());
	}

	@Test
	public void testGetProd() 
	{
		ProductDTO dto = pDao.getProd("123");
		assertNotNull(dto);
	}

	@Test
	public void testAddProd() 
	{
		try 
		{
			assertNotNull(pDao.addProd(new ProductDTO("124",12, "col","dim" ,"spec", "mfr",55, 55, "name")));
		} 
		catch (ProductException e) 
		{
			e.printStackTrace();
		}
	}

	@Test
	public void testEditProd() 
	{
		assertNotNull(pDao.editProd(new ProductDTO("123",12, "col","dim" ,"spec", "mfr",55, 54, "name")));
	}

	
	@Test
	public void testDeleteProd()
	{
		assertNotNull(pDao.deleteProd("123"));
	}

	

}
