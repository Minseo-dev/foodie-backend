package foodie.handler;

import foodie.dao.MemberDAO;
import foodie.exception.AuthenException;

public class FindRequestArgumentHandler {
  MemberDAO memberDAO = new MemberDAO();

  public void findPasswordInputCheck(String id, String name) throws AuthenException {

    if (!memberDAO.duplicateCheckID(id) || !memberDAO.duplicateCheckName(name)) {
      throw new AuthenException("아이디 또는 이름을 잘못입력하셨습니다.");
    }

  }

}
