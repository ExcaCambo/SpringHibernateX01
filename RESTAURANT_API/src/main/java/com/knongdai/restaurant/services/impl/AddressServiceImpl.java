package com.knongdai.restaurant.services.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.knongdai.restaurant.entities.Addresses;
import com.knongdai.restaurant.repositories.AddressRepository;
import com.knongdai.restaurant.services.AddressService;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public ArrayList<Addresses> getAllAddress() {
		return addressRepository.getAllAddress();
	}

	@Override
	public boolean insertAddress(Addresses address) {
		addressRepository.insertAddress(address);
		
		System.out.println("ADDRESS ID==>" + address.getAddress_id());
		return true;
	}

	@Override
	public boolean deleteAddress(int address_id) {
		return addressRepository.deleteAddress(address_id);
	}

	@Override
	public boolean updateAddress(Addresses address) {
		return addressRepository.updateAddress(address);
	}

	@Override
	public ArrayList<Addresses> findAddressById(int address_id) {
		return addressRepository.findAddressById(address_id);
	}
	
}
