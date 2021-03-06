package com.knongdai.restaurant.services.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.knongdai.restaurant.entities.Addresses;
import com.knongdai.restaurant.entities.Restaurants;
import com.knongdai.restaurant.entities.UploadedFileInfo;
import com.knongdai.restaurant.filters.RestypeFilter;
import com.knongdai.restaurant.form.RestaurantForm2;
import com.knongdai.restaurant.form.RestaurantForm2.RestaurantUpdateForm2;
import com.knongdai.restaurant.repositories.AddressRepository;
import com.knongdai.restaurant.repositories.CategoryRepository;
import com.knongdai.restaurant.repositories.MenuRepository;
import com.knongdai.restaurant.repositories.RestPictureRepository;
import com.knongdai.restaurant.repositories.RestaurantRepository;
import com.knongdai.restaurant.repositories.RestypeRepository;
import com.knongdai.restaurant.services.FileUploadService;
import com.knongdai.restaurant.services.RestaurantService;
import com.knongdai.restaurant.utils.Pagination;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private RestypeRepository restType;
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private CategoryRepository categoryRepository; 
	
	@Autowired
	private RestPictureRepository restPictureRepository; 
	
	@Autowired
	private FileUploadService fileUploadService;
	
	@Override
	public ArrayList<Restaurants> getAllRestaurant() {
		return restaurantRepository.getAllRestaurant();
	}

	/*@Override
	public boolean insertRestaurant(Restaurants restaurant) {
		//return restaurantRepository.insertRestaurant(restaurant);
		return addNewRestaurant(restaurant);
	}
*/
	@Override
	public boolean deleteRestaurant(int rest_id, int address_id) {
		restaurantRepository.deleteAddress(address_id);
		return restaurantRepository.deleteRestaurant(rest_id);
	}

	/*@Override
	public boolean updateRestaurant(RestaurantUpdateForm2 restaurantUpdateForm2) {
		return restaurantRepository.updateRestaurant(restaurantUpdateForm2);
	}*/

	@Override
	public Restaurants findRestaurantById(int rest_id) {
		return restaurantRepository.findRestaurantById(rest_id);
	}

	@Override
	public ArrayList<Restaurants> findRestaurantWithCategory(Pagination pagination) {
		// TODO Auto-generated method stub
		return restaurantRepository.findRestaurantWithCategory(pagination.getLimit(), pagination.getOffset());
	}
	
	@Override
	@Transactional
	public boolean addNewRestaurant(RestaurantForm2 restaurantForm){
		
		// ============== Belove Teacher Pirang
		try{
			
			UploadedFileInfo menuPath = fileUploadService.upload(restaurantForm.getMenu_files(), "menu");
			UploadedFileInfo restaurantPath = fileUploadService.upload(restaurantForm.getRestaurant_files(), "restaurant");
			// fileInfo.getNames() : List of FIle Path
			//1. Upload File
			//2. Get Url
			//3. Insert Restaurant -> Return ID
			//4. Insert Menu
			//==================
			
			// 1. Insert address -> return address id (table name : addresses)
			Addresses address = restaurantForm.getAddress();
			System.out.println(address.getStreet());
			addressRepository.insertAddress(address);
			
			System.out.println("ADDRESS_ID ==> " + address.getAddress_id());
			
			// 2. Insert Restaurant -> return rest_id (table name : restaurants)
			restaurantForm.setAddress(address);
			restaurantRepository.insertRestaurant(restaurantForm);
			
			System.out.println("REST ID ======= > " + restaurantForm.getRest_id());
			
			//3. Insert Many Categories -> return category ID (table name : categories)
			//Categories cate = new Categories();
			categoryRepository.inertBatchCategories(menuPath.getNames() , restaurantForm.getRest_id());
			
			
			//Restpictures restpicture = new Restpictures();
			restPictureRepository.inertBatchRestpicture(restaurantPath.getNames(), restaurantForm.getRest_id());
			
			
			//4. Insert Rest Type ID
			restType.insertBatchRestypeId(restaurantForm.getRestypes_id(), restaurantForm.getRest_id());
			
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;
		
	}



//	@Override
//	public int countRestById(String keyword) {
//		
//		return restaurantRepository.countRestById(keyword.toLowerCase());
//	}
	
	@Override
	public int countRestById(int categoryId, String keyword) {
		
		return restaurantRepository.countRestById(categoryId, keyword.toLowerCase());
	}

	@Override
	public ArrayList<Restaurants> searchRest(Pagination pagination, RestypeFilter filter) {
		
		System.out.println(filter.getCategory_id());
		
		return restaurantRepository.searchRest(filter.getCategory_id(), 
				"%" + filter.getKeyword().toLowerCase() + "%", 
				pagination.getLimit(), pagination.getOffset());
		
	}

	@Override
	public int countRestOwner() {
		
		return restaurantRepository.countRestOwner();
	}
	
	//=============================== update image restaurant ============================
	@Override
	@Transactional
	public boolean updateRestaurant(RestaurantUpdateForm2 restaurantUpdateForm2){
		
		// ============== Beloved Teacher PIRANG =======================
		try{
	
			List<String> deletemenuPath = restaurantUpdateForm2.getDeletedMenuImageUrl();
			List<String> deletedImageRest = restaurantUpdateForm2.getDeletedRestaurantImageUrl();
			
			//================== UPDATE ADDRESS =============================
			Addresses address = restaurantUpdateForm2.getAddress();
			addressRepository.updateAddress(address);
			
			//================== UPDATE MENUS =============================
		
			menuRepository.deleteMenus(restaurantUpdateForm2.getRest_id());
			
			/*for(RestTypeId  id : restaurantUpdateForm2.getRestypes_id() ){
				System.out.println(id.getRestype_id());
			}*/
			restType.insertBatchRestypeId(restaurantUpdateForm2.getRestypes_id(), 
					restaurantUpdateForm2.getRest_id());
			
			//================== UPDATE RESTAURANT =============================
			restaurantRepository.updateRestaurant(restaurantUpdateForm2);
			//restaurantRepository.updateBatchMenu(restaurantUpdateForm2.getRestypes_id(), restaurantUpdateForm2.getRest_id());
			
			//System.out.println(restaurantUpdateForm2.getRestypes_id());
			//restType.updateBatchRestypeId(restaurantUpdateForm2.getRestypes_id(), restaurantUpdateForm2.getRest_id());
			
			//===================== add more category (menu) to restaurant
			if(!restaurantUpdateForm2.getMenu_files().isEmpty()){
				UploadedFileInfo menu_urls = fileUploadService.upload(restaurantUpdateForm2.getMenu_files(), "menu");
				categoryRepository.inertBatchCategories(menu_urls.getNames(), restaurantUpdateForm2.getRest_id());
			}
			//===================== add more Restaurant Picture  to restaurant
			if(!restaurantUpdateForm2.getRestaurant_files().isEmpty()){
				UploadedFileInfo path_names = fileUploadService.upload(restaurantUpdateForm2.getRestaurant_files(), "restaurant");
				restPictureRepository.inertBatchRestpicture(path_names.getNames(), restaurantUpdateForm2.getRest_id());
			}
		

			//===================== DELETE  CATEGORY(MENU OF RRSTAURANT  TO RESTAURANT
			
			for (String string : deletedImageRest) {
				System.out.println("Rest +> " + string);
			}
			
			for (String string : deletemenuPath) {
				System.out.println("Menu +> " + string);
			}
			

			if(deletemenuPath.size() > 0){
				if(categoryRepository.deleteBatchCategories(deletemenuPath, restaurantUpdateForm2.getRest_id()))
					System.out.println("can delete");
				else
					System.out.println("Error");
			}else{
				System.out.println("No delete");
			}
			
			//===================== DELETE  RESTAURNAT PICTURE ===========================
			if(deletedImageRest.size() > 0){
				restPictureRepository.deleteBatchRestPicture(deletedImageRest, restaurantUpdateForm2.getRest_id());
			}
			
			//===================== DELETE  DATA FROM SERVER ===========================
			System.out.println(deletemenuPath);
			fileUploadService.delete(deletemenuPath, "/resources/NhamEy/upload/menu");
	
			return true;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return false;

	}

	@Override
	public int countRest() {
		return restaurantRepository.countRest();
	}

	@Override
	public ArrayList<Restaurants> topRest() {
		return restaurantRepository.topRest();
	}


	

	

}



