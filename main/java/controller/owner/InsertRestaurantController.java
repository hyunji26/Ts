package controller.owner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.RestaurantManager;

public class InsertRestaurantController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String ownerId = request.getSession().getAttribute("USER_SESSION_KEY").toString();
		// 임시로 사용
//		String ownerId = "owner01";
		String name = request.getParameter("name");
		String location = request.getParameter("location");
		
		try {
			RestaurantManager.getInstance().insertRestaurantWithAuto(ownerId, name, location, 0);
			
			return "redirect:/owner/ownerMain";
		} catch(Exception ex) {
			return "/owner/addRestaurantForm.jsp";
		}
	}

}
