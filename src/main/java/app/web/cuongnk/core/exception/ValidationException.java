package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class ValidationException extends BaseException {
  public ValidationException(String message) {
    super(message);
  }

  public ValidationException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
