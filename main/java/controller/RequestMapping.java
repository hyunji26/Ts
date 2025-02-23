package controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import controller.menu.DeleteMenuController;
import controller.menu.InquireMenuController;
import controller.menu.InsertMenuController;
import controller.menu.MenuFormController;
import controller.menu.MenuSelectController;
import controller.menu.SearchResultController;
import controller.menu.UpdateMenuController;
import controller.menu.UpdateMenuOptionController;
import controller.menu.ViewRecommendController;
import controller.owner.InsertRestaurantController;
import controller.owner.OwnerMainController;
import controller.owner.UpdateRestaurantController;
import controller.owner.UpdateRestaurantFormController;
import controller.owner.ViewRestaurantResultController;
import controller.student.InsertReviewController;
import controller.student.LogoutController;
import controller.student.ReviewFormController;
import controller.student.SignUpController;
import controller.student.StudentLoginController;
import controller.student.StudentMainController;
import controller.student.ViewAllRestaurantController;
import controller.student.ViewMyReviewListController;

public class RequestMapping {
    private static final Logger logger = LoggerFactory.getLogger(DispatcherServlet.class);
    
    // 각 요청 uri에 대한 controller 객체를 저장할 HashMap 생성
    private Map<String, Controller> mappings = new HashMap<String, Controller>();

    public void initMapping() {
    	// 각 uri에 대응되는 controller 객체를 생성 및 저장
    	
    	// TastySom 
    	mappings.put("/", new ForwardController("index.jsp"));
    	// 로그인
    	mappings.put("/student/studentLogin/Form", new ForwardController("/student/studentLoginForm.jsp"));
	    mappings.put("/student/studentLogin", new StudentLoginController());
    	// 회원 가입
	    mappings.put("/student/signUp/form", new ForwardController("/student/signUpForm.jsp"));
	    mappings.put("/student/signUp", new SignUpController());
	    
    	// 학생 기능
		// 학생 메인페이지로 이동
	    mappings.put("/student/studentMain", new StudentMainController());
		// 로그아웃
	    mappings.put("/student/logout", new LogoutController()); 
    	// 리뷰 작성
    	mappings.put("/student/writeReview", new ViewAllRestaurantController());
    	mappings.put("/student/writeReview/form", new ReviewFormController());
    	mappings.put("/student/writeReview/update", new InsertReviewController());
    	// 리뷰 조회
        mappings.put("/student/myReview", new ViewMyReviewListController());
        // 메뉴 검색
        mappings.put("/student/SearchMenu", new InquireMenuController());
		mappings.put("/student/SearchResult", new SearchResultController());
		// 추천
	    mappings.put("/student/studentRecommend", new ViewRecommendController());
        
		// 식당대표 기능
	    // 식당 메인페이지로 이동
	    mappings.put("/owner/ownerMain", new OwnerMainController());
		// 로그아웃
		mappings.put("/owner/logout", new LogoutController());
        // 식당 추가
        mappings.put("/owner/insertRestaurant", new ForwardController("/owner/addRestaurantForm.jsp"));
        mappings.put("/owner/insertRestaurant/insert", new InsertRestaurantController());
        // 식당 수정
        mappings.put("/owner/updateRestaurantForm", new UpdateRestaurantFormController());
	    mappings.put("/owner/updateRestaurant", new UpdateRestaurantController());
	    mappings.put("/owner/restaurantResult", new ViewRestaurantResultController());
        
        // 메뉴 생성
        mappings.put("/owner/insertMenu", new InsertMenuController());
        // 메뉴 수정
        mappings.put("/owner/MenuSelect",new MenuSelectController());
        mappings.put("/owner/UpdateMenuForm", new MenuFormController());
		mappings.put("/owner/UpdateMenuOption", new UpdateMenuOptionController());
		mappings.put("/owner/UpdateMenu",new UpdateMenuController());
        // 메뉴 삭제
		mappings.put("/owner/Delete", new DeleteMenuController());
        
        logger.info("Initialized Request Mapping!");
    }

    public Controller findController(String uri) {	
    	// 주어진 uri에 대응되는 controller 객체를 찾아 반환
        return mappings.get(uri);
    }
}