package com.shoping.shopingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categorydao;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("");
		context.refresh();
		categorydao = (CategoryDAO) context.getBean("categorydao");

	}

	/*
	 * @Test public void testAddCategory() {
	 * 
	 * category = new Category(); category.setName("Television");
	 * category.setDescription("This is some description for television!!");
	 * category.setImageUrl("nikhil.png");
	 * assertEquals("Successfully add a single category",
	 * true,categorydao.add(category)); }
	 */

	/*
	 * @Test public void testGetCategory() { category = categorydao.get(1);
	 * assertEquals("Successfully fetch a category", "Televition",
	 * category.getName()); }
	 */
	@Test
	public void testUpdateCategory() {
		category = categorydao.get(1);
		category.setName("Tv");
		assertEquals("Successfully update a category", true, categorydao.update(category));
	}

}
