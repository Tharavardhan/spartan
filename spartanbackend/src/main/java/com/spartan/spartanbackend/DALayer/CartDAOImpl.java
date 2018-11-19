	package com.spartan.spartanbackend.DALayer;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spartan.spartanbackend.model.Cart;
import com.spartan.spartanbackend.model.Product;

@Repository
@Transactional
public class CartDAOImpl implements CartDAO {
	
	@Autowired
	SessionFactory sessionfactory;


	public boolean CreateCart(Cart cart) {
		try
		{
			sessionfactory.getCurrentSession().save(cart);
			
			return true;
		}
		catch (Exception e) {
			return false;
		}
		
	}

	public boolean UpdateCart(Cart cart) {
		try
		{
			System.out.println("updateitem impl");
			sessionfactory.getCurrentSession().update(cart);
			return true;
		}
		catch (Exception e) {
			System.out.println("updateitem excn"+e.getMessage());
			return false;
		}
		

	}

	public boolean DeleteCart(int id) {
		try
		{
			
			System.out.println("backend cart delete");
			Cart cart=(Cart)sessionfactory.getCurrentSession().createQuery("from Cart where itemid="+id).uniqueResult();
			sessionfactory.getCurrentSession().delete(cart);
			return true;
		}
		catch (Exception e) {
			System.out.println("catch block"+e.getMessage());
			return false;
		}
		}

	public List<Cart> SelectCart(int cartid) {
		try {
			return sessionfactory.getCurrentSession().createQuery("from Cart where cartid="+cartid).list();
		}

		catch (Exception e) {
			  return new ArrayList<Cart>();
		}

	}

	public Cart Showitem(int itemid) {
		try {
	System.out.println("showitem impl");
			Cart cart=(Cart)sessionfactory.getCurrentSession().createQuery("from Cart where itemid="+itemid).uniqueResult();
			
			return cart;
		}

		catch (Exception e) {
			System.out.println("showitem excn"+e.getMessage());
			  return null;
		}
	}

}
