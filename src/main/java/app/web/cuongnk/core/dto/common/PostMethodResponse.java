package app.web.cuongnk.core.dto.common;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
public class PostMethodResponse<T> {
  private Boolean status;
  private String message;
  private Integer httpCode;
  private T id;
  private String errorCode;

  public PostMethodResponse() {
  }

  public Boolean getStatus() {
    return this.status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Integer getHttpCode() {
    return this.httpCode;
  }

  public void setHttpCode(Integer httpCode) {
    this.httpCode = httpCode;
  }

  public T getId() {
    return this.id;
  }

  public void setId(T id) {
    this.id = id;
  }

  public String getErrorCode() {
    return this.errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public static <T> PostMethodResponseBuilder<T> builder() {
    return new PostMethodResponseBuilder();
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof PostMethodResponse)) {
      return false;
    } else {
      PostMethodResponse<?> other = (PostMethodResponse)o;
      if (!other.canEqual(this)) {
        return false;
      } else {
        label71: {
          Object this$status = this.getStatus();
          Object other$status = other.getStatus();
          if (this$status == null) {
            if (other$status == null) {
              break label71;
            }
          } else if (this$status.equals(other$status)) {
            break label71;
          }

          return false;
        }

        Object this$message = this.getMessage();
        Object other$message = other.getMessage();
        if (this$message == null) {
          if (other$message != null) {
            return false;
          }
        } else if (!this$message.equals(other$message)) {
          return false;
        }

        label57: {
          Object this$httpCode = this.getHttpCode();
          Object other$httpCode = other.getHttpCode();
          if (this$httpCode == null) {
            if (other$httpCode == null) {
              break label57;
            }
          } else if (this$httpCode.equals(other$httpCode)) {
            break label57;
          }

          return false;
        }

        Object this$id = this.getId();
        Object other$id = other.getId();
        if (this$id == null) {
          if (other$id != null) {
            return false;
          }
        } else if (!this$id.equals(other$id)) {
          return false;
        }

        Object this$errorCode = this.getErrorCode();
        Object other$errorCode = other.getErrorCode();
        if (this$errorCode == null) {
          if (other$errorCode == null) {
            return true;
          }
        } else if (this$errorCode.equals(other$errorCode)) {
          return true;
        }

        return false;
      }
    }
  }

  protected boolean canEqual(final Object other) {
    return other instanceof PostMethodResponse;
  }

  public int hashCode() {
    int result = 1;
    Object $status = this.getStatus();
    result = result * 59 + ($status == null ? 43 : $status.hashCode());
    Object $message = this.getMessage();
    result = result * 59 + ($message == null ? 43 : $message.hashCode());
    Object $httpCode = this.getHttpCode();
    result = result * 59 + ($httpCode == null ? 43 : $httpCode.hashCode());
    Object $id = this.getId();
    result = result * 59 + ($id == null ? 43 : $id.hashCode());
    Object $errorCode = this.getErrorCode();
    result = result * 59 + ($errorCode == null ? 43 : $errorCode.hashCode());
    return result;
  }

  public String toString() {
    Boolean var10000 = this.getStatus();
    return "PostMethodResponse(status=" + var10000 + ", message=" + this.getMessage() + ", httpCode=" + this.getHttpCode() + ", id=" + this.getId() + ", errorCode=" + this.getErrorCode() + ")";
  }

  public PostMethodResponse(final Boolean status, final String message, final Integer httpCode, final T id, final String errorCode) {
    this.status = status;
    this.message = message;
    this.httpCode = httpCode;
    this.id = id;
    this.errorCode = errorCode;
  }

  public static class PostMethodResponseBuilder<T> {
    private Boolean status;
    private String message;
    private Integer httpCode;
    private T id;
    private String errorCode;

    PostMethodResponseBuilder() {
    }

    public PostMethodResponseBuilder<T> status(final Boolean status) {
      this.status = status;
      return this;
    }

    public PostMethodResponseBuilder<T> message(final String message) {
      this.message = message;
      return this;
    }

    public PostMethodResponseBuilder<T> httpCode(final Integer httpCode) {
      this.httpCode = httpCode;
      return this;
    }

    public PostMethodResponseBuilder<T> id(final T id) {
      this.id = id;
      return this;
    }

    public PostMethodResponseBuilder<T> errorCode(final String errorCode) {
      this.errorCode = errorCode;
      return this;
    }

    public PostMethodResponse<T> build() {
      return new PostMethodResponse(this.status, this.message, this.httpCode, this.id, this.errorCode);
    }

    public String toString() {
      return "PostMethodResponse.PostMethodResponseBuilder(status=" + this.status + ", message=" + this.message + ", httpCode=" + this.httpCode + ", id=" + this.id + ", errorCode=" + this.errorCode + ")";
    }
  }
}
