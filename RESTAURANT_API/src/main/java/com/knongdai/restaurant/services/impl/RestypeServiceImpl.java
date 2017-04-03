package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knongdai.restaurant.entities.Restaurants;
import com.knongdai.restaurant.entities.Restypes;
import com.knongdai.restaurant.entities.UploadedFileInfo;
import com.knongdai.restaurant.filters.RestypeFilter;
import com.knongdai.restaurant.repositories.RestypeRepository;
import com.knongdai.restaurant.services.FileUploadService;
import com.knongdai.restaurant.services.RestypeService;
import com.knongdai.restaurant.utils.Pagination;

@Service
public class RestypeServiceImpl implements RestypeService {

	@Autowired
	private RestypeRepository restypeRepository;
	
	@Autowired
	private FileUploadService fileUploadService;
	
	
	@Override
	public ArrayList<Restypes> getAllRestype(Pagination pagination, RestypeFilter filter) {
		System.out.println(pagination.getOffset() + " " + pagination.getLimit());
		System.out.println(filter.getKeyword()) ;
		return restypeRepository.getAllRestype("%" + filter.getKeyword().toLowerCase() + "%", 
				pagination.getLimit(), pagination.getOffset());
	}

	@Override
	@Transactional
	public boolean insertRestype(Restypes restype) {
		
		if(!restype.getRestype_files().isEmpty()){
			UploadedFileInfo picture = fileUploadService.upload(restype.getRestype_files(), "restype");
			
			for(String picture_file : picture.getNames()){
				restype.setRestype_picture(picture_file);
				System.out.println(picture_file);
			}
			
			return restypeRepository.insertRestype(restype);
			
		}else{
			System.out.println("null ");
		}
		
		return false;
		
	}

	@Override
	public boolean deleteRestype(int restype_id) {
		return restypeRepository.deleteRestype(restype_id);
	}

	@Override
	@Transactional
	public boolean updateRestype(Restypes restype) {
		if(!restype.getRestype_files().isEmpty()){
			UploadedFileInfo picture = fileUploadService.upload(restype.getRestype_files(), "restype");
			
			for(String picture_file : picture.getNames()){
				restype.setRestype_picture(picture_file);
				System.out.println(picture_file);
			}
			
			return restypeRepository.updateRestype(restype);
			
		}else{
			System.out.println("null ");
		}
		return false;
	}

	@Override
	public ArrayList<Restaurants> findRestypeById(int restype_id, Pagination pagination) {
		
		return restypeRepository.findRestypeById(restype_id, pagination.getLimit(), pagination.offset());
		
	}

	@Override
	public int countRestype(String keyword) {
		return restypeRepository.countRestype(keyword);
	}

	@Override
	public ArrayList<Restypes> findRestypeByKeyword(String keyword) {
		return restypeRepository.findRestypeByKeyword(keyword);
	}

	@Override
	public int countRest(int restype_id) {
		
		return restypeRepository.countRest(restype_id);
	}

	@Override
	public Restypes getOnlyRestype(int restype_id) {
		// TODO Auto-generated method stub
		return restypeRepository.getOnlyRestype(restype_id);
	}
	
}
