package foodie.dao;

import foodie.DBAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SupervisorDaoImpl implements SupervisorDAO {
  private static SupervisorDaoImpl instance = null;

  public static SupervisorDaoImpl getInstance() {
    if (instance == null) {
      instance = new SupervisorDaoImpl();
    }
    return instance;
  }

  public boolean getSupervisorLoginObject(String supervisorId, String supervisorPassword) {
    final String query = "SELECT ID, PASSWORD FROM MEMBER WHERE ID = ? AND PASSWORD =?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, supervisorId);
      pstmt.setString(2, supervisorPassword);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          return true;
        }
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  //회원 전체 출력
  public void getMemberList() {
    final String query = "SELECT * FROM MEMBER ORDER BY NAME";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query);
         ResultSet rs = pstmt.executeQuery()) {

      while (rs.next()) {
        System.out.print("[아이디] " + rs.getString(1) + " || ");
        System.out.print("[비밀번호] " + rs.getString(2) + " || ");
        System.out.print("[이름] " + rs.getString(3) + " || ");
        System.out.println("[별명] " + rs.getString(4));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void deleteMemberList() {
    final String query = "DELETE FROM SERVICECENTER ";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      int retValue = pstmt.executeUpdate();
      connection.commit();

      System.out.println(retValue + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

//  //회원 일괄 삭제
//  public void deleteMemberList(SupervisorDeleteDTO[] member) {
//    final String query = "DELETE FROM SERVICECENTER WHERE BLOCK_ID = ?";
//
//    try (Connection connection = DBAccess.setConnection();
//         PreparedStatement pstmt = connection.prepareStatement(query)) {
//      connection.setAutoCommit(false);
//
//      for (int i = 0; i < member.length; i++) {
//        if (member[i].getMemberId() == null) break;
//
//
//        pstmt.addBatch();
//        pstmt.clearParameters();
//      }
//
//      int[] retValue = pstmt.executeBatch();
//      connection.commit();
//
//      System.out.println(retValue.length + "건의 사항이 처리되었습니다.");
//
//    } catch (SQLException e) {
//      e.printStackTrace();
//    }
//  }

}
