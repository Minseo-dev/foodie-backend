package foodie.service;

import foodie.MemberJoinDAO;
import foodie.exception.AuthenException;
import foodie.exception.SearchException;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectService {

  public void getMemberAll() {
    final String query = "SELECT * FROM MEMBER ORDER BY NAME";

    try (Connection connection = MemberJoinDAO.setConnection();
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

  public void getMemberID(String memberID) {
    final String query = "SELECT * FROM MEMBER WHERE ID = ?";

    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, memberID);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          System.out.println("[아이디] " + rs.getString(1));
        } else {
          System.out.println("없는 아이디 입니다.");
        }
      }


    } catch (SQLException e) {

      e.printStackTrace();
    }
  }

}
