package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class BaseException extends Exception {
  protected String messageCode;

  public BaseException(String message) {
    super(message);
  }

  public BaseException(String message, String messageCode) {
    super("#" + messageCode + " " + message);
    this.messageCode = messageCode;
  }

  public String getMessageCode() {
    return this.messageCode;
  }

  public void setMessageCode(String messageCode) {
    this.messageCode = messageCode;
  }
}
