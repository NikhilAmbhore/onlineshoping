package com.shoping.shopingbackend.dao;

import java.util.List;

import com.shoping.shopingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);

	List<Category> list();

}
