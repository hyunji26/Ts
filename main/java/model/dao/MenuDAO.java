package model.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.domain.Menu;
import model.domain.Restaurant;

public class MenuDAO {
    private JDBCUtil jdbcUtil = null;

    public MenuDAO() {
        jdbcUtil = new JDBCUtil();
    }

    // Insert Menu
    public int insertMenu2(Menu menu) {
        String sql = "INSERT INTO Menu (menu_id, name, price, restaurant_id, owner_id) VALUES (?, ?, ?, ?, ?)";
        Object[] params = new Object[] {
            menu.getMenuId(),
            menu.getName(),
            menu.getPrice(),
            menu.getRestaurantId(),
            menu.getOwnerId()
        };
        
        jdbcUtil.setSqlAndParameters(sql, params);
        try {
            jdbcUtil.executeUpdate();
        } catch (Exception ex) {
            jdbcUtil.rollback();
            ex.printStackTrace();
        } finally {
            jdbcUtil.commit();
            jdbcUtil.close();
        }
        return 0;
    }

    /// Insert Menu
	public boolean insertMenu(Menu menu) {

		String sql = "SELECT restaurant_id FROM Restaurant WHERE owner_id = ?";
		Object[] param = new Object[] { menu.getOwnerId() };

		jdbcUtil.setSqlAndParameters(sql, param);

		try {
			ResultSet rs = jdbcUtil.executeQuery();
			int resId = 0;

			while (rs.next()) {
				resId = rs.getInt("restaurant_id");
			}

			String insertSql = "INSERT INTO Menu (menu_id, name, price, restaurant_id, owner_id) VALUES (menu_seq.NEXTVAL, ?, ?, ?, ?)";
			Object[] params = new Object[] { menu.getName(), menu.getPrice(), resId, menu.getOwnerId() };
			jdbcUtil.setSqlAndParameters(insertSql, params);

			if(0< jdbcUtil.executeUpdate()) {
				return true;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return false;
	}

	// Delete Menu, 입력된 식당이름, 주인이름이기에 조인 필요
	public boolean deleteMenu(int menuId) {

		String sql = " DELETE FROM Menu WHERE menu_id = ? ";

		Object[] params = { menuId };
		jdbcUtil.setSqlAndParameters(sql, params);

		try {
			if (jdbcUtil.executeUpdate() > 0) {
				return true;
			}
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return false;
	}

	// Update Menu(파라미터 쿼리 수정함)
	public boolean updateMenu(String modiMenuName, int price, int menuId) {
		String sql = "UPDATE Menu SET name = ?, price = ? WHERE menu_id = ?";
		Object[] params = new Object[] { modiMenuName, price, menuId };

		jdbcUtil.setSqlAndParameters(sql, params);
		try {
			jdbcUtil.executeUpdate();
			return true;
		} catch (Exception ex) {
			jdbcUtil.rollback();
			ex.printStackTrace();
		} finally {
			jdbcUtil.commit();
			jdbcUtil.close();
		}
		return false;
	}

	// 해당 식당에 메뉴 보여주려고 select all- 사용자 로그인 된 상태로 오너 아이디랑 조인해서
	public ArrayList<Menu> selectAllRestaurantByIdWithPrice(String ownerId) {
		String sql = "SELECT NAME,MIN(PRICE) AS PRICE FROM MENU WHERE owner_id = ? GROUP BY NAME";
	    Object[] param = new Object[] {ownerId};

	    jdbcUtil.setSqlAndParameters(sql, param);

	    try {
	        ArrayList<Menu> menuList = new ArrayList<>();
	        ResultSet rs = jdbcUtil.executeQuery();

	        while (rs.next()) {
	        	Menu menu = new Menu();
	            menu.setName(rs.getString("NAME"));
	            menu.setPrice(rs.getInt("PRICE"));    // Retrieve the menu price

	            menuList.add(menu); // Add the Menu object to the list
	        }

	        return menuList; // Return the list of menus
	    } catch (Exception ex) {
	        ex.printStackTrace();
	    }

	    return null;
	}
	
	public ArrayList<Menu> selectAllRestaurantById(String ownerId) {
		// String sql = "SELECT name FROM Menu";
		String sql = "SELECT m.name , m.menu_id, m.restaurant_id " + "FROM Menu m " + "WHERE m.owner_id = ? ";

		Object[] param = new Object[] { ownerId };
		jdbcUtil.setSqlAndParameters(sql, param);
		try {

			ArrayList<Menu> menuList = new ArrayList<>();
			ResultSet rs = jdbcUtil.executeQuery();
			while (rs.next()) {

				Menu m = new Menu();
				m.setName(rs.getString("name"));
				m.setMenuId(rs.getInt("menu_id"));
				m.setRestaurantId(rs.getInt("restaurant_id"));
				
//				System.out.print(sql);
				menuList.add(m);
			}
			return menuList;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	// 메뉴 이름으로 식당 검색
	public List<Restaurant> findRestaurantList(String menu) {
		List<Restaurant> resList = new ArrayList<>();
		String sql = "SELECT r.restaurant_id, r.owner_id, r.name, r.location, r.rating " + "FROM Restaurant r "
				+ "JOIN Menu m ON r.restaurant_id = m.restaurant_id " + "WHERE m.name = ?";

		Object[] params = new Object[] { menu };

		jdbcUtil.setSqlAndParameters(sql, params);

		try {
			ResultSet rs = jdbcUtil.executeQuery(); // 결과 집합 가져오기
			while (rs.next()) {
				Restaurant restaurant = new Restaurant();
				restaurant.setRestaurantId(rs.getInt("restaurant_id"));
				restaurant.setOwnerId(rs.getString("owner_id"));
				restaurant.setName(rs.getString("name"));
				restaurant.setLocation(rs.getString("location"));
				restaurant.setRating(rs.getFloat("rating"));

				resList.add(restaurant); // 리스트에 추가
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			jdbcUtil.close(); // 항상 리소스 정리
		}

		// System.out.println(resList.size());
		return resList;
	}

	// 메뉴 아이디로 메뉴 가져오기
	public Menu SearchById(int menuId) {
		String sql = "SELECT m.name , m.menu_id, m.price " + "FROM Menu m " + "WHERE m.menu_id = ? ";

		Object[] param = new Object[] { menuId };
		jdbcUtil.setSqlAndParameters(sql, param);
		try {
			Menu m = new Menu();
			ResultSet rs = jdbcUtil.executeQuery();
			while (rs.next()) {

				m.setName(rs.getString("name"));
				m.setMenuId(rs.getInt("menu_id"));
				m.setPrice(rs.getInt("price"));
				System.out.print(sql);
			}
			return m;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}
}
