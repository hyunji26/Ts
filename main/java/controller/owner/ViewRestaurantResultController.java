package controller.owner;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.domain.Menu;
import model.domain.Restaurant;
import model.service.MenuManager;
import model.service.RestaurantManager;

public class ViewRestaurantResultController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String ownerId = (String)session.getAttribute("USER_SESSION_KEY");
		
		 MenuManager manager = MenuManager.getInstance();
	     ArrayList<Menu> menuList = manager.selectAllRestaurantByIdWithPrice(ownerId);
	     
	     request.setAttribute("menuList",menuList);
	     
	     RestaurantManager rmanager = RestaurantManager.getInstance();
	     Restaurant restaurant = rmanager.findRestaurantByOwnerId(ownerId);
	     
	     request.setAttribute("restaurant",restaurant);
	     
		return "/owner/restaurantResult.jsp";
	}

}
