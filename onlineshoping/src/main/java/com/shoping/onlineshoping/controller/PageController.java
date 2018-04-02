package com.shoping.onlineshoping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shoping.onlineshoping.exception.ProductNotFoundException;
import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dao.ProductDAO;
import com.shoping.shopingbackend.dto.Category;
import com.shoping.shopingbackend.dto.Product;

@Controller
public class PageController {
	@Autowired
	private CategoryDAO CategoryDAO;

	@Autowired
	private ProductDAO productDAO;

	@RequestMapping(value = { "/", "/home", "/index" })
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "Home");

		mv.addObject("categories", CategoryDAO.list());

		mv.addObject("userClickHome", true);
		return mv;
	}

	@RequestMapping(value = { "/about" })
	public ModelAndView about() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "About Us");
		mv.addObject("userClickAbout", true);
		return mv;
	}

	@RequestMapping(value = { "/contact" })
	public ModelAndView contact() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "Contact Us");
		mv.addObject("userClickContact", true);
		return mv;
	}

	@RequestMapping(value = { "/services" })
	public ModelAndView services() {
		ModelAndView mv = new ModelAndView("page");
		/* mv.addObject("greeting", "Welcome to spring mvc"); */
		mv.addObject("title", "Services");
		mv.addObject("userClickServices", true);
		return mv;
	}

	@RequestMapping(value = "/test/{greeting}")
	public ModelAndView test(@PathVariable("greeting") String greeting) {
		if (greeting == null) {
			greeting = "greeting is null";
		}
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("greeting", greeting);
		return mv;
	}

	/*
	 * Methods to load all the products and based on category
	 */

	/*@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title", "All Products");

		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());

		mv.addObject("userClickAllProducts", true);
		return mv;
	}

	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");

		// categoryDAO to fetch a single category
		Category category = null;

		category = CategoryDAO.get(id);

		mv.addObject("title", category.getName());

		// passing the list of categories
		mv.addObject("categories", CategoryDAO.list());

		// passing the single category object
		mv.addObject("category", category);

		mv.addObject("userClickCategoryProducts", true);
		return mv;
	}*/
	
	
	/*
	 * Viewing a single product
	 * */
	
	/*@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
		
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		
		mv.addObject("userClickShowProduct", true);
		
		
		return mv;
		
	}*/

}
