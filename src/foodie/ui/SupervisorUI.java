package foodie.ui;

import foodie.Input;
import foodie.service.SupervisorServiceOption;

enum SupervisorOption {TERMINATED, LOGIN}

enum WorkOption {TERMINATED, SELECT_MEMBER_ALL, DELETE_MEMBER}

public class SupervisorUI {
  Input input = Input.getInstance();
  SupervisorServiceOption supervisorServiceOption = new SupervisorServiceOption();

  private SupervisorOption menu() {
    System.out.println("----- Supervisor mode ------");
    String number = getNumInput("[1] 로그인 [0] 종료");
    return SupervisorOption.values()[Integer.parseInt(number)];
  }

  private String getNumInput(String msg) {
    System.out.println(msg);
    return input.getNumber();
  }

  public void run() {
    SupervisorOption supervisorOption = null;
    while (supervisorOption != SupervisorOption.TERMINATED) {
      supervisorOption = menu();
      switch (supervisorOption) {
        case LOGIN:
          supervisorServiceOption.supervisorLogin();
          work();
          break;
      }
    }
  }
  public void work() {
    WorkOption workOption = null;

    while (workOption != WorkOption.TERMINATED) {
      System.out.println("----- Work mode ------");
      String number = getNumInput("[1] 로그인 [0] 종료");
      workOption=WorkOption.values()[Integer.parseInt(number)];

      switch (workOption) {
        case SELECT_MEMBER_ALL:
          supervisorServiceOption.getMemberList();
          break;
        case DELETE_MEMBER:
          supervisorServiceOption.deleteMemberList();
          break;
      }
    }
  }
}
