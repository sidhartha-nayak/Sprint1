package com.capgemini.go.controller;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Map;

import com.capgemini.go.dao.ProductDao;
import com.capgemini.go.dao.ProductDaoImpl;
import com.capgemini.go.dto.ProductDTO;
import com.capgemini.go.exception.ProductException;
import com.capgemini.go.service.ProductService;
import com.capgemini.go.service.ProductServiceImpl;
import com.capgemini.go.util.ProductValidator;
//import com.capgemini.go.util.ProductValidator;

public class ProductController {
	// ProductValidator valid = new ProductValidator();

	ProductService pService;

	public ProductController() throws ProductException {

		ProductDao pDao = new ProductDaoImpl();
		pService = new ProductServiceImpl(pDao);
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		while (true) {
			System.out.println("*********PRODUCT MANAGEMENT SYSTEM*********");
			choice = getChoice(scan);
			switch (choice) {

			case 1:
				System.out.println("show all products");
				Map<String, ProductDTO> mp = pService.getMap();
				if (mp == null)
					System.out.println("No products available");
				else
					System.out.println(mp);

				break;

			case 2:
				System.out.println(" Add products");

				ProductDTO prod = null;

				try {
					System.out.println("Enter the ProductId  ");
					String productId = scan.next();
					ProductDTO product = pService.getProd(productId);
					boolean valid = ProductValidator.ValidateProductId(productId);
					if (valid) {
						
						System.out.println(
								"Enter <productID> <price> <color> <dimension> <specification> <manufacturer> <quantity> <productCategory> <productName>");
						prod = new ProductDTO(scan.next(),scan.nextDouble(), scan.next(), scan.next(), scan.next(), scan.next(),
								scan.nextInt(), scan.nextInt(), scan.next());

						boolean success = pService.addProd(prod);
						if (success)
							System.out.println("Added product");

						else
							System.out.println("Failed to add");

					} else {
						System.out.println("It should AlphaNumeric");
					}
				} catch (InputMismatchException e) {
					System.out.println("it should be a integer value");
					scan.nextLine();
				} catch (ProductException e) {
					System.err.println("Product already exists");

				}

				break;

			case 3:
				System.out.println("EDIT");
				System.out.println("Enter the product id you want to update: ");
				String productID1 = scan.next();
				try {
					ProductDTO product = pService.getProd(productID1);
					System.out.println("prod: " + product);

					if (product != null) {

						System.out.println(
								"Enter <price> <color> <dimension> <specification> <manufacturer> <quantity> <productCategory> <productName>");
						prod = new ProductDTO( scan.nextDouble(), scan.next(), scan.next(), scan.next(),
								scan.next(), scan.nextInt(), scan.nextInt(), scan.next());
						System.out.println(prod);
						boolean success2 = pService.editProd(prod);
						if (success2)
							System.out.println("updated");
					} else
						System.out.println("cannot be updated");

				} catch (InputMismatchException e) {
					System.out.println("it should be alphanumeric");
					scan.nextLine();
				} catch (ProductException e) {
					System.err.println(e.getMessage());

				}

				break;

			case 4:
				System.out.println("DELETE");
				System.out.println("Enter Product id you want to delete: ");
				String productID = scan.next();
				try {
					boolean success1 = pService.deleteProd(productID);
					if (success1)

						System.out.println("Product list deleted");
					else
						System.out.println("not deleted");
				} catch (InputMismatchException e) {
					System.out.println("it should be alphanumeric");
					scan.nextLine();
				} catch (ProductException e) {
					System.err.println(e.getMessage());
				}

				break;

			case 5:
				System.out.println("Exited");
				System.exit(0);
				break;

			default:
				System.out.println("please enter 1 to 5 only");
				break;
			}
		}
	}

	private int getChoice(Scanner scan) throws ProductException {
		int choice = 0;
		System.out.println("1.SHOW ALL PRODUCTS");
		System.out.println("2.ADD PRODUCT");
		System.out.println("3.EDIT PRODUCT");
		System.out.println("4.DELETE PRODUCT");
		System.out.println("5.EXITING SYSTEM");
		System.out.println("Enter your Choice:");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Please enter a number");
			scan.nextLine();
		}
		return choice;
	}

	public static void main(String[] args) throws ProductException {
		new ProductController();// calling the constructor
	}
}
