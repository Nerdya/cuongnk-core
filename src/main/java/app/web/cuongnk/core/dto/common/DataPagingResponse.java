package app.web.cuongnk.core.dto.common;

/**
 * @author cuongnk
 * @since 25/04/2023
 */
import java.util.List;

public class DataPagingResponse<T> {
  private List<T> list;
  private long num;
  private long totalPage;
  private long currentPage;

  public DataPagingResponse() {
  }

  public List<T> getList() {
    return this.list;
  }

  public long getNum() {
    return this.num;
  }

  public long getTotalPage() {
    return this.totalPage;
  }

  public long getCurrentPage() {
    return this.currentPage;
  }

  public void setList(final List<T> list) {
    this.list = list;
  }

  public void setNum(final long num) {
    this.num = num;
  }

  public void setTotalPage(final long totalPage) {
    this.totalPage = totalPage;
  }

  public void setCurrentPage(final long currentPage) {
    this.currentPage = currentPage;
  }

  public boolean equals(final Object o) {
    if (o == this) {
      return true;
    } else if (!(o instanceof DataPagingResponse)) {
      return false;
    } else {
      DataPagingResponse<?> other = (DataPagingResponse)o;
      if (!other.canEqual(this)) {
        return false;
      } else {
        Object this$list = this.getList();
        Object other$list = other.getList();
        if (this$list == null) {
          if (other$list != null) {
            return false;
          }
        } else if (!this$list.equals(other$list)) {
          return false;
        }

        if (this.getNum() != other.getNum()) {
          return false;
        } else if (this.getTotalPage() != other.getTotalPage()) {
          return false;
        } else if (this.getCurrentPage() != other.getCurrentPage()) {
          return false;
        } else {
          return true;
        }
      }
    }
  }

  protected boolean canEqual(final Object other) {
    return other instanceof DataPagingResponse;
  }

  public int hashCode() {
    int result = 1;
    Object $list = this.getList();
    result = result * 59 + ($list == null ? 43 : $list.hashCode());
    long $num = this.getNum();
    result = result * 59 + (int)($num >>> 32 ^ $num);
    long $totalPage = this.getTotalPage();
    result = result * 59 + (int)($totalPage >>> 32 ^ $totalPage);
    long $currentPage = this.getCurrentPage();
    result = result * 59 + (int)($currentPage >>> 32 ^ $currentPage);
    return result;
  }

  public String toString() {
    List var10000 = this.getList();
    return "DataPagingResponse(list=" + var10000 + ", num=" + this.getNum() + ", totalPage=" + this.getTotalPage() + ", currentPage=" + this.getCurrentPage() + ")";
  }
}
