package foodie.main;

import foodie.exception.AuthenException;
import foodie.ui.MemberUI;

public class foodie {

  public static void main(String... args) throws AuthenException {

    //사용자 인터페이스
    MemberUI ui = new MemberUI();
    ui.run();

  }

}

