package foodie.service;

import foodie.MemberJoinDAO;
import foodie.MemberJoinDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class InsertService {

  public void insertMember(final MemberJoinDTO member) {
    final String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, NICKNAME) VALUES (?,?,?,?)";

    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      pstmt.setString(1, member.getMemberID());
      pstmt.setString(2, member.getMemberPassword());
      pstmt.setString(3, member.getMemberName());

      if (member.getMemberNickName() == null) {
        pstmt.setNull(4, Types.VARCHAR);
      } else {
        pstmt.setString(4, member.getMemberNickName());
      }


      int retValue = pstmt.executeUpdate();
      connection.commit();
      System.out.println(retValue + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

}