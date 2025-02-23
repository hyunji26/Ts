package controller.menu;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;


public class InquireMenuController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	    // 폼에서 전달된 메뉴 이름을 파라미터로 받음

	    // 리다이렉트
	    return "/student/search.jsp";
	}

}
