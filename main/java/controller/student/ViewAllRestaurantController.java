package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.RestaurantManager;

public class ViewAllRestaurantController implements Controller{
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		try {
			request.setAttribute("restList", RestaurantManager.getInstance().selectAll());
			return "/student/chooseRestaurant.jsp";
		} catch(Exception ex) {
			return "/student/studentMain.jsp";
		}
	}
}
