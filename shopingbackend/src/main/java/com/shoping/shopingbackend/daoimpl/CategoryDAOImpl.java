package com.shoping.shopingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoping.shopingbackend.dao.CategoryDAO;
import com.shoping.shopingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	private static List<Category> categories = new ArrayList<Category>();

	static {
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Tevilivion");
		cat.setDescription("Nikihil");
		cat.setImageUrl("abc.png");
		categories.add(cat);

	}
	static {
		Category cat = new Category();
		cat.setId(2);
		cat.setName("Table");
		cat.setDescription("Samrat");
		cat.setImageUrl("abc.png");
		categories.add(cat);

	}

	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}

	@Transactional
	public boolean add(Category category) {

		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
