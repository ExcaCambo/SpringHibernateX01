package com.knongdai.restaurant.services;

import java.util.ArrayList;

import com.knongdai.restaurant.entities.FoodPictures;



public interface FoodPictureService {
	
	public boolean insertFoodPictures(FoodPictures foodPictures);
	
	public ArrayList<FoodPictures> getFoodPictures();
	
	public boolean updateFoodPictures(FoodPictures FoodPictures);
	
	public boolean deleteFoodPictures(int picture_id);
	
	public ArrayList<FoodPictures> findFoodPicturesById(int picture_id);
}
