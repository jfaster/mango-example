package org.jfaster.mango.example.crud;

import com.google.common.base.MoreObjects;
import org.jfaster.mango.annotation.ID;

/**
 * @author ash
 */
public class Order {

  @ID
  private Integer id;

  private Integer uid;

  private Integer status;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("uid", uid)
        .add("status", status)
        .toString();
  }

}
