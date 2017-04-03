package com.knongdai.restaurant.services;

import java.util.ArrayList;

import com.knongdai.restaurant.entities.Foods;

public interface FoodService {
	
	public boolean insertFood(Foods food);
	public ArrayList<Foods> getFood();
	public boolean updateFood(Foods food);
	public boolean deleteFood(int food_id);
	public ArrayList<Foods> findFoodById(int food_id);
	
}
