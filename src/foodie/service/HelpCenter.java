package foodie.service;

import foodie.Input;
import foodie.dao.HelpCenterDaoImpl;
import foodie.dto.HelpCenterReportDTO;
import foodie.exception.AuthenException;
import foodie.handler.FindRequestArgumentHandler;

public class HelpCenter {
  Input input = Input.getInstance();
  HelpCenterDaoImpl helpCenterDao = HelpCenterDaoImpl.getInstance();

  HelpCenterReportDTO ReportDTO = new HelpCenterReportDTO();
  FindRequestArgumentHandler findRequestArgumentHandler = new FindRequestArgumentHandler();

  public void addReportMember() {

    try {
      System.out.print("본인 아이디");
      ReportDTO.setMemberId(input.getString());
      System.out.print("신고할 아이디: ");
      ReportDTO.setBlockMemberId(input.getString());
      System.out.print("신고 사유: ");
      ReportDTO.setReport(input.getString());

      findRequestArgumentHandler.checkDuplicateId(ReportDTO.getBlockMemberId());
      helpCenterDao.addMemberReport(ReportDTO);

    } catch (AuthenException e) {
      e.getMessage();
    }


  }
}
