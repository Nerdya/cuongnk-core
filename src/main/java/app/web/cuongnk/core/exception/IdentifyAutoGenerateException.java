package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class IdentifyAutoGenerateException extends BaseException {
  public IdentifyAutoGenerateException(String message) {
    super(message);
  }

  public IdentifyAutoGenerateException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
