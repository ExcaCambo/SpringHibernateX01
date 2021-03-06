package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.FavouriteRestaurants;

@Service
public interface FavouriteRestaurantService {
	public boolean insertFavouriteRestaurant(FavouriteRestaurants favouriteRestaurant);
	public ArrayList<FavouriteRestaurants> getFavouriteRestaurant();
	public FavouriteRestaurants findFavouriteRestaurantById(@Param("favrest_id") int favrest_id);
	public boolean updateFavouriteRestaurant(FavouriteRestaurants favouriteRestaurant);
	public boolean deleteFavouriteRestaurant(@Param("favrest_id") int favrest_id);
	public ArrayList<FavouriteRestaurants> getFavouriteRestaurantByUserId(@Param("user_id") int user_id);
	
	public int totalFavourite(int user_id);
	public int countFavByUserIdAndRestId(int userId , int restId);
	public int countFavoriteRest();
}
