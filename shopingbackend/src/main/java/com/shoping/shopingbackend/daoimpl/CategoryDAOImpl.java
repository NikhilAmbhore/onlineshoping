package com.shoping.shopingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dto.Category;
import com.shoping.shopingbackend.dto.Product;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {
		return sessionFactory.getCurrentSession().createQuery("FROM CATEGORY", Category.class).getResultList();

	}

	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();

		}
		return false;
	}

	/* getting single category id base on id */
	public Category get(int id) {
		try {
			return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* update single category */
	public boolean update(Category category) {
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Category category) {
		try {
			category.setActive(false);
			return this.update(category);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
