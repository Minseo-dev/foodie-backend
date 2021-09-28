package foodie;

public class MemberJoinDTO {
  private String ID;
  private String Password;
  private String Name;
  private String nickName;

  public MemberJoinDTO(String id, String password,String name,String nickName){
    ID =id;
    Password =password;
    Name =name;
    this.nickName=nickName;
  }

  public String getID() {
    return ID;
  }

  public String getPassword() {
    return Password;
  }
  public String getName() {
    return Name;
  }

  public String getNickName() {
    return nickName;
  }

  public void setName(String name) {
    Name = name;
  }

  public void setID(String ID) {
    this.ID = ID;
  }

  public void setPassword(String password) {
    this.Password = password;
  }

  public void setNickName(String nickName) {
    this.nickName = nickName;
  }
}
