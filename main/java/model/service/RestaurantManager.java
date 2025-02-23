package model.service;

import java.util.ArrayList;

import model.dao.RestaurantDAO;
import model.domain.Restaurant;

public class RestaurantManager {
	private static RestaurantManager restMan = new RestaurantManager();
	private RestaurantDAO restDAO;
	
	public RestaurantManager() {
		try {
			restDAO = new RestaurantDAO();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	//레스토랑 업데이트
	public boolean updateRestaurant(Restaurant restaurant) {
		return restDAO.updateRestaurant(restaurant);
	}
	
	//OWNER_ID의 RESTAURANT 정보찾기
		public Restaurant findRestaurantByOwnerId(String ownerId) {
			try {
				return restDAO.findRestaurantByOwnerId(ownerId);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}
	
	public Restaurant searchRestaurantByOwnerId(String ownerId) {
		 return restDAO.searchRestaurantByOwnerId(ownerId);
		}
	
	public static RestaurantManager getInstance() {
		return restMan;
	}
	
	public int updateNameAndLocation(String name, String location, int restaurantId) {
		return restDAO.updateNameAndLocation(name, location, restaurantId);
	}
	
	public int updateRating(int size, int point, int restaurantId) {
		return restDAO.updateRating(size, point, restaurantId);
	}
	
	public ArrayList<Restaurant> selectAll(){
		return restDAO.selectAllRestaurant();
	}
	
	public ArrayList<Restaurant> selectByOwnerId(String ownerId){
		return restDAO.selectByOwnerId(ownerId);
	}
	
	public Restaurant selectRestaurantById(int restId) {
		return restDAO.selectRestaurantById(restId);
	}
	
	public String findOwnerIdByRestaurantId(int restId) {
		return restDAO.findOwnerIdByRestaurantId(restId);
	}
	
	
	public int insertRestaurantWithAuto(String ownerId, String name, String location, float rating) {
		return restDAO.insertRestaurantWithAuto(ownerId, name, location, rating);
	}
}
