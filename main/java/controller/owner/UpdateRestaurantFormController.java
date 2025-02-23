package controller.owner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.domain.Restaurant;
import model.service.RestaurantManager;

public class UpdateRestaurantFormController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 세션에서 로그인한 사용자 ID 가져오기
        HttpSession session = request.getSession();
        String ownerId = (String) session.getAttribute("USER_SESSION_KEY");

        // ownerId를 기준으로 식당 정보 조회
        RestaurantManager manager = RestaurantManager.getInstance();
        Restaurant restaurant = manager.findRestaurantByOwnerId(ownerId);

        request.setAttribute("restaurant", restaurant);

        return "/owner/updateRestaurantForm.jsp";
    }
}