package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.service.ReviewManager;

public class ViewMyReviewListController implements Controller{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int studentId = Integer.parseInt(request.getSession().getAttribute("USER_SESSION_KEY").toString());
		
        try {
            request.setAttribute("myReviewList", ReviewManager.getInstance().findMyReviewPlusRestName(studentId));
            
            return "/student/myReviewList.jsp";
        } catch(Exception ex) {
            return "/student/studentMain.jsp";
        }
	}
}
