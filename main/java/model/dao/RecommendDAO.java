package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자 관리를 위해 데이터베이스 작업을 전담하는 DAO 클래스
 * USERINFO 테이블에 사용자 정보를 추가, 수정, 삭제, 검색 수행 
 */
public class RecommendDAO {
   private JDBCUtil jdbcUtil = null;
   
   public RecommendDAO() {         
      jdbcUtil = new JDBCUtil();      // JDBCUtil 객체 생성
   }
      
   /**
    * 사용자 관리 테이블에 새로운 사용자 생성.
    */
   public List<String> findRecommendList(int studentId) throws SQLException {
      String sql = 
             "SELECT MENU_NAME " +
             "FROM ( " +
             "    SELECT MENU_NAME, COUNT(*) AS SEARCH_COUNT " +
             "    FROM RECOMMEND " +
             "    WHERE STUDENT_ID = ? " + 
             "    GROUP BY MENU_NAME " +
             "    ORDER BY COUNT(*) DESC " +
             ") " +
             "WHERE ROWNUM <= 3";


      
      jdbcUtil.setSqlAndParameters(sql,new Object[] { studentId });   
                  
       List<String> menuList = new ArrayList<>(); // 메뉴 이름을 저장할 리스트
          try {
              ResultSet rs = jdbcUtil.executeQuery(); // 쿼리 실행
              while (rs.next()) {
                  // ResultSet에서 menu_name 컬럼 값을 가져와 리스트에 추가
                  menuList.add(rs.getString("menu_name"));
              }
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 반환
      }      
      return menuList;         
   }
}