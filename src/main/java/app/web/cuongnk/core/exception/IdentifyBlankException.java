package app.web.cuongnk.core.exception;

public class IdentifyBlankException extends BaseException {
  public IdentifyBlankException(String message) {
    super(message);
  }

  public IdentifyBlankException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
