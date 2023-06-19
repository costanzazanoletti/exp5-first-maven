package cms;

public class InvalidUserNameException extends IllegalArgumentException {

  public InvalidUserNameException(String s) {
    super(s);
  }
}
