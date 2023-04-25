package app.web.cuongnk.core.exception;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class ProxyAuthenticationException extends BaseException {
  public ProxyAuthenticationException(String message) {
    super(message);
  }

  public ProxyAuthenticationException(String message, String messageCode) {
    super(message, messageCode);
  }

  public String getMessage() {
    return super.getMessage();
  }
}
