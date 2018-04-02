package com.shoping.shopingbackend.test;

import org.junit.BeforeClass;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.shoping.shopingbackend.dao.ProductDAO;
import com.shoping.shopingbackend.dto.Product;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	
	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoping.shopingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("categorydao");
	}
	
	
}
