package foodie.handler;

import foodie.dao.MemberDAO;
import foodie.exception.AuthenException;

public class FindRequestArgumentHandler {
  MemberDAO memberDAO = MemberDAO.getInstance();

  public void findPasswordInputCheck(String id, String name) throws AuthenException {

    if (!memberDAO.duplicateCheckID(id) || !memberDAO.duplicateCheckName(name)) {
      throw new AuthenException("아이디 또는 이름을 잘못입력하셨습니다.");
    }

  }

  public void findNameCheck(String name) throws AuthenException {
    if (!memberDAO.duplicateCheckName(name))
      throw new AuthenException("존재하지 않는 사용자입니다.");
  }

  public void checkDuplicateNickName(String nickName) throws AuthenException {
    if (memberDAO.duplicateCheckNickName(nickName))
      throw new AuthenException("이미 있는 별명입니다.");
  }

}
