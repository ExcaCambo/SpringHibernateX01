package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.FoodPictures;
import com.knongdai.restaurant.repositories.FoodPictureRepository;
import com.knongdai.restaurant.services.FoodPictureService;

@Service
public class FoodPictureServiceImpl implements FoodPictureService{
	
	@Autowired
	private FoodPictureRepository foodPictureRepository;
	
	@Override
	public boolean insertFoodPictures(FoodPictures foodPicture) {
		
		return foodPictureRepository.insertFoodPicture(foodPicture);
	}

	@Override
	public ArrayList<FoodPictures> getFoodPictures() {
		
		return foodPictureRepository.getFoodPictures();
	}

	@Override
	public boolean updateFoodPictures(FoodPictures foodPictures) {
	
		return foodPictureRepository.updateFoodPicture(foodPictures);
	}

	@Override
	public boolean deleteFoodPictures(int picture_id) {
		
		return foodPictureRepository.deleteFoodPictures(picture_id);
	}

	@Override
	public ArrayList<FoodPictures> findFoodPicturesById(int picture_id) {
		
		return foodPictureRepository.findFoodPictureById(picture_id);
	}

}
