package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class DuplicateEntityException extends BaseException {
  public DuplicateEntityException(String message) {
    super(message);
  }

  public DuplicateEntityException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
