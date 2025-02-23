package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.MenuManager;

public class DeleteMenuController implements Controller{

	private MenuManager menuManager = new MenuManager();
	 
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		 // 세션에서 식당주인 아이디 가져옴 
		String m = (String)request.getSession().getAttribute("menuId");
		int menuId = Integer.parseInt(m);
		 
		if(	menuManager.deleteMenu(menuId)) {
			request.getSession().setAttribute("delete_result", "성공적으로 삭제하였습니다.");
		 	return "redirect:/owner/UpdateMenuForm";
		 }
		else {
			request.getSession().setAttribute("delete_result", "삭제를 실패하였습니다.");
			 return "redirect:/owner/UpdateMenuForm";
		}
	}

}
