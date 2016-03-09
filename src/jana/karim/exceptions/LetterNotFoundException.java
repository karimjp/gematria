package jana.karim.exceptions;

public class LetterNotFoundException extends Exception {

  private static final long serialVersionUID = -1679049940938078260L;
  private static String defaultMessage = "Unknown character in UTF-16 encoding";

  public LetterNotFoundException() {
    super(defaultMessage);
  }

  public LetterNotFoundException(String message) {
    super(message);
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }

}
