package foodie.handler;

import foodie.exception.AuthenException;
import foodie.dao.MemberDaoImpl;

public class LoginRequestArgumentHandler extends Throwable {

  MemberDaoImpl memberDaoImpl = MemberDaoImpl.getInstance();

  public void loginStandard(String id,String password ) throws AuthenException {

    if (!memberDaoImpl.getMemberLoginObject(id, password)) {
      throw new AuthenException("아이디 또는 비밀번호를 잘못입력하셨습니다.");
    }
  }

}
