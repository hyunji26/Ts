package controller.owner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import model.service.RestaurantManager;
import model.domain.Restaurant;

public class UpdateRestaurantController implements Controller {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // getParameter로 값 받아오기
        String name = request.getParameter("name");
        String location = request.getParameter("location");

        // 세션에서 USER_SESSION_KEY 가져오기
        HttpSession session = request.getSession();
        String ownerId = (String) session.getAttribute("USER_SESSION_KEY");

        // 입력값 검증
        if (name == null || name.isEmpty()) {
            return "식당 이름을 입력하세요";
        }
        if (location == null || location.isEmpty()) {
            return "위치를 입력하세요";
        }
        if (ownerId == null) {
            return "로그인 세션이 만료되었습니다. 다시 로그인해주세요.";
        }
        //변경할 값 restaurant객체에 삽입
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        restaurant.setLocation(location);
        restaurant.setOwnerId(ownerId); // ownerId를 설정

        // RestaurantManager를 통해 업데이트 수행
        RestaurantManager manager = RestaurantManager.getInstance();
        boolean isUpdated = manager.updateRestaurant(restaurant);
        if(!isUpdated) {
        	return "/owner/updateRestaurantForm.jsp";
        }
        // 성공 시 리다이렉트
        return "redirect:/owner/restaurantResult";
    }
}