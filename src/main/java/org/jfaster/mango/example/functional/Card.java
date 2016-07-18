package org.jfaster.mango.example.functional;

import org.jfaster.mango.annotation.Getter;
import org.jfaster.mango.annotation.Setter;
import org.jfaster.mango.invoker.function.json.GsonToObjectFunction;
import org.jfaster.mango.invoker.function.json.ObjectToGsonFunction;

/**
 * @author ash
 */
public class Card {

    private int id;

    private String name;

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

    @Getter(ObjectToGsonFunction.class)
    public SubCard getSubCard() {
        return subCard;
    }

    @Setter(GsonToObjectFunction.class)
    public void setSubCard(SubCard subCard) {
        this.subCard = subCard;
    }

}
