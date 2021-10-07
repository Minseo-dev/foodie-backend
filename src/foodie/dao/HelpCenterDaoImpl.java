package foodie.dao;

import foodie.DBAccess;
import foodie.dto.HelpCenterReportDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HelpCenterDaoImpl implements HelpCenterDAO{

  private static HelpCenterDaoImpl instance = null;

  public static HelpCenterDaoImpl getInstance() {
    if (instance == null) {
      instance = new HelpCenterDaoImpl();
    }
    return instance;
  }


  public void addMemberReport(final HelpCenterReportDTO member) {
    final String query = "INSERT INTO SERVICECENTER VALUES (?,?,?)";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      pstmt.setString(1, member.getMemberId());
      pstmt.setString(2, member.getBlockMemberId());
      pstmt.setString(3, member.getReport());


      int retValue = pstmt.executeUpdate();
      connection.commit();
      System.out.println(retValue + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
