package foodie.dao;

import foodie.dto.MemberLoginDTO;
import foodie.dto.MemberSignUpDTO;
import foodie.dto.MemberUpdateDTO;

public interface MemberDAO {

  void addMemberSignUpObject(MemberSignUpDTO memberSignUpDTO);

  boolean getMemberLoginObject(String id,String password);
  String getMemberIdValue(String name, String email);
  boolean getCheckDuplicateId(String id);
  boolean getCheckDuplicatePassword(String password);
  boolean getCheckDuplicateName(String name);
  boolean getCheckDuplicateNickName(String nickName);

  void editMemberPasswordObject(MemberUpdateDTO memberUpdateDTO);
  void editMemberNickNameObject(MemberUpdateDTO memberUpdateDTO);

  void deleteMemberObject(MemberLoginDTO memberLoginDTO);

}
