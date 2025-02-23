package controller.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class StudentMainController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 필요한 데이터가 있다면 request에 설정
        request.setAttribute("welcomeMessage", "학생 메인 페이지에 오신 것을 환영합니다!");

        // studentMain.jsp로 포워딩
        return "/student/studentMain.jsp";
}
}
