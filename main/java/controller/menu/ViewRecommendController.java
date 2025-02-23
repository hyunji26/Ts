package controller.menu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.StudentManager;

public class ViewRecommendController implements Controller {
  
    private StudentManager studentManager = StudentManager.getInstance();
    @Override 
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // No additional processing needed if topMenus is already set in the session
    	HttpSession session = request.getSession();
   	    int studentId = Integer.parseInt(session.getAttribute("USER_SESSION_KEY").toString());
   	    
   	    List<String> topMenus = studentManager.findRecommandList(studentId);
        request.setAttribute("topMenus", topMenus);
        
        
        return "/student/studentRecommend.jsp"; // Forward to the JSP page
        
        
    }
}