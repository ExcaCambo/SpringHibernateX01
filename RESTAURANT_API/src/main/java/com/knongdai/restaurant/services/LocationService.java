package com.knongdai.restaurant.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Locations;



@Service
public interface LocationService {
	
	//public ArrayList<Locations> getAlllocation();
	
	List<Locations> getAllCities();
	
	List<Locations> getAllDistrictsByCityId(int cityId);
	
	List<Locations> getAllCommunesByDistrictById(int districtId);
	
	List<Locations> getAllVillagesByCommuneId(int communeId);
}
