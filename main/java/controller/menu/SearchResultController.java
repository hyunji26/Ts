package controller.menu;

import java.util.List;

//import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import model.domain.Restaurant;
import model.service.MenuManager;

public class SearchResultController implements Controller {

    private MenuManager menuManager = new MenuManager();

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
       String menuName = (String)request.getParameter("search_menu");   
        request.setAttribute("search_menuName", menuName);
        // 메뉴 이름을 기반으로 식당 리스트 검색
        List<Restaurant> restaurants = menuManager.findRestaurantList(menuName);
        request.setAttribute("restaurantlist",restaurants);
        return  "/student/searchResult.jsp";  // 리턴 값은 null로 설정하여 직접 포워딩만 수행
    }
}
