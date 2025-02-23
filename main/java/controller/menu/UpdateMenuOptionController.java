package controller.menu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;

public class UpdateMenuOptionController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       String m = request.getParameter("menuIdd");
       //test
       System.out.print("UpdateMenuOptuinController :: ");
       System.out.println(m);
       
       if (m != null) {
            int menuId = Integer.parseInt(m);
         request.getSession().setAttribute("menuId", m);
        }

        String action = request.getParameter("action");


        if ("update".equals(action)) {
            return "redirect:/owner/UpdateMenu";
        } else if ("delete".equals(action)) {
            // 실제 삭제 처리가 성공했는지 여부를 확인한 뒤 delete_result 설정
            boolean deleteSuccess = performDelete(request);
            if (deleteSuccess) {
                request.getSession().setAttribute("delete_result", "성공적으로 삭제되었습니다.");
            } else {
                request.getSession().setAttribute("delete_result", "삭제에 실패했습니다.");
            }
            return "redirect:/owner/Delete";
        }

        return null;
    }

    // 메뉴 삭제 로직 (예제)
    private boolean performDelete(HttpServletRequest request) {
        // 삭제 처리를 수행하고 성공 여부를 반환
        String menuId = (String) request.getSession().getAttribute("menuId");
        System.out.println("test test test :: " + menuId);
        if (menuId != null) {
            // 실제 삭제 로직을 구현 (DB 연동 등)
            // 예: MenuDAO.delete(Integer.parseInt(menuId));
            return true; // 삭제 성공
        }
        return false; // 삭제 실패
    }
}
