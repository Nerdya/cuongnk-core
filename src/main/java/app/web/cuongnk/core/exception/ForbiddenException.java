package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class ForbiddenException extends BaseException {
  public ForbiddenException(String message) {
    super(message);
  }

  public ForbiddenException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
