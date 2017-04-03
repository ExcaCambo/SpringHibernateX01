package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.FavouriteFoods;
import com.knongdai.restaurant.repositories.FavouriteFoodRepository;
import com.knongdai.restaurant.services.FavouriteFoodService;

@Service
public class FavouriteFoodServiceImpl implements FavouriteFoodService{
	
	@Autowired
	private FavouriteFoodRepository favouriteFoodRepository;
	
	@Override
	public boolean insertFavouriteFood(FavouriteFoods favouriteFoods) {
		
		return favouriteFoodRepository.insertFavouriteFood(favouriteFoods);
	}

	@Override
	public ArrayList<FavouriteFoods> getFavouriteFood() {
		
		return favouriteFoodRepository.getFavouriteFoods();
	}

	@Override
	public ArrayList<FavouriteFoods> findFavouriteFoodsById(int fav_id) {
		
		return favouriteFoodRepository.findFavouriteFoodById(fav_id);
	}

	@Override
	public boolean updateFavouriteFood(FavouriteFoods favouriteFoods) {
		
		return favouriteFoodRepository.updateFavouriteFood(favouriteFoods);
	}

	@Override
	public boolean deleteFavouriteFood(int fav_id) {
		
		return favouriteFoodRepository.deleteFavouriteFood(fav_id);
	}
	
	
}
