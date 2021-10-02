package foodie.dto;

public class MemberSignUpDTO {
  private String memberId;
  private String memberPassword;
  private String memberName;
  private String memberNickName;
  private String memberEmail;

  public String getMemberId() {
    return memberId;
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

  public String getMemberEmail() {
    return memberEmail;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
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

  public void setMemberEmail(String memberEmail) {
    this.memberEmail = memberEmail;
  }
}