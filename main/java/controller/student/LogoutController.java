package controller.student;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class LogoutController implements Controller {

   @Override
   public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
      // TODO Auto-generated method stub
      if (request.getSession().getAttribute("USER_SESSION_KEY") != null) {
         request.getSession().removeAttribute("USER_SESSION_KEY");
         return "redirect:/student/studentLogin/Form";
      }
      return null;
   }
}

