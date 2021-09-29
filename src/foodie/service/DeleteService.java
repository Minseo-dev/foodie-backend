package foodie.service;

import foodie.MemberJoinDAO;
import foodie.MemberJoinDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteService {

  public void deleteMemberID(MemberJoinDTO[] member) {
    final String query = "DELETE FROM MEMBER WHERE ID =?";

    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      for (int i = 0; i < member.length; i++) {
        if (member[i].getMemberID() == null) break;

        pstmt.setString(1, member[i].getMemberID());

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
