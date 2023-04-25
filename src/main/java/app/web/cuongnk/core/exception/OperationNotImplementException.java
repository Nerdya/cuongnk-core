package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class OperationNotImplementException extends BaseException {
  public OperationNotImplementException(String message) {
    super(message);
  }

  public OperationNotImplementException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
