package com.knongdai.restaurant.services;

import java.util.ArrayList;

import com.knongdai.restaurant.entities.FavouriteFoods;

public interface FavouriteFoodService {
	
	public boolean insertFavouriteFood(FavouriteFoods favouriteFoods);
	
	public ArrayList<FavouriteFoods> getFavouriteFood();
	
	public ArrayList<FavouriteFoods> findFavouriteFoodsById(int fav_id);
	
	public boolean updateFavouriteFood(FavouriteFoods favouriteFoods);
	
	public boolean deleteFavouriteFood(int fav_id);
}
