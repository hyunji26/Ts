package model.service;

import java.util.ArrayList;

import model.dao.ReviewDAO;
import model.domain.Review;

public class ReviewManager {
	private static ReviewManager reviewMan = new ReviewManager();
    private ReviewDAO reviewDAO;
//    private ReviewAnalysis reviewAnalysis; 
    
    private ReviewManager() {
        try {
            reviewDAO = new ReviewDAO();
//            reviewAnalysis = new ReviewAnalysis(reviewDAO);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static ReviewManager getInstance() {
        return reviewMan;
    }
    
    // insertReview
    // findMyReview
    // findRestaurantReview
    public int insertReview(Review review) {
        return reviewDAO.insertReview(review);
    }
    
    public ArrayList<Review> findMyReviewPlusRestName(int studentId){
    	return reviewDAO.selectAllPlusRestName(studentId);
    }
    
    public ArrayList<Review> findMyReview(int studentId) {
        return reviewDAO.findReviewByStudentId(studentId);
    }
    
    public ArrayList<Review> findRestaurantReview(int restaurantId) {
        return reviewDAO.findReviewByRestaurantId(restaurantId);
    }
}
