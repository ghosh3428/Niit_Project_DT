package com.niit.Backend_Niit.DAO;

import java.util.List;

import com.niit.Backend_Niit.model.Category;

public interface CategoryDAO 
{
	public boolean insert(Category category);
	
	public List<Category> activeCategoryList();
	
	public Category get(int id);

}
