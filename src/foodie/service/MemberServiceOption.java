package foodie.service;


import foodie.dto.MemberLoginDTO;
import foodie.dto.MemberSignUpDTO;
import foodie.dto.MemberUpdateDTO;
import foodie.exception.AuthenException;
import foodie.handler.FindRequestArgumentHandler;
import foodie.handler.LoginRequestArgumentHandler;
import foodie.handler.SignUpRequestArgumentHandler;
import foodie.dao.MemberDAO;

import java.util.Scanner;

public class MemberServiceOption {

  Scanner sc = new Scanner(System.in);

  MemberSignUpDTO signUpDTO = new MemberSignUpDTO();
  MemberLoginDTO loginDTO = new MemberLoginDTO();
  MemberUpdateDTO updateDTO = new MemberUpdateDTO();

  SignUpRequestArgumentHandler signUpRequestArgumentHandler = new SignUpRequestArgumentHandler();
  LoginRequestArgumentHandler loginRequestArgumentHandler = new LoginRequestArgumentHandler();
  FindRequestArgumentHandler findRequestArgumentHandler = new FindRequestArgumentHandler();

  MemberDAO memberDAO = new MemberDAO();

  public void loginMember() {
    try {
      System.out.print("아이디 : ");
      loginDTO.setMemberId(sc.nextLine());
      System.out.print("비밀번호 : ");
      loginDTO.setMemberPassword(sc.nextLine());

      loginRequestArgumentHandler.loginStandard(loginDTO.getMemberId(), loginDTO.getMemberPassword());

      memberDAO.loginMember(loginDTO.getMemberId(), loginDTO.getMemberPassword());
      System.out.println("로그인 성공");

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }

  }

  public void findId() {
    System.out.print("이름 : ");
    signUpDTO.setMemberName(sc.nextLine());
    System.out.print("이메일 : ");
    signUpDTO.setMemberEmail(sc.nextLine());
    memberDAO.getMemberID(signUpDTO.getMemberName(), signUpDTO.getMemberEmail());
    System.out.println();

  }

  public void findPassword() {
    String password;

    try {
      System.out.print("아이디: ");
      updateDTO.setMemberId(sc.nextLine());
      System.out.print("이름: ");
      updateDTO.setMemberName(sc.nextLine());

      findRequestArgumentHandler.findPasswordInputCheck(updateDTO.getMemberId(), updateDTO.getMemberName());

      System.out.print("수정 할 비밀번호: ");
      updateDTO.setMemberPassword(sc.nextLine());
      System.out.print("비밀번호 확인: ");
      password = sc.nextLine();

      signUpRequestArgumentHandler.passwordStandard(updateDTO.getMemberPassword(), password);

      memberDAO.updateMemberPassword(updateDTO);

      System.out.println("비밀번호가 수정되었습니다");


    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }

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

      while (checkEmail) {
        try {
          System.out.print("* 이메일 :");
          signUpDTO.setMemberEmail(sc.nextLine());

          signUpRequestArgumentHandler.emailStandard(signUpDTO.getMemberEmail());

          checkEmail = false;

        } catch (AuthenException e) {
          System.out.println(e.getMessage());
        }
      }
    }
    memberDAO.insertMember(signUpDTO);
  }



}
