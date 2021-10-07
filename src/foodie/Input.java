package foodie;

import java.util.Scanner;

public class Input {
  private static Input instance = null;

  private Scanner scanner;

  private Input() {
    scanner = new Scanner(System.in);
  }

  public static Input getInstance() {
    if (instance == null) {
      instance = new Input();
    }
    return instance;
  }

  public String getNumber() {
    while (!scanner.hasNextInt()) {
      System.out.println("숫자를 입력해주세요");
    }
    return scanner.nextLine();
  }

  public String getString() {
    String sInput = scanner.nextLine();
    scanner.reset();
    return sInput;
  }

}
