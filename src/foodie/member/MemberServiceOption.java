package foodie.member;


import foodie.dto.MemberLoginDTO;
import foodie.dto.MemberSignUpDTO;
import foodie.exception.AuthenException;
import foodie.handler.LoginRequestArgumentHandler;
import foodie.handler.SignUpRequestArgumentHandler;
import foodie.service.MemberDAO;

import java.util.Scanner;

public class MemberServiceOption {

  Scanner sc = new Scanner(System.in);

  MemberSignUpDTO signUpDTO = new MemberSignUpDTO();
  MemberLoginDTO loginDTO = new MemberLoginDTO();

  SignUpRequestArgumentHandler signUpRequestArgumentHandler = new SignUpRequestArgumentHandler();
  LoginRequestArgumentHandler loginRequestArgumentHandler = new LoginRequestArgumentHandler();

  MemberDAO memberDAO = new MemberDAO();

  public void loginMember() {
    try {
      System.out.print("아이디 : ");
      loginDTO.setMemberId(sc.nextLine());
      System.out.print("비밀번호 : ");
      loginDTO.setMemberPassword(sc.nextLine());

      loginRequestArgumentHandler.loginStandard(loginDTO.getMemberId(), loginDTO.getMemberPassword());

      memberDAO.loginMember(loginDTO.getMemberId(), loginDTO.getMemberPassword());

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }

  }

  public void findId() {
    System.out.print("검색할 아이디 입력 : ");
    String memberID = sc.next();
    memberDAO.getMemberID(memberID);
    System.out.println();

  }

  public void findPassword() {

  }

  public void signUpMember() {
    boolean checkId = true;
    boolean checkPassword = true;
    boolean checkName = true;
    boolean checkNickName = true;
    boolean checkEmail = true;

    String password;



    while (checkId) {
      try {
        System.out.print("* 아이디 : ");
        signUpDTO.setMemberId(sc.nextLine());
        signUpRequestArgumentHandler.checkIDStandard(signUpDTO.getMemberId());

        checkId = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    while (checkPassword) {
      try {
        System.out.print("* 비밀번호 : ");
        signUpDTO.setMemberPassword(sc.nextLine());

        System.out.print("* 비밀번호 확인 : ");
        password = sc.nextLine();

        signUpRequestArgumentHandler.passwordStandard(signUpDTO.getMemberPassword(), password);

        checkPassword = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }


    }

    while (checkName) {
      try {
        System.out.print("* 이름 : ");
        signUpDTO.setMemberName(sc.nextLine());

        signUpRequestArgumentHandler.nameStandard(signUpDTO.getMemberName());

        checkName = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    while (checkNickName) {
      try {
        System.out.print("* 별명 : ");
        signUpDTO.setMemberNickName(sc.nextLine());

        signUpRequestArgumentHandler.nickNameStandard(signUpDTO.getMemberNickName());

        checkNickName = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

      while (checkEmail){
        try {
          System.out.print("* 이메일 :");
          signUpDTO.setMemberEmail(sc.nextLine());

          signUpRequestArgumentHandler.emailStandard(signUpDTO.getMemberEmail());

          checkEmail=false;

        }catch (AuthenException e){
          System.out.println(e.getMessage());
        }
      }
    }
    memberDAO.insertMember(signUpDTO);
  }

//  public void updateInfo() {
//
//    try {
//      System.out.print("수정 할 비밀번호 : ");
//      dto.setMemberPassword(sc.nextLine());
//
//      System.out.print("수정 할 별명: ");
//
//
//      if (result != 0)
//
//        System.out.println("회원정보가 수정되었습니다");
//
//      else
//
//        System.out.println("회원정보수정에 실패했습니다");
//
//
//    } catch (Exception e) {
//
//      System.out.println(e.toString());
//
//    }
//
//
//  }

}
