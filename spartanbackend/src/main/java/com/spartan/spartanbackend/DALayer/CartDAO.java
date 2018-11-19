package com.spartan.spartanbackend.DALayer;

import java.util.List;

import com.spartan.spartanbackend.model.Cart;


public interface CartDAO {
	 
	 boolean CreateCart(Cart cart);
	 boolean UpdateCart(Cart cart);
	 boolean DeleteCart(int id);
	 List<Cart> ViewCart(int cartid);
	 Cart Showitem(int itemid);
	}
