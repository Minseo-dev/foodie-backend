package foodie.service;


import foodie.Input;
import foodie.dto.MemberLoginDTO;
import foodie.dto.MemberSignUpDTO;
import foodie.dto.MemberUpdateDTO;
import foodie.exception.AuthenException;
import foodie.handler.FindRequestArgumentHandler;
import foodie.handler.LoginRequestArgumentHandler;
import foodie.handler.SignUpRequestArgumentHandler;
import foodie.dao.MemberDAO;


public class MemberServiceOption {
  private String password;

  Input input = Input.getInstance();
  MemberDAO memberDAO = MemberDAO.getInstance();


  MemberSignUpDTO signUpDTO = new MemberSignUpDTO();
  MemberLoginDTO loginDTO = new MemberLoginDTO();
  MemberUpdateDTO updateDTO = new MemberUpdateDTO();

  SignUpRequestArgumentHandler signUpRequestArgumentHandler = new SignUpRequestArgumentHandler();
  LoginRequestArgumentHandler loginRequestArgumentHandler = new LoginRequestArgumentHandler();
  FindRequestArgumentHandler findRequestArgumentHandler = new FindRequestArgumentHandler();



  public void loginMember() {
    try {
      System.out.print("아이디 : ");
      loginDTO.setMemberId(input.getString());
      System.out.print("비밀번호 : ");
      loginDTO.setMemberPassword(input.getString());

      loginRequestArgumentHandler.loginStandard(loginDTO.getMemberId(), loginDTO.getMemberPassword());

      memberDAO.loginMember(loginDTO.getMemberId(), loginDTO.getMemberPassword());
      System.out.println("로그인 성공");
      System.out.println();
    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }

  }

  public void findId() {
    System.out.print("이름 : ");
    signUpDTO.setMemberName(input.getString());
    System.out.print("이메일 : ");
    signUpDTO.setMemberEmail(input.getString());
    memberDAO.getMemberID(signUpDTO.getMemberName(), signUpDTO.getMemberEmail());
    System.out.println();

  }

  public void findPassword() {
    try {
      System.out.print("아이디: ");
      updateDTO.setMemberId(input.getString());
      System.out.print("이름: ");
      updateDTO.setMemberName(input.getString());

      findRequestArgumentHandler.findPasswordInputCheck(updateDTO.getMemberId(), updateDTO.getMemberName());

      System.out.print("수정 할 비밀번호: ");
      updateDTO.setMemberPassword(input.getString());
      System.out.print("비밀번호 확인: ");
      password = input.getString();

      signUpRequestArgumentHandler.passwordStandard(updateDTO.getMemberPassword(), password);

      memberDAO.updateMemberPassword(updateDTO);

      System.out.println("비밀번호가 수정되었습니다");
      System.out.println();

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


    while (checkId) {
      try {
        System.out.print("* 아이디 : ");
        signUpDTO.setMemberId(input.getString());
        signUpRequestArgumentHandler.checkIDStandard(signUpDTO.getMemberId());

        checkId = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    while (checkPassword) {
      try {
        System.out.print("* 비밀번호 : ");
        signUpDTO.setMemberPassword(input.getString());

        System.out.print("* 비밀번호 확인 : ");
        password = input.getString();

        signUpRequestArgumentHandler.passwordStandard(signUpDTO.getMemberPassword(), password);

        checkPassword = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }


    }

    while (checkName) {
      try {
        System.out.print("* 이름 : ");
        signUpDTO.setMemberName(input.getString());

        signUpRequestArgumentHandler.nameStandard(signUpDTO.getMemberName());

        checkName = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    while (checkNickName) {
      try {
        System.out.print("* 별명 : ");
        signUpDTO.setMemberNickName(input.getString());

        signUpRequestArgumentHandler.nickNameStandard(signUpDTO.getMemberNickName());

        checkNickName = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

      while (checkEmail) {
        try {
          System.out.print("* 이메일 :");
          signUpDTO.setMemberEmail(input.getString());

          signUpRequestArgumentHandler.emailStandard(signUpDTO.getMemberEmail());

          checkEmail = false;

        } catch (AuthenException e) {
          System.out.println(e.getMessage());
        }
      }
    }
    memberDAO.insertMember(signUpDTO);
    System.out.println("회원가입이 완료되었습니다.");
    System.out.println();
  }

  public void updateMemberPassword() {
    try {
      System.out.print("수정할 사용자 이름 : ");
      updateDTO.setMemberName(input.getString());

      findRequestArgumentHandler.findNameCheck(updateDTO.getMemberName());

      System.out.print("수정 할 비밀번호: ");
      updateDTO.setMemberPassword(input.getString());
      System.out.print("비밀번호 확인: ");
      password = input.getString();

      signUpRequestArgumentHandler.passwordStandard(updateDTO.getMemberPassword(), password);

      memberDAO.updateMemberPassword(updateDTO);

      System.out.println("비밀번호가 수정되었습니다");
      System.out.println();

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }
  }

  public void updateMemberNickName() {
    try {
      System.out.print("수정할 사용자 이름 : ");
      updateDTO.setMemberName(input.getString());

      findRequestArgumentHandler.findNameCheck(updateDTO.getMemberName());

      System.out.print("수정 할 별명: ");
      updateDTO.setMemberNickName(input.getString());

      findRequestArgumentHandler.checkDuplicateNickName(updateDTO.getMemberNickName());

      memberDAO.updateMemberNickName(updateDTO);

      System.out.println("별명이 수정되었습니다");
      System.out.println();

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }
  }
}
