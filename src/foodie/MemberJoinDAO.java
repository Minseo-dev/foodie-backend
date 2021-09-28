package foodie;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MemberJoinDAO {
  Scanner sc = new Scanner(System.in);
  List<MemberJoinDTO> members = new ArrayList<>();

  public MemberJoinDAO() {
    members.add(new MemberJoinDTO("Superman", "1234", "New York","superman"));
    members.add(new MemberJoinDTO("Batman", "1234", "Boston","batman"));
    members.add(new MemberJoinDTO("Pororo", "1234", "Seoul","pororo"));
  }

  public void run() {
    int key = 0;
    while ((key = menu()) != 0) {
      switch (key) {
        case 1:
          Login();
          break;
        case 2:
          MemberJoin();
          break;
        case 3:
          SelectMember();
      }
    }
  }

  private void SelectMember() {
    Iterator<MemberJoinDTO> ite = members.iterator();

    while (ite.hasNext()) {
      System.out.println(ite.next() + " ");
    }

  }

  private void MemberJoin() {
    sc.nextLine();
    String id = getStrInput("ID : ");
    String pw = getStrInput("PassWord : ");
    String pw2 = getStrInput("Password Confirm : ");
    String name = getStrInput("Name : ");
    String ninkName = getStrInput("nickName : ");

    if (idCheck(id)) {
      System.out.println("중복된 ID입니다.");
    } else if (pw.equals(pw2)) {
      members.add(new MemberJoinDTO(id, pw, name,ninkName));
      System.out.println(id + "님 가입을 축하드립니다.");
    } else {
      System.out.println("비밀번호를 확인해주세요.");
    }

  }

  private boolean idCheck(String id) {
    boolean check = true;
    MemberJoinDTO member = FindById(id);
    if (member == null)
      check = false;
    return check;
  }

  private void Login() {
    sc.nextLine();
    String id = getStrInput("      ID : ");
    String pw = getStrInput("PassWord : ");

    MemberJoinDTO member = FindById(id);
    if (member == null) {
      System.out.println("등록되지 않은 ID입니다.");
    } else if (member.getPassword().equals(pw)) {
      System.out.println("[" + member.getID() + "]님께서 로그인 하셨습니다.");
    } else {
      System.out.println("비밀번호가 틀렸습니다.");
    }
  }

  private MemberJoinDTO FindById(String id) {
    for (MemberJoinDTO memberDTO : members) {
      if (memberDTO.getID().equals(id)) {
        return memberDTO;
      }
    }
    return null;
  }

  private String getStrInput(String msg) {
    System.out.println(msg);
    return sc.nextLine();
  }

  private int menu() {
    System.out.println("Welcome to Foodie");
    return getNumInput("[1]로그인 [2]회원가입 [3]전체 회원 보기 [0]종료");
  }

  private int getNumInput(String msg) {
    System.out.println(msg);
    return sc.nextInt();
  }

}


