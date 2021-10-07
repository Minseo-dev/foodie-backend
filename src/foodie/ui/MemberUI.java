package foodie.ui;

import foodie.Input;
import foodie.service.HelpCenter;
import foodie.service.MemberServiceOption;


enum ServiceOption {TERMINATED, LOGIN, FIND_ID, FIND_PASSWORD, SIGNUP, DELETE}

enum UpdateOption {TERMINATED, PASSWORD, NICKNAME, REPORT}

public class MemberUI {
  Input input = Input.getInstance();

  MemberServiceOption memberServiceOption = new MemberServiceOption();
  HelpCenter helpCenter = new HelpCenter();

  private ServiceOption menu() {
    System.out.println("Welcome to Foodie");
    String number = getNumInput("[1] 로그인 [2] 아이디 찾기 [3] 비밀번호 찾기 [4] 회원가입 [5] 탈퇴 [0] 종료");
    return ServiceOption.values()[Integer.parseInt(number)];
  }

  private String getNumInput(String msg) {
    System.out.println(msg);
    return input.getNumber();
  }

  public void run() {
    ServiceOption serviceOption = null;
    while (serviceOption != ServiceOption.TERMINATED) {
      serviceOption = menu();
      switch (serviceOption) {
        case LOGIN:
          memberServiceOption.loginMember();
          updateProfile();
          break;
        case FIND_ID:
          memberServiceOption.findId();
          break;
        case FIND_PASSWORD:
          memberServiceOption.findPassword();
          break;
        case SIGNUP:
          memberServiceOption.signUpMember();
          break;
        case DELETE:
          memberServiceOption.deleteMember();
          break;
      }
    }
  }

  public void updateProfile() {

    UpdateOption updateOption = null;

    while (updateOption != UpdateOption.TERMINATED) {
      System.out.println("----- 회원정보 수정 -----");
      String number = getNumInput("[1] 비밀번호 변경 [2] 별명 변경 [3] 신고 [0] 종료");
      updateOption = UpdateOption.values()[Integer.parseInt(number)];
      switch (updateOption) {
        case PASSWORD:
          memberServiceOption.updateMemberPassword();
          break;
        case NICKNAME:
          memberServiceOption.updateMemberNickName();
          break;
        case REPORT:
          helpCenter.addReportMember();
      }
    }
  }

}
