package foodie.service;

import foodie.MemberJoinDAO;
import foodie.MemberJoinDTO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class InsertService {

  public void insertMember(MemberJoinDTO[] member) {
    final String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, NICKNAME) VALUSE (?,?,?)";
    try (Connection connection = MemberJoinDAO.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      for (int i = 0; i < member.length; i++) {
        if (member[i].getMemberID() == null && member[i].getMemberPassword()==null&&member[i].getMemberName()==null) break;

        pstmt.setString(1,member[i].getMemberID());
        pstmt.setString(2,member[i].getMemberPassword());

        if(member[i].getMemberNickName()==null){
          pstmt.setNull(3, Types.VARCHAR);
        }else{
          pstmt.setString(3,member[i].getMemberNickName());
        }

        pstmt.addBatch();
        pstmt.clearParameters();
      }
      int[] retValue = pstmt.executeBatch();
      connection.commit();
      System.out.println(retValue.length +"건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
