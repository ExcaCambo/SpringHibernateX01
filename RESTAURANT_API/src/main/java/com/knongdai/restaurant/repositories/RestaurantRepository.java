package com.knongdai.restaurant.repositories;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.knongdai.restaurant.entities.Categories;
import com.knongdai.restaurant.entities.Restaurants;
import com.knongdai.restaurant.entities.Restpictures;
import com.knongdai.restaurant.entities.Restypes;
import com.knongdai.restaurant.form.RestTypeId;
import com.knongdai.restaurant.form.RestaurantForm2;
import com.knongdai.restaurant.repositories.selectproviders.RestaurantRepositorySelectProvider;

@Repository
public interface RestaurantRepository {
	
	
	//=================== Restaurant Pagination with search ===============
	
	/*final String R_RESTYPE = 
			  "SELECT R.rest_id, "
			+ "	  	  R.rest_name, "
			+ "	  	  R.rest_name_kh, "
			+ "	  	  R.contact, "
			+ "	  	  R.about, "
			+ " 	  R.latitude,"
			+ " 	  R.longitude"
			+ " FROM  restaurants R "
			+ " WHERE LOWER(R.rest_name) LIKE LOWER(#{keyword}) "
			+ " AND "
			+ " ORDER BY R.rest_id DESC "
			+ " LIMIT #{limit} OFFSET #{offset} ";
	@Select(R_RESTYPE)
	@Results(value={
			@Result(property = "rest_id", column = "rest_id"),
			@Result(property = "restpictures", javaType=List.class, column="rest_id", many=@Many(select="findRestyPicture"))
	})
	public ArrayList<Restaurants> searchRest(@Param("keyword") String keyword, 
			@Param("limit") int limit, @Param("offset") int offset);*/
	@SelectProvider(type=RestaurantRepositorySelectProvider.class, method="searchRestaurant")
	@Results(value={
			@Result(property = "rest_id", column = "rest_id"),
			@Result(property = "restpictures", javaType=List.class, column="rest_id", many=@Many(select="findRestyPicture"))
	})
	public ArrayList<Restaurants> searchRest(@Param("category_id")int category_id, @Param("keyword") String keyword, 
			@Param("limit") int limit, @Param("offset") int offset);
	
	//==================COUNT Restaurant Detail  ================
//	String COUNT_RESTBYID = "SELECT COUNT(rest_id) FROM restaurants WHERE LOWER(rest_name) LIKE '%'||#{keyword}||'%' ";
//	@Select(COUNT_RESTBYID)
//	public int countRestById(String keyword);
	
	@SelectProvider(type=RestaurantRepositorySelectProvider.class, method="count")
	public int countRestById(@Param("category_id")int categoryId, @Param("keyword")String keyword);
		
	//================== Restaurant Detail  ================
	String R_RESTAURANT = "SELECT"
			+ " DISTINCT ON(R.rest_id) R.rest_id,"
			+ " R.rest_name,"
			+ " R.contact,"
			+ " R.about,"
			+ " R.open_close,"
			+ " R.latitude,"
			+ " R.longitude,"
			+ " M.restype_id AS menu_restype_id,"
			+ " A.address_id AS address_address_id, "
			+ " A.street, "
			+ " A.district, "
			+ " A.communce, "
			+ " A.province, "
			+ " U.user_id,"
			+ " U.first_name, "
			+ " U.last_name,"
			+ " U.username,"
			+ " U.email,"
			+ " U.password,"
			+ " U.salt, "
			+ " U.dob, "
			+ " U.joined, "
			+ " U.picture,"
			+ " RT.restype_id,"
			+ " RT.restype_name,"
			+ " RT.parentid_restypeid,"
			+ " RT.restype_name_kh"
			+ " FROM"
			+ " restaurants R"
			+ " INNER JOIN"
			+ " menus M"
			+ " ON M.rest_id = R.rest_id "
			+ " INNER JOIN restypes RT ON RT.restype_id = M.restype_id"
			+ " INNER JOIN Addresses A"
			+ " ON R.address_id = A.address_id"
			+ " INNER JOIN users U"
			+ " ON R.user_id = U.user_id";
	@Select(R_RESTAURANT)
	@Results(value={
			@Result(property = "restypes.restype_id", column = "restype_restype_id"),
			@Result(property = "address.address_id", column = "address_address_id"),
			@Result(property = "address.user_id", column = "user_user_id"),
			@Result(property = "restypes.restype_id", column = "restype_id"),
			@Result(property = "restypes.restype_name", column = "restype_name"),
			@Result(property = "address.street", column = "street"),
			@Result(property = "restypes.parentid_restypeid", column = "parentid_restypeid"),
			@Result(property = "restypes.restype_name_kh", column = "restype_name_kh"),
			@Result(property = "address.district", column = "district"),
			@Result(property = "address.communce", column = "communce"),
			@Result(property = "address.province", column = "province"),
			@Result(property = "user.user_id", column = "user_id"),
			@Result(property = "user.first_name", column = "first_name"),
			@Result(property = "user.last_name", column = "last_name"),
			@Result(property = "user.email", column = "email"),
			@Result(property = "user.salt", column = "salt"),
			@Result(property = "user.dob", column = "dob"),
			@Result(property = "user.joined", column = "joined"),
			@Result(property = "user.picture", column = "picture"),
			@Result(property = "user.username", column = "username"),
			@Result(property = "user.password", column = "password")
	})
	public ArrayList<Restaurants> getAllRestaurant();
	
	//TODO: 2. ADD TO RESTAURANT RETURN ID
	String C_RESTAURANT = "INSERT INTO restaurants"
			+ " (rest_name, rest_name_kh, contact,about,"
			+ " open_close, address_id,user_id, latitude, longitude)"
			+ " VALUES(#{rest_name} , #{rest_name_kh} , #{contact} , #{about},#{open_close},"
			+ " #{address.address_id},#{user_id},#{latitude},#{longitude})";
	@Insert(C_RESTAURANT)
	@SelectKey(
            keyProperty = "rest_id",
            before = false,
            resultType = Integer.class,
            statement = { "SELECT last_value FROM restaurants_rest_id_seq" })
	//public boolean insertRestaurant(RestaurantForm restaurantForm);
	public boolean insertRestaurant(RestaurantForm2 restaurantForm);
	//==================== DELETE RESTAURANT ===============
	/*String D_RESTAURANT = "DELETE"
			+ " FROM"
			+ " restaurants"
			+ " WHERE"
			+ " rest_id = #{rest_id}";
	@Delete(D_RESTAURANT)
	public boolean deleteRestaurant(int rest_id);*/
	
	String D_RESTAURANT = "DELETE"
			+ " FROM"
			+ " restaurants"
			+ " WHERE"
			+ " rest_id = #{rest_id};"
			+ " DELETE"
			+ " FROM"
			+ " comments"
			+ " WHERE"
			+ " rest_id = #{rest_id};"
			+ " DELETE"
			+ " FROM"
			+ " categories"
			+ " WHERE"
			+ " rest_id = #{rest_id};"
			+ " DELETE"
			+ " FROM"
			+ " menus"
			+ " WHERE"
			+ " rest_id = #{rest_id};"
			+ " DELETE"
			+ " FROM"
			+ " restpictures"
			+ " WHERE"
			+ " rest_id = #{rest_id};";
	@Delete(D_RESTAURANT)
	public boolean deleteRestaurant(int rest_id);
	
	String D_ADDRESS = "DELETE FROM  addresses WHERE address_id = #{address_id}";
	@Delete(D_ADDRESS)
	public boolean deleteAddress(int address_id);
	
	String U_RESTAURANT = "UPDATE restaurants SET "
			+ "	rest_name=#{rest_name} , "
			+ "	rest_name_kh=#{rest_name_kh} , "
			+ "	contact=#{contact} , "
			+ "	about=#{about},"
			+ " latitude   = #{latitude},"
			+ " longitude  = #{longitude},"
			+ " open_close = #{open_close},"
			+ " address_id = #{address.address_id}"
			+ " WHERE "
			+ "	rest_id = #{rest_id}";
	
	@Update(U_RESTAURANT)
	public boolean updateRestaurant(RestaurantForm2 restaurant);
	
	
	String UPDATE_BATCH_MENUS =  "<script>"
			+ " <foreach collection='restypes_id' item='restype_id' separator=','>"
			+ "     UPDATE menus SET "
			+ " 	restype_id = #{restype_id} WHERE rest_id =  #{rest_id})"
			+ " </foreach>"
			+ " </script>";
	@Insert(UPDATE_BATCH_MENUS)
	public boolean updateBatchMenu(@Param("restypes_id") List<RestTypeId> restypes_id , @Param("rest_id") int rest_id);
	
	/*String F_RESTAURANT = "SELECT DISTINCT"
	+ " R.rest_id,"
	+ " R.rest_name,"
	+ " R.contact,"
	+ " R.about,"
	+ " R.open_close,"
	+ " R.,"
	+ " A.address_id AS address_address_id,"
	+ " U.user_id AS user_user_id,"
	+ " U.username AS user_username"
	+ " FROM"
	+ " restaurants R"
	+ " INNER JOIN menus M ON R.rest_id = M.rest_id"
	+ " INNER JOIN restypes rs ON rs.restype_id = M.restype_id"
	+ " INNER JOIN Addresses A ON R.address_id = A.address_id"
	+ " INNER JOIN users U ON R.user_id = U.user_id"
	+ " WHERE R.rest_id = #{rest_id} ";*/
	String F_RESTAURANT = "SELECT "
			+ " R.rest_id,"
			+ " R.rest_name,"
			+ " R.rest_name_kh,"
			+ " R.contact,"
			+ " R.about,"
			+ " R.open_close,"
			+ " R.latitude,"
			+ " R.longitude,"
			+ " A.address_id AS address_address_id,"
			+ " A.street,"
			+ " A.village,"
			+ " A.district, "
			+ " A.communce,"
			+ " A.province,"
			+ " U.user_id,"
			+ "  U.first_name,"
			+ "  U.last_name,"
			+ "  U.username,"
			+ "  U.email,"
			+ "  U.password,"
			+ "  U.salt,"
			+ "  U.dob,"
			+ "  U.joined,"
			+ "  U.picture,"
			+ "  RO.role_name"
			+ " FROM restaurants R"
			+ " LEFT JOIN Addresses A  ON R.address_id = A.address_id"
			+ " LEFT JOIN users U  ON R.user_id = U.user_id "
			+ " LEFT JOIN roles RO ON U.role_id = RO.role_id WHERE R.rest_id = #{rest_id}";
	@Select(F_RESTAURANT)
	@Results(value={
			@Result(property = "rest_id", column = "rest_id"),
			@Result(property = "user.user_id", column = "user_id"),
			@Result(property = "user.first_name", column = "first_name"),
			@Result(property = "user.last_name", column = "last_name"),
			@Result(property = "user.email", column = "email"),
			@Result(property = "user.salt", column = "salt"),
			@Result(property = "user.dob", column = "dob"),
			@Result(property = "user.joined", column = "joined"),
			@Result(property = "user.picture", column = "picture"),
			@Result(property = "user.username", column = "username"),
			@Result(property = "user.password", column = "password"),
			@Result(property = "address.address_id", column = "address_address_id"),
			@Result(property = "address.district", column = "district"),
			@Result(property = "address.communce", column = "communce"),
			@Result(property = "address.province", column = "province"),
			@Result(property = "address.street", column = "street"),
			@Result(property = "address.village", column = "village"),
			@Result(property = "categories", javaType=List.class, column="rest_id", many=@Many(select="getCategoryByRestId")),
			@Result(property = "restpictures", javaType=List.class, column="rest_id", many=@Many(select="findRestyPicture")),
			@Result(property = "restype", javaType=List.class, column="rest_id", many=@Many(select="findMenuByRestId"))
	})
	public Restaurants  findRestaurantById(int rest_id);
	
	/*======================DASHBOARD REQUIREMENT ==================*/
	/*======================GET Restaurant WITH CATEGORY ==================*/

	String F_RESTAURANT_C = "SELECT "
			+ " R.rest_id,"
			+ " R.rest_name,"
			+ " R.contact,"
			+ " R.about,"
			+ " R.open_close,"
			+ " R.latitude,"
			+ " R.longitude,"
			+ " A.address_id AS address_address_id,"
			+ " A.street,"
			+ " A.district, "
			+ " A.communce,"
			+ " A.province,"
			+ " U.user_id,"
			+ "  U.first_name,"
			+ "  U.last_name,"
			+ "  U.username,"
			+ "  U.email,"
			+ "  U.password,"
			+ "  U.salt,"
			+ "  U.dob,"
			+ "  U.joined,"
			+ "  U.picture,"
			+ "  RO.role_name"
			+ " FROM restaurants R"
			+ " LEFT JOIN Addresses A  ON R.address_id = A.address_id"
			+ " LEFT JOIN users U  ON R.user_id = U.user_id "
			+ " LEFT JOIN roles RO ON U.role_id = RO.role_id WHERE RO.role_id=2 OR RO.role_id = 3"
			+ " ORDER BY rest_id DESC "
			+ " LIMIT #{limit} OFFSET #{offset} ";;
	@Select(F_RESTAURANT_C)
	@Results(value={
			@Result(property = "rest_id", column = "rest_id"),
			@Result(property = "user.user_id", column = "user_id"),
			@Result(property = "user.first_name", column = "first_name"),
			@Result(property = "user.last_name", column = "last_name"),
			@Result(property = "user.email", column = "email"),
			@Result(property = "user.salt", column = "salt"),
			@Result(property = "user.dob", column = "dob"),
			@Result(property = "user.joined", column = "joined"),
			@Result(property = "user.picture", column = "picture"),
			@Result(property = "user.username", column = "username"),
			@Result(property = "user.password", column = "password"),
			@Result(property = "address.address_id", column = "address_address_id"),
			@Result(property = "address.district", column = "district"),
			@Result(property = "address.communce", column = "communce"),
			@Result(property = "address.province", column = "province"),
			@Result(property = "address.street", column = "street"),
			@Result(property = "categories", javaType=List.class, column="rest_id", many=@Many(select="getCategoryByRestId")),
			@Result(property = "restpictures", javaType=List.class, column="rest_id", many=@Many(select="findRestyPicture")),
			@Result(property = "restype", javaType=List.class, column="rest_id", many=@Many(select="findMenuByRestId"))
	})
	public ArrayList<Restaurants> findRestaurantWithCategory( 
			@Param("limit") int limit, @Param("offset") int offset);
	
	String COUNT_RESTOWNER = "SELECT COUNT(rest_id) FROM restaurants R LEFT JOIN users U  "
			+ " ON R.user_id = U.user_id WHERE U.role_id=2 OR U.role_id = 3";
	@Select(COUNT_RESTOWNER)
	public int countRestOwner();
	/*====================== Get Category By Restaurant ID ==================*/
	/*String GC_BRID = "SELECT "
					+"		c.category_id, "
					+"		c.picture, "
					+"		c.category_name_kh, "
					+"		c.category_name"
					+"	FROM "
					+"	categories c "
					+"  INNER JOIN catrests cr ON c.category_id = cr.category_id "
					+"	WHERE cr.rest_id = #{rest_id}";*/
	String GC_BRID = "SELECT "
			+"		c.category_id, "
			+"		c.picture, "
			+"		c.category_name_kh, "
			+"		c.picture,"
			+"		c.url,"
			+"		c.category_name"
			+"	FROM "
			+"	categories c "
			+"  INNER JOIN restaurants r ON c.rest_id = r.rest_id "
			+"	WHERE c.rest_id = #{rest_id}";
	@Select(GC_BRID)
	public ArrayList<Categories> getCategoryByRestId(int rest_id);
	
	@Select("SELECT  RT.restype_id, RT.restype_name , RT.restype_name_kh  FROM restaurants R"
			+ " INNER JOIN menus M ON R.rest_id = M.rest_id"
			+ " INNER JOIN restypes RT ON M.restype_id = RT.restype_id"
			+ " WHERE R.rest_id =#{rest_id} ")
	@Results(value={
			@Result(property = "rest_id", column = "rest_id"),
			@Result(property = "restype_id", column = "restype_id"),
			@Result(property = "user.user_id", column = "user_id"),
			@Result(property = "user.first_name", column = "first_name"),
			@Result(property = "user.last_name", column = "last_name"),
			@Result(property = "user.email", column = "email"),
	})
	public ArrayList<Restypes> findMenuByRestId(int rest_id);
	
	@Select("SELECT  RP.picture_id, RP.path_name, RP.date_added, RP.date_modify FROM restaurants R"
			+ " INNER JOIN restpictures RP ON R.rest_id = RP.rest_id"
			+ " WHERE R.rest_id =#{rest_id} ")
	@Results(value={
			@Result(property = "rest_id", column = "rest_id"),
			@Result(property = "picture_id", column = "picture_id"),
			@Result(property = "path_name", column = "path_name")
	})
	public ArrayList<Restpictures> findRestyPicture(int rest_id);
	
	@Select("SELECT COUNT(*) FROM restaurants")
	public int countRest();
	
	String T_FAREST="Select rest_name,"
			+ " COUNT(F.user_id) total_favorite"
			+ " From restaurants R"
			+ " INNER JOIN favouriterestaurants F "
			+ " ON R.rest_id=F.rest_id"
			+ " GROUP BY rest_name"
			+ " ORDER BY 2 DESC"
			+ " limit 5";
	@Select(T_FAREST)
	@Results(value={
			@Result(property="total_favorite",column="total_favorite")
	})
	public ArrayList<Restaurants> topRest();
	
}
