package com.shoping.shopingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoping.shopingbackend.dao.ProductDAO;
import com.shoping.shopingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Product get(int productId) {
		try {
			return sessionFactory.getCurrentSession().get(Product.class, Integer.valueOf(productId));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Product> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM Product", Product.class).getResultList();

	}

	public boolean add(Product product) {
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(Product product) {
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public boolean delete(Product product) {
		try {
			product.setActive(false);
			return this.update(product);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public List<Product> listActivesProducts() {
		String selectActiveProducts = "FROM Product WHERE active = : active";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProducts, Product.class)
				.setParameter("active", true).getResultList();
	}

	public List<Product> listActivesProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = : active AND categoryId=:categoryId";

		return sessionFactory.getCurrentSession().createQuery(selectActiveProductsByCategory, Product.class)
				.setParameter("active", true).setParameter(categoryId, categoryId).getResultList();

	}

	public List<Product> getLatestActivesProducts(int count) {

		return sessionFactory.getCurrentSession()
				.createQuery("FROM Product where active=:active ORDER BY id", Product.class)
				.setParameter("active", true).setParameter("active", true).setFirstResult(0).setMaxResults(count)
				.getResultList();

	}

}