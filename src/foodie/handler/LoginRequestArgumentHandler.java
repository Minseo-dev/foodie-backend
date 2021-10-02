package foodie.handler;

import foodie.exception.AuthenException;
import foodie.service.MemberDAO;

public class LoginRequestArgumentHandler {

  MemberDAO memberDAO = new MemberDAO();

  public void loginStandard(String id, String password) throws AuthenException {

    if (memberDAO.loginMember(id, password) == false) {
      throw new AuthenException("아이디 또는 비밀번호를 잘못입력하셨습니다.");
    }
  }

}
