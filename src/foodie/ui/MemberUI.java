package foodie.ui;

import foodie.member.MemberServiceOption;

import java.util.Scanner;

enum ServiceOption {TERMINATED, LOGIN, FIND_ID, FIND_PASSWORD, SIGNUP}

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
          System.out.println("로그인 성공");
          break;
        case FIND_ID:
          memberServiceOption.findId();
          break;
        case FIND_PASSWORD:
          memberServiceOption.findPassword();
          break;
        case SIGNUP:
          memberServiceOption.signUpMember();
          System.out.println("회원가입이 완료되었습니다.");
          break;
      }
    }
  }


}
