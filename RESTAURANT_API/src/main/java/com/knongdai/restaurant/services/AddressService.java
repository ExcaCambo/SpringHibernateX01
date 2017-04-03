package com.knongdai.restaurant.services;

import java.util.ArrayList;

import com.knongdai.restaurant.entities.Addresses;


public interface AddressService {

	public ArrayList<Addresses> getAllAddress();
	
	public boolean insertAddress(Addresses address);
	
	public boolean deleteAddress(int address_id);
	
	public boolean updateAddress(Addresses address);
	
	public ArrayList<Addresses> findAddressById(int address_id);
}
