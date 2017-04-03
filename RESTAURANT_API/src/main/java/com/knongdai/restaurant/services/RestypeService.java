package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Restaurants;
import com.knongdai.restaurant.entities.Restypes;
import com.knongdai.restaurant.filters.RestypeFilter;
import com.knongdai.restaurant.utils.Pagination;

@Service
public interface RestypeService {

	public int countRestype(String keyword);
	
	public int countRest(int restype_id);
	
	public ArrayList<Restypes> getAllRestype(Pagination pagination, RestypeFilter filter);
	
	public boolean insertRestype(Restypes restype);
	
	public boolean deleteRestype(int restype_id);
	
	public boolean updateRestype(Restypes restype);
	
	public ArrayList<Restaurants>  findRestypeById(int restype_id, Pagination pagination);
	
	public ArrayList<Restypes> findRestypeByKeyword(String keyword);
	
	public Restypes getOnlyRestype(int restype_id);
}
