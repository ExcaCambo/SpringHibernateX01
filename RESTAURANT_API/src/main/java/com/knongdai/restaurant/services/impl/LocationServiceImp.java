package com.knongdai.restaurant.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knongdai.restaurant.entities.Locations;
import com.knongdai.restaurant.repositories.LocationRepository;
import com.knongdai.restaurant.services.LocationService;

@Service
@Transactional
public class LocationServiceImp implements LocationService{

	@Autowired
	private LocationRepository locationRepository;
	
	@Override
	public List<Locations> getAllCities() {
		try{
			return locationRepository.getAllLocationByParentIdAndTypeCode(0, "0");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Locations> getAllDistrictsByCityId(int cityId) {
		try{
			return locationRepository.getAllLocationByParentIdAndTypeCode(cityId, "1");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Locations> getAllCommunesByDistrictById(int districtId) {
		try{
			return locationRepository.getAllLocationByParentIdAndTypeCode(districtId, "2");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Locations> getAllVillagesByCommuneId(int communeId) {
		try{
			return locationRepository.getAllLocationByParentIdAndTypeCode(communeId, "3");
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}	
}
