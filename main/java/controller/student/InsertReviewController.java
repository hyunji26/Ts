package controller.student;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Review;
import model.service.RestaurantManager;
import model.service.ReviewManager;

public class InsertReviewController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//test
//		System.out.print("InsertReviewController test --------------");
//		System.out.println(Integer.parseInt(request.getSession().getAttribute("USER_SESSION_KEY").toString()) + " ------");
		int studentId = Integer.parseInt(request.getSession().getAttribute("USER_SESSION_KEY").toString());
//		int studentId = Integer.parseInt("20220800");
        int point = Integer.parseInt(request.getParameter("point"));
        String content = request.getParameter("content");
        int restaurantId = Integer.parseInt(request.getParameter("restaurantId").toString());
        
        Review review = new Review(studentId, point, content, restaurantId, null);
        
        try {
        	String ownerId = RestaurantManager.getInstance().findOwnerIdByRestaurantId(restaurantId);
        	review.setOwnerId(ownerId);
        	//test
//        	System.out.print("InsertReviewController test ------------------------ ");
//        	System.out.print("studentId: " + review.getStudentId() + " restaurantId: " + review.getRestaurantId() + " ownerId: " + review.getOwnerId());
//        	System.out.println(" point: " + review.getReviewPoint() + " content: " + review.getReviewContent());
            
        	ReviewManager.getInstance().insertReview(review);   
        	// 추가된 review에 따라 식당 평점 update
        	ArrayList<Review> reviewList = ReviewManager.getInstance().findRestaurantReview(restaurantId);
        	RestaurantManager.getInstance().updateRating(reviewList.size(), point, restaurantId);
        	
            return "redirect:/student/studentMain";
        } catch(Exception ex) {
            return "/student/reviewForm.jsp";
        }
	}
	
}
