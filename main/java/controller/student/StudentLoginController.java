package controller.student;

import java.io.IOException;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.StudentManager;

// warning 제거 추가
@SuppressWarnings("serial")
public class StudentLoginController extends HttpServlet implements Controller {

    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String userId = request.getParameter("user_id");
        String password = request.getParameter("user_password");
        String role = request.getParameter("role");

        StudentManager manager = StudentManager.getInstance();

        try {
            if ("student".equals(role)) {
            	manager.studentLogin(userId, password);
            	
            	HttpSession session = request.getSession();
                session.setAttribute("USER_SESSION_KEY", userId);
                return "redirect:/student/studentMain";
            } else if ("owner".equals(role)) {
            	manager.ownerLogin(userId, password);
            	
            	HttpSession session = request.getSession();
                session.setAttribute("USER_SESSION_KEY", userId);
                return "redirect:/owner/ownerMain";
            }
            else {
            	request.setAttribute("loginFailed", true);
                request.setAttribute("exception", "신분을 선택해주세요.");
                return "/student/studentLoginForm.jsp";
            }
           
           
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("loginFailed", true);
            request.setAttribute("exception", e);
            return "/student/studentLoginForm.jsp";
        }
    }
}
