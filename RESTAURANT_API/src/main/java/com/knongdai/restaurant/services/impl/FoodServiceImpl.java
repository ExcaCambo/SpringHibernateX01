package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Foods;
import com.knongdai.restaurant.repositories.FoodRepository;
import com.knongdai.restaurant.services.FoodService;

@Service
public class FoodServiceImpl implements FoodService{
	
	@Autowired
	private FoodRepository foodRepository;
	
	@Override
	public boolean insertFood(Foods food) {
	
		return foodRepository.insertFood(food);
	}

	@Override
	public ArrayList<Foods> getFood() {
		return foodRepository.getFood();
	}

	@Override
	public boolean updateFood(Foods food) {
		return foodRepository.updateFood(food);
	}

	@Override
	public boolean deleteFood(int food_id) {
		return foodRepository.deleteFood(food_id);
	}

	@Override
	public ArrayList<Foods> findFoodById(int food_id) {
		return foodRepository.findFoodById(food_id);
	}

	
}
