package com.shoping.shopingbackend.test;

/*import static org.junit.Assert.assertEquals;*/

import org.junit.BeforeClass;
/*import org.junit.Test;*/
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dto.Category;

public class CategoryTestCase {
	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	@BeforeClass
	public static void init() {

		context = new AnnotationConfigApplicationContext();
		context.scan("com.shoping.shopingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");

	}

/*	@Test
	public void testAddCategory() {

		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television!!");
		category.setImageUrl("nikhil.png");
		assertEquals("Successfully add a single category", true, categoryDAO.add(category));
	}
*/
	/*
	 * @Test public void testGetCategory() { category = categorydao.get(1);
	 * assertEquals("Successfully fetch a category", "Televition",
	 * category.getName()); }
	 */
	/*@Test
	public void testUpdateCategory() {
		category = categoryDAO.get(1);
		category.setName("Tv");
		assertEquals("Successfully update a category", true, categoryDAO.update(category));
	}*/

}
