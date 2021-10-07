package foodie.dto;

public class HelpCenterReportDTO {
  private String memberId;
  private String blockMemberId;
  private String report;

  public String getMemberId() {
    return memberId;
  }

  public void setMemberId(String memberId) {
    this.memberId = memberId;
  }

  public String getBlockMemberId() {
    return blockMemberId;
  }

  public void setBlockMemberId(String blockMemberId) {
    this.blockMemberId = blockMemberId;
  }

  public String getReport() {
    return report;
  }

  public void setReport(String report) {
    this.report = report;
  }
}
