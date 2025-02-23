package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.RestaurantManager;

public class ReviewFormController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// test
//		System.out.print("------------------- test test -----------------");
//		System.out.println(request.getParameter("restaurant"));
		
		int restaurantId = Integer.parseInt(request.getParameter("restaurant"));
		
		try {
			request.setAttribute("restaurant", RestaurantManager.getInstance().selectRestaurantById(restaurantId));
			return "/student/reviewForm.jsp";
		} catch(Exception ex) {
			return "/student/chooseRestaurant.jsp";
		}
	}

}
