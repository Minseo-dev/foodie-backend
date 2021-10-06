package foodie.dto;

public class MemberUpdateDTO {
  private String memberId;
  private String memberPassword;
  private String memberName;
  private String memberNickName;


  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getMemberName() {
    return memberName;
  }

  public void setMemberName(String memberName) {
    this.memberName = memberName;
  }


  public String getMemberPassword() {
    return memberPassword;
  }

  public void setMemberPassword(String memberPassword) {
    this.memberPassword = memberPassword;
  }

  public String getMemberNickName() {
    return memberNickName;
  }

  public void setMemberNickName(String memberNickName) {
    this.memberNickName = memberNickName;
  }
}
