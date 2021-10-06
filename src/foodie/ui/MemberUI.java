package foodie.ui;


import foodie.service.MemberServiceOption;

import java.util.Scanner;

enum ServiceOption {TERMINATED, LOGIN, FIND_ID, FIND_PASSWORD, SIGNUP}

enum UpdateOption {TERMINATED, PASSWORD, NICKNAME}

public class MemberUI {
  Scanner sc = new Scanner(System.in);

  MemberServiceOption memberServiceOption = new MemberServiceOption();

  private ServiceOption menu() {
    System.out.println("Welcome to Foodie");
    int number = getNumInput("[1] 로그인 [2] 아이디 찾기 [3] 비밀번호 찾기 [4] 회원가입 [0] 종료");
    return ServiceOption.values()[number];
  }

  private int getNumInput(String msg) {
    System.out.println(msg);
    return sc.nextInt(); //nextInt 문제 많음
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
      }
    }
  }

  public void updateProfile() {

    UpdateOption updateOption = null;

    while (updateOption != UpdateOption.TERMINATED) {
      System.out.println("----- 회원정보 수정 -----");
      int number = getNumInput("[1] 비밀번호 변경 [2] 별명 변경 [0] 종료");
      updateOption = UpdateOption.values()[number];
      switch (updateOption) {
        case PASSWORD:
          memberServiceOption.updateMemberPassword();
          break;
        case NICKNAME:
          memberServiceOption.updateMemberNickName();
          break;
      }
    }
  }

}
