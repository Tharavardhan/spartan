package com.spartan.spartanbackend.DALayer;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spartan.spartanbackend.model.Category;

@Repository
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean CreateCategory(Category category) {
		try {
			System.out.println(category.getCategory_Name());
			sessionfactory.getCurrentSession().save(category);
			return true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
	}

	public boolean UpdateCategory(Category category) {
		try {
			System.out.println("HELLO");
			sessionfactory.getCurrentSession().update(category);
			return true;
		} catch (Exception e) {
			System.out.println("bye");
			
			return false;
		}

	}

	public boolean DeleteCategory(String Category_Name) {
		try {
			
			sessionfactory.getCurrentSession().delete(ViewOneCategory(Category_Name));
			//sessionfactory.getCurrentSession().delete(Category_Name, Category.class);
			return true;
		} catch (Exception e) 
		{
			
			return false;
		}

	}

	public List<Category> ViewAllCategory() {
		try {
			return sessionfactory.getCurrentSession().createQuery("from Category").list();
		}

		catch (Exception e) {
			return null;

		}

	}

	public Category ViewOneCategory(String CategoryName) {
		try {
			System.out.println("2");
			return (Category) sessionfactory.getCurrentSession()
					.createQuery("from Category where category_Name='"+ CategoryName+"'").uniqueResult();
		}

		catch (Exception e) {
			return null;

		}

	}
}
