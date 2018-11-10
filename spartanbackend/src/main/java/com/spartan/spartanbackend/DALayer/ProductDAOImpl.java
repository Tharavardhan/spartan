package com.spartan.spartanbackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spartan.spartanbackend.model.Category;
import com.spartan.spartanbackend.model.Product;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	SessionFactory sessionfactory;

	public boolean CreateProduct(Product product) {
		try
		{
			sessionfactory.getCurrentSession().save(product);
			System.out.println(product.getCategory().getCategory_Name());
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
		
	}

	public boolean UpdateProduct(Product product) {
		try
		{
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
		 
	}

	public boolean DeleteProduct(Product product) {
		try
		{
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
		
	}

	public Product SelectProduct(int Product_id) {
		try {
			return (Product) sessionfactory.getCurrentSession()
					.createQuery("from Product where Product_id='" + Product_id + "'").uniqueResult();
		}

		catch (Exception e) {
			return null;
		}

		
	}

	public List<Product> showallProduct() {
		try
		{
			ArrayList<Product> product = (ArrayList<Product>)sessionfactory.getCurrentSession().createQuery("from Product").list();
					return product;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		
	}

	
	public List<Product> SelectCatproduct(String categoryName) {
		try {
			Category c=(Category)sessionfactory.getCurrentSession().createQuery("from Category where Category_Name='"+categoryName+"'").uniqueResult();
			return sessionfactory.getCurrentSession()
					.createQuery("from Product where category_category_id="+c.getCategory_id()).list();
		}

		catch (Exception e) {
			return null;
		}


	}
}
