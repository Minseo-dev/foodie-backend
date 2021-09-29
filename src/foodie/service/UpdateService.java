package foodie.service;

import foodie.MemberJoinDAO;
import foodie.MemberJoinDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateService {

  public void updateMemberInfoAll(MemberJoinDTO[] member) {
    final String query = "UPDATE MEMBER SET PASSWORD = ?, NICKNAME =? WHERE ID =?";

    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      for (int i = 0; i < member.length; i++) {
        if (member[i].getMemberID() == null) break;

        pstmt.setString(1, member[i].getMemberPassword());
        pstmt.setString(2, member[i].getMemberNickName());

        pstmt.addBatch();
        pstmt.clearParameters();
      }
      int[] retValue = pstmt.executeBatch();
      connection.commit();

      System.out.println(retValue.length + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public void updateMemberPassword(MemberJoinDTO[] member) {
    final String query = "UPDATE MEMBER SET PASSWORD = ?, NICKNAME =? WHERE ID =?";

    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      for (int i = 0; i < member.length; i++) {
        if (member[i].getMemberID() == null) break;

        pstmt.setString(1, member[i].getMemberPassword());

        pstmt.addBatch();
        pstmt.clearParameters();
      }
      int[] retValue = pstmt.executeBatch();
      connection.commit();

      System.out.println(retValue.length + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void updateMemberNickName(MemberJoinDTO[] member) {
    final String query = "UPDATE MEMBER SET NICKNAME =? WHERE ID =?";

    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      for (int i = 0; i < member.length; i++) {
        if (member[i].getMemberID() == null) break;

        pstmt.setString(1, member[i].getMemberNickName());

        pstmt.addBatch();
        pstmt.clearParameters();
      }
      int[] retValue = pstmt.executeBatch();
      connection.commit();

      System.out.println(retValue.length + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}
