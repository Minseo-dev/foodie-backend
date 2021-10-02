package foodie.dto;

public class MemberSignUpDTO {
  private String memberID;
  private String memberPassword;
  private String memberName;
  private String memberNickName;

  public String getMemberID() {
    return memberID;
  }

  public String getMemberPassword() {
    return memberPassword;
  }

  public String getMemberName() {
    return memberName;
  }

  public String getMemberNickName() {
    return memberNickName;
  }

  public void setMemberID(String memberID) {
    this.memberID = memberID;
  }

  public void setMemberPassword(String memberPassword) {
    this.memberPassword = memberPassword;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }

  public void setMemberNickName(String memberNickName) {
    this.memberNickName = memberNickName;
  }
}