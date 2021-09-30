package foodie.member;


import foodie.MemberJoinDTO;
import foodie.exception.AuthenException;
import foodie.handler.JoinReguestArgumentHandler;
import foodie.service.InsertService;
import foodie.service.SelectService;

import java.util.Scanner;

public class Member {

  Scanner sc = new Scanner(System.in);

  MemberJoinDTO dto = new MemberJoinDTO();
  JoinReguestArgumentHandler joinReguestArgumentHandler = new JoinReguestArgumentHandler();

  SelectService selectService = new SelectService();
  InsertService insertService = new InsertService();

  public void searchId() {
    System.out.print("검색할 아이디 입력 : ");
    String memberID = sc.next();
    selectService.getMemberID(memberID);
    System.out.println();

  }

  public void memberJoin() {
    boolean id = true;
    boolean password = true;
    boolean name = true;
    boolean nickName = true;

    String password2;

    while (id) {
      try {
        System.out.print("* 아이디 : ");
        dto.setMemberID(sc.nextLine());
        joinReguestArgumentHandler.idStandard(dto.getMemberID());

        id = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    while (password) {
      try {
        System.out.print("* 비밀번호 : ");
        dto.setMemberPassword(sc.nextLine());

        System.out.print("* 비밀번호 확인 : ");
        password2 = sc.nextLine();

        joinReguestArgumentHandler.passwordStandard(dto.getMemberPassword(), password2);

        password = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }


    }

    while (name) {
      try {
        System.out.print("* 이름 : ");
        dto.setMemberName(sc.nextLine());

        joinReguestArgumentHandler.nameStandard(dto.getMemberName());

        name = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    while (nickName) {
      try {
        System.out.print("* 별명 : ");
        dto.setMemberNickName(sc.nextLine());

        joinReguestArgumentHandler.nickNameStandard(dto.getMemberNickName());

        nickName = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }
    insertService.insertMember(dto);
  }

}
