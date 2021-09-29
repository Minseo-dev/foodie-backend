package foodie.ui;

import foodie.exception.AuthenException;
import foodie.member.Member;

import java.util.Scanner;

public class MemberUI {
  Scanner sc = new Scanner(System.in);
  Member member = new Member();

  private int menu() {
    System.out.println("Welcome to Foodie");
    return getNumInput("[1] 로그인 [2] 회원가입 [0] 종료");
  }

  private int getNumInput(String msg) {
    System.out.println(msg);
    return sc.nextInt();
  }

  public void run() throws AuthenException {
    int key = 0;
    while ((key = menu()) != 0) {
      switch (key) {
        case 1:
          member.searchId();
          break;
        case 2:
          member.memberJoin();
          break;
      }
    }
  }

}
