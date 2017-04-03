package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knongdai.restaurant.entities.Brands;
import com.knongdai.restaurant.repositories.BrandRepository;
import com.knongdai.restaurant.services.AddressService;
import com.knongdai.restaurant.services.BrandService;

@Service
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	AddressService addressService;

	@Autowired
	private BrandRepository brandRepositoy;
	
	@Override
	public ArrayList<Brands> getAllBrand() {
		return brandRepositoy.getAllBrand();
	}

	@Override
	@Transactional
	public boolean insertBrand(Brands brand) {
		addressService.insertAddress(brand.getAddress());
		int address_id =  brand.getAddress().getAddress_id();
		return brandRepositoy.insertBrand(brand);
	}

	@Override
	public boolean deleteBrand(int brand_id) {
		return brandRepositoy.deleteBrand(brand_id);
	}

	@Override
	public boolean updateBrand(Brands brand) {
		return brandRepositoy.updateBrand(brand);
	}

	@Override
	public Brands findBrandById(int brand_id) {
		return brandRepositoy.findBrandById(brand_id);
	}

}
