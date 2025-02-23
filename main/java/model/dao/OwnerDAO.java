package model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.domain.Owner;

public class OwnerDAO {

   private JDBCUtil jdbcUtil = null;
   //기본 생성자 
   public OwnerDAO() {
      jdbcUtil = new JDBCUtil();
   }
   //새로운 회원 삽입
   public int insert(String ownerId,String pwd) {
       String sql = "INSERT INTO OWNERUSER (OWNER_ID,PASSWORD) VALUES (?, ?)";
       Object[] param = new Object[] { ownerId,pwd };
             
       jdbcUtil.setSqlAndParameters(sql, param);
       try {
           jdbcUtil.executeUpdate();  // insert 문 실행
       } catch (Exception ex) {
           jdbcUtil.rollback();
           ex.printStackTrace();
       } finally {
           jdbcUtil.commit();
           jdbcUtil.close();   // resource 배환
       }
       return 0;
   }
   public int insert2(Owner  newOnr) {

      String sql = "INSERT INTO OwnerUser (ownerId, name, password) VALUES (?, ?, ?)";
       Object[] param = new Object[] { newOnr.getOwnerId(), newOnr.getName(), newOnr.getPassword() };   
   
      jdbcUtil.setSqlAndParameters(sql, param);
      try {    
         jdbcUtil.executeUpdate();  // insert 문 실행
       
         
      } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 반환
      }
      return 0;
   }
   
   //비밀번호 변경(아이디, 이름 변경 불가하니까 비밀번호만)  
   public int updatePassword(String id, String pwd) {
      
      String sql = "UPDATE OwnerUser SET password = ? WHERE owner_Id = ?";
      Object[] param = new Object[] {id, pwd};      
   
      jdbcUtil.setSqlAndParameters(sql, param);
      
      try {    
         jdbcUtil.executeUpdate();  // update 문 실행
       } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 반환
      }      
      return 0;
   }
   
   //id로 회원 삭제 
   public int delete(String id) {
      String sql = "DELETE FROM OwnerUser WHERE owner_id= ?";
      Object[] param = new Object[] {id};      
   
      jdbcUtil.setSqlAndParameters(sql, param);
      
      try {    
         jdbcUtil.executeUpdate();  // delete 문 실행
       } catch (Exception ex) {
         jdbcUtil.rollback();
         ex.printStackTrace();
      } finally {      
         jdbcUtil.commit();
         jdbcUtil.close();   // resource 반환
      }      
      return 0;
   }
   
   //id 중복 검사 
   public boolean existingId(String id) throws SQLException {
      String sql = "SELECT owner_id FROM OwnerUser WHRE owner_id=?";      
      jdbcUtil.setSqlAndParameters(sql, new Object[] {id});   // JDBCUtil에 query문과 매개 변수 설정

      try {
         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
         if (rs.next()) {
            int count = rs.getInt(1);
            return (count == 1 ? true : false);
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      // resource 반환
      }
      return false;
   }
   public Owner findUser(String ownerId) throws SQLException {
       String sql = "SELECT NAME,PASSWORD,OWNER_ID "
                + "FROM OWNERUSER "
                + "WHERE OWNER_ID=? ";              
      jdbcUtil.setSqlAndParameters(sql, new Object[] {ownerId});   // JDBCUtil에 query문과 매개 변수 설정

      try {
         ResultSet rs = jdbcUtil.executeQuery();      // query 실행
         if (rs.next()) {                  // 학생 정보 발견
            Owner owner = new Owner(      // User 객체를 생성하여 학생 정보를 저장
                  rs.getString("NAME"),
                  rs.getString("PASSWORD").trim(),
                  ownerId);
            return owner;
         }
      } catch (Exception ex) {
         ex.printStackTrace();
      } finally {
         jdbcUtil.close();      // resource 반환
      }
      return null;
   }
}