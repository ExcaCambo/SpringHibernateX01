package com.knongdai.restaurant.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Brands;
@Service
public interface BrandService {

	public ArrayList<Brands> getAllBrand();
	public boolean insertBrand(Brands brand);
	public boolean deleteBrand(int brand_id);
	public boolean updateBrand(Brands brand);
	public Brands findBrandById(int brand_id);
}
