package foodie;


import foodie.service.SelectService;

import java.util.Scanner;

public class Member {

  Scanner sc = new Scanner(System.in);
  SelectService service = new SelectService();

  public void searchId(){
    System.out.println("검색할 아이디 입력 : ");
    String memberID = sc.next();
    service.getMemberID(memberID);
    System.out.println();
  }

}
