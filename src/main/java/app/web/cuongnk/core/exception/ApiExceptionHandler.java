package app.web.cuongnk.core.exception;

import app.web.cuongnk.core.dto.common.BaseMethodResponse;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

/**
 * @author bontk
 */
@RestControllerAdvice
public class ApiExceptionHandler {
  private static final Logger logger = LoggerFactory.getLogger(ApiExceptionHandler.class);

  @ExceptionHandler({Exception.class})
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public BaseMethodResponse handleAllException(Exception ex, WebRequest request) {
    logger.error(ex.toString(), ex);
    return BaseMethodResponse.builder().status(false)
        .message(ex.getMessage())
        .errorCode(HttpStatus.INTERNAL_SERVER_ERROR.name().toLowerCase())
        .httpCode(HttpStatus.INTERNAL_SERVER_ERROR.value()).build();
  }

  @ExceptionHandler({MethodArgumentNotValidException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public BaseMethodResponse handleArgumentNotValidException(MethodArgumentNotValidException ex, WebRequest request) {
    logger.error(ex.toString(), ex);
    BindingResult bindingResult = ex.getBindingResult();
    String errorMessage = bindingResult.getFieldErrors().stream()
        .map(FieldError::getDefaultMessage)
        .findFirst()
        .orElse("Validation failed");
    return BaseMethodResponse.builder().status(false)
        .message(errorMessage)
        .errorCode(HttpStatus.BAD_REQUEST.name().toLowerCase())
        .httpCode(HttpStatus.BAD_REQUEST.value()).build();
  }

  @ExceptionHandler({ProxyAuthenticationException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleProxyAuthenticationException(ProxyAuthenticationException ex,
      WebRequest request) {
    logger.warn(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.UNAUTHORIZED.value()).build();
  }

  @ExceptionHandler({ForbiddenException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleForbiddenException(ForbiddenException ex,
      WebRequest request) {
    logger.warn(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.FORBIDDEN.value()).build();
  }

  @ExceptionHandler({ResourceNotFoundException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleResourceNotFoundException(ResourceNotFoundException ex,
      WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.NOT_FOUND.value()).build();
  }

  @ExceptionHandler({DuplicateEntityException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleDuplicateEntityException(DuplicateEntityException ex,
      WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.CONFLICT.value()).build();
  }

  @ExceptionHandler({IdentifyAutoGenerateException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleIdentifyAutoGenerateException(IdentifyAutoGenerateException ex,
      WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.NOT_IMPLEMENTED.value()).build();
  }

  @ExceptionHandler({IdentifyBlankException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleIdentifyBlankException(IdentifyBlankException ex,
      WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.BAD_REQUEST.value()).build();
  }

  @ExceptionHandler({OperationNotImplementException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleOperationNotImplementException(OperationNotImplementException ex,
      WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.BAD_REQUEST.value()).build();
  }

  @ExceptionHandler({UnAuthorizedException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleUnAuthorizedException(UnAuthorizedException ex,
      WebRequest request) {
    logger.warn(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.UNAUTHORIZED.value()).build();
  }

  @ExceptionHandler({UserNotFoundException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleUserNotFoundException(UserNotFoundException ex,
      WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.BAD_REQUEST.value()).build();
  }

  @ExceptionHandler({ValidationException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleValidationException(ValidationException ex, WebRequest request) {
    logger.debug(ex.getMessage());
    return BaseMethodResponse.builder().status(false).message(ex.getMessage())
        .errorCode(ex.getMessageCode()).httpCode(HttpStatus.BAD_REQUEST.value()).build();
  }

  @ExceptionHandler({IOException.class})
  @ResponseStatus(value = HttpStatus.OK)
  public BaseMethodResponse handleIOException(IOException e, WebRequest request) {
    logger.warn(e.getMessage());
    return BaseMethodResponse.builder().status(false).message(e.toString())
        .errorCode(HttpStatus.NOT_IMPLEMENTED.name())
        .httpCode(HttpStatus.NOT_IMPLEMENTED.value()).build();
  }
}
