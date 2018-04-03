package com.shoping.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoping.shopingbackend.dao.ProductDAO;
import com.shoping.shopingbackend.dto.*;

public class ProductTestCase {
	private static AnnotationConfigApplicationContext context;
	private static ProductDAO productDAO;
	private Product product;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoping.shopingbackend");
		context.refresh();
		productDAO = (ProductDAO) context.getBean("productDAO");
	}

	@Test
	public void testCrudProduct() {
		product = new Product();

		product.setName("Lenovo G570");
		product.setBrand("LENOVO");
		product.setDescription("Lenovo laptop LENOVO G570");
		product.setUnitPrice(39000);
		product.setActive(true);
		product.setCategory_id(3);
		product.setSupplier_id(3);

		assertEquals("Successfully add a single category", true, productDAO.add(product));

	}
}
