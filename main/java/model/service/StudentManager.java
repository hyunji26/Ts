package model.service;

import java.sql.SQLException;
//import java.util.List;
import java.util.List;

import model.dao.*;
import model.domain.Owner;
import model.domain.Student;
/**
 * SystemManager 클래스
 * 사용자 로그인/로그아웃, 레스토랑 관리, 메뉴 관리, 리뷰 관리 등
 * 시스템 전반의 비즈니스 로직을 처리하는 클래스
 */
public class StudentManager {
    private static StudentManager sysMan = new StudentManager();

    // DAO 객체들
//    private UserDAO userDao;
//    private RestaurantDAO restaurantDao;
//    private MenuDAO menuDao;
//    private ReviewDAO reviewDao;
    private StudentDAO studentDao;
    private OwnerDAO ownerDao;
    private RecommendDAO recommendDao;

    // 생성자: DAO 객체 초기화
    private StudentManager() {
//        userDao = new UserDAO();
//        restaurantDao = new RestaurantDAO();
//        menuDao = new MenuDAO();
//        reviewDao = new ReviewDAO();
        studentDao = new StudentDAO();
        ownerDao = new OwnerDAO();
        recommendDao = new RecommendDAO();
    }

    public static StudentManager getInstance() {
        return sysMan;
    }

    /** 1) 메뉴 추천 */
    public List<String> findRecommandList(int studentId) throws SQLException {
    	System.out.println("Received studentId: " + studentId);
        return recommendDao.findRecommendList(studentId);
    }
    /** 2) 로그인 */
    public Student findUser(String studentId)
          throws SQLException, UserNotFoundException {
          Student student = studentDao.findUser(studentId);
          
          if (student == null) {
             throw new UserNotFoundException(studentId + "는 존재하지 않는 아이디입니다.");
          }      
          return student;
       }
    /** 3)사용자 추가 */
    public boolean insertStudentUser(String studentId,String pwd) {
        try {
            studentDao.insert(studentId,pwd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
    public boolean insertOwnerUser(String studentId,String pwd) {
        try {
            ownerDao.insert(studentId,pwd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
		return false;
    }
    public Owner findOwner(String studentId)
          throws SQLException, UserNotFoundException {
          Owner owner = ownerDao.findUser(studentId);
          
          if (owner == null) {
             throw new UserNotFoundException(studentId + "는 존재하지 않는 아이디입니다.");
          }      
          return owner;
       }

    public boolean studentLogin(String StudentId, String password) 
          throws SQLException,UserNotFoundException, PasswordMismatchException {
            Student user = studentDao.findUser(StudentId);
       
           if (!user.matchPassword(password)) {
              throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
           }
           return true;
    }

    public boolean ownerLogin(String ownerId, String password)
          throws SQLException,UserNotFoundException, PasswordMismatchException {
              Owner user = findOwner(ownerId);
      
          if (!user.matchPassword(password)) {
             throw new PasswordMismatchException("비밀번호가 일치하지 않습니다.");
          }
          return true;
   }
    /** 사용자 추가 */
    public boolean insertUser(String studentId,String pwd) {
        try {
            studentDao.insert(studentId,pwd);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
      return false;
    }
//    /** 로그아웃 */
//    public void logOut() {
//        System.out.println("User logged out.");
//    }

 
//    /** 회원가입 */
//    public boolean signIn(User user) {
//        try {
//            return userDao.create(user) > 0;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    /** 회원탈퇴 */
//    public void quit(String userId) {
//        try {
//            userDao.remove(userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /** 사용자 업데이트 */
//    public void updateUser(User user) {
//        try {
//            userDao.update(user);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 사용자 삭제 */
//    public void deleteUser(String userId) {
//        try {
//            userDao.remove(userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 레스토랑 추가 */
//    public void insertRestaurant(Restaurant restaurant) {
//        try {
//            restaurantDao.createRestaurant(restaurant);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 레스토랑 수정 */
//    public void updateRestaurant(Restaurant restaurant) {
//        try {
//            restaurantDao.updateRestaurant(restaurant);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 레스토랑 삭제 */
//    public void deleteRestaurant(int restaurantId) {
//        try {
//            restaurantDao.deleteRestaurant(restaurantId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 레스토랑 정보 조회 */
//    public List<Restaurant> findRestaurantList() {
//        try {
//            return restaurantDao.getAllRestaurants();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /** 메뉴 추가 */
//    public void insertMenu(Menu menu) {
//        try {
//            menuDao.createMenu(menu);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 메뉴 수정 */
//    public void updateMenu(Menu menu) {
//        try {
//            menuDao.updateMenu(menu);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 메뉴 삭제 */
//    public void deleteMenu(int menuId) {
//        try {
//            menuDao.deleteMenu(menuId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 정렬 기준 선택 */
//    public void selectSortCriteria(String criteria) {
//        System.out.println("정렬 기준 선택: " + criteria);
//    }
//
//    /** 리뷰 추가 */
//    public void insertReview(Review review) {
//        try {
//            reviewDao.createReview(review);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    /** 리뷰 조회 */
//    public List<Review> findMyReviewList(String userId) {
//        try {
//            return reviewDao.findReviewsByUser(userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}

