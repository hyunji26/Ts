package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.domain.Review;

public class ReviewDAO {
private JDBCUtil jdbcUtil = null;
    
    public ReviewDAO() {
        jdbcUtil = new JDBCUtil();
    }
   
    // restaurantDAO에 getRestaurantId() 추가: 리뷰 작성할 식당 선택 후 사용
    // restaurantDAO에 getOwnerIdByRestaurantId() 추가: 리뷰 작성 시 Review 객체 생성하기 위해 사용
    // studentDAO에 getStudentId() 추가: 나의 리뷰 조회 페이지 이동 후 사용
    
    // studentId에 해당하는 Review list (restaurant name까지)
    public ArrayList<Review> selectAllPlusRestName(int studentId){
    	StringBuffer query = new StringBuffer();
    	query.append("SELECT r.review_id, r.review_content, r.point, r.student_id, r.restaurant_id, res.name AS restaurant_name, r.owner_id");
    	query.append(" FROM review r");
    	query.append(" JOIN restaurant res ON r.restaurant_id = res.restaurant_id");
    	query.append(" WHERE r.student_id = ?");
   
    	jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {studentId});
    	
    	try {
    		ArrayList<Review> reviewList = new ArrayList<>();
    		ResultSet rs = jdbcUtil.executeQuery();
    		while(rs.next()) {
    			Review item = new Review();
    			item.setReviewId(rs.getInt("review_id"));
                item.setReviewContent(rs.getString("review_content"));
                item.setReviewPoint(rs.getInt("point"));
                item.setStudentId(rs.getInt("student_id"));
                item.setRestaurantId(rs.getInt("restaurant_id"));
                item.setOwnerId(rs.getString("owner_id"));
                item.setRestName(rs.getString("restaurant_name"));
                
                reviewList.add(item);
    		}
    		return reviewList;
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	} finally {
    		jdbcUtil.commit();
    		jdbcUtil.close();
    	}
    	return null;
    }
    
    // review 추가
    // Oracle 수정: review_id를 AUTO_INCREMENT로 재설정해야 함
    public int insertReview(Review review) {
        StringBuffer query = new StringBuffer();
        query.append("INSERT INTO review (review_id, student_id, restaurant_id, owner_id, point, review_content) ");
        query.append("VALUES (review_seq.NEXTVAL, ?, ?, ?, ?, ?)");
        
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {
                review.getStudentId(), review.getRestaurantId(), review.getOwnerId(), 
                review.getReviewPoint(), review.getReviewContent()});
        
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
    
    // studentId와 일치하는 모든 review를 ArrayList로 반환
    public ArrayList<Review> findReviewByStudentId(int studentId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT review_id, review_content, point, student_id, restaurant_id, owner_id");
        query.append(" FROM review");
        query.append(" WHERE student_id = ?");
        
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {studentId});
        
        try {
            ArrayList<Review> reviewList = new ArrayList<>();
            ResultSet rs = jdbcUtil.executeQuery();
            
            while(rs.next()) {
                Review item = new Review();
                item.setReviewId(rs.getInt("review_id"));
                item.setReviewContent(rs.getString("review_content"));
                item.setReviewPoint(rs.getInt("point"));
                item.setStudentId(rs.getInt("student_id"));
                item.setRestaurantId(rs.getInt("restaurant_id"));
                item.setOwnerId(rs.getString("owner_id"));
                
                reviewList.add(item);
            }
            return reviewList;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
        	jdbcUtil.commit();
            jdbcUtil.close();
        }
        
        return null;
    }
    
    // restaurantId와 일치하는 모든 review를 ArrayList로 반환
    public ArrayList<Review> findReviewByRestaurantId(int restaurantId) {
        StringBuffer query = new StringBuffer();
        query.append("SELECT review_id, review_content, point, student_id, restaurant_id, owner_id");
        query.append(" FROM review");
        query.append(" WHERE restaurant_id = ?");
        
        jdbcUtil.setSqlAndParameters(query.toString(), new Object[] {restaurantId});
        
        try {
            ArrayList<Review> reviewList = new ArrayList<>();
            ResultSet rs = jdbcUtil.executeQuery();
            
            while(rs.next()) {
                Review item = new Review();
                item.setReviewId(rs.getInt("review_id"));
                item.setReviewContent(rs.getString("review_content"));
                item.setReviewPoint(rs.getInt("point"));
                item.setStudentId(rs.getInt("student_id"));
                item.setRestaurantId(rs.getInt("restaurant_id"));
                item.setOwnerId(rs.getString("owner_id"));
                
                reviewList.add(item);
            }
            
            return reviewList;
        } catch(SQLException ex) {
            ex.printStackTrace();
        } finally {
        	jdbcUtil.commit();
            jdbcUtil.close();
        }
        
        return null;
    }
}
