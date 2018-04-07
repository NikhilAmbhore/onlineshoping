package com.shoping.onlineshoping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dao.ProductDAO;
import com.shoping.shopingbackend.dto.Category;
import com.shoping.shopingbackend.dto.Product;

@Controller
@RequestMapping("/json/data")
public class JsonDataController {
	@Autowired
	private ProductDAO productDAO;
	@Autowired
	private CategoryDAO categoryDAO;
	
	

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProducts() {
		return productDAO.listActivesProducts();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		return productDAO.listActivesProductsByCategory(id);
	}
	
	@RequestMapping("/all/categorys")
	@ResponseBody
	public List<Category> getAllCategorys(){
		return categoryDAO.listAcivesCategory();
	}

}
