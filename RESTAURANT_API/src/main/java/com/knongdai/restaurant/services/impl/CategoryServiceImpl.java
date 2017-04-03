package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Categories;
import com.knongdai.restaurant.repositories.CategoryRepository;
import com.knongdai.restaurant.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public boolean insertCategory(Categories category) {
	
		return categoryRepository.insertCategory(category);
	}

	@Override
	public ArrayList<Categories> getCategory() {
		
		return categoryRepository.getCategory();
	}
	
	@Override
	public Categories findCategoryById(int category_id) {
		
		return categoryRepository.findCategoryById(category_id);
	}

	@Override
	public boolean updateCategory(Categories category) {
		
		return categoryRepository.updateCategory(category);
	}

	@Override
	public boolean deleteCategory(int category_id) {
		
		return categoryRepository.deleteCategory(category_id);
	}

	@Override
	public ArrayList<Categories> getCategoryByRestId(int rest_id) {
		
		return categoryRepository.getCategoryByRestId(rest_id);
	}
	
	
	
}
