package org.jfaster.mango.example.transfer;

import org.jfaster.mango.annotation.Transfer;
import org.jfaster.mango.invoker.transfer.enums.EnumToIntegerTransfer;

/**
 * @author ash
 */
public class Person {

  private int id;

  private String name;

  @Transfer(EnumToIntegerTransfer.class)
  private Gender gender;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

}
