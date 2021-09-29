package foodie.exception;

import foodie.exception.AuthenException;

import java.util.regex.Pattern;

public class JoinException {

  public void idStandard(String str) throws AuthenException {

    if (str.length() < 0 || str.length() > 20) {
      throw new AuthenException("3자~18자 이내의 아이디만 가능합니다.");
    }

    int c1 = 0, c2 = 0;

    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        c1++;
      } else if (ch >= '0' && ch <= '9') {
        c2++;
      }
    }

    if (c1 == 0 || c2 == 0) {
      throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요.");
    }

  }

  public void passwordStandard(String password1, String password2) throws AuthenException {
    int c1 = 0, c2 = 0;

    for (int i = 0; i < password1.length(); i++) {
      char ch = password1.charAt(i);
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        c1++;
      } else if (ch >= '0' && ch <= '9') {
        c2++;
      }
    }

    if (c1 == 0 || c2 == 0) {
      throw new AuthenException("비밀번호는 영문자와 숫자를 혼용해서 만들어주세요.");
    }
    if (!password1.equals(password2))
      throw new AuthenException("비밀번호가 다릅니다.");
  }

  public void nameStandard(String name) throws AuthenException {
    boolean check = Pattern.matches("^[가-힣]*$", name);
    if (!check) {
      throw new AuthenException("이름은 한글로 입력하세요.");
    }
  }

  public void nickNameStandard(String nickName) throws AuthenException {

    if (nickName.length() < 0 || nickName.length() > 20) {
      throw new AuthenException("3자~18자 이내의 별명만 가능합니다.");
    }
  }
}


