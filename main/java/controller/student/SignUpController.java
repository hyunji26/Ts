package controller.student;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

import java.io.IOException;
//import model.dao.StudentDAO;
import model.service.StudentManager;

public class SignUpController implements Controller {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String Id = request.getParameter("id");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        if (Id == null || Id.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("errorMessage", "ID와 비밀번호를 입력해주세요.");
            return "/student/signUpForm.jsp"; 
        }

        StudentManager manager = StudentManager.getInstance();
        try {
        	boolean isInserted = false;
        	if("student".equals(role)) {
            isInserted = manager.insertStudentUser(Id, password);
        	}
        	else if("owner".equals(role)) {
                isInserted = manager.insertOwnerUser(Id, password);
            	}
            if (isInserted && "student".equals(role)) {
                return "redirect:/student/studentLogin/Form"; 
            } 
            if (isInserted && "owner".equals(role)) {
                return "redirect:/student/studentLogin/Form"; 
            } 
            else {
         
                request.setAttribute("errorMessage", "회원가입에 실패했습니다. 다시 시도해주세요.");
                return "/student/signUpForm.jsp"; 
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "시스템 오류가 발생했습니다.");
            return "/student/signUpForm.jsp"; 
        }
    }
}
