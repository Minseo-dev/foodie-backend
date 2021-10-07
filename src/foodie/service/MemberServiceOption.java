package foodie.service;


import foodie.Input;
import foodie.dto.MemberLoginDTO;
import foodie.dto.MemberSignUpDTO;
import foodie.dto.MemberUpdateDTO;
import foodie.exception.AuthenException;
import foodie.handler.FindRequestArgumentHandler;
import foodie.handler.LoginRequestArgumentHandler;
import foodie.handler.SignUpRequestArgumentHandler;
import foodie.dao.MemberDaoImpl;


public class MemberServiceOption {
  private String password;

  Input input = Input.getInstance();
  MemberDaoImpl memberDaoImpl = MemberDaoImpl.getInstance();


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

      memberDaoImpl.getMemberLoginObject(loginDTO.getMemberId(), loginDTO.getMemberPassword());
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
    memberDaoImpl.getMemberIdValue(signUpDTO.getMemberName(), signUpDTO.getMemberEmail());
    System.out.println();

  }

  public void findPassword() {
    try {
      System.out.print("아이디: ");
      updateDTO.setMemberId(input.getString());
      System.out.print("이름: ");
      updateDTO.setMemberName(input.getString());

      findRequestArgumentHandler.checkInputPassword(updateDTO.getMemberId(), updateDTO.getMemberName());

      System.out.print("수정 할 비밀번호: ");
      updateDTO.setMemberPassword(input.getString());
      System.out.print("비밀번호 확인: ");
      password = input.getString();

      signUpRequestArgumentHandler.passwordStandard(updateDTO.getMemberPassword(), password);

      memberDaoImpl.editMemberPasswordObject(updateDTO);

      System.out.println("비밀번호가 수정되었습니다");
      System.out.println();

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }

  }


  public void signUpMember() {
    boolean checkSignUp = true;


    while (checkSignUp) {
      try {
        System.out.print("* 아이디 : ");
        signUpDTO.setMemberId(input.getString());
        signUpRequestArgumentHandler.checkIDStandard(signUpDTO.getMemberId());

        System.out.print("* 비밀번호 : ");
        signUpDTO.setMemberPassword(input.getString());
        System.out.print("* 비밀번호 확인 : ");
        password = input.getString();
        signUpRequestArgumentHandler.passwordStandard(signUpDTO.getMemberPassword(), password);


        System.out.print("* 이름 : ");
        signUpDTO.setMemberName(input.getString());
        signUpRequestArgumentHandler.nameStandard(signUpDTO.getMemberName());

        System.out.print("* 별명 : ");
        signUpDTO.setMemberNickName(input.getString());
        signUpRequestArgumentHandler.nickNameStandard(signUpDTO.getMemberNickName());


        System.out.print("* 이메일 :");
        signUpDTO.setMemberEmail(input.getString());
        signUpRequestArgumentHandler.emailStandard(signUpDTO.getMemberEmail());

        checkSignUp = false;

      } catch (AuthenException e) {
        System.out.println(e.getMessage());
      }

    }

    memberDaoImpl.addMemberSignUpObject(signUpDTO);
    System.out.println("회원가입이 완료되었습니다.");
    System.out.println();
  }

  public void updateMemberPassword() {
    try {
      System.out.print("수정할 사용자 이름 : ");
      updateDTO.setMemberName(input.getString());

      findRequestArgumentHandler.checkDuplicateName(updateDTO.getMemberName());

      System.out.print("수정 할 비밀번호: ");
      updateDTO.setMemberPassword(input.getString());
      System.out.print("비밀번호 확인: ");
      password = input.getString();

      signUpRequestArgumentHandler.passwordStandard(updateDTO.getMemberPassword(), password);

      memberDaoImpl.editMemberPasswordObject(updateDTO);

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

      findRequestArgumentHandler.checkDuplicateName(updateDTO.getMemberName());

      System.out.print("수정 할 별명: ");
      updateDTO.setMemberNickName(input.getString());

      findRequestArgumentHandler.checkDuplicateNickName(updateDTO.getMemberNickName());

      memberDaoImpl.editMemberNickNameObject(updateDTO);

      System.out.println("별명이 수정되었습니다");
      System.out.println();

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }
  }

  public void deleteMember() {
    try {
      System.out.print("탈퇴할 사용자 아이디: ");
      loginDTO.setMemberId(input.getString());

      System.out.print("탈퇴할 사용자 비밀번호: ");
      loginDTO.setMemberPassword(input.getString());

      findRequestArgumentHandler.checkDuplicateMember(loginDTO.getMemberId(), loginDTO.getMemberPassword());

      memberDaoImpl.deleteMemberObject(loginDTO);
      System.out.println("탈퇴가 완료되었습니다..");


    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }
  }

}
