package org.jfaster.mango.example.crud;

import com.google.common.base.MoreObjects;
import org.jfaster.mango.annotation.Column;
import org.jfaster.mango.annotation.ID;
import org.jfaster.mango.annotation.Ignore;

/**
 * @author ash
 */
public class OrderB {

  @ID(autoGenerateId = false)
  private Integer id;

  @Column("uid")
  private Integer userId;

  private Integer status;

  @Ignore
  private String address;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("id", id)
        .add("userId", userId)
        .add("status", status)
        .add("address", address)
        .toString();
  }

}
