package foodie.ui;

import foodie.member.MemberServiceFunction;

import java.util.Scanner;

enum ServiceOption {TERMINATED, LOGIN, FIND_ID, SIGNUP}

public class MemberUI {
  Scanner sc = new Scanner(System.in);

  MemberServiceFunction memberServiceFunction = new MemberServiceFunction();

  private ServiceOption menu() {
    System.out.println("Welcome to Foodie");
    int number = getNumInput("[1] 로그인 [2] 아이디 찾기 [3] 회원가입 [0] 종료");
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
          break;
        case FIND_ID:
          memberServiceFunction.findId();
          break;
        case SIGNUP:
          memberServiceFunction.signUpMember();
          System.out.println("회원가입이 완료되었습니다.");
          break;
      }
    }
  }


}
