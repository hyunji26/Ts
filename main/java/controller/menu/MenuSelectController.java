package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

//import model.service.*;

public class MenuSelectController implements Controller{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {	    
        request.getSession().removeAttribute("delete_result");
		return "redirect:/owner/UpdateForm";
	}

}
