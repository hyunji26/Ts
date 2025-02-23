package controller.menu;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MenuManager;
import model.service.RestaurantManager;
import model.domain.*;

public class InsertMenuController implements Controller{

	MenuManager menuMananger = new MenuManager();
	RestaurantManager restManager = new RestaurantManager();
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		 
		String ownerId = request.getSession().getAttribute("USER_SESSION_KEY").toString();
//		String ownerId ="owner01";
		Restaurant res = restManager.searchRestaurantByOwnerId(ownerId);
		request.setAttribute("resInfo", res);
		
	    String modiMenuName = request.getParameter("menuName");
	    String priceParam = request.getParameter("price");
	    
	    if(modiMenuName ==null) {
	    	 request.getSession().removeAttribute("insert_result");
	    }
	    int price = 0;
	    try {
	        price = Integer.parseInt(priceParam);
	    } catch (NumberFormatException e) {
	        return "/owner/addMenuForm.jsp";
	    }
	    
	    // dto 생성
	    Menu newMenu = new Menu();
	    
	    newMenu.setName(modiMenuName);
	    newMenu.setOwnerId(ownerId);
	    newMenu.setPrice(price);
	    
	    if (MenuManager.getInstance().insertMenu(newMenu)) {
	        request.setAttribute("insert_result", "메뉴 추가가 성공적으로 완료되었습니다.");
	        return "/owner/addMenuForm.jsp";
	        		//"redirect:/owner/UpdateForm";
	    } else {
	        request.setAttribute("insert_result", "추가에 실패했습니다. 다시 시도해주세요.");
	        return "/owner/addMenuForm.jsp";
	    }
	}
}
