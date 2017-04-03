package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Restpictures;
import com.knongdai.restaurant.repositories.RestPictureRepository;
import com.knongdai.restaurant.services.RestpictureService;

@Service
public class RestpictureServiceImpl implements RestpictureService {

	@Autowired
	private RestPictureRepository restpicRepository;
	@Override
	public ArrayList<Restpictures> getAllRestpicture() {
		return restpicRepository.getAllRestpicture();
	}

	@Override
	public boolean insertRestpicture(Restpictures restpicture) {
		return restpicRepository.insertRestpicture(restpicture);
	}

	@Override
	public boolean updateRestpicture(Restpictures restpicture) {
		return restpicRepository.updateRestpicture(restpicture);
	}

	@Override
	public boolean deleteRestpicture(int picture_id) {
		return restpicRepository.deleteRestpicture(picture_id);
	}

	@Override
	public ArrayList<Restpictures> findRestpictureById(int picture_id) {
		return restpicRepository.findRestpictureById(picture_id);
	}

	

	
}
