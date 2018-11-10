package com.spartan.spartanbackend.DALayer;

import java.util.List;

import com.spartan.spartanbackend.model.Category;


public interface CategoryDAO {
	
	boolean CreateCategory(Category category);
	boolean UpdateCategory(Category category);
	boolean DeleteCategory(String Category_Name);
	List<Category> ViewAllCategory();
	Category ViewOneCategory(String CategoryName);


}
