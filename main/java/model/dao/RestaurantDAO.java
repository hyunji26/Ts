package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import model.domain.Restaurant;

public class RestaurantDAO {
    private JDBCUtil jdbcUtil = null;

    public RestaurantDAO() {
        jdbcUtil = new JDBCUtil();
    }
    
  //onwer_id의 레스토랑 정보 찾기
    public Restaurant findRestaurantByOwnerId(String ownerId) throws Exception {
        String sql = "SELECT * FROM restaurant WHERE owner_id = ?";
        Object[] param = new Object[] {ownerId};
        
        jdbcUtil.setSqlAndParameters(sql, param);
        try {
        	 Restaurant restaurant = new Restaurant();
             ResultSet rs = jdbcUtil.executeQuery();

            if (rs.next()) {
                restaurant.setName(rs.getString("name"));
                restaurant.setLocation(rs.getString("location"));
                restaurant.setOwnerId(rs.getString("owner_id"));
                restaurant.setRestaurantId(rs.getInt("restaurant_id"));
                restaurant.setRating(rs.getFloat("rating"));

                return restaurant; // 조회된 Restaurant 객체 반환
            }
        } catch (Exception e) {
        	 jdbcUtil.rollback();
            e.printStackTrace();
        } finally {
        	jdbcUtil.commit();
            jdbcUtil.close();
        }
        return null; // 조회된 결과가 없을 경우 null 반환
    }
    
    public Restaurant searchRestaurantByOwnerId(String ownerId) {
		
 	   String sql = "";
        sql += "SELECT  name, location, rating";
        sql += " FROM restaurant ";
        sql += " WHERE owner_id = ?";
        
        Object[] params = new Object[]{ownerId};
        
        jdbcUtil.setSqlAndParameters(sql, params);
        
        try {
          Restaurant res = new Restaurant();
           ResultSet rs = jdbcUtil.executeQuery();
           while(rs.next()) {
        
             res.setName(rs.getString("name"));
             res.setLocation(rs.getString("location"));
             res.setRating(rs.getFloat("rating"));
          
           }
           
           return res;
        } catch(Exception ex) {
           ex.printStackTrace();
        }
 	return null;
 }
    
    // select restaurants by owner_id
    public ArrayList<Restaurant> selectByOwnerId(String ownerId){
    	StringBuffer query = new StringBuffer();
    	query.append("SELECT restaurant_id, owner_id, name, location, rating");
    	query.append(" FROM restaurant");
    	query.append(" WHERE owner_id = ?");
    	
    	jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {ownerId});
    	
    	try {
    		ArrayList<Restaurant> restList = new ArrayList<>();
    		ResultSet rs = jdbcUtil.executeQuery();
    		while(rs.next()) {
    			Restaurant item = new Restaurant();
    			item.setRestaurantId(rs.getInt("restaurant_id"));
    			item.setOwnerId(rs.getString("owner_id"));
    			item.setName(rs.getString("name"));
    			item.setLocation(rs.getString("location"));
    			item.setRating(rs.getFloat("rating"));
    			
    			restList.add(item);
    		}
    		return restList;
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return null;
    }
    
    // update name and location
    public int updateNameAndLocation(String name, String location, int restaurantId) {
    	StringBuffer query = new StringBuffer();
    	query.append("UPDATE restaurant");
    	query.append(" SET name = ?, location = ?");
    	query.append(" WHERE restaurant_id = ?");
    	
    	jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {name, location, restaurantId});
    	
    	try {
    		return jdbcUtil.executeUpdate();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		jdbcUtil.commit();
    		jdbcUtil.close();
    	}
    	return -1;
    }

    // update rating
    public int updateRating(int size, int point, int restaurantId) {
    	float newPoint = (float) point;
    	
    	StringBuffer query = new StringBuffer();
    	query.append("UPDATE restaurant");
    	query.append(" SET rating = ROUND((rating * (? - 1) + ?) / ?, 2)");
    	query.append(" WHERE restaurant_id = ?");
    	
    	jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {size, newPoint, size, restaurantId});
    	
    	try {
    		jdbcUtil.executeUpdate();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		jdbcUtil.commit();
    		jdbcUtil.close();
    	}
    	return 0;
    }
    
    // insert restaurant (auto increasing: restaurant_id)
    public int insertRestaurantWithAuto(String ownerId, String name, String location, float rating) {
    	StringBuffer query = new StringBuffer();
    	query.append("INSERT INTO restaurant (owner_id, name, location, rating)");
    	query.append(" VALUES (?, ?, ?, ?)");
    	
    	jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {ownerId, name, location, rating});
    	
    	try {
    		return jdbcUtil.executeUpdate();
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		jdbcUtil.commit();
    		jdbcUtil.close();
    	}
    	return 0;
    }
    
    // Insert Restaurant
    public int insertRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO restaurant (restaurant_id, name, location, owner_id, rating) VALUES (?, ?, ?, ?, ?)";
        Object[] params = new Object[] {
            restaurant.getRestaurantId(),
            restaurant.getName(),
            restaurant.getLocation(),
            restaurant.getOwnerId(),
            restaurant.getRating()
        };

        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    // Delete Restaurant
    public boolean deleteRestaurant(int restaurantId) {
        String sql = "DELETE FROM restaurant WHERE restaurant_id = ?";
        Object[] params = { restaurantId };

        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return false;
    }

    // Update Restaurant
    public boolean updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurant SET name = ?, location = ? WHERE owner_id = ?";
        Object[] params = {
            restaurant.getName(),
            restaurant.getLocation(), 
            restaurant.getOwnerId()
        };

        System.out.println(restaurant.getName());
        System.out.println(restaurant.getLocation());
        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
            return true;
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return false;
    }
//    public boolean updateRestaurant(Restaurant restaurant) {
//        String sql = "UPDATE Restaurant SET name = ?, location = ?, owner_id = ?, rating = ? WHERE restaurant_id = ?";
//        Object[] params = {
//            restaurant.getName(),
//            restaurant.getLocation(),
//            restaurant.getOwnerId(),
//            restaurant.getRating(),
//            restaurant.getRestaurantId()
//        };
//
//        jdbcUtil.setSqlAndParameters(sql, params);
//        try {
//            jdbcUtil.executeUpdate();
//        } catch (Exception ex) {
//            jdbcUtil.rollback();
//            ex.printStackTrace();
//        } finally {
//            jdbcUtil.commit();
//            jdbcUtil.close();
//        }
//        return false;
//    }
    
    // select all restaurant
    public ArrayList<Restaurant> selectAllRestaurant(){
    	String sql = "";
    	sql += "SELECT restaurant_id, name, location, owner_id, rating";
    	sql += " FROM restaurant";
    	
    	jdbcUtil.setSqlAndParameters(sql, null);
    	
    	try {
    		ArrayList<Restaurant> restList = new ArrayList<>();
    		ResultSet rs = jdbcUtil.executeQuery();
    		while(rs.next()) {
    			Restaurant item = new Restaurant();
    			item.setRestaurantId(rs.getInt("restaurant_id"));
    			item.setName(rs.getString("name"));
    			item.setLocation(rs.getString("location"));
    			item.setOwnerId(rs.getString("owner_id"));
    			item.setRating(rs.getFloat("rating"));
    			
    			restList.add(item);
    		}
    		
    		return restList;
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	
    	return null;
    }
    
    // select restaurant by id
    public Restaurant selectRestaurantById(int id) {
    	String sql = "";
    	sql += "SELECT restaurant_id, name, location, owner_id, rating";
    	sql += " FROM restaurant";
    	sql += " WHERE restaurant_id = ?";
    	
    	jdbcUtil.setSqlAndParameters(sql, new Object[] {id});
    	
    	try {
    		Restaurant rest = new Restaurant();
    		ResultSet rs = jdbcUtil.executeQuery();
//    		int count = 0; // 잘못된 SQL문 실행 확인용
    		
    			
			while(rs.next()) {
				rest.setRestaurantId(rs.getInt("restaurant_id"));
				rest.setName(rs.getString("name"));
				rest.setLocation(rs.getString("location"));
				rest.setOwnerId(rs.getString("owner_id"));
				rest.setRating(rs.getFloat("rating"));
			}
    		
    		return rest;
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} 
    	return null;
    }
    
    // find owner_id by restaurant_id
    public String findOwnerIdByRestaurantId(int restId) {
    	String sql = "";
    	sql += "SELECT owner_id";
    	sql += " FROM restaurant";
    	sql += " WHERE restaurant_id = ?";
    	
    	jdbcUtil.setSqlAndParameters(sql, new Object[] {restId});
    	
    	try {
    		String ownerId = null;
    		ResultSet rs = jdbcUtil.executeQuery();
    		while(rs.next()) {
    			ownerId = rs.getString("owner_id");
    		}
    		return ownerId;
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return null;
    }
}
