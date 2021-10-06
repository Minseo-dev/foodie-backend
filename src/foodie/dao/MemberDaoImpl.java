package foodie.dao;

import foodie.DBAccess;
import foodie.dto.MemberLoginDTO;
import foodie.dto.MemberSignUpDTO;
import foodie.dto.MemberUpdateDTO;

import java.sql.*;

public class MemberDaoImpl implements MemberDAO {

  private static MemberDaoImpl instance = null;

  public static MemberDaoImpl getInstance() {
    if (instance == null) {
      instance = new MemberDaoImpl();
    }
    return instance;
  }


  //회원 로그인
  public boolean getMemberLoginObject(String id, String password) {
    final String query = "SELECT ID, PASSWORD FROM MEMBER WHERE ID = ? AND PASSWORD =?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, id);
      pstmt.setString(2, password);

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

  //회원가입
  public void addMemberSignUpObject(final MemberSignUpDTO member) {
    final String query = "INSERT INTO MEMBER(ID, PASSWORD, NAME, NICKNAME,EMAIL) VALUES (?,?,?,?,?)";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      pstmt.setString(1, member.getMemberId());
      pstmt.setString(2, member.getMemberPassword());
      pstmt.setString(3, member.getMemberName());

      if (member.getMemberNickName() == null) {
        pstmt.setNull(4, Types.VARCHAR);
      } else {
        pstmt.setString(4, member.getMemberNickName());
      }
      if (member.getMemberNickName() == null) {
        pstmt.setNull(5, Types.VARCHAR);
      } else {
        pstmt.setString(5, member.getMemberEmail());
      }


      int retValue = pstmt.executeUpdate();
      connection.commit();
      System.out.println(retValue + "건의 사항이 처리되었습니다.");

    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  //회원 ID 찾기
  public String getMemberIdValue(String memberName, String memberEmail) {
    final String query = "SELECT ID FROM MEMBER WHERE NAME = ? AND EMAIL = ? ";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, memberName);
      pstmt.setString(2, memberEmail);

      try (ResultSet rs = pstmt.executeQuery()) {
        if (rs.next()) {
          System.out.print("[아이디] " + rs.getString("ID"));
        }
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  //회원 아이디 중복 찾기
  public boolean getCheckDuplicateId(String memberID) {
    final String query = "SELECT ID FROM MEMBER WHERE ID = ?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, memberID);

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

  //회원 이름 중복 찾기
  public boolean getCheckDuplicateName(String memberName) {
    final String query = "SELECT NAME FROM MEMBER WHERE NAME = ?  ";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, memberName);

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

  //중복 별명 찾기
  public boolean getCheckDuplicateNickName(String memberNickName) {
    final String query = "SELECT NICKNAME FROM MEMBER WHERE NICKNAME = ?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, memberNickName);

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

  //중복 비밀번호 찾기
  public boolean getCheckDuplicatePassword(String memberPassword) {
    final String query = "SELECT PASSWORD FROM MEMBER WHERE PASSWORD = ?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {

      pstmt.setString(1, memberPassword);

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


  //회원 비밀번호 수정
  public void editMemberPasswordObject(MemberUpdateDTO member) {
    final String query = "UPDATE MEMBER SET PASSWORD = ? WHERE NAME  =?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);

      pstmt.setString(1, member.getMemberPassword());
      pstmt.setString(2, member.getMemberName());


      pstmt.executeUpdate();

      connection.commit();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  //회원 별명 수정
  public void editMemberNickNameObject(final MemberUpdateDTO member) {
    final String query = "UPDATE MEMBER SET NICKNAME =? WHERE NAME =?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);


      pstmt.setString(1, member.getMemberNickName());
      pstmt.setString(2, member.getMemberName());

      pstmt.executeUpdate();
      connection.commit();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  //회원삭제
  public void deleteMemberObject(MemberLoginDTO member) {
    final String query = "DELETE FROM MEMBER WHERE ID =? AND PASSWORD = ?";

    try (Connection connection = DBAccess.setConnection();
         PreparedStatement pstmt = connection.prepareStatement(query)) {
      connection.setAutoCommit(false);


      pstmt.setString(1, member.getMemberId());
      pstmt.setString(2, member.getMemberPassword());

      pstmt.executeUpdate();
      connection.commit();

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}



