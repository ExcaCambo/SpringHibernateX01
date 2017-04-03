package com.knongdai.restaurant.services;

import java.util.ArrayList;

import com.knongdai.restaurant.entities.Categories;

public interface CategoryService {
	
	public boolean insertCategory(Categories category);
	
	public ArrayList<Categories> getCategory();
	
	public Categories findCategoryById(int category_id);
	
	public boolean updateCategory(Categories category);
	
	public boolean deleteCategory(int category_id);
	
	public ArrayList<Categories> getCategoryByRestId(int rest_id);
	
}
