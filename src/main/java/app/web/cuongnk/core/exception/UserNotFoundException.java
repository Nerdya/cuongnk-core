package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class UserNotFoundException extends BaseException {
  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
