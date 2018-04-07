package com.shoping.shopingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Category> list() {

		String selectActiveCategory = "FROM Category WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * public List<Category> list() { try {
	 * 
	 * return sessionFactory.getCurrentSession().createQuery("FROM Category",
	 * Category.class).getResultList(); } catch (Exception e) { e.printStackTrace();
	 * } return null; }
	 */

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


	public List<Category> listAcivesCategory() {
		String listActivesCategory = "FROM Product WHERE active = :active";
		return sessionFactory.getCurrentSession().createQuery(listActivesCategory, Category.class)
				.setParameter("active", true).getResultList();
	}

}
