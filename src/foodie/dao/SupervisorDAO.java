package foodie.dao;

public interface SupervisorDAO {
  boolean getSupervisorLoginObject(String id, String password);

  void getMemberList();
  //int getMemberListCount();
 // void deleteMemberList(MemberLoginDTO[] memberLoginDTO);

}
