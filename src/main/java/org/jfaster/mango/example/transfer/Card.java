package org.jfaster.mango.example.transfer;

import org.jfaster.mango.annotation.Transfer;
import org.jfaster.mango.invoker.transfer.json.ObjectToGsonTransfer;

/**
 * @author ash
 */
public class Card {

  private int id;

  private String name;

  @Transfer(ObjectToGsonTransfer.class)
  private SubCard subCard;

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

  public SubCard getSubCard() {
    return subCard;
  }

  public void setSubCard(SubCard subCard) {
    this.subCard = subCard;
  }

}
