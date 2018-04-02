package com.shoping.shopingbackend.dao;

import java.util.List;

import com.shoping.shopingbackend.dto.Product;

public interface ProductDAO {

	Product get(int productId);

	List<Product> list();

	boolean add(Product product);

	boolean update(Product product);

	boolean delete(Product product);

	/* business method */

	List<Product> listActivesProducts();

	List<Product> listActivesProductsByCategory(int categoryId);

	List<Product> getLatestActivesProducts(int count);

}
