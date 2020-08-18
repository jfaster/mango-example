package org.jfaster.mango.example.transfer;

import org.jfaster.mango.annotation.Transfer;
import org.jfaster.mango.invoker.transfer.IntegerListToStringTransfer;

import java.util.List;

/**
 * @author ash
 */
public class Teacher {

  private int id;

  private String name;

  @Transfer(IntegerListToStringTransfer.class)
  private List<Integer> studentIds;

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

  public List<Integer> getStudentIds() {
    return studentIds;
  }

  public void setStudentIds(List<Integer> studentIds) {
    this.studentIds = studentIds;
  }

}
