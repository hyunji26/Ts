package controller.menu;

//import java.awt.Menu;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Restaurant;
import model.service.*;

public class MenuFormController implements Controller{

	public RestaurantManager restManager = new RestaurantManager();
	public MenuManager  menuManager = new MenuManager();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		// 세션에서 식당주인 아이디 가져옴 
		String ownerId = (String) request.getSession().getAttribute("USER_SESSION_KEY");
//		String ownerId = "owner01"; 
		Restaurant res = restManager.searchRestaurantByOwnerId(ownerId);
		
		request.setAttribute("resInfo", res);
		request.setAttribute("menulist", menuManager.selectAllRestaurantById(ownerId));
//		ArrayList<Menu> menuList = MenuManager.getInstance().selectAllRestaurantById(ownerId);
//		System.out.print("MenuFormCOntroller test :: ");
//		System.out.println();
		
		return "/owner/updateForm.jsp";
	}

}
