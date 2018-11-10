package com.spartan.spartanbackend.DALayer;

import java.util.List;

import com.spartan.spartanbackend.model.Product;


public interface ProductDAO {
	
	
		
		boolean CreateProduct(Product product);
		boolean UpdateProduct(Product product);
		boolean DeleteProduct(Product product);
		Product SelectProduct(int Product_id);
		public List<Product> showallProduct();
		public List<Product> SelectCatproduct(String categoryName);
	}



