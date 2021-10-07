package foodie.handler;

import foodie.dao.MemberDaoImpl;
import foodie.exception.AuthenException;

public class FindRequestArgumentHandler extends Throwable {
  MemberDaoImpl memberDaoImpl = MemberDaoImpl.getInstance();

  public void checkInputPassword(String id, String name) throws AuthenException {
    if (!memberDaoImpl.getCheckDuplicateId(id) || !memberDaoImpl.getCheckDuplicateName(name)) {
      throw new AuthenException("아이디 또는 이름을 잘못입력하셨습니다.");
    }
  }

  public void checkDuplicateName(String name) throws AuthenException {
    if (!memberDaoImpl.getCheckDuplicateName(name))
      throw new AuthenException("존재하지 않는 사용자입니다.");
  }

  public void checkDuplicateNickName(String nickName) throws AuthenException {
    if (memberDaoImpl.getCheckDuplicateNickName(nickName))
      throw new AuthenException("이미 있는 별명입니다.");
  }

  public void checkDuplicateId(String id) throws AuthenException{
    if(memberDaoImpl.getCheckDuplicateId(id))
      throw new AuthenException("존재하지 않는 사용자입니다.");
  }

  public void checkDuplicateMember(String id, String password) throws AuthenException {
    if (!memberDaoImpl.getCheckDuplicateId(id) || !memberDaoImpl.getCheckDuplicatePassword(password)) {
      throw new AuthenException("존재하지 않는 사용자입니다.");
    }
  }

}
