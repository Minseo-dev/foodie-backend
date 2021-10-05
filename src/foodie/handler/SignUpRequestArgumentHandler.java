package foodie.handler;


import foodie.exception.AuthenException;
import foodie.dao.MemberDAO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUpRequestArgumentHandler extends Throwable {

  public static final Pattern EMAIL_REGEX = Pattern.compile("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", Pattern.CASE_INSENSITIVE);

  MemberDAO memberDAO = new MemberDAO();

  public void checkIDStandard(String id) throws AuthenException {

    if (id.length() < 3 || id.length() > 19) {
      throw new AuthenException("3자~18자 이내의 아이디만 가능합니다.");
    }

    String[] strings = id.split(" ");

    if (strings.length > 1) {
      throw new AuthenException("띄어쓰기는 사용할 수 없습니다.");
    }

    int c1 = 0, c2 = 0;

    for (int i = 0; i < id.length(); i++) {
      char ch = id.charAt(i);
      if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
        c1++;
      } else if (ch >= '0' && ch <= '9') {
        c2++;
      }
    }

    if (c1 == 0 || c2 == 0) {
      throw new AuthenException("아이디는 영문자와 숫자를 혼용해서 만들어주세요.");
    }

    if (memberDAO.duplicateCheckID(id)) {
      throw new AuthenException("중복된 아이디입니다.");
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
    boolean checkName = Pattern.matches("^[가-힣]*$", name);
    if (!checkName) {
      throw new AuthenException("이름은 한글로 입력하세요.");
    }
  }

  public void nickNameStandard(String nickName) throws AuthenException {

    if (nickName.length() > 20) {
      throw new AuthenException("3자~18자 이내의 별명만 가능합니다.");
    }
  }

  public static boolean validate(String email) {
    Matcher matcher = EMAIL_REGEX.matcher(email);
    return matcher.find();
  }

  public void emailStandard(String email) throws AuthenException {

    String[] strings = email.split(" ");

    if (strings.length > 1 || !validate(email)) {
      throw new AuthenException("이메일을 잘못 입력하셨습니다.");
    }


  }
}


