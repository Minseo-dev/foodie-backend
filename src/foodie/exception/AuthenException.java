package foodie.exception;

public class AuthenException extends Exception {
  private static final long serialVersionUID = 1L;

  public AuthenException(String alert) {
    super(alert);
  }

}
