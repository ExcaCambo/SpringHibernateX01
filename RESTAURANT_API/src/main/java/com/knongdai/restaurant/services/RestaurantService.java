package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Restaurants;
import com.knongdai.restaurant.filters.RestypeFilter;
import com.knongdai.restaurant.form.RestaurantForm2;
import com.knongdai.restaurant.form.RestaurantForm2.RestaurantUpdateForm2;
import com.knongdai.restaurant.utils.Pagination;

@Service
public interface RestaurantService {

	public ArrayList<Restaurants> getAllRestaurant();
	
//	public boolean addNewRestaurant(RestaurantForm restaurantForm);
	
	public boolean addNewRestaurant(RestaurantForm2 restaurantForm);
	
	public boolean deleteRestaurant(int rest_id, int address_id);
	
	//public boolean updateRestaurant(Restaurants restaurant);
	
	public  Restaurants findRestaurantById(int rest_id);//edit this 
	
	public ArrayList<Restaurants> findRestaurantWithCategory(Pagination pagination);
	
	public ArrayList<Restaurants> searchRest(Pagination pagination, RestypeFilter filter);
	
	public int countRestById(int categoryId, String keyword);
	
	public int countRestOwner();
	
	public boolean updateRestaurant(RestaurantUpdateForm2 restaurantUpdateForm2);
	
	public int countRest();
	public ArrayList<Restaurants> topRest();
	
	
}
