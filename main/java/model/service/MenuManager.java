package model.service;

import java.util.ArrayList;
import java.util.List;

import model.dao.MenuDAO;
import model.domain.Menu;
import model.domain.Restaurant;

public class MenuManager {
	private static MenuManager menuMan = new MenuManager();
	private MenuDAO menuDAO;
	
	public MenuManager() {
		try {
			menuDAO = new MenuDAO();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static MenuManager getInstance() {
		return menuMan;
	}
	
	public void insertMenu2(Menu menu){
		menuDAO.insertMenu2(menu);
	}
	
	// 특정 메뉴에 해당하는 레스토랑 목록 가져오기
		public List<Restaurant> findRestaurantList(String menuname) {
			try {
				return menuDAO.findRestaurantList(menuname); // DAO 호출

			} catch (Exception e) {
				// 예외 처리: 로깅하거나 사용자에게 명확한 에러 메시지 전달
				e.printStackTrace();
			}
			// 실패하면 null 반환
			return null;
		}

		// 메뉴 삭제
		public boolean deleteMenu(int menuId) {
			try {
				return (boolean) menuDAO.deleteMenu(menuId);
			} catch (Exception e) {
				return false;
			}
		}
		
		public ArrayList<Menu> selectAllRestaurantByIdWithPrice(String ownerId) {
			try {
				return menuDAO.selectAllRestaurantByIdWithPrice(ownerId);
			} catch (Exception e) {
				return null;
			}
		}

		public ArrayList<Menu> selectAllRestaurantById(String ownerId) {
			try {
				return menuDAO.selectAllRestaurantById(ownerId);
			} catch (Exception e) {
				return null;
			}
		}

		// 메뉴 수정
		public boolean updateMenu(String ModiMenuName, int price, int menuId) {
			try {
				return menuDAO.updateMenu(ModiMenuName, price, menuId);
			} catch (Exception e) {
				return false;
			}
		}

		// 삽입
		public boolean insertMenu(Menu m) {
			try {
				return menuDAO.insertMenu(m);

			} catch (Exception e) {
				return false;
			}
		}

		// 메뉴 아이디로 가져오기
		public Menu SearchById(int menuId) {
			try {
				return menuDAO.SearchById(menuId);
			} catch (Exception e) {
				return null;
			}
		}
}
