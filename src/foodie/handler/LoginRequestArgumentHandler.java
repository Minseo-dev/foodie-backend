package foodie.handler;

import foodie.exception.AuthenException;
import foodie.dao.MemberDAO;

public class LoginRequestArgumentHandler {

  MemberDAO memberDAO = MemberDAO.getInstance();

  public void loginStandard(String id, String password) throws AuthenException {

    if (!memberDAO.loginMember(id, password)) {
      throw new AuthenException("아이디 또는 비밀번호를 잘못입력하셨습니다.");
    }
  }

}
