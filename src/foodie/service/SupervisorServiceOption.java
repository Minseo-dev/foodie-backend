package foodie.service;

import foodie.Input;
import foodie.dao.SupervisorDaoImpl;
import foodie.dto.SupervisorLoginDTO;
import foodie.exception.AuthenException;
import foodie.handler.LoginRequestArgumentHandler;

public class SupervisorServiceOption {
  Input input = Input.getInstance();
  SupervisorDaoImpl supervisorDaoImpl = SupervisorDaoImpl.getInstance();
  SupervisorLoginDTO loginDTO = new SupervisorLoginDTO();

  LoginRequestArgumentHandler loginRequestArgumentHandler = new LoginRequestArgumentHandler();

  public void supervisorLogin() {
    try {
      System.out.print("아이디 : ");
      loginDTO.setSupervisorID(input.getString());
      System.out.print("비밀번호 : ");
      loginDTO.setSupervisorPassword(input.getString());
      loginRequestArgumentHandler.loginStandard(loginDTO.getSupervisorID(), loginDTO.getSupervisorPassword());

      supervisorDaoImpl.getSupervisorLoginObject(loginDTO.getSupervisorID(), loginDTO.getSupervisorPassword());
      System.out.println("로그인 성공");

    } catch (AuthenException e) {
      System.out.println(e.getMessage());
    }
  }

  public void getMemberList(){
    supervisorDaoImpl.getMemberList();
    System.out.println();
  }

  public void deleteMemberList(){

    supervisorDaoImpl.deleteMemberList();

  }
}
